package estoque_pecas.pedido;

import estoque_pecas.comandos.ClasseConexao;
import estoque_pecas.os.addPecaOs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author rafae
 */
public class pedidoAberto extends javax.swing.JFrame {

public void Selecionando()
	{
            //buscar dados usuários para tabela 
            Connection conexao = null;
            Statement  comando = null;
            ResultSet  resultado = null;
            int quantTable = 0;
            try {
                    conexao = ClasseConexao.Conectar();
                    comando = conexao.createStatement();
                    String meu_sql = "SELECT id_compra AS 'Número Pedido', cod_peca_compra AS 'Código', quant_peca_compra AS 'Quantidade' FROM compra WHERE estado_compra = 0";
                    resultado = comando.executeQuery(meu_sql); 
                    tableAbertos.setModel(DbUtils.resultSetToTableModel(resultado));
                    quantTable = tableAbertos.getRowCount();
                    if(quantTable == 0){
                        this.dispose();
                        JOptionPane.showMessageDialog(null,"Nenhum pedido em aberto!");
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
    }
    
    
    public pedidoAberto() {
        initComponents();
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
        tableAbertos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos em Aberto");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableAbertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tableAbertos);

        jButton2.setText("Cancelar Pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Concluir Pedido");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Selecionando();
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int linhaSel = tableAbertos.getSelectedRow();
        if(linhaSel == -1){
            JOptionPane.showMessageDialog(this, "Nenhum pedido selecionado!","Erro",JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel model = (DefaultTableModel) tableAbertos.getModel();
            Integer codRow = (Integer) model.getValueAt(linhaSel, 0);
            Connection conexao = null;
            PreparedStatement comando = null;
            int result = JOptionPane.showConfirmDialog(null,"Confirme para excluir o pedido: "+codRow,"Excluindo...", JOptionPane.YES_NO_CANCEL_OPTION);
            if(result == 0){
                try
                {
                    conexao = ClasseConexao.Conectar();
                    String sql = "DELETE FROM compra WHERE id_compra=?";
                    comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                    comando.setInt(1, codRow);

                    if(comando.executeUpdate()>0)
                    {
                            JOptionPane.showMessageDialog(null,"Pedido cancelado!");
                            Selecionando();

                    }else{
                        JOptionPane.showMessageDialog(null, "Pedido não encontrado!");
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
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int linhaSel = tableAbertos.getSelectedRow();
        if(linhaSel == -1){
            JOptionPane.showMessageDialog(this, "Nenhum pedido selecionado!","Erro",JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel model = (DefaultTableModel) tableAbertos.getModel();
            Integer codRow = (Integer) model.getValueAt(linhaSel, 0);
            Connection conexao = null;
            int result = JOptionPane.showConfirmDialog(null,"Confirme para concluir o pedido: "+codRow,"Excluindo...", JOptionPane.YES_NO_CANCEL_OPTION);
            if(result == 0){
                    
                    PreparedStatement comandoIn = null;
                    try{conexao = ClasseConexao.Conectar();
                        //LINHA DE INSERT, DELETE E UPDATE SQL
                        String sqlIn = "UPDATE compra SET estado_compra=? WHERE id_compra=?";
                        comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);

                        //VALORES PARA OS CAMPOS DA LINHA SQL  
                        comandoIn.setInt(1, 1);
                        comandoIn.setInt(2, codRow);

                        if(comandoIn.executeUpdate()>0)
                        {
                            //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO
                            JOptionPane.showMessageDialog(null, "Pedido concluído!");
                            Integer quantPeca = (Integer) model.getValueAt(linhaSel, 2);
                            String codPeca = (String) model.getValueAt(linhaSel, 1);
                            
                            PreparedStatement comandoIn2 = null;
                            try{conexao = ClasseConexao.Conectar();
                                //LINHA DE INSERT, DELETE E UPDATE SQL
                                String sqlIn2 = "UPDATE pecas SET quant_peca=quant_peca+? WHERE cod_peca=?";
                                comandoIn2 = conexao.prepareStatement(sqlIn2,Statement.RETURN_GENERATED_KEYS);

                                //VALORES PARA OS CAMPOS DA LINHA SQL  
                                comandoIn2.setInt(1, quantPeca);
                                comandoIn2.setString(2, codPeca);

                                if(comandoIn2.executeUpdate()>0)
                                {
            
                                }}catch(SQLException erro)
                            {erro.printStackTrace();}
                            finally{ClasseConexao.FecharConexao(conexao);
                                try{comandoIn2.close();}
                                catch(SQLException erro){erro.printStackTrace();}}

                        }}catch(SQLException erro)
                    {erro.printStackTrace();}
                    finally{ClasseConexao.FecharConexao(conexao);
                        try{comandoIn.close();}
                        catch(SQLException erro){erro.printStackTrace();}}
                    Selecionando();
            }else{
                
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(pedidoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pedidoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pedidoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pedidoAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pedidoAberto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableAbertos;
    // End of variables declaration//GEN-END:variables
}
