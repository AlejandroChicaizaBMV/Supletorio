package CSBL.Entities;

public class CSHormiga {
    protected int Id;
    protected String Tipo;
    protected String Sexo;
    protected String Alimentacion;
    protected String Estado;
    

    public CSHormiga(int id) {
        Id = id;
    }

    public CSHormiga(int id, String tipo, String sexo, String alimentacion, String estado) {
        Id = id;
        Tipo = tipo;
        Sexo = sexo;
        Alimentacion = alimentacion;
        Estado = estado;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getAlimentacion() {
        return Alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        Alimentacion = alimentacion;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public CSHormiga comer(CSIngestaNativa alimento){
        CSHormiga csHormiga = new CSHormiga(getId(), getTipo(), getSexo(), getAlimentacion(), getEstado());
        return csHormiga;
    }

    @Override 
    public String toString(){
        if (Tipo == null)
            Tipo = "";
        
        return Tipo;
    }
}
