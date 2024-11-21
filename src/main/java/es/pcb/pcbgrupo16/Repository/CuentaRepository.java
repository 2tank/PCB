package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Query("SELECT c FROM Cuenta c WHERE c.nombre = :nombre AND c.contrasena = :contrasena")
    Cuenta findByNombreAndContrasena(@Param("nombre") String nombre, @Param("contrasena") String contrasena);

}
