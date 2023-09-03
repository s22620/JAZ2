package pl.pjatk.jaz.s22620.nbp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jaz.s22620.nbp.service.NbpService;

@RestController
@RequestMapping("/nbp")
public class Controller {
    private final NbpService nbpService;
    private Object desc;

    public Controller(NbpService nbpService) {
        this.nbpService = nbpService;
    }
    @ApiResponses({@ApiResponse(responseCode = "404", description = "Nie ma takiego numeru" ),
        @ApiResponse(responseCode = "400", description = "Coś poszło nie tak")})
    @GetMapping("/{startDate}/{endDate}/{currency}")
    @Operation(description = " Program do obliczania średniej kursu wybranej waluty z podanego przedziału czasowego :)")
    public ResponseEntity<Double> getAVGCurrency(@PathVariable String startDate,
                                                 @PathVariable String endDate,
                                                 @PathVariable String currency) {
        return ResponseEntity.status(200).body((Double) nbpService.getAvgCurrency(startDate, endDate, currency));
    }
}
