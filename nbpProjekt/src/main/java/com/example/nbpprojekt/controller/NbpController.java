package com.example.nbpprojekt.controller;

import com.example.nbpprojekt.service.NbpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nbp")
//localhost:8080/nbp/
public class NbpController {

    //    @Autowired
    //    private NbpService nbpService;
    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @ApiResponses({@ApiResponse(responseCode = "404", description = "404 Not Found - UPSI DAISY"),
            @ApiResponse(responseCode = "400", description = "400 Bad Request - kurza twarz")})
    //Tworzy endpoint pod adresem: localhost:8080/nbp/{startDate}/{endDate}/{waluta}
    // {startDate} - parametr/zmienne PathVariable
    @GetMapping("/{startDate}/{endDate}/{currency}")
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "upsi daisy - wiem, że i tak pokarze się BAD REQUEST ale no można dodać reason zdarzenia")
    @Operation(description = "Program oblicza avg kursu walut z podanego przedziału czasu oraz w danej walucie :)")
    public ResponseEntity<Double> getAvgCurrency(@PathVariable String startDate,
                                                 @PathVariable String endDate,
                                                 @PathVariable String currency) {
        return ResponseEntity.status(200).body(nbpService.getAvgCurrency(startDate, endDate, currency));
    }
}
