# 🛒 E-Commerce Backend with AI Assistant

A secure and scalable e-commerce backend built with **Java 21, Spring Boot, Spring Security, and Spring AI**. The application provides REST APIs for user authentication, product management, cart operations, orders, and payments, enhanced with an **AI-powered assistant using LLM tool calling and Retrieval-Augmented Generation (RAG)**.

The project combines traditional backend development with modern AI integration to deliver intelligent product assistance and knowledge-based responses.

---

## 🧩 Problem Statement

E-commerce applications need secure user management, reliable order processing, payment handling, and efficient access to product information. Traditional backends can also struggle to provide natural-language assistance and contextual answers from business documents.

This project addresses these challenges through a secure REST API architecture and an AI assistant that combines tool calling with RAG-based document retrieval.

## 💡 Solution Architecture

The application provides the following capabilities:

- 🔐 **Authentication and Authorization:** JWT-based authentication, role-based access control, and Google OAuth2 login.
- 📦 **Product Management:** CRUD operations for product information and product images.
- 🛒 **Cart Management:** Add products, update quantities, and remove cart items.
- 📋 **Order Management:** Order creation, status tracking, and user-specific order access.
- 💳 **Payment and Refund Handling:** Payment integration and refund handling for eligible cancelled orders.
- 🤖 **AI Assistant:** Natural-language product search, filtering, comparison, and recommendations using Spring AI tool calling.
- 📚 **RAG Chatbot:** Retrieves relevant information from documents using embeddings and a Pinecone vector database to support context-aware responses.
- 🔒 **Data Access Control:** Users can access their own orders and relevant account data, while administrative operations are role-protected.
- 🔌 **RESTful APIs:** Structured endpoints for frontend applications and API clients.
- 🗄️ **Database Integration:** Relational database access using Spring Data JPA and Hibernate.

## 🏗️ AI and RAG Implementation

The AI functionality extends the standard e-commerce backend with intelligent assistance.

### 1. AI-powered product assistant

- Integrated **Spring AI** with an LLM.
- Used AI tool calling to connect natural-language requests with backend functionality.
- Supported product-related queries, filtering, comparisons, and recommendations through application tools.

### 2. Retrieval-Augmented Generation (RAG)

- Implemented a document ingestion pipeline for loading PDF documents.
- Processed documents into smaller text chunks.
- Generated embeddings for document content.
- Integrated **Pinecone Vector Database** to store and retrieve vector representations.
- Retrieved relevant document content to provide context for AI-generated answers.

### 3. Technology integration

- **Spring AI:** AI model integration, embeddings, and tool calling.
- **Pinecone:** Vector storage and similarity-based retrieval.
- **Spring Boot:** Application APIs and backend integration.
- **PDF processing:** Document loading and preparation for the RAG pipeline.

This implementation demonstrates how conventional Java backend services can be combined with LLM-based tool calling and document retrieval.

## 🔧 Tech Stack

### Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- REST APIs
- Maven

### Authentication and Security
- JWT Authentication
- Role-Based Access Control
- Google OAuth2 Login

### Database and AI
- MySQL / PostgreSQL configuration, depending on the application setup
- Spring AI
- Large Language Models (LLMs)
- AI Tool Calling
- Retrieval-Augmented Generation (RAG)
- Embeddings
- Pinecone Vector Database
- PDF Document Processing

### Development and API Tools
- JUnit
- Mockito
- Spring DevTools
- Springdoc OpenAPI / Swagger UI
- Environment-based configuration

## 🚀 Key Features

- 🔐 Secure user registration and login using JWT.
- 👤 Role-based authorization with `ROLE_USER` and `ROLE_ADMIN`.
- 🌐 Google OAuth2 login integration.
- 📦 Product CRUD operations.
- 🛒 Cart management with product quantity updates.
- 📋 Order creation and status management.
- 💳 Payment integration and refund handling for eligible cancelled orders.
- 🔒 User-specific order access and protected administrative operations.
- 🤖 AI-powered product assistance using LLM tool calling.
- 📚 RAG-based document retrieval using embeddings and Pinecone.
- ⚙️ Environment-based configuration for sensitive settings.
- 🧪 Testing support with JUnit and Mockito.

## ⚙️ Installation and Setup

### Prerequisites

- JDK 21
- Maven
- A configured relational database
- Pinecone account and API key for RAG functionality
- API credentials for the configured AI model
- Git

### 1. Clone the repository

```bash
git clone https://github.com/onkardunakhe/E-Commerce-Backend-with-AI-Assistant.git
cd E-Commerce-Backend-with-AI-Assistant
```

### 2. Configure application properties

Copy the example configuration file:

```bash
cp src/main/resources/application-example.properties src/main/resources/application.properties
```

On Windows PowerShell, use:

```powershell
Copy-Item src/main/resources/application-example.properties src/main/resources/application.properties
```

Update `application.properties` with your local database settings and the required AI and Pinecone credentials.

**Security note:** Never commit real API keys, database passwords, or other secrets to GitHub. Keep your local `application.properties` out of version control.

### 3. Configure the database

Create your database and configure the JDBC URL, username, and password in `application.properties`. Ensure the database settings match the database supported by your current project configuration.

### 4. Configure AI and Pinecone

Set the required credentials for your selected AI model and Pinecone instance according to the application's configuration.

Ensure the configured embedding model and Pinecone index settings are compatible with your implementation.

### 5. Build the application

```bash
mvn clean install
```

### 6. Run the application

```bash
mvn spring-boot:run
```

### 7. Explore and test the APIs

Once the application is running, access Swagger UI at:

```text
http://localhost:8080/swagger-ui/index.html
```

If your configured Springdoc version exposes a different Swagger path, use the path configured by your application. You can also test the endpoints using Postman.

## 🔮 Future Improvements

- 🔐 OTP-based authentication and two-factor authentication.
- 📈 An analytics dashboard for orders, revenue, and user activity.
- 💾 Database backup and restore functionality.
- ☁️ Dockerization and cloud deployment.
- 🧠 Improved RAG evaluation, retrieval quality, and document update workflows.
- ⚡ Caching and performance optimization for frequently accessed data.
- 🧪 Expanded unit, integration, and API security tests.

## 👨‍💻 Author

**Onkar Dunakhe**  
Java Backend Developer | Spring Boot | Spring AI

- 📧 Email: [onkardunakhe1@gmail.com](mailto:onkardunakhe1@gmail.com)
- 💻 GitHub: [onkardunakhe](https://github.com/onkardunakhe)
- 🔗 LinkedIn: [onkar-dunakhe](https://www.linkedin.com/in/onkar-dunakhe)
- 🌐 Portfolio: [onkardunakhe.github.io/onkar-portfolio](https://onkardunakhe.github.io/onkar-portfolio)

---

⭐ If you find this project interesting, feel free to explore the repository and its implementation.
