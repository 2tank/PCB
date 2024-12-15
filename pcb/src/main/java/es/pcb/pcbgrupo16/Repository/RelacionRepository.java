package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RelacionRepository extends JpaRepository<Relacion, Integer> {
    @Query("SELECT r FROM Relacion r WHERE r.cuenta = :cuenta ")
    List<Relacion> findAllByCuenta(@Param("cuenta") Cuenta cuenta);

    @Query("SELECT r FROM Relacion r WHERE r.id = :id")
    Relacion findRelacionById(@Param("id")Integer id);

    @Modifying
    @Transactional
    @Query("UPDATE Relacion r SET r.prod1 = NULL, r.prod2 = NULL WHERE r.prod1.id = :id OR r.prod2.id = :id")
    void setProd1AndProd2NullById(@Param("id") Integer id);

    @Query("SELECT r FROM Relacion r WHERE r.prod1 = :id or r.prod2 = :id")
    List<Relacion> findAllByProducto(@Param("id") Integer id);
}
