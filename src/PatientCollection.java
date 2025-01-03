public interface PatientCollection {
    void addPatient(Patient patient);
    void removePatient(Patient patient);
    Patient findPatientById(int id);
    void displayAllPatients();
}
