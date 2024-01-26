package com.example.socksaccounting.dto;

import com.example.socksaccounting.model.Socks;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocksDto {

    private String color;

    private Integer cottonPart;

    private Integer quantity;

    public static SocksDto fromSocks(Socks socks) {

        SocksDto socksDto = new SocksDto();

        socksDto.setColor(socks.getColor());
        socksDto.setQuantity(socks.getQuantity());
        socksDto.setCottonPart(socks.getCottonPart());

        return socksDto;
    }

    public Socks fromDto() {
        Socks socks = new Socks();

        socks.setColor(this.getColor());
        socks.setQuantity(this.getQuantity());
        socks.setCottonPart(this.getCottonPart());

        return socks;
    }
}
