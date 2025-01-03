import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specialist extends Doctor {
    private String expertiseArea;
    @Override
    public void displayInfo()
    {
        super.displayInfo();
        System.out.println("--------Specialist's expertise area: "+ getExpertiseArea());
    }
}
