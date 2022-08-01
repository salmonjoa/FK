package com.example.firstproject.myDto;

import com.example.firstproject.myEntity.FKorea;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FKoreaForm {
    private Long seq;
    private String product;
    private String information;

    public FKorea toEntity() {
        return new FKorea(seq, product, information);
    }
}
