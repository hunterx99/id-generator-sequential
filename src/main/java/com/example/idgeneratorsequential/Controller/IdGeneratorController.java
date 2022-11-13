package com.example.idgeneratorsequential.Controller;

import com.example.idgeneratorsequential.Service.IdGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdGeneratorController {
    @Autowired
    IdGeneratorService idGeneratorService;

    @GetMapping("/getId")
    public long getId() {
        return idGeneratorService.getId();
    }
}
