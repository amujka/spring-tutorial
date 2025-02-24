package algebra.spring_practice.user;

import lombok.Data;

@Data
public class UpdateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long oib;
    private String dateOfBirth;
}
