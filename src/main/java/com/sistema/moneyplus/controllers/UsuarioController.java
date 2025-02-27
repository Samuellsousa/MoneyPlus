package com.sistema.moneyplus.controllers;

import com.sistema.moneyplus.models.Usuario;
import com.sistema.moneyplus.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {


    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrar(@RequestBody Usuario usuario) {
        // Verifica se o email já existe no banco de dados
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: O email informado já está em uso.");
        }

        try {
            // Salva o usuário no banco de dados
            Usuario savedUsuario = usuarioRepository.save(usuario);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Usuário cadastrado com sucesso! ID do usuário: " + savedUsuario.getId());
        } catch (Exception e) {
            // Em caso de erro durante o cadastro, retorna uma mensagem de erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao cadastrar o usuário: " + e.getMessage());
        }
    }





    // Endpoint para buscar um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
        // Buscando o usuário no banco de dados
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        // Caso o usuário não seja encontrado, retorna 404
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
