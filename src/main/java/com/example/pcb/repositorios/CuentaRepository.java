package com.example.pcb.repositorios;

import com.example.pcb.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
