import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    private int id;
    private String name;
    private String address;

    public abstract void displayInfo();
}
