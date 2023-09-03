package pl.pjatk.jaz.s22620.nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.jaz.s22620.nbp.model.DatabaseEntry;

@Repository
public interface NbpRepository extends JpaRepository<DatabaseEntry,Integer>{
}
