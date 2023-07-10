package Forms;

import entities.Libro;
import entities.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class DevolverLibro extends JFrame {

    private JButton aceptarButton;
    private JPanel panel1;
    private JTextField textField1;
    private JButton menuButton;
    private JTextField textField2;

    public DevolverLibro(LinkedList<Libro> libros, Usuario usuario, LinkedList<Usuario> usuarios) {
        setContentPane(panel1);
        setTitle("Menu Biblioteca");
        setSize(450,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        aceptarButton.addActionListener(e -> devolver(libros));

        //Para volver al menu principal
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MenuBiblioteca menuPrincipal = new MenuBiblioteca(libros, usuario, usuarios);
            }
        });

    }
    public void devolver(LinkedList<Libro> libros){
        try{
            String isbn = textField1.getText();

            //Comprobamos que no este vacio
            if (!isbn.isEmpty()){
                for (Libro libro : libros){
                    if (libro.getIsbn().equalsIgnoreCase(textField1.getText())){
                        libro.setCopias(libro.getCopias()+1);
                        textField2.setText("Se ha devuelto el libro exitosamente, stock actual : "+libro.getCopias());
                        return;

                    }
                }
            } else {
                JOptionPane.showMessageDialog(panel1, "Ingrese un ISBN",
                        "Error al buscar libro", JOptionPane.ERROR_MESSAGE);
            }
            //Si no se encuentra el libro
            textField2.setText("Libro no encontrado");

        }catch (Exception e){
            JOptionPane.showMessageDialog(panel1,"Ha ocurrido un error"+e.getMessage());
        }

    }

}
