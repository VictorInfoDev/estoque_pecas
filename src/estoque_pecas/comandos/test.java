/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estoque_pecas.comandos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rafae
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Connection conexao = null;
    Statement comando = null;
    ResultSet resultado = null;

    try {
        conexao = ClasseConexao.Conectar();
        comando = conexao.createStatement();

        String sql = "SELECT * FROM usuario";
        resultado = comando.executeQuery(sql);
        while(resultado.next())
        {
                System.out.println(resultado.getString("nome_user"));
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
}
