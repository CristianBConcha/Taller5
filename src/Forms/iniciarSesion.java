package Forms;
import javax.swing.*;
import java.util.LinkedList;
import entities.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class iniciarSesion extends JFrame{
    private JPanel panel1;
    private JTextField RUT;
    private JTextField CONTRASENIA;
    private JButton iniciarSesionButton;
    private Usuario usuario;
    private Libro libros;

    public iniciarSesion(LinkedList<Usuario> usuarios, LinkedList<Libro> libros) {

        setContentPane(panel1);
        setTitle("Iniciar Sesion");
        setSize(450,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        iniciarSesionButton.addActionListener(e -> iniciar(usuarios, libros));
    }
    /**
     * Metodo para vaciar los campos de escritura
     */
    public void vaciar(){
        CONTRASENIA.setText("");
        RUT.setText("");
    }

    public void iniciar(LinkedList<Usuario> usuarios, LinkedList<Libro> libros){
        try{
            String rut = RUT.getText();
            String contrasenia = CONTRASENIA.getText();
            //Procuramos que los campos no esten vacios
            if (!contrasenia.isEmpty() && !rut.isEmpty()){
                //Si no escriben nada
                if (this.usuario == null) {
                    vaciar();
                    JOptionPane.showMessageDialog(panel1, "Credenciales invalidas",
                            "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);

                    // Se busca si el usuario esta en la lista de usuarios
                    for (Usuario usuario : usuarios) {
                        if (usuario.getContrasenia().equalsIgnoreCase(contrasenia) && usuario.getRut().equalsIgnoreCase(rut)) {
                            this.usuario = usuario;
                            break;
                        }
                    }
                } else {
                    vaciar();
                    setVisible(false);
                    MenuBiblioteca menu = new MenuBiblioteca(libros,this.usuario,usuarios);
                }
            } else {
                //Si no se encuentra al usuario
                vaciar();
                JOptionPane.showMessageDialog(panel1, "Error, intentelo denuevo.",
                        "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(panel1,"Ocurrió un error: "+e.getMessage());
        }
    }

}
