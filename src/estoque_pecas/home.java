package estoque_pecas;
import estoque_pecas.pedido.pedidoPeca;
import estoque_pecas.pedido.pedidoAberto;
import estoque_pecas.pedido.pedidoFechado;
import estoque_pecas.peca.cadastroPeca;
import estoque_pecas.peca.consultaPeca;
import estoque_pecas.peca.baixaPeca;
import estoque_pecas.peca.consultaBaixa;
import estoque_pecas.cliente.consultaCliente;
import estoque_pecas.cliente.cadastroCliente;
import estoque_pecas.usuario.consultaUsuario;
import estoque_pecas.usuario.cadastroUsuario;
import estoque_pecas.comandos.ClasseConexao;
import estoque_pecas.os.criarOS;
import estoque_pecas.os.abertasOS;
import estoque_pecas.os.fechadosOS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author victo
 */
public class home extends javax.swing.JFrame {
    
public void Selecionando()
	{
            //buscar dados usuários para tabela 
            Date dataAtual = new Date();
            SimpleDateFormat formatoDia = new SimpleDateFormat("dd");
            SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
            String dia = formatoDia.format(dataAtual);
            String mes = formatoMes.format(dataAtual);
            Connection conexao = null;
            Statement  comando = null;
            ResultSet  resultado = null;
            int quantTable = 0;
            try {
                    conexao = ClasseConexao.Conectar();
                    comando = conexao.createStatement();
                    String meu_sql = "SELECT id_os AS 'OS', cpf_cliente_os AS 'CPF', placa_veiculo AS 'Placa' FROM ordem_servico WHERE estado_os = 0 and mes='"+mes+"' and dia ='"+dia+"'";
                    resultado = comando.executeQuery(meu_sql); 
                    tableOS.setModel(DbUtils.resultSetToTableModel(resultado));
                    quantTable = tableOS.getRowCount();
                    if(quantTable == 0){
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
    
public void Selecionando2()
	{
            //buscar dados usuários para tabela 
            Connection conexao = null;
            Statement  comando = null;
            ResultSet  resultado = null;
            int quantTable = 0;
            try {
                    conexao = ClasseConexao.Conectar();
                    comando = conexao.createStatement();
                    String meu_sql = "SELECT cod_peca AS 'Código', uni_peca AS 'Unidade', quant_peca AS 'Quantidade' FROM pecas WHERE quant_peca<6";
                    resultado = comando.executeQuery(meu_sql); 
                    tablePeca.setModel(DbUtils.resultSetToTableModel(resultado));
                    quantTable = tablePeca.getRowCount();
                    if(quantTable == 0){
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
public void Selecionando3()
	{
            Date dataAtual = new Date();
            SimpleDateFormat formatoAno = new SimpleDateFormat("yyyy");
            SimpleDateFormat formatoMes = new SimpleDateFormat("MM");
            String Ano = formatoAno.format(dataAtual);
            String mes = formatoMes.format(dataAtual);
            Connection conexao = null;
            Statement  comando = null;
            ResultSet  resultado = null;
            Statement comandoSelect = null;
            try
            {
                conexao = ClasseConexao.Conectar();
                comandoSelect = conexao.createStatement();
                //LINHA DE BUSCA SQL
                String sqlSelect = "SELECT SUM(valor_os) FROM ordem_servico WHERE estado_os = 1 and mes='"+mes+"' and ano ='"+Ano+"'";
                resultado = comandoSelect.executeQuery(sqlSelect);
                //RESULTADO DA BUSCA
                while(resultado.next())
                {
                    faturamento.setText(resultado.getString("SUM(valor_os)"));
                }

            }catch(SQLException erro){erro.printStackTrace();}
            finally{ClasseConexao.FecharConexao(conexao);
                try{comandoSelect.close();}
                catch(SQLException erro){erro.printStackTrace();}}
            	
    }
    
    
    
    
    private String tipo_user;
    
    
    
    public home(String tipoUs) {
        initComponents();
        this.tipo_user = tipoUs;
        
        if(tipo_user.equals("admin")){
            menuAdmin.setVisible(true);
            menu2Admin.setVisible(true); 
        }else{
            menuAdmin.setVisible(false);
            menu2Admin.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOS = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePeca = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nomeUserLogin = new javax.swing.JLabel();
        faturamento = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        menu2Admin = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        menuAdmin = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();

        jLabel10.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Painel de Controle Estoque");
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Outher Packages/imagens/icon database.png"))); // NOI18N

        tableOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OS", "Placa", "CPF", "Horário"
            }
        ));
        jScrollPane1.setViewportView(tableOS);

        tablePeca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Unidade", "Quantidade"
            }
        ));
        jScrollPane2.setViewportView(tablePeca);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ordens de serviços para hoje");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Peças com baixas quantidades");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Faturado no mês:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Outher Packages/imagens/icon reload.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Outher Packages/imagens/icon reload.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("R$");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Outher Packages/imagens/logo projeto.png"))); // NOI18N

        faturamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        faturamento.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(185, 185, 185)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(nomeUserLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(2, 2, 2)
                                .addComponent(faturamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(faturamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(nomeUserLogin))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setBorder(null);
        jMenu1.setText("Ordem de serviço");
        jMenu1.add(jSeparator1);

        jMenu2.setText("Nova");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu2);

        jMenu8.setText("Abertas");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu8);

        jMenu9.setText("Encerradas");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenu1.add(jMenu9);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Estoque de peças");

        jMenu12.setText("Cadastrar");
        jMenu12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu12MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu12);

