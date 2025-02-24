package algebra.spring_practice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long oib;
    private String dateOfBirth;
}
