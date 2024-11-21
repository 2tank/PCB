package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
