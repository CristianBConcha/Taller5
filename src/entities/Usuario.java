package entities;

public class Usuario {
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String rut;

    public Usuario(String nombre, String apellido, String contrasenia, String rut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.rut = rut;
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
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @return contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     *
     * @return rut
     */
    public String getRut() {
        return rut;
    }
}
