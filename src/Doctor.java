import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {
    private String speciality;
    private List<String> qualifications;
    public Doctor(int id, String name, String address, String speciality, List<String> qualifications) {
        super(id, name, address);
        this.speciality = speciality;
        this.qualifications = qualifications;
    }

    @Override
    public void displayInfo() {
        System.out.println("--------Doctor's ID: " + getId());
        System.out.println("--------Doctor's Name: " + getName());
        System.out.println("--------Doctor's Address: " + getAddress());
        System.out.println("--------Doctor's Specialty: " + getSpeciality());
        System.out.println("--------Doctor's Qualifications: " + getQualifications());
    }
}
