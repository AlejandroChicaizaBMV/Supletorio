package CSBL;

import java.util.ArrayList;             
import CSBL.Entities.*;
import CSDAC.CSHormigueroDAC;
import CSInfra.CSAppException;          

public class CSHormigueroBL {
    public ArrayList<CSHormiga> lstHormiguero = new ArrayList<>();
    
    public ArrayList<CSHormiga> getLstHormiguero() {
        return lstHormiguero;
    }

    public String crearLarva() throws Exception{
        CSHormiga hormiga = new CSHLarva(lstHormiguero.size() + 1);
        lstHormiguero.add(hormiga);
        return "HORMIGA LARVA, agregada al hormiguero";
    }

    public String eliminarHormiga(int idHormiga) throws Exception{
        String msg = "HORMIGA no encontrada";
        for(int i = 0; i < lstHormiguero.size(); i++){
            if(lstHormiguero.get(i).getId() == idHormiga){
                msg = lstHormiguero.get(i).getTipo() + ", eliminada del Hormiguero";
                lstHormiguero.remove(i);
                break;
            }
        }
        return msg;
    }

    public String guardarHormiguero() throws CSAppException{
        String fullDataHormiga = "";
        for (CSHormiga hormiga : lstHormiguero)
            fullDataHormiga += hormiga.toString();

        CSHormigueroDAC hormigueroDAC = new CSHormigueroDAC();
        hormigueroDAC.saveHormigueroToCSV(fullDataHormiga);
        return "HORMIGUERO almacenado";
    }

    public String alimentarHormiga(int IdHormiga, String alimentoGeno, String alimentoNativo ) throws CSAppException{
        int indexList           = 0;
        CSGenoAlimento aGeno    = null;
        CSIngestaNativa aNativo = null;
        CSHormiga hormiga       = null;

        switch(alimentoGeno){
            case "XX": aGeno = new CSXX();      break;
            case "XY": aGeno = new CSXY();      break;
            default:   aGeno = new CSX();       break;
        }

        switch(alimentoNativo){
            case "Carnivoro":           aNativo = new CSCarnivoro()     ; break;
            case "Herbivoro":           aNativo = new CSHerbivoro()     ; break;
            case "Omnivoro":            aNativo = new CSOmnivoro()      ; break;
            case "Insectivoro":         aNativo = new CSInsectivoro()   ; break;
            case "Nectarivoro":         aNativo = new CSNectarivoro()   ; break;
        }

        for(; indexList < lstHormiguero.size(); indexList++)
            if (lstHormiguero.get(indexList).getId() == IdHormiga){
                hormiga = lstHormiguero.get(indexList);
                break;
            }
        if(aNativo == null || aGeno ==  null || hormiga == null || hormiga.getEstado() == "Muerta")
            return "Ups!...! alimento u hromiga no son validos";
        
        if(aNativo.inyectar(aGeno))
            lstHormiguero.set(indexList, hormiga.comer(aNativo));
        else   
            return hormiga.getTipo()+"NO alimentada";
        
        return lstHormiguero.get(indexList).getTipo() + " Alimentada ";
    }


}
