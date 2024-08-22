package CSInfra;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSAppException extends Exception {

    public CSAppException(String message) {
        super(message);
        logErrorToFile(message,"","");
    }

    public CSAppException(Exception e, String clase, String metodo){
        super("Ups! Hormiguero sin control...");
        logErrorToFile(e.getMessage(), clase, metodo);
    }

    private void logErrorToFile (String message, String clase, String metodo){
        try(PrintWriter writer = new PrintWriter(new FileWriter(Config.LOGFILE, true))){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            System.out.println("AppException "+"- "+clase+". "+clase+": "+ message );
            writer.println(now.format(formatter)+ " - "+clase+" . "+clase+" : " + message);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("AppException "+"- "+clase+". "+clase+": "+ message );
        }

    }

    @Override
    public String getMessage() {
        return "Error... el programa quedó 🤡";
    }
}
