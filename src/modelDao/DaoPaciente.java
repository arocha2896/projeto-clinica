/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelDao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelConection.conexaoBD;
import modeloBeans.BeansPaciente;

/**
 *
 * @author andre e taila
 */
public class DaoPaciente {
    conexaoBD conex = new conexaoBD();
    conexaoBD conexbairro = new conexaoBD();
            String nomeBairro;
    int codBai;
    
  public void salvar(BeansPaciente pac){
      buscabaicod(pac.getNomeBairro());
      conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes (paci_nome,paci_rg,paci_telefone,paci_rua,paci_cep,paci_complemento,paci_baicodigo,paci_nasc) values(?,?,?,?,?,?,?,?)");
           pst.setString(1, pac.getNomePac());
           pst.setString(2, pac.getRg());
           pst.setString(3, pac.getTelefone());
           pst.setString(4, pac.getRua());
           pst.setString(5, pac.getCep());
           pst.setString(6, pac.getComplemento());
           pst.setInt(7, codBai);
           pst.setString(8, pac.getNasc());
           pst.execute();
                    JOptionPane.showMessageDialog(null,"paciente salvo com sucesso");
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"não foi possivel inserir paciente"+ex);
  }  
        conex.desconecta();
  }
  
  public void alterar(BeansPaciente pac){
      buscabaicod(pac.getNomeBairro());
      conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update  pacientes set paci_nome=?, paci_rg=?, paci_telefone=?, paci_rua=?, paci_cep=?, paci_complemento=?, paci_baicodigo=?, paci_nasc=? where paci_codigo=?");
           pst.setString(1, pac.getNomePac());
           pst.setString(2, pac.getRg());
           pst.setString(3, pac.getTelefone());
           pst.setString(4, pac.getRua());
           pst.setString(5, pac.getCep());
           pst.setString(6, pac.getComplemento());
           pst.setInt(7, codBai);
           pst.setString(8, pac.getNasc());
           pst.setInt(9, pac.getCodPac());
           pst.execute();
                    JOptionPane.showMessageDialog(null,"paciente alterado com sucesso");
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"não foi possivel alterar paciente"+ex);
  }  
        conex.desconecta();
  }
    
    public void buscabaicod (String nome){
        conex.conexao();
        conex.executasql("select * from bairro where bainome ='"+nome+"'");
        try {
            conex.rs.first();
        codBai=conex.rs.getInt("baicodigo");
        } catch (SQLException ex) {

        }
        conex.desconecta();
    }
    public BeansPaciente buscaPaciente(BeansPaciente pac){
        conex.conexao();
        try {
            conex.executasql("select *from pacientes where paci_nome = '%"+pac.getPesquisar()+"%'");
            conex.rs.first();
            buscaNomeBairro(conex.rs.getInt("paci_baicodigo"));
            pac.setNomeBairro(conex.rs.getString("paci_nome"));
            pac.setCep(conex.rs.getString("paci_cep"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "não foi possivel buscar paciente"+ex);
        }
        conex.desconecta();
    
        return pac;    
    }
    
    public void buscaNomeBairro(int cod){
        conexbairro.conexao();
        try {
            conexbairro.executasql("select * from bairro where baicodigo ='"+cod);
            conexbairro.rs.first();
               nomeBairro = conexbairro.rs.getString("bainome");
        } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "não foi possivel buscar nome bairro"+ex);
        }
        conexbairro.desconecta();
    }
}

