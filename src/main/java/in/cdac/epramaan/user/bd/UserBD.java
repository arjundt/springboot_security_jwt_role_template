package in.cdac.epramaan.user.bd;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import in.cdac.epramaan.user.model.User;
import in.cdac.epramaan.user.model.UserResponse;
 
public interface UserBD extends UserDetailsService {
 
    public UserResponse addUser(User user);
 
    public User getUser(Integer userId);
 
    public User getUserByUserName(String username);
    
    public UserResponse authenticateUser(User user);
 
    public UserResponse updateUser(User user);
    
    public void deleteUser(Integer userId);
 
    public List<User> getUsers();
    
}