package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Atributousuario;
import es.pcb.pcbgrupo16.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AtributoUsuarioRepository extends JpaRepository<Atributousuario, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Atributousuario a WHERE a.id.idAtributo = :atributoId")
    void deleteAtributoById(@Param("atributoId") Integer atributoId);
}
