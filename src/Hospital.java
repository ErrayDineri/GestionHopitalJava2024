import lombok.*;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital implements  PatientCollection, DoctorPatientMap{
    private List<Patient> patients = new ArrayList<>();
    private Map<Doctor, Set<Patient>> doctorPatientMap = new HashMap<>();

    @Override
    public void assignPatientToDoctor(Doctor d, Patient p) throws HospitalException {

    }

    @Override
    public List<Patient> getPatientsOfDoctor(Doctor d) {
        return patients;
    }

    @Override
    public void displayAllAssignments() {

    }

    @Override
    public void addPatient(Patient patient) {

    }

    @Override
    public void removePatient(Patient patient) {

    }

    @Override
    public Patient findPatientById(int id) {
        return null;
    }

    @Override
    public void displayAllPatients() {

    }
}
