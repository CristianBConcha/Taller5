package Forms;
import entities.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MenuBiblioteca extends JFrame{
    private JPanel panel2;
    private JButton BUSCARLIBRO;
    private JButton PRESTARLIBRO;
    private JButton AGREGARLIBRONUEVO;
    private JButton DEVOLVERLIBRO;
    private JButton salirButton;

    public MenuBiblioteca(LinkedList<Libro> libros, Usuario usuario, LinkedList<Usuario> usuarios) {
        setContentPane(panel2);
        setTitle("Menu de Biblioteca");
        setSize(450, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        //Si aprieta el boton buscar libro
        BUSCARLIBRO.addActionListener(e -> {
            setVisible(false);
            BuscarLibro buscarLibro = new BuscarLibro(libros, usuario, usuarios);
        });

        //Si aprieta el boton prestar libro
        PRESTARLIBRO.addActionListener(e -> {
            setVisible(false);
            PrestarLibro prestarLibro = new PrestarLibro(libros,usuario,usuarios);
        });

        //Si aprita el boton agregar libro
        AGREGARLIBRONUEVO.addActionListener(e ->{
            setVisible(false);
            AgregarLibro agregarLibro = new AgregarLibro(libros, usuario, usuarios);
        });
        //Si aprieta el boton salir
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

                System.exit(0);
            }
        });
        //Si aprieta el boton DEVOLVERLIBRO
        DEVOLVERLIBRO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                DevolverLibro prestarLibro = new DevolverLibro(libros,usuario,usuarios);

            }
        });
    }
}
