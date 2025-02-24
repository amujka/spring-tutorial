package algebra.spring_practice.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDTO createUserDTO){
        return userService.createUser(createUserDTO);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UpdateUserDTO updateUserDTO){
        userService.updateUser(id,updateUserDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable int id){
         userService.deleteUserById(id);
    }
}
