package com.javanauta.cadastro_usuario.infrastrucure;

import com.javanauta.cadastro_usuario.infrastrucure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{


}
