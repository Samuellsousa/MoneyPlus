package com.sistema.moneyplus.services;

import com.sistema.moneyplus.dto.UsuarioDTO;
import com.sistema.moneyplus.models.Usuario;
import com.sistema.moneyplus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Listar todos os usuários
    public List<UsuarioDTO> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuario -> new UsuarioDTO(usuario.getId(), usuario.getNome(), usuario.getEmail()))
                .toList();
    }

    // Criar um novo usuário
    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getSenha()); // Garante que senha existe
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuarioSalvo.getId(), usuarioSalvo.getNome(), usuarioSalvo.getEmail());
    }

    // Atualizar um usuário existente
    public UsuarioDTO atualizarUsuario(Long id, UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDTO.getNome());
            usuario.setEmail(usuarioDTO.getEmail());

            // Verifica se o DTO possui senha antes de definir
            if (usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isEmpty()) {
                usuario.setSenha(usuarioDTO.getSenha());
            }

            Usuario usuarioAtualizado = usuarioRepository.save(usuario);
            return new UsuarioDTO(usuarioAtualizado.getId(), usuarioAtualizado.getNome(), usuarioAtualizado.getEmail());
        }
        return null;
    }

    // Deletar um usuário
    public boolean deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
