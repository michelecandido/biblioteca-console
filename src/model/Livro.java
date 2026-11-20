package model;

public class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int ano;
    private boolean disponivel;
    private static int proximoId = 1;

    public Livro(String titulo, String autor, int ano) {
        this.id = proximoId++;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAno() { return ano; }
    public boolean isDisponivel() { return disponivel; }
}