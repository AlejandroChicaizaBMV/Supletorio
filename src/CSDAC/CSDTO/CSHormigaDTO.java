package CSDAC.CSDTO;

public class CSHormigaDTO {
    private int csNHormiga;
    private String csTipo;
    private String csSexo;
    private String csProvincia;
    private String csIngestaNativa;
    private String csGenoAlimento;
    
    
    
    private String csEstado;
    
    
    
    public CSHormigaDTO() {
    }
    
    


            
            
            
    public CSHormigaDTO(String csTipo, String csSexo, String csProvincia, String csIngestaNativa, String csGenoAlimento,
            String csEstado) {
        this.csTipo = csTipo;
        this.csSexo = csSexo;
        this.csProvincia = csProvincia;
        this.csIngestaNativa = csIngestaNativa;
        this.csGenoAlimento = csGenoAlimento;
        this.csEstado = csEstado;
    }







    public CSHormigaDTO(int csNHormiga, String csTipo, String csSexo, String csProvincia, String csIngestaNativa,
            String csGenoAlimento, String csEstado) {
        this.csNHormiga = csNHormiga;
        this.csTipo = csTipo;
        this.csSexo = csSexo;
        this.csProvincia = csProvincia;
        this.csIngestaNativa = csIngestaNativa;
        this.csGenoAlimento = csGenoAlimento;
        this.csEstado = csEstado;
    }







    public String getCsGenoAlimento() {
        return csGenoAlimento;
    }
        
        
        
    public void setCsGenoAlimento(String csGenoAlimento) {
        this.csGenoAlimento = csGenoAlimento;
    }

    public int getCsNHormiga() {
        return csNHormiga;
    }



    public void setCsNHormiga(int csNHormiga) {
        this.csNHormiga = csNHormiga;
    }



    public String getCsTipo() {
        return csTipo;
    }



    public void setCsTipo(String csTipo) {
        this.csTipo = csTipo;
    }



    public String getCsSexo() {
        return csSexo;
    }



    public void setCsSexo(String csSexo) {
        this.csSexo = csSexo;
    }



    public String getCsProvincia() {
        return csProvincia;
    }



    public void setCsProvincia(String csProvincia) {
        this.csProvincia = csProvincia;
    }



    public String getCsIngestaNativa() {
        return csIngestaNativa;
    }



    public void setCsIngestaNativa(String csIngestaNativa) {
        this.csIngestaNativa = csIngestaNativa;
    }



    public String getCsEstado() {
        return csEstado;
    }



    public void setCsEstado(String csEstado) {
        this.csEstado = csEstado;
    }



    @Override
    public String toString() {
        return csNHormiga + "," + 
               csTipo + "," + 
               csSexo + "," + 
               csProvincia + "," + 
               csIngestaNativa + "," + 
               csGenoAlimento +"," + 
               csEstado;
    }
}
