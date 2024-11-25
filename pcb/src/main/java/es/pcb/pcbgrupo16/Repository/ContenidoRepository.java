package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Contenido c WHERE c.atributo.id = :atributo")
    void deleteByAtributo(@Param("atributo") int atributo);

    @Query(value = "SELECT c FROM Contenido c WHERE c.producto.id = :producto")
    List<Contenido> getContenidoByProducto(@Param("producto") int producto);

    @Modifying
    @Transactional
    @Query("DELETE FROM Contenido c WHERE c.producto.id = :producto")
    void deleteByProducto(@Param("producto") int producto);
}
