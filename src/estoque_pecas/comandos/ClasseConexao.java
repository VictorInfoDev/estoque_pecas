package estoque_pecas.comandos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseConexao {
private static Connection conexao = null;
public static Connection Conectar()
	{
		try
		{
                    if(conexao==null)
                    {
                        String url = "jdbc:mysql://localhost/estoque";
                        conexao = DriverManager.getConnection(url,"root","");

                    }
		}catch(SQLException erro)
		{
                        JOptionPane.showMessageDialog(null, "Database não está conectado!");
                        System.exit(0);
		}
		return conexao;
	}
	
	public static void FecharConexao(Connection c)
	{
		try
		{
			if(c != null)
			{
				c.close();
				conexao = null;
			}
		}catch(SQLException erro)
		{
			erro.printStackTrace();
		}
	}

}
