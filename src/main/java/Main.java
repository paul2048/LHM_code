
import com.mycompany.lhm.Hospital;
import com.mycompany.lhm.Patient;
//import com.mycompany.lhm.Prescription;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        var hospital = new Hospital("LHM", "12 Oxford Street, HA7 7BP", 10000);
        
        var dob = LocalDate.now();
        var p = new Patient("Joe", "Doe", dob, hospital);
//        p.requestAppointment(false, dob);
        
//        Prescription prescription = new Prescription();
//        p.takePrescription();
    }
}
