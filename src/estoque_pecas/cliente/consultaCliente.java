package estoque_pecas.cliente;
import javax.swing.JOptionPane; 
import estoque_pecas.filtros.soNumerosQtd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import estoque_pecas.comandos.ClasseConexao;

public class consultaCliente extends javax.swing.JFrame {


    public consultaCliente() {
        initComponents();
        nomeConsulta.setEditable(false);
        enderecoConsulta.setEditable(false);
        telefoneConsulta.setEditable(false);
        jButton3.setEnabled(false);
        cpfConsultaSearch.setDocument(new soNumerosQtd());
        telefoneConsulta.setDocument(new soNumerosQtd());  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nomeConsulta = new javax.swing.JTextField();
        enderecoConsulta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telefoneConsulta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cpfConsultaSearch = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Clientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Telefone:");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Editar");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir Cliente");
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
                    .addComponent(nomeConsulta)
                    .addComponent(enderecoConsulta)
                    .addComponent(telefoneConsulta)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(nomeConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(telefoneConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("CPF do cliente:");

        cpfConsultaSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfConsultaSearchActionPerformed(evt);
            }
        });

        jButton2.setText("Procurar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfConsultaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cpfConsultaSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cpfConsultaSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfConsultaSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfConsultaSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int nome = nomeConsulta.getText().length();
        int telefone = telefoneConsulta.getText().length();
        int endereco = enderecoConsulta.getText().length();
        if(nome < 4 || nome > 50 || telefone < 10 || telefone > 20 || endereco < 4 || endereco > 100){JOptionPane.showMessageDialog(null, "Dados de alteração inválidos!");}
        else{
        Connection conexao = null;
        PreparedStatement comandoIn = null;
        try{conexao = ClasseConexao.Conectar();
            //LINHA DE INSERT, DELETE E UPDATE SQL
            String sqlIn = "UPDATE clientes SET nome_cliente=?, endereco_cliente=?, telefone_cliente=? WHERE cpf=?";
            comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);

            //VALORES PARA OS CAMPOS DA LINHA SQL  
            comandoIn.setString(1, nomeConsulta.getText());
            comandoIn.setString(2, enderecoConsulta.getText());
            comandoIn.setString(3, telefoneConsulta.getText());
            comandoIn.setString(4, cpfConsultaSearch.getText());
                
            if(comandoIn.executeUpdate()>0)
            {
                //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO 
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");

            }}catch(SQLException erro)
        {erro.printStackTrace();}
        finally{ClasseConexao.FecharConexao(conexao);
            try{comandoIn.close();}
            catch(SQLException erro){erro.printStackTrace();}}
        
        
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ItemStateChanged

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()){
            nomeConsulta.setEditable(true);
            enderecoConsulta.setEditable(true);
            telefoneConsulta.setEditable(true);
            jButton3.setEnabled(true);
        }else{
            nomeConsulta.setEditable(false);
            enderecoConsulta.setEditable(false);
            telefoneConsulta.setEditable(false);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conexao = null;
        PreparedStatement comando = null;
        int result = JOptionPane.showConfirmDialog(null,"Confirme para excluir: "+cpfConsultaSearch.getText(),"Excluindo...", JOptionPane.YES_NO_CANCEL_OPTION);
        if(result == 0){
            try
            {
                conexao = ClasseConexao.Conectar();
                String sql = "DELETE FROM clientes WHERE cpf=?";
                comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                comando.setString(1, cpfConsultaSearch.getText());

                if(comando.executeUpdate()>0)
                {
                        this.dispose();
                        JOptionPane.showMessageDialog(null,"Cliente Excluído!");

                }else{
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
                    cpfConsultaSearch.setText("");
                }
                }catch(SQLException erro)
                {
                        erro.printStackTrace();
                }finally {
                    ClasseConexao.FecharConexao(conexao);
                    try
                    {
                        comando.close();
                    }catch(SQLException erro)
                    {
                        erro.printStackTrace();
                    }           
                }
        }else{
            cpfConsultaSearch.setText("");
            nomeConsulta.setText("");
            telefoneConsulta.setText("");
            enderecoConsulta.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conexao = null;
        Statement comandoSelect = null;
        ResultSet resultado = null;
        int qtdCpfSearch = 0;
        try
        {
            conexao = ClasseConexao.Conectar();
            comandoSelect = conexao.createStatement();
            //LINHA DE BUSCA SQL
            String sqlSelect = "SELECT count(cpf), nome_cliente, endereco_cliente, telefone_cliente FROM clientes WHERE cpf = '" + cpfConsultaSearch.getText() + "'";
            resultado = comandoSelect.executeQuery(sqlSelect);
            //RESULTADO DA BUSCA
            while(resultado.next())
            {
                qtdCpfSearch = Integer.parseInt(resultado.getString("count(cpf)"));
                nomeConsulta.setText(resultado.getString("nome_cliente"));
                enderecoConsulta.setText(resultado.getString("endereco_cliente"));
                telefoneConsulta.setText(resultado.getString("telefone_cliente"));
            }

        }catch(SQLException erro){erro.printStackTrace();}
        finally{ClasseConexao.FecharConexao(conexao);
            try{comandoSelect.close();}
            catch(SQLException erro){erro.printStackTrace();}}
        if(qtdCpfSearch == 0){
            JOptionPane.showMessageDialog(null, "Este CPF não está cadastrado!");
            cpfConsultaSearch.setText("");        
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
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
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cpfConsultaSearch;
    private javax.swing.JTextField enderecoConsulta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeConsulta;
    private javax.swing.JTextField telefoneConsulta;
    // End of variables declaration//GEN-END:variables
}
