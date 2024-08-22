package CSBL.Entities;

public class CSHLarva extends CSHormiga {
    
    public CSHLarva (int Id) {
        this.Id = Id;
        this.Tipo = "larva";
        this.Sexo = "Asexual";
        this.Alimentacion = "Nectarivoro";
        this.Estado = "VIVA";
    }
    public int getnHormiga() {
        return Id;
    }

}
