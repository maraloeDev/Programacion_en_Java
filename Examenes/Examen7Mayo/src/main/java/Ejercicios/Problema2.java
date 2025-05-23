package Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Problema2 extends javax.swing.JFrame {

    /**
     * Creates new form Problema2
     */
    
    static String url = "jdbc:mysql://localhost:3306/carnetdb";
    static String user = "root";
    static String password = "";
    static PreparedStatement ps;
    static ResultSet rs;
    static ArrayList<Carnet> listaCarnets;
    
    public Problema2() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        muestroDatos = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCrear = new javax.swing.JMenu();
        menuBuscar = new javax.swing.JMenu();
        menuMostrar = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Problema2");

        muestroDatos.setColumns(20);
        muestroDatos.setRows(5);
        jScrollPane1.setViewportView(muestroDatos);

        menuCrear.setText("Crear");
        menuCrear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCrearMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuCrear);

        menuBuscar.setText("Buscar");
        menuBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBuscarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuBuscar);

        menuMostrar.setText("Mostrar");
        jMenuBar1.add(menuMostrar);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCrearMouseClicked
        crearCarnets();
    }//GEN-LAST:event_menuCrearMouseClicked

    private void menuBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBuscarMouseClicked
        buscarTitular();
    }//GEN-LAST:event_menuBuscarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Problema2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Problema2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Problema2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Problema2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Problema2().setVisible(true);
        });
    }
    
    private void crearCarnets() {
        listaCarnets  = new ArrayList<>();
        try(Connection conn = coneBD()) {
            ps = conn.prepareStatement("SELECT * FROM carnet");
            rs = ps.executeQuery();
            while(rs.next()) {
                int codigo = rs.getInt("codigo");
                String dni_titular = rs.getString("dni_titular");
                int puntos = rs.getInt("puntos");
                Carnet c = new Carnet(codigo, dni_titular, puntos);
                listaCarnets.add(c);
                System.out.println("carnets agregados a la lista");
            }
            
            if (!listaCarnets.isEmpty()) {
                JOptionPane.showMessageDialog(null, "La lista ya esta llena");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Problema2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void buscarTitular() {
        muestroDatos.removeAll();
        muestroDatos.setEditable(false);
         String titular = JOptionPane.showInputDialog(null, "Nombre de titular a buscar");
         
         for(Carnet busquedaTitular : listaCarnets) {
             if(busquedaTitular.getTitular().equals(titular)) {
                 muestroDatos.setText(String.valueOf(busquedaTitular.getPuntos()));
             }
         }
    }
    
    private static Connection coneBD() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuBuscar;
    private javax.swing.JMenu menuCrear;
    private javax.swing.JMenu menuMostrar;
    private javax.swing.JTextArea muestroDatos;
    // End of variables declaration//GEN-END:variables
}
