package CSBusinessLogic;

public abstract class CSAlimentoBL {
    protected String csTipo;

    @Override 
    public String toString(){
        if (csTipo == null)
            csTipo = "";
        
        return csTipo.toUpperCase();
    }
}
