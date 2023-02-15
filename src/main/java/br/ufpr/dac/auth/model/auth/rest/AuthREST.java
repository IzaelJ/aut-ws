package br.ufpr.dac.auth.model.auth.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufpr.dac.auth.model.auth.model.Login;
import br.ufpr.dac.auth.model.auth.model.Usuario;

@CrossOrigin
@RestController
public class AuthREST {
    public static List<Login> lista = new ArrayList<>();

    @GetMapping("/login")
    public List<Login> obterTodosLogin() {
        return lista;
    }

    @PostMapping("/login")
    ResponseEntity<Usuario> login(@RequestBody Login login) {
        // BD para verificar o login/senha
        if (login.getLogin().equals(login.getSenha())) {
            Usuario usu = new Usuario(1, login.getLogin(), login.getLogin(), "XXX", "ADMIN");
            return ResponseEntity.ok().body(usu);
        } else {
            return ResponseEntity.status(401).build();
        }

    }

    static {
        lista.add(new Login("admin", "admin"));
        lista.add(new Login("teste", "teste"));
    }
}
