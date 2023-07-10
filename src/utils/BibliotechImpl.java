package utils;

import Forms.*;
import entities.Libro;
import entities.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

public class BibliotechImpl implements Bibliotech{
    LinkedList<Usuario>listaUsuarios = new LinkedList<>();
    LinkedList<Libro>listaLibros = new LinkedList<>();

    /**
     * Constructor de BibliotechImpl
     */
    public BibliotechImpl(){
        leerArchivoLibros();
        leerArchivoUsuarios();
        iniciarSesion();
    }

    public void iniciarSesion(){
        iniciarSesion iniciarSesion = new iniciarSesion(listaUsuarios, listaLibros);
    }

    /**
     * Metodo leerArchivoLibros
     */
    public void leerArchivoLibros() {
        // Leer el archivo "libros.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("libros.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String isbn = chain[0];
                String titulo = chain[1];
                String autor = chain[2];
                String categoria = chain[3];
                int cantPaginas = Integer.parseInt(chain[4]);
                int copias = Integer.parseInt(chain[5]);
                listaLibros.add(new Libro(isbn,titulo,autor,categoria,cantPaginas,copias));
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    /**
     * Metodo leerArchivoUsuarios
     */
    public void leerArchivoUsuarios() {
        // Leer el archivo "usuarios.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"))) {
            String line;
            int n =0;
            while ((line = br.readLine()) != null) {
                String[] chain = line.split(",");
                String rut = chain[0];
                String nombre = chain[1];
                String apellido = chain[2];
                String contrasenia = chain[3];

                listaUsuarios.add(new Usuario(nombre,apellido,contrasenia,rut));
                System.out.println(listaUsuarios.get(n).getRut()+listaUsuarios.get(n).getContrasenia());
                n++;
            }


        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
