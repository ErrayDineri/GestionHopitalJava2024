import java.util.*;

public class Main {

    public static void main(String[] args) {
        Patient patient1 = new Patient(1, "John Doe", "123 Main St", 23, "Flu");
        Patient patient2 = new Patient(2, "Jane Smith", "456 Oak St", 24, "Cough");
        Patient patient3 = new Patient(3, "Alice Johnson", "789 Pine St", 52, "Headache");

        Doctor doctor1 = new Doctor(1, "Dr. Watson", "221B Baker Street", "Cardiology", Arrays.asList("MD", "PhD"));
        Doctor doctor2 = new Doctor(2, "Dr. Strange", "1234 Marvel Ave", "Neurology", Arrays.asList("MD"));

        Hospital hospital = new Hospital();

        hospital.addPatient(patient1);
        hospital.addPatient(patient2);
        hospital.addPatient(patient3);

        System.out.println("All patients:");
        hospital.displayAllPatients();

        Patient foundPatient = hospital.findPatientById(2);
        if (foundPatient != null) {
            System.out.println("Found patient by ID 2: " + foundPatient.getName());
        } else {
            System.out.println("Patient not found");
        }

        try {
            hospital.assignPatientToDoctor(doctor1, patient1);
            hospital.assignPatientToDoctor(doctor1, patient2);
            hospital.assignPatientToDoctor(doctor2, patient3);
        } catch (HospitalException e) {
            System.out.println("Error assigning patient: " + e.getMessage());
        }

        System.out.println("\nAll doctor-patient assignments:");
        hospital.displayAllAssignments();

        System.out.println("\nPatients of Dr. Watson:");
        List<Patient> patientsOfDoctor1 = hospital.getPatientsOfDoctor(doctor1);
        for (Patient p : patientsOfDoctor1) {
            System.out.println(p.getName());
        }

        System.out.println("\nPatients sorted by name:");
        List<Patient> sortedPatients = new ArrayList<>(hospital.getPatientsOfDoctor(doctor1));
        sortedPatients.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        for (Patient p : sortedPatients) {
            System.out.println(p.getName());
        }
    }
}