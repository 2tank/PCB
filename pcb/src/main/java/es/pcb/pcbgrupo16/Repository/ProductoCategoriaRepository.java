package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Cuenta;
import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoCategoriaRepository extends JpaRepository<Productocategoria, ProductocategoriaId> {


    @Query(value = "SELECT * FROM productocategoria WHERE idProducto = :idProducto", nativeQuery = true)
    List<Productocategoria> findByIdIdProducto(@Param("idProducto") Integer idProducto);


}
