package service;

import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public Livro cadastrarLivro(String titulo, String autor, int ano) {
        Livro livro = new Livro(titulo, autor, ano);
        livros.add(livro);
        return livro;
    }

    public Usuario cadastrarUsuario(String nome) {
        Usuario user = new Usuario(nome);
        usuarios.add(user);
        return user;
    }

    public List<Livro> listarLivros() {
        return List.copyOf(livros);
    }

    public List<Livro> buscarPorTitulo(String trecho) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for(Livro livro : livros) {
            if(livro.getTitulo().toLowerCase().contains(trecho.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }
}