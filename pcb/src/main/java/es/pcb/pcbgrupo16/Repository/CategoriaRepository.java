package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Categoria;
import es.pcb.pcbgrupo16.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
