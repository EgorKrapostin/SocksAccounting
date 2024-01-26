package com.example.socksaccounting.controller;

import com.example.socksaccounting.dto.SocksDto;
import com.example.socksaccounting.model.Operations;
import com.example.socksaccounting.service.SocksService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }


    @PostMapping("/income")
    public void socksIncome(@RequestBody SocksDto socksDto) {
        socksService.socksIncome(socksDto);
    }

    @PostMapping("/outcome")
    public void socksOutcome(@RequestBody SocksDto socksDto) {
        socksService.socksOutcome(socksDto);
    }

    @GetMapping("/")
    public SocksDto socksInStock(@RequestParam String color,
                                 @RequestParam int cottonPart,
                                 @RequestParam Operations operation) {

        return socksService.socksInStock(color,cottonPart, operation);
    }
}
