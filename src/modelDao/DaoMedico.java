/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;
import modelConection.conexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.beansMedico;


public class DaoMedico {
    conexaoBD conex = new conexaoBD();
    beansMedico mod = new beansMedico();
        
        public void salvar(beansMedico mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("INSERT INTO medicos(nome_medico,especialidade_medico,crm_medico) values(?,?,?)");
                pst.setString(1, mod.getNome());
                pst.setString(2, mod.getEspecialidade());
                pst.setInt(3, mod.getCrm());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico! \n ERRO: } "+ex);
        }
                 
            
            
                
            conex.desconecta();
                
        }

public void editar (beansMedico mod){
            conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("UPDATE medicos set nome_medico=?,especialidade_medico=?,crm_medico=? where cod_medico=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");
        } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Erro ao alterar cadastro de médico! \n ERRO: } "+ex);
        }
            
            conex.desconecta();
}
        
public void excluir (beansMedico mod) {
    conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico =?");
            pst.setInt(1,mod.getCodigo());
            pst.execute();
                        JOptionPane.showMessageDialog(null, "cadastro excluido com sucesso");
                    
        } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null, "Erro ao excluir cadastro de m  édico! \n ERRO: } "+ex);
        }
    
    conex.desconecta();
}
public beansMedico buscaMedico(beansMedico mod){
            conex.conexao();
            conex.executasql("select * from medicos where nome_medico like '%"+mod.getPesquisa()+"%'");
        try {
            
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setEspecialidade(conex.rs.getString("especialidade_medico"));
            mod.setCrm(conex.rs.getInt("crm_medico"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"médico não cadastrado!");
                    
                    
        }
    
    conex.desconecta();
        return mod;
}
}
