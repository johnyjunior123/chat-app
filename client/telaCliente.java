
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import models.MensagemDirecionada;
import utilidades.Write;


public class telaCliente extends javax.swing.JFrame {
    private Socket cliente;
    private String nomeUsuario;
    /**
     * Creates new form telaCliente
     */
    public telaCliente(Socket cliente) {
        initComponents();
        this.setLocationRelativeTo(null);
        Entrada entrada = new Entrada(this, true, this);
        entrada.setVisible(true);
        this.cliente = cliente;
        // na primeira vez que for entrar em contato com o servidor ele manda o nome de usuario
        try{
            PrintStream saida = new PrintStream(this.cliente.getOutputStream());
            saida.println(this.nomeUsuario);
        }catch(IOException e){
            System.out.println(e);
        }
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
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(920, 522));

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
        jScrollPane1.setViewportView(areaMensagem);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(true);
        jTextArea1.setEditable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("Mensagem Privada");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(689, 689, 689)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(butaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </  ditor-fold>             
                        

    private void butaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        Write.write(this.cliente, tratarMensagem.formatarParaEnviar(this.nomeUsuario, areaMensagem.getText()));
        renderizarPropriaMensagem(areaMensagem.getText());
        this.areaMensagem.setText(null);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        mensagemPrivada m = new mensagemPrivada(this, true, this);
        m.setVisible(true);
    }       

    public void renderizarPropriaMensagem(String mensagem){
        this.jTextArea1.append(tratarMensagem.formatarMinha(mensagem));
    }

    public void renderizarMensagemPrivada(MensagemDirecionada mensagem){
        this.jTextArea1.append(tratarMensagem.formatarMinhaPrivado(mensagem));
    }

    public void renderizarOutrasMensagens(String mensagem){
        this.jTextArea1.append(tratarMensagem.formatarRecebidoDeOutros(mensagem));
    }

    public void renderizarOutrasMensagensPrivadas(String mensagem){
        this.jTextArea1.append(tratarMensagem.formatarRecebidoPrivado(mensagem));
    }

    public void setNomeUsuario(String nome){
        this.nomeUsuario = nome;
    }

    public Socket getCliente(){
        return this.cliente;
    };

    public String getNomeUsuario(){
        return this.nomeUsuario;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JTextArea areaMensagem;
    private javax.swing.JButton butaoEnviar;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration
}
