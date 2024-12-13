package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query("SELECT p FROM Producto p WHERE p.cuenta.id = :cuentaId")
    List<Producto> findAllByCuenta(@Param("cuentaId") Integer cuentaId);

    @Query("SELECT p FROM Producto p WHERE p.id = :id")
    Producto findProductoById(@Param("id")Integer id);
}
