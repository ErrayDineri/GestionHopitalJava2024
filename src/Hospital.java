import lombok.*;

import java.sql.SQLOutput;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital implements  PatientCollection, DoctorPatientMap{
    private List<Patient> patients = new ArrayList<>();
    private Map<Doctor, Set<Patient>> doctorPatientMap = new HashMap<>();

    static public List<Doctor> getDoctorsBySpecialty(Map<Doctor, Set<Patient>> doctorPatientMap, String specialty)
    {
        ArrayList<Doctor> doctors = new ArrayList<>();
        for(Doctor d: doctorPatientMap.keySet())
            if (d.getSpeciality().equals(specialty))
                doctors.add(d);
        return doctors;
    }

    static public List<Patient> getPatientByAilment(List<Patient> patients, String ailment)
    {
        ArrayList<Patient> patientsRes = new ArrayList<>();
        for(Patient p: patients)
            if(p.getAilment().equals(ailment))
                patientsRes.add(p);
        return patientsRes;
    }

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Override
    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    @Override
    public Patient findPatientById(int id) {
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
        for (Patient p: patients)
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

    public List<Patient> sortPatientsByName()
    {
        //Lambda Func as a comparator
        patients.sort((d1, d2)-> d1.getName().compareTo(d2.getName()));
        return patients;
    }

    public List<Patient> searchPatientsByName(String name)
    {
        ArrayList<Patient> res = new ArrayList<>();
        for(Patient p: patients)
            if(p.getName().contains(name))
                res.add(p);
        return res;
    }

    public List<Doctor> searchDoctorsByName(String name)
    {
        ArrayList<Doctor> res = new ArrayList<>();
        for(Doctor p: doctorPatientMap.keySet())
            if(p.getName().contains(name))
                res.add(p);
        return res;
    }

    public List<Doctor> searchDoctorsByAddress(String address)
    {
        ArrayList<Doctor> res = new ArrayList<>();
        for(Doctor p: doctorPatientMap.keySet())
            if(p.getAddress().contains(address))
                res.add(p);
        return res;
    }

    public List<Patient> searchPatientsByAddress(String address)
    {
        ArrayList<Patient> res = new ArrayList<>();
        for(Patient p: patients)
            if(p.getAddress().contains(address))
                res.add(p);
        return res;
    }

    public void reportStat()
    {
        for(Doctor d: doctorPatientMap.keySet())
        {
            int nbPatients = doctorPatientMap.get(d).size();
            if(nbPatients>0)
                System.out.println("Doctor "+d.getName()+" has "+nbPatients+" patients");
            else
                System.out.println("Doctor "+d.getName()+" has no patients");
        }
        Map<String, Integer> ailmentsFreq = new HashMap<>();
        for (Patient p: patients)
        {
            if(p.getAilment()!=null)
                ailmentsFreq.put(p.getAilment(), ailmentsFreq.getOrDefault(p.getAilment(), 0)+1);
        }
        List<String> ailments = new ArrayList<>(ailmentsFreq.keySet());
        ailments.sort((d1, d2)->ailmentsFreq.get(d2).compareTo(ailmentsFreq.get(d1)));
        for(String ailment: ailments)
            System.out.println("Ailment "+ailment+" has "+ailmentsFreq.get(ailment)+" patients");

    }


}
