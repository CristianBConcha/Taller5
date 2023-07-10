package Forms;

import entities.Libro;
import entities.Usuario;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

public class PrestarLibro extends JFrame{
    private JPanel panel4;
    private JTextField ISBNField1;
    private JButton buscarButton;
    private JLabel ISBNLabel;
    private JButton menuBibliotecaButton;

    public PrestarLibro(LinkedList<Libro> libros, Usuario usuario, LinkedList<Usuario> usuarios) {
        setContentPane(panel4);
        setTitle("Prestar Libro");
        setSize(450, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buscarButton.addActionListener(e -> prestarLibro(libros,usuario));

        //Para volver al menu principal
        menuBibliotecaButton.addActionListener(e -> {
            setVisible(false);
            MenuBiblioteca menuPrincipal = new MenuBiblioteca(libros, usuario, usuarios);
        });
    }

    public void prestarLibro(LinkedList<Libro>libros, Usuario usuario){
        try{
            String isbn = ISBNField1.getText();
            //Comprobamos que no este vacio
            if (!isbn.isEmpty()){
                for (Libro libro : libros){
                    if (libro.getIsbn().equalsIgnoreCase(ISBNField1.getText())){
                        if(libro.getCopias()>0){
                            int copias = libro.getCopias();

                            String nombreLibro = libro.getNombre();
                            String rut = usuario.getRut();
                            String nombre = usuario.getNombre();
                            String apellido = usuario.getApellido();
                            // Restamos la cantidad de copias
                            libro.setCopias(copias-1);
                            // Guardamos los cambios
                            BufferedWriter bw = new BufferedWriter(new FileWriter("registro.txt",true));
                            String[] data = {rut,nombre,apellido,isbn,nombreLibro,"préstamo"};
                            bw.write(String.join(",",data));
                            bw.newLine();
                            bw.close();
                            JOptionPane.showMessageDialog(panel4, "Prestamo exitoso",
                                    "Menú de Biblioteca", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }
            } else {
                //Si esta vacio
                JOptionPane.showMessageDialog(panel4, "Ingrese un ISBN",
                        "Error al buscar libro", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(panel4,"Ha ocurrido un error"+e.getMessage());
        }
    }
}
