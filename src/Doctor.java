import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person{
    private String speciality;
    private List<String> qualifications;

    @Override
    public void displayInfo()
    {
        System.out.println("Patient's ID: "+ getId());
        System.out.println("Patient's Name: "+ getName());
        System.out.println("Patient's address: "+ getAddress());
        System.out.println("Patient's SSN: "+ getSpeciality());
        System.out.println("Patient's ailment: "+getQualifications());
    }

}
