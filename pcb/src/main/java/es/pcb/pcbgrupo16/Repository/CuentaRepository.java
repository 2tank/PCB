package es.pcb.pcbgrupo16.Repository;

import es.pcb.pcbgrupo16.Entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {




}
