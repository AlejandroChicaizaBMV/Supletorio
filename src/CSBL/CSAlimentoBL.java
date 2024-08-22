package CSBL;

public abstract class CSAlimentoBL {
    protected String Tipo;

    @Override 
    public String toString(){
        if (Tipo == null)
            Tipo = "";
        
        return Tipo;
    }
}
