package estoque_pecas.os;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import estoque_pecas.comandos.ClasseConexao;
import javax.swing.JOptionPane;
import estoque_pecas.filtros.caixaAlta;
import estoque_pecas.filtros.soNumeros;
import estoque_pecas.filtros.soNumerosQtd;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;




public class addPecaOs extends javax.swing.JFrame {
    private int os;
    private int peca;
    
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
                    String meu_sql = "SELECT cod_peca_os AS 'Código', quant_peca AS 'Quantidade', valor_total AS 'Valor' FROM pecas_os WHERE id_os_peca='"+os+"'";
                    resultado = comando.executeQuery(meu_sql); 
                    tablePecas.setModel(DbUtils.resultSetToTableModel(resultado));
                    quantTable = tablePecas.getRowCount();
                    double somaTotalTable = 0;
                    for (int i = 0; i < tablePecas.getRowCount(); i++) {
                        Object value = tablePecas.getValueAt(i, 2);
                        if (value instanceof Number) {
                            somaTotalTable += ((Number) value).doubleValue();
                        }
                    }
                    totalTable.setText(String.valueOf(somaTotalTable));

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
    
    
    
    
    
    
    
    
    
    
    public addPecaOs(int OSAD) {
        initComponents();
        this.os = OSAD;
        codPeca.setDocument(new caixaAlta());
        qtdPeca.setDocument(new soNumerosQtd());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codPeca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        qtdPeca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePecas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        totalTable = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        nomePeca = new javax.swing.JLabel();
        unidadePeca = new javax.swing.JLabel();
        descPeca = new javax.swing.JLabel();
        valorUnitarioPeca = new javax.swing.JLabel();
        qtdDispPeca = new javax.swing.JLabel();
        totalPeca = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Peça");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Código da peça");

        jLabel3.setText("Quantidade");

        tablePecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablePecas);

        jLabel4.setText("Nome:");

        jLabel6.setText("Unidade:");

        jLabel7.setText("Descrição:");

        jLabel8.setText("Valor Unitário: R$");

        jLabel9.setText("Quantidade Disponível:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Total: R$");

        jButton2.setText("Procurar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Adicionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Deletar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Peças Adicionadas");

        totalTable.setText("0000000");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Total: R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(codPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(qtdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nomePeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(totalPeca, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(16, 16, 16))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(25, 25, 25)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(qtdDispPeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valorUnitarioPeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(descPeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(unidadePeca, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdPeca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomePeca))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(unidadePeca))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(descPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(valorUnitarioPeca))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(qtdDispPeca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(totalPeca))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(totalTable, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        codPeca.setEditable(true);
        qtdPeca.setEditable(true);
        codPeca.setText("");
        qtdPeca.setText("");
        nomePeca.setText("");
        descPeca.setText("");
        valorUnitarioPeca.setText("");
        qtdDispPeca.setText("");
        unidadePeca.setText("");
        totalPeca.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Connection conexao = null;
        Statement comandoSelect = null;
        ResultSet resultado = null;
        if(codPeca.getText().equals("") || qtdPeca.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Dados inválidos para busca!");
            codPeca.setText("");
            qtdPeca.setText("");
            codPeca.setEditable(true);
            qtdPeca.setEditable(true);
                    
        }else{
            codPeca.setEditable(false);
            qtdPeca.setEditable(false);
            int qtd = Integer.parseInt(qtdPeca.getText());
            double valorPecaUni = 0;
            double totalPecaSum = 0;
            try
            {
                conexao = ClasseConexao.Conectar();
                comandoSelect = conexao.createStatement();
                //LINHA DE BUSCA SQL
                String sqlSelect = "SELECT id_peca, nome_peca, desc_peca, valor_peca, uni_peca, quant_peca FROM pecas WHERE cod_peca = '" + codPeca.getText() + "'";
                resultado = comandoSelect.executeQuery(sqlSelect);
                //RESULTADO DA BUSCA
                while(resultado.next())
                {
                    nomePeca.setText(resultado.getString("nome_peca"));
                    unidadePeca.setText(resultado.getString("uni_peca"));
                    descPeca.setText(resultado.getString("desc_peca"));
                    valorUnitarioPeca.setText(resultado.getString("valor_peca"));
                    qtdDispPeca.setText(resultado.getString("quant_peca"));
                    valorPecaUni = Double.parseDouble(resultado.getString("valor_peca"));
                    peca = resultado.getInt("id_peca");
                }

            }catch(SQLException erro){erro.printStackTrace();}
            finally{ClasseConexao.FecharConexao(conexao);
                try{comandoSelect.close();}
                catch(SQLException erro){erro.printStackTrace();}}
            
            totalPecaSum = qtd * valorPecaUni;
            totalPeca.setText(String.valueOf(totalPecaSum));
            
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Connection conexao = null;
        Statement comandoSelect = null;
        ResultSet resultado = null;
        int qtdCod = 0;
        try
        {
            conexao = ClasseConexao.Conectar();
            comandoSelect = conexao.createStatement();
            //LINHA DE BUSCA SQL
            String sqlSelect = "SELECT count(cod_peca_os) FROM pecas_os WHERE cod_peca_os = '" + codPeca.getText() + "' and id_os_peca='"+os+"'";
            resultado = comandoSelect.executeQuery(sqlSelect);
            //RESULTADO DA BUSCA
            while(resultado.next())
            {
                qtdCod = Integer.parseInt(resultado.getString("count(cod_peca_os)"));
            }
            
        }catch(SQLException erro){erro.printStackTrace();}
        finally{ClasseConexao.FecharConexao(conexao);
            try{comandoSelect.close();}
            catch(SQLException erro){erro.printStackTrace();}}
        
        if(qtdCod == 1){JOptionPane.showMessageDialog(null,"Peça já adicionada");
        codPeca.setEditable(true);
        qtdPeca.setEditable(true);
        codPeca.setText("");
        qtdPeca.setText("");      
        }
        else{
            if(codPeca.getText().equals("") || qtdPeca.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Insira a peça para adicionar!");
            }else{
                int qtdSolicitado = Integer.parseInt(qtdPeca.getText());
                int qtdDisp = Integer.parseInt(qtdDispPeca.getText());
                double total = Double.parseDouble(totalPeca.getText());
                if(qtdSolicitado > qtdDisp){
                    JOptionPane.showMessageDialog(null, "Quantidade indisponível!");
                    qtdPeca.setText("");
                    qtdPeca.setEditable(true);
                }else{
                    conexao = null;
                    PreparedStatement comandoIn = null;
                    try{
                        conexao = ClasseConexao.Conectar();
                        //LINHA DE INSERT, DELETE E UPDATE SQL
                        String sqlIn = "INSERT into pecas_os (id_peca_os, id_os_peca, cod_peca_os, nome_peca, quant_peca, valor_total) VALUES(?,?,?,?,?,?)";
                        comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);

                        //VALORES PARA OS CAMPOS DA LINHA SQL  
                        comandoIn.setInt(1, peca);
                        comandoIn.setInt(2, os);
                        comandoIn.setString(3, codPeca.getText());
                        comandoIn.setString(4, nomePeca.getText());
                        comandoIn.setInt(5, qtdSolicitado);
                        comandoIn.setDouble(6, total);

                        if(comandoIn.executeUpdate()>0)
                        {
                            //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO
                            Selecionando();
                            PreparedStatement comandoInE = null;
                            try{
                                conexao = ClasseConexao.Conectar();
                                //LINHA DE INSERT, DELETE E UPDATE SQL
                                String sqlInE = "UPDATE pecas SET quant_peca=quant_peca-? WHERE cod_peca=?";
                                comandoInE = conexao.prepareStatement(sqlInE,Statement.RETURN_GENERATED_KEYS);

                                //VALORES PARA OS CAMPOS DA LINHA SQL  
                                comandoInE.setInt(1, qtdSolicitado);
                                comandoInE.setString(2, codPeca.getText());

                                if(comandoInE.executeUpdate()>0)
                                {
                                    PreparedStatement comandoInE2 = null;
                                    try{
                                    conexao = ClasseConexao.Conectar();
                                    //LINHA DE INSERT, DELETE E UPDATE SQL
                                    String sqlInE2 = "UPDATE ordem_servico SET valor_os=valor_os+? WHERE id_os=?";
                                    comandoInE2 = conexao.prepareStatement(sqlInE2,Statement.RETURN_GENERATED_KEYS);

                                    //VALORES PARA OS CAMPOS DA LINHA SQL  
                                    comandoInE2.setDouble(1, total);
                                    comandoInE2.setInt(2, os);                               

                                    if(comandoInE2.executeUpdate()>0)
                                    {


                                    }}catch(SQLException erro)
                                    {erro.printStackTrace();}
                                    finally{ClasseConexao.FecharConexao(conexao);
                                        try{comandoInE2.close();}
                                        catch(SQLException erro){erro.printStackTrace();}}

                                }}catch(SQLException erro)
                                {erro.printStackTrace();}
                                finally{ClasseConexao.FecharConexao(conexao);
                                    try{comandoInE.close();}
                                    catch(SQLException erro){erro.printStackTrace();}}

                                codPeca.setEditable(true);
                                qtdPeca.setEditable(true);
                                codPeca.setText("");
                                qtdPeca.setText("");
                                nomePeca.setText("");
                                descPeca.setText("");
                                valorUnitarioPeca.setText("");
                                qtdDispPeca.setText("");
                                unidadePeca.setText("");
                                totalPeca.setText("");

                        }}catch(SQLException erro)
                        {erro.printStackTrace();}
                        finally{ClasseConexao.FecharConexao(conexao);
                            try{comandoIn.close();}
                            catch(SQLException erro){erro.printStackTrace();}}                



                }

            }
        
        }
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Selecionando();
    }//GEN-LAST:event_formWindowOpened

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int linhaSel = tablePecas.getSelectedRow();
        double valorDouble = 0;
        if(linhaSel == -1){
            JOptionPane.showMessageDialog(this, "Nenhuma peça selecionada!","Erro",JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel model = (DefaultTableModel) tablePecas.getModel();
            String codDel = (String) model.getValueAt(linhaSel, 0);
            Integer quantDel = (Integer) model.getValueAt(linhaSel, 1);
            Object valorObjeto = tablePecas.getValueAt(linhaSel, 2);
            if (valorObjeto instanceof Number) {
                valorDouble = ((Number) valorObjeto).doubleValue();
            }
            Connection conexao = null;
            PreparedStatement comandoIn = null;
            try{
                conexao = ClasseConexao.Conectar();
                //LINHA DE INSERT, DELETE E UPDATE SQL
                String sqlIn = "DELETE FROM pecas_os WHERE cod_peca_os=? and id_os_peca=?";
                comandoIn = conexao.prepareStatement(sqlIn,Statement.RETURN_GENERATED_KEYS);

                //VALORES PARA OS CAMPOS DA LINHA SQL  
                comandoIn.setString(1, codDel);
                comandoIn.setInt(2, os);
                if(comandoIn.executeUpdate()>0)
                {
                    //EXECUTA CASO A OPERACAO SEJA REALIZADA COM SUCESSO 
                    Selecionando();
                    conexao = null;
                    PreparedStatement comandoInE = null;
                    try{
                        conexao = ClasseConexao.Conectar();
                        //LINHA DE INSERT, DELETE E UPDATE SQL
                        String sqlInE = "UPDATE ordem_servico SET valor_os=valor_os-? WHERE id_os=?";
                        comandoInE = conexao.prepareStatement(sqlInE,Statement.RETURN_GENERATED_KEYS);

                        //VALORES PARA OS CAMPOS DA LINHA SQL  
                        comandoInE.setDouble(1, valorDouble);
                        comandoInE.setInt(2, os);

                        if(comandoInE.executeUpdate()>0)
                        {
                                PreparedStatement comandoInE2 = null;
                                try{
                                conexao = ClasseConexao.Conectar();
                                //LINHA DE INSERT, DELETE E UPDATE SQL
                                String sqlInE2 = "UPDATE pecas SET quant_peca=quant_peca+? WHERE cod_peca=?";
                                comandoInE2 = conexao.prepareStatement(sqlInE2,Statement.RETURN_GENERATED_KEYS);

                                //VALORES PARA OS CAMPOS DA LINHA SQL  
                                comandoInE2.setInt(1, quantDel);
                                comandoInE2.setString(2, codDel);                               

                                if(comandoInE2.executeUpdate()>0)
                                {


                                }}catch(SQLException erro)
                                {erro.printStackTrace();}
                                finally{ClasseConexao.FecharConexao(conexao);
                                    try{comandoInE2.close();}
                                    catch(SQLException erro){erro.printStackTrace();}}
                        }}catch(SQLException erro)
                    {erro.printStackTrace();}
                    finally{ClasseConexao.FecharConexao(conexao);
                        try{comandoInE.close();}
                        catch(SQLException erro){erro.printStackTrace();}}   
                    

                }}catch(SQLException erro)
                {erro.printStackTrace();}
                finally{ClasseConexao.FecharConexao(conexao);
                    try{comandoIn.close();}
                    catch(SQLException erro){erro.printStackTrace();}}
            
            
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(addPecaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addPecaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addPecaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addPecaOs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new addPecaOs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codPeca;
    private javax.swing.JLabel descPeca;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomePeca;
    private javax.swing.JLabel qtdDispPeca;
    private javax.swing.JTextField qtdPeca;
    private javax.swing.JTable tablePecas;
    private javax.swing.JLabel totalPeca;
    private javax.swing.JLabel totalTable;
    private javax.swing.JLabel unidadePeca;
    private javax.swing.JLabel valorUnitarioPeca;
    // End of variables declaration//GEN-END:variables
}
