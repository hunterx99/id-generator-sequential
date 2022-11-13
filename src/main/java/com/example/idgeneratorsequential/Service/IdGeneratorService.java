package com.example.idgeneratorsequential.Service;

import com.example.idgeneratorsequential.Model.IdGenerator;
import com.example.idgeneratorsequential.Repo.IdGeneratorRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class IdGeneratorService {

    @Autowired
    IdGeneratorRepo idGeneratorRepo;

    private static int COUNTER;
    private static final int LIMIT = 2000;



    public synchronized int getId() {
        if (COUNTER % LIMIT == 0) {
            saveLastCounterUsed(Instant.now().toEpochMilli());
        }
        int counter = COUNTER;
        COUNTER++;
        log.info("id====== {} ", counter);
        return counter;
    }

    public void getCOUNTER() {
        COUNTER = idGeneratorRepo.getLastInsertedRecord()
                .map(IdGenerator::getLastUniqueId)
                .orElse(1) + LIMIT;

        System.out.println("COUNTER======" + COUNTER);
    }

    public void saveLastCounterUsed(long currentEpochMillSec) {
        long startTime = System.currentTimeMillis();
        long id = idGeneratorRepo.save(
                        IdGenerator
                                .builder()
                                .lastUniqueId(COUNTER)
                                .timeStamp(currentEpochMillSec)
                                .build())
                .getLastUniqueId();
        log.info("Saved last used counter {}, time taken {}", id, (System.currentTimeMillis() - startTime));
    }
}
