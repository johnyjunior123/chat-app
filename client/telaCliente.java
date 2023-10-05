import java.net.Socket;
import java.util.ArrayList;

public class telaCliente extends javax.swing.JFrame {
    private Socket cliente;
    private ArrayList<String>mensagem_list;
    /**
     * Creates new form telaCliente
     */
    public telaCliente(Socket cliente) {
        initComponents();
        this.cliente = cliente;
        this.mensagem_list = new ArrayList<String>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        butaoEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMensagem = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensagens = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 522));

        butaoEnviar.setText("Enviar");
        butaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoEnviarActionPerformed(evt);
            }
        });

        areaMensagem.setColumns(20);
        areaMensagem.setLineWrap(true);
        areaMensagem.setRows(3);
        areaMensagem.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        areaMensagem.setNextFocusableComponent(butaoEnviar);
        jScrollPane1.setViewportView(areaMensagem);

        mensagens.setColumns(20);
        mensagens.setRows(5);
        mensagens.setEditable(false);
        jScrollPane2.setViewportView(mensagens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(689, 689, 689)
                            .addComponent(jSeparator1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(butaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>                        
                        

    private void butaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        Write.write(this.cliente, areaMensagem.getText());
        renderizarPropriaMensagem(areaMensagem.getText());
        this.areaMensagem.setText(null);
        // TODO add your handling code here:
    }                                           

    private void renderizarPropriaMensagem(String mensagem){
        this.mensagens.append(tratarMensagem.formatar(mensagem));
    }

    public void renderizarOutrasMensagens(String mensagem){
        this.mensagens.append(tratarMensagem.formatar(mensagem));
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea areaMensagem;
    private javax.swing.JButton butaoEnviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea mensagens;
    // End of variables declaration
}
