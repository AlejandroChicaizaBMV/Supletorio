package CSBL;

import java.io.IOException;
import java.util.List;

import CSBL.Entities.CSHormiga;
import CSDAC.CSHormigaDAO;

public class CSHormigaBL {

    private CSHormigaDAO csHormigaDAO = new CSHormigaDAO("CSData\\Hormiguero.csv");

    public CSHormigaBL() {}

    public CSHormigaBL(String csFilePath) {
        this.csHormigaDAO = new CSHormigaDAO(csFilePath);
    }

    public List<CSHormiga> csObtenerHormigas() throws IOException {
        return csHormigaDAO.csReadAll();
    }

    public void csAgregarHormiga(List<CSHormiga> csHormigasLista) throws IOException {
        csHormigaDAO.csCreate(csHormigasLista);
    }

    public void csEliminarHormiga(int csNHormiga) throws IOException {
        csHormigaDAO.csDelete(csNHormiga);
    }
}
