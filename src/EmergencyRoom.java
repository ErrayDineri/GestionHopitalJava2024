import lombok.*;
import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmergencyRoom implements PatientCollection, DoctorPatientMap {
    private Set<Patient> patientsSet = new HashSet<>();
    private Map<Doctor, Set<Patient>> doctorPatientMap = new HashMap<>();

    static public List<Doctor> getDoctorsBySpecialty(Map<Doctor, Set<Patient>> doctorPatientMap, String specialty)
    {
        return Hospital.getDoctorsBySpecialty(doctorPatientMap, specialty);
    }

    static public List<Patient> getPatientByAilment(List<Patient> patients, String ailment)
    {
        return Hospital.getPatientByAilment(patients, ailment);
    }

    @Override
    public void addPatient(Patient patient) {
        patientsSet.add(patient);
    }

    @Override
    public void removePatient(Patient patient) {
        patientsSet.remove(patient);
    }

    @Override
    public Patient findPatientById(int id) {
        List<Patient> patients = new ArrayList<>(patientsSet);
        int i=0;
        while (i<patients.size() && patients.get(i).getId()!=id)
            i++;
        if (i<patients.size())
            return patients.get(i);
        else
            return null;
    }

    @Override
    public void displayAllPatients() {
        for (Patient p: patientsSet)
        {
            p.displayInfo();
        }
    }
    @Override
    public void assignPatientToDoctor(Doctor d, Patient p) throws HospitalException {
        if (d==null || p==null)
            throw new HospitalException("Invalid doctor or patient");
        if (doctorPatientMap.containsKey(d))
            doctorPatientMap.get(d).add(p);
        else
        {
            Set<Patient> s = new HashSet<>();
            s.add(p);
            doctorPatientMap.put(d, s);
        }

    }

    @Override
    public List<Patient> getPatientsOfDoctor(Doctor d) {
        return new ArrayList<>(doctorPatientMap.get(d));
    }

    @Override
    public void displayAllAssignments() {
        for (Doctor d: doctorPatientMap.keySet())
        {
            System.out.println("Doctor "+d.getName()+" has the following patients:");
            for (Patient p: doctorPatientMap.get(d))
            {
                p.displayInfo();
            }
        }

    }

}
