package pl.pjatk.kos.jaz22051nbp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.pjatk.kos.jaz22051nbp.model.WalutaResponse;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;


@Repository
public interface NbpRepository extends JpaRepository<WalutaResponse, Long> {

    @Modifying
    @Query(value = "INSERT into WalutaResponse (id, average, currency, fromDate, toDate, createdAt) VALUES (:average, :currency, :fromDate, :toDate, :createAt)", nativeQuery = true)
    WalutaResponse save(@Param("average") BigDecimal avg, @Param("currency") String currency, @Param("fromDate") LocalDate from, @Param("toDate") LocalDate to, @Param("createAt")Instant createAt);

}
