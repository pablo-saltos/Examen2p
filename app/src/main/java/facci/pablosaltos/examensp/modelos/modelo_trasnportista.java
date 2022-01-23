package facci.pablosaltos.examensp.modelos;

public class modelo_trasnportista {
    private String id, cedula, nombres, apellidos, direccion, tipovehiculo, cooperativa;

    public modelo_trasnportista() {
    }

    public modelo_trasnportista(String id, String cedula, String nombres, String apellidos, String direccion, String tipovehiculo, String cooperativa) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.tipovehiculo = tipovehiculo;
        this.cooperativa = cooperativa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public String getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(String cooperativa) {
        this.cooperativa = cooperativa;
    }
}
