package com.example.socksaccounting.service;

import com.example.socksaccounting.dto.SocksDto;
import com.example.socksaccounting.model.Operations;
import com.example.socksaccounting.model.Socks;
import com.example.socksaccounting.repository.SocksRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocksServiceImpl implements SocksService {

    private final SocksRepository socksRepository;


    public SocksServiceImpl(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    @Override
    public void socksIncome(SocksDto socksDto) {
        socksRepository.save(socksDto.fromDto());
    }

    @Override
    public void socksOutcome(SocksDto socksDto) {
        Socks socks = socksRepository.findByColorAndCottonPart(socksDto.getColor(),
                socksDto.getCottonPart());

        socks.setQuantity(socks.getQuantity() - socksDto.getQuantity());

        socksRepository.save(socks);
    }

    @Override
    public SocksDto socksInStock(String color,Integer cottonPart, Operations operation) {

        SocksDto socksDto =
                switch (operation.getOperation()) {
                    case "=" -> {
                        Socks socks = socksRepository.findByEquals(color, cottonPart);

                        yield SocksDto.fromSocks(socks);
                    }

                    case ">" -> {
                        Socks socks = socksRepository.findByMoreThen(color, cottonPart);

                        yield SocksDto.fromSocks(socks);
                    }

                    case "<" -> {
                        Socks socks = socksRepository.findByLessThen(color, cottonPart);

                        yield SocksDto.fromSocks(socks);
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + operation.getOperation());
                };

        return socksDto;
    }
}
