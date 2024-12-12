package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.*;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoCategoriaRepository extends JpaRepository<Productocategoria, ProductocategoriaId> {


    @Query(value = "SELECT * FROM productocategoria WHERE idProducto = :idProducto", nativeQuery = true)
    List<Productocategoria> findByIdIdProducto(@Param("idProducto") Integer idProducto);

    @Query(value = "SELECT * FROM productocategoria WHERE idCategoria = :idCategoria", nativeQuery = true)
    List<Productocategoria> findByIdIdCategoria(@Param("idCategoria") Integer idCategoria);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productocategoria WHERE idProducto = :idProducto", nativeQuery = true)
    void deleteByIdProducto(@Param("idProducto") Integer idProducto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productocategoria WHERE idCategoria = :idCategoria", nativeQuery = true)
    void deleteByIdCategoria(@Param("idCategoria") Integer idCategoria);

}
