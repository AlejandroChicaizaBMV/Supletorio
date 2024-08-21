package CSBusinessLogic;

import java.io.IOException;
import java.util.List;

import CSDAC.CSHormigaDAO;
import CSDAC.CSDTO.CSHormigaDTO;

public class CSHormigaBL {

    private CSHormigaDAO csHormigaDAO = new CSHormigaDAO("CSData\\Hormiguero.csv");

    public CSHormigaBL() {}

    public CSHormigaBL(String csFilePath) {
        this.csHormigaDAO = new CSHormigaDAO(csFilePath);
    }

    public List<CSHormigaDTO> csObtenerHormigas() throws IOException {
        return csHormigaDAO.csReadAll();
    }

    public void csAgregarHormiga(List<CSHormigaDTO> csHormigasLista) throws IOException {
        csHormigaDAO.csCreate(csHormigasLista);
    }

    public void csEliminarHormiga(int csNHormiga) throws IOException {
        csHormigaDAO.csDelete(csNHormiga);
    }
}
