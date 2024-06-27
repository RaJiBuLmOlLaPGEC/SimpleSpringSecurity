package com.rajibul.SpringSecurityApp1.service;

import com.rajibul.SpringSecurityApp1.models.UserInfo;
import com.rajibul.SpringSecurityApp1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetalsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo useropt=userInfoRepository.findByName(username).orElseThrow(()->new UsernameNotFoundException("User not found with name "+username));
        return new UserInfoUserDetails(useropt);
    }
    public String register(UserInfo user){
        user.setPassword(encoder.encode(user.getPassword()));
        userInfoRepository.save(user);
        return "user saved.";
    }
}
