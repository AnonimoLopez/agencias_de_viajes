/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencias_de_viajes;

/**
 *
 * @author anonimo
 */
public class User {
    private String cve_user = "";
    private String user = "";
    private int tipo_empleado = -1;

    public String getCve_user() {
        return cve_user;
    }

    public void setCve_user(String cve_user) {
        this.cve_user = cve_user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(int tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }
    
}
