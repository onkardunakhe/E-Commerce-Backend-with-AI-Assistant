package com.Crud.Crud.Service;

import com.Crud.Crud.Tools.ProductTools;
import jakarta.annotation.PostConstruct;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AiService {
    private final ChatClient chatClient;
    private final ProductTools productTools;
    private final VectorStore vectorStore;


    @Value("classpath*:knowledge/*.pdf")
    private Resource[] policyFiles;

    public AiService(VectorStore vectorStore, ChatClient.Builder chatClientBuilder, ProductTools productTools) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClientBuilder.build();
        this.productTools = productTools;
    }

    @PostConstruct
    public void loadKnowledgeBase() {
        // 1. Read all PDF files.
        // 2. FOr each file I will divide them into chunks
        //3. I will store those chunks in vector DB --> Pinecone.

        List<Document> allChunks = new ArrayList<>();

        TokenTextSplitter splitter = TokenTextSplitter.builder()
                .withChunkSize(300)
                .build();

        // Loop through each PDF file
        for (Resource resource : policyFiles) {

            PagePdfDocumentReader reader = new PagePdfDocumentReader(resource);
            List<Document> pages = reader.read();
            List<Document> chunks = splitter.apply(pages);
            allChunks.addAll(chunks);
        }
        vectorStore.add(allChunks);
    }


    public String answerUserQuery(String question) {
        // 1. Question --> vector
        //2. similrity search in our vector db
        //3. top 4 results fetch

        List<Document> relevantChunks = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(question)
                        .topK(4)
                        .build()
        );

        StringBuilder context = new StringBuilder();

        for (Document document : relevantChunks) {

            context.append(document)
                    .append("\n\n");
        }

        String finalContext = context.toString();

        String prompt = """
                You are an AI customer support assistant for our e-commerce company.
                
                Answer the customer using ONLY the company information provided below.
                
                If the answer is not available in the provided information, say:
                "I don't have that information in the company documents."
                
                COMPANMY INFORMATION
                %s
                
                """.formatted(finalContext);

        return chatClient.prompt()
                .system(prompt)
                .user(question)
                .tools(productTools)
                .call()
                .content();


    }


}
