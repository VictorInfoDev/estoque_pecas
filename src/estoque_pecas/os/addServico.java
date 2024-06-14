package estoque_pecas.os;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import estoque_pecas.filtros.caixaAlta;
import estoque_pecas.filtros.soNumeros;
import estoque_pecas.comandos.ClasseConexao;
import net.proteanit.sql.DbUtils;


public class addServico extends javax.swing.JFrame {

    private int os;
    private double valorS = 0;
    private double valorP = 0;
    private double valorTotal = 0;
    
public void Selecionando()
	{
            //buscar dados usuários para tabela 
            Connection conexao = null;
            Statement  comando = null;
            ResultSet  resultado = null;
            try {
                    conexao = ClasseConexao.Conectar();
                    comando = conexao.createStatement();
                    String meu_sql = "SELECT desc_servico, valor_os FROM ordem_servico WHERE id_os='"+os+"'";
                    resultado = comando.executeQuery(meu_sql);
                    while(resultado.next()){
                        descServico.setText(resultado.getString("desc_servico"));
                        valorS = Double.parseDouble(resultado.getString("valor_os"));
                    }
            }
            catch (SQLException e)
            {
                    e.printStackTrace();
            }
            finally
            {
                ClasseConexao.FecharConexao(conexao);
                try
                {
                        comando.close();
                        resultado.close();
                }
                catch (SQLException e)
                {
                        e.printStackTrace();
                }
            }
            try {
                    conexao = ClasseConexao.Conectar();
                    comando = conexao.createStatement();
                    String meu_sql = "SELECT SUM(valor_total) FROM pecas_os WHERE id_os_peca='"+os+"'";
                    resultado = comando.executeQuery(meu_sql);
                    while(resultado.next()){
                        if(resultado.getString("SUM(valor_total)") == null){valorP=0;}
                        else{
                            valorP = Double.parseDouble(resultado.getString("SUM(valor_total)"));
                        }
                    }
            }
            catch (SQLException e)
            {
                    e.printStackTrace();
            }
            finally
            {
                ClasseConexao.FecharConexao(conexao);
                try
                {
                        comando.close();
                        resultado.close();
                }
                catch (SQLException e)
                {
                        e.printStackTrace();
                }
            }
            valorTotal = valorS - valorP;
            valorServico.setText(String.valueOf(valorTotal));
            
    }
    
    
    
    
    
    public addServico(int OSAD) {
        initComponents();       
        this.os = OSAD;
        valorServico.setDocument(new soNumeros());
        valorServico.setEditable(false);
        descServico.setEditable(false);
        btnSalvar.setEnabled(false);
        btnEditar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        descServico = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        valorServico = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Serviço Realizado");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Descreva o serviço a ser realizado:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Valor do serviço:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(descServico)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descServico, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
            Connection conexao = null;
            conexao = ClasseConexao.Conectar();
            PreparedStatement comandoIn = null;
            double valor = Double.parseDouble(valorServico.getText());
            try{conexao = ClasseConexao.Conectar();
                //LINHA DE INSERT, DELETE E UPDATE SQL
                String sqlIn = "UPDATE ordem_servico SET desc_servico=?, valor_os=valor_os+? WHERE id_os=?";
                comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);
                //VALORES PARA OS CAMPOS DA LINHA SQL  
                comandoIn.setString(1, descServico.getText());
                comandoIn.setDouble(2, valor);
                comandoIn.setInt(3, os);
                if(comandoIn.executeUpdate()>0)
                {
                    //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO
                    this.dispose();
                    new abertasOS().setVisible(true);
                }}catch(SQLException erro)
            {erro.printStackTrace();}
            finally{ClasseConexao.FecharConexao(conexao);
                try{comandoIn.close();}
                catch(SQLException erro){erro.printStackTrace();}}
            
            
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        valorServico.setEditable(true);
        descServico.setEditable(true);
        btnSalvar.setEnabled(true);
        btnEditar.setEnabled(false);
        Connection conexao = null;
        conexao = ClasseConexao.Conectar();
        PreparedStatement comandoIn = null;
        double valor = Double.parseDouble(valorServico.getText());
        try{conexao = ClasseConexao.Conectar();
            //LINHA DE INSERT, DELETE E UPDATE SQL
            String sqlIn = "UPDATE ordem_servico SET valor_os=valor_os-? WHERE id_os=?";
            comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);
            //VALORES PARA OS CAMPOS DA LINHA SQL  
            comandoIn.setDouble(1, valor);
            comandoIn.setInt(2, os);
            if(comandoIn.executeUpdate()>0)
            {
                //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO 

            }}catch(SQLException erro)
        {erro.printStackTrace();}
        finally{ClasseConexao.FecharConexao(conexao);
            try{comandoIn.close();}
            catch(SQLException erro){erro.printStackTrace();}}
        valorServico.setText("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Selecionando();
    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new abertasOS().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(addServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new addServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField descServico;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField valorServico;
    // End of variables declaration//GEN-END:variables
}
