package com.cibertec.practiquant.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.practiquant.security.entity.Rol;
import com.cibertec.practiquant.security.enums.RolNombre;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
