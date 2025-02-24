package algebra.spring_practice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    //Korisnik ima id (Long), ime, prezime, email, password, oib, datum rodenja.
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private long oib;
    private String dateOfBirth;
}