        jMenu10.setText("Consultar");
        jMenu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu10MouseClicked(evt);
            }
        });
        jMenu3.add(jMenu10);

        jMenu11.setText("Baixas");

        jMenu20.setText("Nova");
        jMenu20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu20MouseClicked(evt);
            }
        });
        jMenu11.add(jMenu20);

        menu2Admin.setText("Consultar");
        menu2Admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu2AdminMouseClicked(evt);
            }
        });
        jMenu11.add(menu2Admin);

        jMenu3.add(jMenu11);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Clientes");

        jMenu13.setText("Cadastrar");
        jMenu13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu13MouseClicked(evt);
            }
        });
        jMenu4.add(jMenu13);

        jMenu14.setText("Consultar");
        jMenu14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu14MouseClicked(evt);
            }
        });
        jMenu4.add(jMenu14);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Pedidos");

        jMenu15.setText("Novo");
        jMenu15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu15MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu15);

        jMenu16.setText("Abertos");
        jMenu16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu16MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu16);

        jMenu17.setText("Encerrados");
        jMenu17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu17MouseClicked(evt);
            }
        });
        jMenu5.add(jMenu17);

        jMenuBar1.add(jMenu5);

        menuAdmin.setText("Configurações Administrador");

        jMenu18.setText("Cadastrar Usuário");
        jMenu18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu18MouseClicked(evt);
            }
        });
        menuAdmin.add(jMenu18);

        jMenu19.setText("Consultar Usuários");
        jMenu19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu19MouseClicked(evt);
            }
        });
        menuAdmin.add(jMenu19);

        jMenuBar1.add(menuAdmin);

        setJMenuBar(jMenuBar1);

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLabel1.setText("Database Disconnet");
        Connection conn = ClasseConexao.Conectar();
        jLabel1.setText("Database Connect");
        ClasseConexao.FecharConexao(conn);
        Selecionando();
        Selecionando2();
        Selecionando3();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Selecionando();
        Selecionando3();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu13MouseClicked
        new cadastroCliente().setVisible(true);
    }//GEN-LAST:event_jMenu13MouseClicked

    private void jMenu14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu14MouseClicked
        new consultaCliente().setVisible(true);
    }//GEN-LAST:event_jMenu14MouseClicked

    private void jMenu12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu12MouseClicked
        new cadastroPeca().setVisible(true);
    }//GEN-LAST:event_jMenu12MouseClicked

    private void jMenu15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu15MouseClicked
        new pedidoPeca().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu15MouseClicked

    private void jMenu18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu18MouseClicked
        new cadastroUsuario().setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_jMenu18MouseClicked

    private void jMenu19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu19MouseClicked
        new consultaUsuario().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu19MouseClicked

    private void jMenu20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu20MouseClicked
        new baixaPeca().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu20MouseClicked

    private void menu2AdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2AdminMouseClicked
        new consultaBaixa().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menu2AdminMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        new criarOS().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        new abertasOS().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu8MouseClicked

    private void jMenu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu10MouseClicked
        new consultaPeca().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu10MouseClicked

    private void jMenu16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu16MouseClicked
        new pedidoAberto().setVisible(true);
    }//GEN-LAST:event_jMenu16MouseClicked

    private void jMenu17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu17MouseClicked
        new pedidoFechado().setVisible(true);
    }//GEN-LAST:event_jMenu17MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        new fechadosOS().setVisible(true);
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Selecionando2();
        Selecionando3();
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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel faturamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menu2Admin;
    private javax.swing.JMenu menuAdmin;
    public javax.swing.JLabel nomeUserLogin;
    private javax.swing.JTable tableOS;
    private javax.swing.JTable tablePeca;
    // End of variables declaration//GEN-END:variables
}
