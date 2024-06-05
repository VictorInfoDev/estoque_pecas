package estoque_pecas.comandos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import estoque_pecas.cadastroUsuario;

public class insertUsuario {
    
    private String nome;
    private String senha;
    int quantUser = 0;
    
    public insertUsuario(String nomeInsert,String senhaInsert) {
            this.nome =  nomeInsert;
            this.senha = senhaInsert;
    }
    public String getNome() {
        return this.nome;
    }
    public String getSenha() {
        return this.senha;
    }
    public void selectUser(String nomeIgual){
        Connection conexao = null;
        Statement comando = null;
        ResultSet resultado = null;
        PreparedStatement comando2 = null;
        try {
            conexao = ClasseConexao.Conectar();
            comando = conexao.createStatement();

            String sql = "SELECT count(nome_user) FROM usuario WHERE nome_user = '" + nomeIgual + "'";
            resultado = comando.executeQuery(sql);
            while(resultado.next())
            {
                quantUser = Integer.parseInt(resultado.getString("count(nome_user)"));
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
    }
    
    
    public void insertDados(){
        Connection conexao = null;
        PreparedStatement comando = null;
        selectUser(getNome());
        if(quantUser == 0){
            try {
                conexao = ClasseConexao.Conectar();
                String sql = "INSERT into usuario(nome_user,senha_user,tipo_user) VALUES(?,?,?)";
                comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

                comando.setString(1, getNome());
                comando.setString(2, getSenha());
                comando.setInt(3, 0);

                if(comando.executeUpdate()>0){
                        JOptionPane.showMessageDialog(null, "Usuário Criado!");
                        cadastroUsuario frame = new cadastroUsuario();
                        frame.fecharFrame();
                }
                
                

            } catch(SQLException erro) {
                erro.printStackTrace();
            } finally {
                ClasseConexao.FecharConexao(conexao);

                try{
                    comando.close();
                } catch(SQLException erro) {
                    erro.printStackTrace();
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Este usuário já existe!");
        }

    }

    
}
