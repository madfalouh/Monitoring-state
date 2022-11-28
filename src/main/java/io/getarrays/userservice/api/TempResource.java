package io.getarrays.userservice.api;


import io.getarrays.userservice.domain.Temp;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.TempService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TempResource {


    private final  TempService tempService ;


    @GetMapping("/temp")
    public ResponseEntity<List<Temp>> getTemp() {
        return ResponseEntity.ok().body(tempService.getTemp());
    }


}
