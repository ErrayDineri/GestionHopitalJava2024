import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person implements Comparable<Patient> {
    private int socialSecurityNumber;
    private String ailment;

    @Override
    public void displayInfo()
    {
        //ToComplete
    }

    @Override
    public int compareTo(Patient p) {
        //A compléter
    }
}
