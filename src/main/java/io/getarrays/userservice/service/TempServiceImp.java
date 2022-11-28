package io.getarrays.userservice.service;

import io.getarrays.userservice.domain.Temp;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repo.TempRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j

public class TempServiceImp implements TempService {

    private final TempRepo  tempRepo ;

    @Override
    public List<Temp> getTemp() {
        return tempRepo.findAll() ;
    }
}
