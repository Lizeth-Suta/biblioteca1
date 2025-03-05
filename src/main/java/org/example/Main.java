import java.util.*;

class Libro {
    String titulo, autor, isbn;
    boolean disponible = true;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}

class Biblioteca {
    private List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro agregado.");
    }

    public void buscarPorTitulo(String titulo) {
        libros.stream().filter(l -> l.titulo.equalsIgnoreCase(titulo))
                .findFirst().ifPresentOrElse(System.out::println, () -> System.out.println("Libro no encontrado."));
    }

    public void buscarPorAutor(String autor) {
        libros.stream().filter(l -> l.autor.equalsIgnoreCase(autor))
                .forEach(System.out::println);
        if (libros.stream().noneMatch(l -> l.autor.equalsIgnoreCase(autor)))
            System.out.println("No se encontraron libros de este autor.");
    }