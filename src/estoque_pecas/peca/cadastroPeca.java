package estoque_pecas.peca;
import estoque_pecas.filtros.caixaAlta;
import estoque_pecas.filtros.soNumeros;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import estoque_pecas.comandos.ClasseConexao;

/**
 *
 * @author rafae
 */
public class cadastroPeca extends javax.swing.JFrame {

    /**
     * Creates new form cadastro_peca
     */
    public cadastroPeca() {
        initComponents();
        codPeca.setDocument(new caixaAlta());
        valorPeca.setDocument(new soNumeros());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        codPeca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomePeca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        unidadePeca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        valorPeca = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        descPeca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Peças");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

        jLabel1.setText("Código:");

        jLabel2.setText("Nome:");

        jLabel3.setText("Unidade:");

        unidadePeca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNIDADE", "JOGO", "KIT", "CONJUNTO", " " }));
        unidadePeca.setSelectedIndex(4);
        unidadePeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidadePecaActionPerformed(evt);
            }
        });

        jLabel4.setText("Valor:");

        valorPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorPecaActionPerformed(evt);
            }
        });

        jLabel5.setText("Descrição da peça:");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codPeca)
                            .addComponent(nomePeca, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(unidadePeca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(valorPeca)))
                    .addComponent(descPeca)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(unidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomePeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(valorPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void unidadePecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidadePecaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unidadePecaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(valorPeca.getText().equals("") || valorPeca.getText() == null){
            valorPeca.setText("0");
        }
        double valorPecaFormat = Double.parseDouble(valorPeca.getText().replaceAll(",", "."));
        valorPeca.setText(String.valueOf(valorPecaFormat).format("%.2f", valorPecaFormat));
        int select = unidadePeca.getSelectedIndex();
        String selectText = "";
        if(select == 0){selectText = "UNIDADE";}
        if(select == 1){selectText = "JOGO";}
        if(select == 2){selectText = "KIT";}
        if(select == 3){selectText = "CONJUNTO";}
        // verificando se já existe a peça
        Connection conexao = null;
        Statement comando = null;
        ResultSet resultado = null;
        int quantPeca = 0;
        try
        {
                conexao = ClasseConexao.Conectar();
                comando = conexao.createStatement();

                String sql = "SELECT count(cod_peca) FROM pecas WHERE cod_peca = '" + codPeca.getText() + "'";
                resultado = comando.executeQuery(sql);
                while(resultado.next())
                {
                        quantPeca = Integer.parseInt(resultado.getString("count(cod_peca)"));
                }
        }catch(SQLException erro)
        {
                erro.printStackTrace();
        }finally
        {
                ClasseConexao.FecharConexao(conexao);
                try
                {
                        comando.close();
                }catch(SQLException erro)
                {
                        erro.printStackTrace();
                }
        }
        if(quantPeca == 1){
            JOptionPane.showMessageDialog(null, "Este código já existe!");
        }else{
                    //insert dados peças
            String codPecaN = codPeca.getText();
            String nomePecaN = nomePeca.getText();
            String descPecaN = descPeca.getText();
            //validação de tamanho do textfield
            if(
                valorPecaFormat == 0 || 
                codPecaN.length() < 3 || codPecaN.length() > 50 ||
                nomePecaN.length() < 3 || nomePecaN.length() > 50 ||
                descPecaN.length() < 3 || descPecaN.length() > 50 ||
                select == 4 
               ){
                JOptionPane.showMessageDialog(null, "Informações de peça incompleta!\nCódigo: 3 a 50 caracteres\nNome: 3 a 50 caracteres\nDescrição: 3 a 50 caracteres\nValor: maior que zero\nUnidade: obrigatório");
            }
            else{
                conexao = null;
                PreparedStatement comandoIn = null;
                try {
                conexao = ClasseConexao.Conectar();
                String sql = "INSERT into pecas(cod_peca, nome_peca, desc_peca, valor_peca, uni_peca, quant_peca) VALUES(?,?,?,?,?,?)";
                comandoIn = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

                comandoIn.setString(1, codPeca.getText());
                comandoIn.setString(2, nomePeca.getText());
                comandoIn.setString(3, descPeca.getText());
                comandoIn.setDouble(4, valorPecaFormat);
                comandoIn.setString(5, selectText);
                comandoIn.setInt(6, 0);

                if(comandoIn.executeUpdate()>0){
                    this.dispose();
                    JOptionPane.showMessageDialog(null, "Peça cadastrada!");
                }
                } catch(SQLException erro) {
                    erro.printStackTrace();
                } finally {
                    ClasseConexao.FecharConexao(conexao);

                    try{
                        comandoIn.close();
                    } catch(SQLException erro) {
                        erro.printStackTrace();
                    }
                }  
            }
        }
        
        
              
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    }//GEN-LAST:event_jButton2ActionPerformed

    private void valorPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorPecaActionPerformed

    }//GEN-LAST:event_valorPecaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        valorPeca.setText("0");
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(cadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroPeca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codPeca;
    private javax.swing.JTextField descPeca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomePeca;
    private javax.swing.JComboBox<String> unidadePeca;
    private javax.swing.JTextField valorPeca;
    // End of variables declaration//GEN-END:variables
}
