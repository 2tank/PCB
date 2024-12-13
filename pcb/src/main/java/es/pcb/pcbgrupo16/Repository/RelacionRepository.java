package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelacionRepository extends JpaRepository<Relacion, Integer> {
    @Query("SELECT r FROM Relacion r WHERE r.cuenta = :cuenta ")
    List<Relacion> findAllByCuenta(@Param("cuenta") Cuenta cuenta);

    @Query("SELECT r FROM Relacion r WHERE r.id = :id")
    Relacion findRelacionById(@Param("id")Integer id);


}
