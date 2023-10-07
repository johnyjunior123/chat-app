import models.Mensagem;
import models.MensagemDirecionada;
import utilidades.Write;
import utilidades.criarData;

public class mensagemPrivada extends javax.swing.JDialog {
    private telaCliente tela;
    /**
     * Creates new form mensagemPrivada
     */
    public mensagemPrivada(java.awt.Frame parent, boolean modal, telaCliente tela) {
        super(parent, modal);
        this.tela = tela;
        this.setLocationRelativeTo(tela);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(3);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Enviar");
        
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String destinatario = jList1.getSelectedValue();
                String mensagem = jTextArea1.getText();
                MensagemDirecionada m = new MensagemDirecionada(criarData.criar(), mensagem, tela.getNomeUsuario(), destinatario);
                System.out.println(m.toString());
                Write.write(tela.getCliente(), m.toString());
                tela.renderizarMensagemPrivada(m);
            }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    //     /* Set the Nimbus look and feel */
    //     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //     /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //      * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //      */
    //     try {
    //         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //             if ("Nimbus".equals(info.getName())) {
    //                 javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                 break;
    //             }
    //         }
    //     } catch (ClassNotFoundException ex) {
    //         java.util.logging.Logger.getLogger(mensagemPrivada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (InstantiationException ex) {
    //         java.util.logging.Logger.getLogger(mensagemPrivada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (IllegalAccessException ex) {
    //         java.util.logging.Logger.getLogger(mensagemPrivada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //         java.util.logging.Logger.getLogger(mensagemPrivada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //     }
    //     //</editor-fold>

    //     /* Create and display the dialog */
    //     // java.awt.EventQueue.invokeLater(new Runnable() {
    //     //     public void run() {
    //     //         mensagemPrivada dialog = new mensagemPrivada(new javax.swing.JFrame(), true);
    //     //         dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    //     //             @Override
    //     //             public void windowClosing(java.awt.event.WindowEvent e) {
    //     //                 System.exit(0);
    //     //             }
    //     //         });
    //     //         dialog.setVisible(true);
    //     //     }
    //     // });
    // }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}