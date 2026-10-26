package com.Crud.Crud.Controllers;

import com.Crud.Crud.Service.AiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai")
public class AiController {
    private final AiService aiService;

    @GetMapping("/query")
    public Map<String, String> query(@RequestParam String question) {
        return Map.of("answer", aiService.answerUserQuery(question));
    }
}
