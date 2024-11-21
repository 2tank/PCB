package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT u FROM Usuario u WHERE u.nombre = :nombre AND u.contrasena = :contrasena")
    Usuario findByNombreAndContrasena(@Param("nombre") String nombre, @Param("contrasena") String contrasena);

}
