package entities;

public class Libro {
    private String isbn;
    private String nombre;
    private String autor;
    private String categoria;
    private int cantPaginas;
    private int copias;

    /**
     * Constructor de libro
     *
     * @param isbn: isbn del libro
     * @param nombre: nombre o titulo del libro
     * @param autor: autor del libro
     * @param categoria: categoria del libro
     * @param cantPaginas: cantidad de paginas del libro
     * @param copias: numero de copias del libro
     */
    public Libro(String isbn, String nombre, String autor, String categoria, int cantPaginas, int copias) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.categoria = categoria;
        this.cantPaginas = cantPaginas;
        this.copias = copias;
    }

    /**
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @return categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @return numero de paginas del libro
     */
    public int getCantPaginas(){
        return cantPaginas;
    }

    /**
     *
     * @return stock
     */
    public int getCopias() {
        return copias;
    }


    /**
     *
     * @param copias
     */
    public void setCopias(int copias) {
        this.copias = copias;
    }

    /**
     *
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }
    public String toString(){
        return "Titulo: "+ this.nombre+"\n"+ "Autor: "+ this.autor+"\n"+ "Categoria: "+ this.categoria+"\n"+ "Número de copias: "+ this.copias;
    }

}
