/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelConection.conexaoBD;
import modeloBeans.BeansUsuario;

/**
 *
 * @author andre e taila
 */
public class DaoUsuario {
    conexaoBD conex = new conexaoBD();
    BeansUsuario mod = new BeansUsuario();
        
        public void salvar(BeansUsuario mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO usuarios (usu_nome,usu_senha,usu_tipo) values(?,?,?)");
                pst.setString(1, mod.getUsuNome());
                pst.setString(2, mod.getUsuSenha());
                pst.setString(3, mod.getUsuTipo());
                pst.execute();
                JOptionPane.showMessageDialog(null, "usuário cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário! \n ERRO: } "+ex);
        }
               conex.desconecta();
                
        }       
        
        
        public void alterar (BeansUsuario mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE usuarios set usu_nome=?,usu_senha=?,usu_tipo=? where usu_cod=?");
            pst.setString(1, mod.getUsuNome());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.setInt(4, mod.getUsuCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso");
        } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro de Usuário! \n ERRO: } "+ex);
        }
            
            conex.desconecta();
}
        // dao excluir Usuário
public void excluir (BeansUsuario mod) {           
    conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where usu_cod =?");
            pst.setInt(1,mod.getUsuCod());
            pst.execute();
                        JOptionPane.showMessageDialog(null, "cadastro excluido com sucesso");
                    
        } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Erro ao excluir cadastro de usuário! \n ERRO: } "+ex);
        }
    
    conex.desconecta();
}
        
        
public BeansUsuario buscaUsuario (BeansUsuario mod){
            conex.conexao();
            conex.executasql("select * from usuarios where usu_nome like '%"+mod.getUsupesquisa()+"%'");
        try {
            
            conex.rs.first();
            mod.setUsuCod(conex.rs.getInt("usu_cod"));
            mod.setUsuNome(conex.rs.getString("usu_nome"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"usuario não cadastrado!"+ex);
             
                    
        }
    
    conex.desconecta();
        return mod;
}

    public BeansUsuario alterar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
