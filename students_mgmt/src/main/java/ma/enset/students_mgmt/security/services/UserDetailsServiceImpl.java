package ma.enset.students_mgmt.security.services;

import lombok.AllArgsConstructor;
import ma.enset.students_mgmt.security.entities.UserApp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private SecurityService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp user = service.loadByUsername(username);
        Collection<GrantedAuthority> authorities = user.getRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
