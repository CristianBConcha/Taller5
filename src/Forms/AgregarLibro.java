package Forms;
import entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class AgregarLibro extends JFrame{
    private JTextField ISBNField1;
    private JPanel panel5;
    private JTextField TituloField2;
    private JTextField AutorField3;
    private JTextField CategoriaField4;
    private JTextField CantPagField5;
    private JTextField CopiasField6;
    private JButton agregarButton;
    private JButton menuPrincipalButton;

    public AgregarLibro(LinkedList<Libro> libros, Usuario usuario, LinkedList<Usuario> usuarios) {
        setContentPane(panel5);
        setTitle("Agregar Libro");
        setSize(450,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Accion del boton de agregar libro en el form
        agregarButton.addActionListener(e -> agregarLibro(libros));

        // Accion del boton de volver al menu principal en el form
        menuPrincipalButton.addActionListener(e -> {
            setVisible(false);
            MenuBiblioteca menu = new MenuBiblioteca(libros, usuario, usuarios);
        });
    }

    public void agregarLibro(LinkedList<Libro> libros){

        try{
            String isbn = ISBNField1.getText();
            //Comprobamos que no este vacio
            if (!isbn.isEmpty()){
                //Revisamos si el libro ya esta agregado
                for (Libro libro : libros){
                    if (libro.getIsbn().equalsIgnoreCase(ISBNField1.getText())){
                        JOptionPane.showMessageDialog(panel5, "Libro registrado, intente con otro",
                                "Error agregando el libro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            } else { // El campo de isbn estaba vacio
                JOptionPane.showMessageDialog(panel5, "Rellene todos los campos",
                        "Error al agregar libro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String titulo = TituloField2.getText();
            String autor = AutorField3.getText();
            String categoria = CategoriaField4.getText();
            String cantPag = CantPagField5.getText();
            String copias = CopiasField6.getText();

            // Vemos que los datos no esten vacios
            if (!copias.isEmpty() && !autor.isEmpty() && !categoria.isEmpty() && !titulo.isEmpty() && !cantPag.isEmpty()){
                int cantCopias;
                int cantPaginas;

                //Try para que solamente ocupen numeros
                try{
                    cantCopias = Integer.parseInt(copias);
                    cantPaginas= Integer.parseInt(cantPag);
                } catch (IllegalArgumentException e){
                    CopiasField6.setText("");
                    JOptionPane.showMessageDialog(panel5, "Ingrese un numero valido para la cantidad de copias",
                            "Error al agregar libro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Verificamos que los numeros ingreasados sean validos
                if (cantCopias < 0){
                    JOptionPane.showMessageDialog(panel5, "No puede agregar numeros negativos",
                            "Error al agregar libro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (cantPaginas <= 0){
                    JOptionPane.showMessageDialog(panel5, "Ingrese una cantidad valida",
                            "Error al agregar libro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Se procede a agregar el libro
                Libro libro = new Libro(isbn,titulo,autor, categoria,cantCopias,cantPaginas);
                libros.add(libro);
                ISBNField1.setText("");
                TituloField2.setText("");
                AutorField3.setText("");
                CategoriaField4.setText("");
                CantPagField5.setText("");
                CopiasField6.setText("");
                JOptionPane.showMessageDialog(panel5, "Libro agregado!",
                        "Menú de Biblioteca", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(panel5, "Intentelo nuevamente",
                        "Error al agregar libro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){ // Ante cualquier error en el sistema
            JOptionPane.showMessageDialog(panel5,"Ha ocurrido un error: "+e.getMessage());
        }
    }
}
