package pl.pjatk.kos.jaz22051nbp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.kos.jaz22051nbp.model.WalutaResponse;
import pl.pjatk.kos.jaz22051nbp.service.NbpService;

@RestController("/home")
public class NbpController {

    final private NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{waluta}")
    public ResponseEntity<WalutaResponse> getWaluta(@PathVariable String waluta, @RequestParam(value = "last", defaultValue = "1") int last) {
        return ResponseEntity.ok(nbpService.getWaluta(waluta, last));
    }
}
