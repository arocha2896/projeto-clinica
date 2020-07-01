
package modelConection;

/**
 *
 * @author andre e taila
 */

import java.sql.*;
import javax.swing.JOptionPane;
public class conexaoBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.driver";
    private String caminho = "jdbc:postgresql://localhost:5434/projetoclinica";
    private String usuario = "postgres";
    private String senha ="";
    public Connection con;
    
    public void conexao () {

        try {
                    System.setProperty("jdbc.drivers", driver);
            con= DriverManager.getConnection(caminho, usuario, senha);
          //  JOptionPane.showMessageDialog(null, "Banco de dados conectado com sucesso!");
                    
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "não foi possivel conectar com banco de dados!: \n"+ex.getMessage());
        }

    }
    public void executasql (String sql){  
        try {
            stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
        }
            
    } 
 
    public void desconecta (){
        try {
            con.close();
      //      JOptionPane.showMessageDialog(null, "Banco de dados desconectado com sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "não foi possivel desconectar com banco de dados!= \n"+ex.getMessage());
        }
    }
}