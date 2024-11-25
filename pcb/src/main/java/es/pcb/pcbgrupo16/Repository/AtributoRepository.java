package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtributoRepository extends JpaRepository<Atributo, Integer> {
    @Query("SELECT a FROM Atributo a WHERE a.cuent = :cuenta")
    List<Atributo> findAllByCuenta(@Param("cuenta") Cuenta cuenta);

}
