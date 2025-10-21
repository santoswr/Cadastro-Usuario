package com.javanauta.cadastro_usuario.infrastrucure;

import com.javanauta.cadastro_usuario.infrastrucure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Optional<Usuario> findByEmail (String email);

    @Transactional
    Void deleteByEmail(String email);
}
