package com.example.demo.entity;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;*/
import org.springframework.stereotype.Component;

/*import java.util.Collection;*/

@Component
public class YcAnthencationProder {



   /* @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username=authentication.getName();
        String password= (String) authentication.getCredentials();

        System.out.println("用户名："+username);
        System.out.println("密码："+password);

        UserEntity user= userServiceImpl.getByUsername(username);
        System.out.println(user);

        if(user==null) {throw new BadCredentialsException("Username not found");
        }

        if(!password.equals(user.getPassword())){throw new BadCredentialsException("Wrong password");};

        Collection<? extends GrantedAuthority> authorities=userServiceImpl.loadUserByUsername(username).getAuthorities();

        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }*/
}
