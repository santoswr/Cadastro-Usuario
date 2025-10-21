package com.javanauta.cadastro_usuario.business;

import com.javanauta.cadastro_usuario.infrastrucure.UsuarioRepository;
import com.javanauta.cadastro_usuario.infrastrucure.entitys.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }
    public void SalvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario BuscarUsuarioPorEmail (String Email){


        return repository.findByEmail(Email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
        );
    }
    public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }

    public void atualizarUsuarioPorEmail(String email, Usuario usuario){
        Usuario usuarioEntity = BuscarUsuarioPorEmail(email);
        Usuario usuarioAtualizado = Usuario.builder()
                .email(usuario.getEmail() != null ?usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() !=null ?usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();
                repository.saveAndFlush(usuarioAtualizado);
    }
}
