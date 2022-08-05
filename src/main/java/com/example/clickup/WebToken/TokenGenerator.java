package com.example.clickup.WebToken;

import com.example.clickup.Entity.Lavozim;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {
    long vaqt=1000*60*60*24;
    Date yashashvaqti=new Date(System.currentTimeMillis()+vaqt);
    String parol="shavkat17#";
   public String yasash(String username, Lavozim lavozimList){
       String token = Jwts
               .builder()
               .setSubject(username)
               .setIssuedAt(new Date())
               .claim("ROLES",lavozimList.getNomi())
               .setExpiration(yashashvaqti)
               .signWith(SignatureAlgorithm.HS512, parol)
               .compact();
       return token;
   }
   public boolean Tokintekshirish(String token){
       JwtParser parser = Jwts
               .parser();
       parser.setSigningKey(parol);
       parser.parseClaimsJws(token);

       return true;
   }
   public String UsernameTekshirish(String username){
       String uname = Jwts
               .parser()
               .setSigningKey(parol)
               .parseClaimsJws(username)
               .getBody()
               .getSubject();

       return uname;
   }

//    public static void main(String[] args) {
//        String faxriddin = yasash("Faxriddin");
//        System.out.println(faxriddin);
//    }
}
