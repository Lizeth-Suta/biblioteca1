package org.example;

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

    public void listarLibros() {
        if (libros.isEmpty()) System.out.println("No hay libros en la biblioteca.");
        else libros.forEach(System.out::println);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        while (true) {
            System.out.println("\n1. Agregar libro 2. Buscar por título 3. Buscar por autor 4. Listar libros 5. Salir");
            System.out.print("Seleccione opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 5) break;
            if (opcion == 1) {
                System.out.print("Título: "); String titulo = sc.nextLine();
                System.out.print("Autor: "); String autor = sc.nextLine();
                System.out.print("ISBN: "); String isbn = sc.nextLine();
                biblioteca.agregarLibro(new Libro(titulo, autor, isbn));
            } else if (opcion == 2) {
                System.out.print("Título: ");
                biblioteca.buscarPorTitulo(sc.nextLine());
            } else if (opcion == 3) {
                System.out.print("Autor: ");
                biblioteca.buscarPorAutor(sc.nextLine());
            } else if (opcion == 4) {
                biblioteca.listarLibros();
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}