import lombok.*;

import java.sql.SQLOutput;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person implements Comparable<Patient> {
    private int socialSecurityNumber;
    private String ailment;

    @Override
    public void displayInfo()
    {
        System.out.println("Patient's ID: "+ getId());
        System.out.println("Patient's Name: "+ getName());
        System.out.println("Patient's address: "+ getAddress());
        System.out.println("Patient's SSN: "+ getSocialSecurityNumber());
        System.out.println("Patient's ailment: "+getAilment());
    }

    @Override
    public int compareTo(Patient p) {
        return Integer.compare(this.getId(), p.getId());
    }
}
