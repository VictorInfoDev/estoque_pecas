package estoque_pecas.comandos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class insertUsuario {
    
    private String nome;
    private String senha;
    
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

    public void insertDados(){
        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = ClasseConexao.Conectar();
            String sql = "INSERT into usuario(nome_user,senha_user,tipo_user) VALUES(?,?,?)";
            comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            comando.setString(1, getNome());
            comando.setString(2, getSenha());
            comando.setInt(3, 0);

            if(comando.executeUpdate()>0){
                    JOptionPane.showMessageDialog(null, "Usuário Criado");
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
    }
    
}
