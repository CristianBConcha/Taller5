package Forms;
import entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BuscarLibro extends JFrame{
    private JTextField ISBNtexto;
    private JPanel panel3;
    private JLabel ISBNetiqueta;
    private JButton buscarButton;
    private JTextField INFORMACION;
    private JButton menuBibliotecaButton;

    public BuscarLibro(LinkedList<Libro> libros, Usuario usuario, LinkedList<Usuario> usuarios) {
        setContentPane(panel3);
        setTitle("Buscar Libro");
        setSize(450,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        buscarButton.addActionListener(e -> buscarLibro(libros));

        //Para volver al menu principal
        menuBibliotecaButton.addActionListener(e -> {
            setVisible(false);
            MenuBiblioteca menuPrincipal = new MenuBiblioteca(libros, usuario, usuarios);
        });
    }

    /**
     * Metodo buscarLibro
     * @param libros
     */
    public void buscarLibro(LinkedList<Libro> libros){

        try{
            String isbn = ISBNtexto.getText();

            //Comprobamos que no este vacio
            if (!isbn.isEmpty()){
                for (Libro libro : libros){
                    if (libro.getIsbn().equalsIgnoreCase(ISBNtexto.getText())){
                        INFORMACION.setText(libro+"");
                        return;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(panel3, "Ingrese un ISBN",
                        "Error al buscar libro", JOptionPane.ERROR_MESSAGE);
            }
            //Si no se encuentra el libro
            INFORMACION.setText("Libro no encontrado");

        }catch (Exception e){
            JOptionPane.showMessageDialog(panel3,"Ha ocurrido un error"+e.getMessage());
        }
    }
}
