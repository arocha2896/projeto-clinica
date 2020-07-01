        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;
                                                    //atributos emcapsulados get e set
public class BeansUsuario {
private Integer usuCod;
private String usuNome;
private String usuTipo;
private String usuSenha;
private String usupesquisa;

    public Integer getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(Integer usuCod) {
        this.usuCod = usuCod;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }

    /**
     * @return the usupesquisa
     */
    public String getUsupesquisa() {
        return usupesquisa;
    }

    /**
     * @param usupesquisa the usupesquisa to set
     */
    public void setUsupesquisa(String usupesquisa) {
        this.usupesquisa = usupesquisa;
    }
}