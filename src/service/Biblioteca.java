package service;

import model.Livro;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final int LIMITE_EMPRESTIMOS = 3;

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

    private Livro buscarLivroId(int id) {
        for(Livro livro : livros) {
            if(livro.getId() == id) {
                return livro;
            }
        }
        throw new IllegalArgumentException("Livro não encontrado: id " + id);
    }

    private Usuario buscarUsuarioId(int id) {
        for(Usuario usuario : usuarios) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuário não encontrado: id " + id);
    }

    public void emprestar(int idLivro, int idUsuario) {
        Livro livro = buscarLivroId(idLivro);
        Usuario usuario = buscarUsuarioId(idUsuario);

        if(!livro.isDisponivel()) {
            throw new IllegalStateException("Livro não disponível: id " + idLivro);
        }

        if(usuario.getLivrosEmprestados().size() >= LIMITE_EMPRESTIMOS) {
            throw new IllegalStateException("Limite de empréstimos atingido.");
        }

        livro.emprestar();
        usuario.adicionarLivro(livro);
    }

    public void devolver(int idLivro, int idUsuario) {
        Livro livro = buscarLivroId(idLivro);
        Usuario usuario = buscarUsuarioId(idUsuario);

        if(!usuario.getLivrosEmprestados().contains(livro)) {
            throw new IllegalStateException("Usuário não possui o livro.");
        }

        livro.devolver();
        usuario.removerLivro(livro);
    }
}