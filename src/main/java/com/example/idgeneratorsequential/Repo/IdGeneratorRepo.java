package com.example.idgeneratorsequential.Repo;

import com.example.idgeneratorsequential.Model.IdGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IdGeneratorRepo extends JpaRepository<IdGenerator, Long> {
    @Query(value = "SELECT * FROM id_generator_sequential ORDER BY time_stamp DESC LIMIT 1", nativeQuery = true)
    Optional<IdGenerator> getLastInsertedRecord();
}
