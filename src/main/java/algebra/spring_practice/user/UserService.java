package algebra.spring_practice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(1,"Alen","Alenic","alen@email.com","alen123",1234567891234L,"1989-09-26"));
        users.add(new User(2,"Bella","Smith","bella@email.com","bella456",9876543212345L,"1990-05-14"));
        users.add(new User(3,"Charlie","Johnson","charlie@email.com","charlie789",8765432101234L,"1991-08-10"));
        users.add( new User(4,"David","Williams","david@email.com","david001",7654321098765L,"1988-12-30"));
        users.add(new User(5,"Eva","Brown","eva@email.com","eva987",6543210987654L,"1993-04-20"));
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public User getUserById(int id){
        for (User user : users) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public User createUser(CreateUserDTO createUserDTO){
       User user =   new User(
                (int)Math.round(Math.random()*10000),
                createUserDTO.getFirstName(),
                createUserDTO.getLastName(),
                createUserDTO.getEmail(),
                createUserDTO.getPassword(),
                createUserDTO.getOib(),
                createUserDTO.getDateOfBirth()
        );

       users.add(user);
       return user;
    }

    public void updateUser(int id, UpdateUserDTO updateUserDTO){
        for (User user : this.users) {
            if (user.getId() == id){
                user.setFirstName(updateUserDTO.getFirstName());
                user.setLastName(updateUserDTO.getLastName());
                user.setEmail(updateUserDTO.getEmail());
                user.setPassword(updateUserDTO.getPassword());
                user.setOib(updateUserDTO.getOib());
                user.setDateOfBirth(updateUserDTO.getDateOfBirth());
            }
        }
    }

    public void deleteUserById(int id){
        users.removeIf(user -> user.getId() == id);
    }
}
