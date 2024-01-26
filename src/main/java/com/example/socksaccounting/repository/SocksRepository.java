package com.example.socksaccounting.repository;

import com.example.socksaccounting.model.Socks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SocksRepository extends JpaRepository<Socks, Integer> {

    @Query(value = "SELECT * " +
            "FROM Socks WHERE color =:color AND cotton_part =:cottonPart LIMIT 1",
            nativeQuery = true)
    Socks findByColorAndCottonPart(@Param("color") String color,
                                   @Param("cottonPart") int cottonPart);


    @Query(value = "SELECT * " +
            "FROM Socks WHERE color =:color AND cotton_part =:cottonPart LIMIT 1",
            nativeQuery = true)
    Socks findByEquals(@Param("color") String color,
                       @Param("cottonPart") int cottonPart);

    @Query(value = "SELECT * " +
            "FROM Socks WHERE color =:color AND cotton_part >:cottonPart LIMIT 1",
            nativeQuery = true)
    Socks findByMoreThen(@Param("color") String color,
                         @Param("cottonPart") int cottonPart);

    @Query(value = "SELECT * " +
            "FROM Socks WHERE color =:color AND cotton_part <:cottonPart LIMIT 1",
            nativeQuery = true)
    Socks findByLessThen(@Param("color") String color,
                         @Param("cottonPart") int cottonPart);


}
