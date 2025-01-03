import lombok.*;


@Data
@NoArgsConstructor
public class Patient extends Person implements Comparable<Patient> {
    private int socialSecurityNumber;
    private String ailment;
    public Patient(int id, String name, String address, int socialSecurityNumber, String ailment) {
        super(id, name, address);
        this.socialSecurityNumber = socialSecurityNumber;
        this.ailment = ailment;
    }

    @Override
    public void displayInfo()
    {
        System.out.println("--------Patient's ID: "+ getId());
        System.out.println("--------Patient's Name: "+ getName());
        System.out.println("--------Patient's address: "+ getAddress());
        System.out.println("--------Patient's SSN: "+ getSocialSecurityNumber());
        System.out.println("--------Patient's ailment: "+getAilment());
    }

    @Override
    public int compareTo(Patient p) {
        return Integer.compare(this.getId(), p.getId());
    }
}
