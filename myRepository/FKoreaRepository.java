package com.example.firstproject.myRepository;

import com.example.firstproject.myEntity.FKorea;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FKoreaRepository extends CrudRepository<FKorea, Long> {
    @Override
    ArrayList<FKorea> findAll();
}
