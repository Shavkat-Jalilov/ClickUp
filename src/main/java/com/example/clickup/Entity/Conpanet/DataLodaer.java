package com.example.clickup.Entity.Conpanet;

import com.example.clickup.Entity.Enums.Huquqlar;
import com.example.clickup.Entity.Lavozim;
import com.example.clickup.Repository.LavozimRepository;
import com.example.clickup.Repository.UserRepository;
import com.example.clickup.Entity.Users;
import com.example.clickup.Util.ConstClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static com.example.clickup.Entity.Enums.Huquqlar.*;

@Component
public class DataLodaer implements ApplicationRunner {
    @Autowired
    LavozimRepository lavozimRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${spring.sql.init.mode}")
    String initmode;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       if(initmode.equals("always")){
           Huquqlar[] huquqlars= Huquqlar.values();
           Lavozim save = lavozimRepository.save(new Lavozim(
                   ConstClass.ADMIN,"Dastur egasi", Arrays.asList(huquqlars)
           ));
           Lavozim save1 = lavozimRepository.save(new Lavozim(
                   ConstClass.USER,"Dastur foydalanuvchisi", Arrays.asList( WORKSPACECREAT, WORKSPACEREAD, WORKSPACEUPDATE, WORKSPACEDELETE)
           ));
           userRepository.save(new Users(
                   "admin","admin",passwordEncoder.encode("admin123"),save,true
           ));
           userRepository.save(new Users(
                   "user","user",passwordEncoder.encode("user123"),save1,true
           ));
       }
    }
}
