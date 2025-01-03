import java.util.List;

public interface DoctorPatientMap {
    void assignPatientToDoctor(Doctor d, Patient p) throws HospitalException;
    List<Patient> getPatientsOfDoctor (Doctor d);
    void displayAllAssignments();
}
