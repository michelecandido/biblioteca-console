package model;

import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;
    private ArrayList<Livro> livrosEmprestados = new ArrayList<>();
    private static int proximoId = 1;

    public Usuario(String nome) {
        this.id = proximoId++;
        this.nome = nome;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public ArrayList<Livro> getLivrosEmprestados() { return livrosEmprestados; }
}