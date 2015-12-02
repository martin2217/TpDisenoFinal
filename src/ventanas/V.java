/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import modelo.CompetenciaAux;

/**
 *
 * @author Martin
 */
public class V extends javax.swing.JFrame {
   
    // Forma de SINGLETON
    private static V SELF = new V();
    //private V() {}
    public static V get(){
        return SELF;
    }
    
    /**
     * Creates new form VentanaPrincipal
     */
    private V() {
        initComponents();
    }
    
    private JPanel aux;
    private JPanel aux2;
    
    public void limpiar(){
        //SELF.removeAll(); NOOOO, elimina nose que masss
        remove(aux);
    }
    
    public void menu(){
        limpiar();
        aux = new Menu();
        add(aux);
        revalidate();
        repaint();
    }
    public void menuVolver(){
        remove(aux2);
        remove(aux);
        aux = new Menu();
        add(aux);
        revalidate();
        repaint();
    }
    public void mostrarFixture(){
        limpiar();
        aux = new MostrarFixture();
        add(aux);
        revalidate();
        repaint();
    }
        public void mostrarTablaPosiciones(){
        limpiar();
        aux = new MostrarTablaPosiciones();
        add(aux);
        revalidate();
        repaint();
    }
    
        public void altaParticipante(){
        limpiar();
        aux = new AltaParticipante();
        add(aux);
        revalidate();
        repaint();
    }
    
    public void verCompetencia(CompetenciaAux compAux){
        aux.setVisible(false);
        aux2 = new VerCompetencia(compAux);
        add(aux2);
        revalidate();
        repaint();
    }
    
    public void listarParticipantes(CompetenciaAux compAux){
        limpiar();
        aux = new ListarParticipantes(compAux);
        add(aux);
        revalidate();
        repaint();
    }
    public void listarCD(){
        limpiar();
        aux=new ListarCompetencias();
        add(aux);
        revalidate();
        repaint();
    }
    public void listarCDVolver(){
        remove(aux2);
        aux2=null;
        aux.setVisible(true);
        revalidate();
        repaint();
    }
    public void altaCompetencia(){
        aux.setVisible(false);
        aux2 = new AltaCompetencia();
        add(aux2);
        revalidate();
        repaint();
    }
    
    public void salir(){
        System.exit(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        
        
        //ICONOS
        final List<Image> icons = new ArrayList<>();
        //URL icon16 = getClass().getResource("/some/package/favicon.png");
        //URL icon32 = getClass().getResource("/some/package/favicon.png");
        //URL icon64 = getClass().getResource("/some/package/favicon.png");
        ImageIcon icon16 = new ImageIcon(getClass().getResource("/imagenes/img_icono16x16.png"));
        ImageIcon icon32 = new ImageIcon(getClass().getResource("/imagenes/img_icono32x32.png"));
        ImageIcon icon64 = new ImageIcon(getClass().getResource("/imagenes/img_icono64x64.png"));
        
        icons.add(icon16.getImage());
        icons.add(icon32.getImage());
        icons.add(icon64.getImage());
        
        setIconImages(icons);
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 630));
        setPreferredSize(new java.awt.Dimension(800, 630));
        setResizable(false);
        setLocationRelativeTo(null);
        
        aux=new Bienvenido();
        aux.setVisible(true);
        add(aux);
        
        
        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new V().get().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    
    // End of variables declaration                   
}
