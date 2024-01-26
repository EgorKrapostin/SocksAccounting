package com.example.socksaccounting.service;

import com.example.socksaccounting.dto.SocksDto;
import com.example.socksaccounting.model.Operations;

public interface SocksService {
    void socksIncome(SocksDto socksDto);

    void socksOutcome(SocksDto socksDto);

    SocksDto socksInStock(String color,Integer cottonPart, Operations operation);
}
