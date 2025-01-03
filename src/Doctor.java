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
        //A compléter
    }

}
