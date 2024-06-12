package estoque_pecas.peca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;  
import estoque_pecas.comandos.ClasseConexao;
import estoque_pecas.filtros.caixaAlta;
import estoque_pecas.filtros.soNumeros;
/**
 *
 * @author rafae
 */
public class consultaPeca extends javax.swing.JFrame {

    /**
     * Creates new form consultaPeca
     */
    public consultaPeca() {
        initComponents();
        codEdit.setDocument(new caixaAlta());
        valorEdit.setDocument(new soNumeros());
        
        nomeEdit.setEditable(false);
        descEdit.setEditable(false);
        valorEdit.setEditable(false);
        unidadeEdit.setEnabled(false);
        nomeEdit.setEditable(false);
        deletarEdit.setEnabled(false);
        salvarEdit.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codEdit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        nomeEdit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descEdit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        valorEdit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        unidadeEdit = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        qtdEdit = new javax.swing.JTextField();
        salvarEdit = new javax.swing.JButton();
        deletarEdit = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Peça");
        setResizable(false);

        jLabel1.setText("Código");

        jLabel2.setText("Nome");

        jLabel3.setText("Descrição");

        jLabel4.setText("Valor");

        jLabel5.setText("Unidade");

        unidadeEdit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UNIDADE", "JOGO", "KIT", "CONJUNTO", " " }));
        unidadeEdit.setSelectedIndex(4);

        jButton1.setText("Procurar");
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

        jLabel6.setText("Quantidade");

        qtdEdit.setEditable(false);

        salvarEdit.setText("Salvar ");
        salvarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarEditActionPerformed(evt);
            }
        });

        deletarEdit.setText("Deletar Peça");
        deletarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletarEditActionPerformed(evt);
            }
        });

        jButton5.setText("Tabela");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomeEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descEdit, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(deletarEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(valorEdit)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(unidadeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(qtdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salvarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(descEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unidadeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarEdit)
                    .addComponent(deletarEdit)
                    .addComponent(jButton5))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new tabelaPecas().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        codEdit.setText("");
        nomeEdit.setText("");
        descEdit.setText("");
        valorEdit.setText("");
        unidadeEdit.setSelectedIndex(4);
        qtdEdit.setText("");
        
        codEdit.setEditable(true);
        nomeEdit.setEditable(false);
        descEdit.setEditable(false);
        valorEdit.setEditable(false);
        unidadeEdit.setEnabled(false);
        nomeEdit.setEditable(false);
        deletarEdit.setEnabled(false);
        salvarEdit.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    codEdit.setEditable(false);
    nomeEdit.setEditable(true);
    descEdit.setEditable(true);
    valorEdit.setEditable(true);
    unidadeEdit.setEnabled(true);
    nomeEdit.setEditable(true);
    deletarEdit.setEnabled(true);
    salvarEdit.setEnabled(true);
        
        
    Connection conexao = null;
    Statement comandoSelect = null;
    ResultSet resultado = null;
    try
    {
        conexao = ClasseConexao.Conectar();
        comandoSelect = conexao.createStatement();
        //LINHA DE BUSCA SQL
        String sqlSelect = "SELECT count(cod_peca), nome_peca, desc_peca, valor_peca, uni_peca, quant_peca FROM pecas WHERE cod_peca = '" + codEdit.getText() + "'";
        resultado = comandoSelect.executeQuery(sqlSelect);
        //RESULTADO DA BUSCA
        while(resultado.next())
        {
            String resultUni = resultado.getString("uni_peca");
            if(resultUni == null || resultUni.equals("")){resultUni = "";}
            int resultInt = 0;
            if(resultUni.equals("UNIDADE")){resultInt = 0;}
            if(resultUni.equals("JOGO")){resultInt = 1;}
            if(resultUni.equals("KIT")){resultInt = 2;}
            if(resultUni.equals("CONJUNTO")){resultInt = 3;}
            
            nomeEdit.setText(resultado.getString("nome_peca"));
            descEdit.setText(resultado.getString("desc_peca"));
            valorEdit.setText(resultado.getString("valor_peca"));
            unidadeEdit.setSelectedIndex(resultInt);
            qtdEdit.setText(resultado.getString("quant_peca"));
            
            int countCod = Integer.parseInt(resultado.getString("count(cod_peca)"));
            if(countCod == 0){
                JOptionPane.showMessageDialog(null, "Peça não cadastrada!");
                codEdit.setText("");
                nomeEdit.setText("");
                descEdit.setText("");
                valorEdit.setText("");
                unidadeEdit.setSelectedIndex(4);
                qtdEdit.setText("");
                codEdit.setEditable(true);
                nomeEdit.setEditable(false);
                descEdit.setEditable(false);
                valorEdit.setEditable(false);
                unidadeEdit.setEnabled(false);
                nomeEdit.setEditable(false);
                deletarEdit.setEnabled(false);
                salvarEdit.setEnabled(false);
            }
            
            
            
        }

    }catch(SQLException erro){erro.printStackTrace();}
    finally{ClasseConexao.FecharConexao(conexao);
        try{comandoSelect.close();}
        catch(SQLException erro){erro.printStackTrace();}}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void deletarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletarEditActionPerformed
        Connection conexao = null;
        PreparedStatement comando = null;
        int result = JOptionPane.showConfirmDialog(null,"Confirme para excluir: "+codEdit.getText(),"Excluindo...", JOptionPane.YES_NO_CANCEL_OPTION);
        if(result == 0){
            try
            {
                conexao = ClasseConexao.Conectar();
                String sql = "DELETE FROM pecas WHERE cod_peca=?";
                comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                comando.setString(1, codEdit.getText());

                if(comando.executeUpdate()>0)
                {
                        this.dispose();
                        JOptionPane.showMessageDialog(null,"Peça Excluída!");

                }else{
                    JOptionPane.showMessageDialog(null, "Peça não encontrado!");
                    codEdit.setText("");
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
        }
    }//GEN-LAST:event_deletarEditActionPerformed

    private void salvarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarEditActionPerformed
        int tnome = nomeEdit.getText().length();
        int tdesc = descEdit.getText().length();
        if(valorEdit.getText().equals("") || valorEdit.getText() == null){
            valorEdit.setText("0");
        }
        double valor = Double.parseDouble(valorEdit.getText().replaceAll(",", "."));
        valorEdit.setText(String.valueOf(valor).format("%.2f", valor));
        int select = unidadeEdit.getSelectedIndex();
        String selectText = "";
        if(select == 0){selectText = "UNIDADE";}
        if(select == 1){selectText = "JOGO";}
        if(select == 2){selectText = "KIT";}
        if(select == 3){selectText = "CONJUNTO";}
        
        Connection conexao = null;
        PreparedStatement comandoIn = null;
        
        if(tnome < 4 || tnome > 50 || tdesc < 4 || tdesc > 100 || valor == 0 || select == 4){
            JOptionPane.showMessageDialog(null, "Informações inválidas para alteração!");
        }else{
                try{conexao = ClasseConexao.Conectar();
            //LINHA DE INSERT, DELETE E UPDATE SQL
            String sqlIn = "UPDATE pecas SET nome_peca=?, desc_peca=?, valor_peca=?, uni_peca=? WHERE cod_peca=?";
            comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);

            //VALORES PARA OS CAMPOS DA LINHA SQL  
            comandoIn.setString(1, nomeEdit.getText());
            comandoIn.setString(2, descEdit.getText());
            comandoIn.setDouble(3, valor);
            comandoIn.setString(4, selectText);
            comandoIn.setString(5, codEdit.getText());

            if(comandoIn.executeUpdate()>0)
            {
                //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO
                JOptionPane.showMessageDialog(null, "Peça alterada com sucesso!");
                this.dispose();

            }}catch(SQLException erro)
        {erro.printStackTrace();}
        finally{ClasseConexao.FecharConexao(conexao);
            try{comandoIn.close();}
            catch(SQLException erro){erro.printStackTrace();}}
        }
        
        

        
    }//GEN-LAST:event_salvarEditActionPerformed

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
            java.util.logging.Logger.getLogger(consultaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaPeca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaPeca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codEdit;
    private javax.swing.JButton deletarEdit;
    private javax.swing.JTextField descEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nomeEdit;
    private javax.swing.JTextField qtdEdit;
    private javax.swing.JButton salvarEdit;
    private javax.swing.JComboBox<String> unidadeEdit;
    private javax.swing.JTextField valorEdit;
    // End of variables declaration//GEN-END:variables
}