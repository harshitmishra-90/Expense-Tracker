package com.harshit.expense_tracker.Service;


import com.harshit.expense_tracker.Model.User;
import com.harshit.expense_tracker.Respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyuserDetailsSerivce implements UserDetailsService {

    @Autowired
    private UserRepository repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        System.out.println("Searching username: " + username);
        User user= repo.findByUsername(username);

        System.out.println("User from DB: " + user);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "User not found: " + username);
        }
        return new UserPrincipal(user);
    }
}
