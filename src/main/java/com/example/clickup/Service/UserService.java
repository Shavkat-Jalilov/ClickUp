package com.example.clickup.Service;

import com.example.clickup.Entity.Attachment;
import com.example.clickup.DTO.ApiResponse;
import com.example.clickup.DTO.UserDTO;
import com.example.clickup.Entity.Enums.SystemRole;
import com.example.clickup.Repository.AttachmentRepository;
import com.example.clickup.Repository.LavozimRepository;
import com.example.clickup.Repository.RoleRepository;
import com.example.clickup.Repository.UserRepository;
import com.example.clickup.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    LavozimRepository lavozimRepository;
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public ApiResponse addUser(UserDTO userDTO){
        boolean b = userRepository.existsByEmail(userDTO.getEmail());
         Optional<Attachment> byId = attachmentRepository.findById(userDTO.getAttachment());
        if (b) return new ApiResponse("Bunday foydalanuvchi ro'yxatdan o'tgan",false);
        Users users=new Users(
                userDTO.getFullName(),
                userDTO.getEmail(),
                passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getColor(),
                userDTO.getInitialLetter(),
                byId.get(),
                SystemRole.USER,true);
        int code = new Random().nextInt(999999);
        users.setEmailCode(String.valueOf(code).substring(0,4));
        userRepository.save(users);
        sendMail(users.getEmail(), users.getEmailCode());
        return new ApiResponse("Foydalanuvchi muavffaqiyatli saqlandi", true);
    }
    public Boolean sendMail(String sendmail, String emailcode){
        try{
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            mailMessage.setFrom("shavkatjalilov17gmail.com");
            mailMessage.setTo(sendmail);
            mailMessage.setSubject("Accauntni tasdiqlash");
            mailMessage.setText(emailcode);
            javaMailSender.send(mailMessage);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public ApiResponse readUser(){
        List<Users> all = userRepository.findAll();
        if (all.isEmpty()){
            return new ApiResponse("Foydalanuvchilar ro'yxati!!!\n", true,all);
        }
        return new ApiResponse("Foydalanuvchilar topilmadi", false);
    }
    public ApiResponse deleteUser(UUID id){
        boolean b = userRepository.existsById(id);
        if (!b){
            return new ApiResponse("Bunday foydalanuvchi mavjud emas", false);
        }
        userRepository.deleteById(id);
        return new ApiResponse("Foydalanuvchu muavffaqiyatli o'chirildi",true);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

