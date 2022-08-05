package com.example.clickup.Filter;

import com.example.clickup.Service.UserService;
import com.example.clickup.WebToken.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenFiltir extends OncePerRequestFilter {
    @Autowired
    TokenGenerator tokenGenerator;
    @Autowired
    UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    //    System.out.println(request.getHeader("Authorization").substring(0,6).equals("Bearer")?"bor":"yoq");
        String a = request.getHeader("Authorization");
        if (a!=null ){
            if (!tokenGenerator.Tokintekshirish(a)) {
                System.out.println("yoq");
            } else {
                System.out.println(a);
                String s = tokenGenerator.UsernameTekshirish(a);
                UserDetails userDetails = userService.loadUserByUsername(s);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
