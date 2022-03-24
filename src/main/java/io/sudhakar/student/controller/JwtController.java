package io.sudhakar.student.controller;

import io.sudhakar.student.dto.MyUserDetails;
import io.sudhakar.student.dto.AuthenticationResponse;
import io.sudhakar.student.dto.User;
import io.sudhakar.student.service.JwtUserDetailsService;
import io.sudhakar.student.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class JwtController {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService userDetailsService;
    private final JwtUtil jwtTokenUtil;

//  private final  UserUtil userUtil;

    public JwtController(AuthenticationManager authenticationManager, JwtUserDetailsService userDetailsService, JwtUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;


    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody MyUserDetails myUserDetails) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(myUserDetails.getUsername(),
                            myUserDetails.getPassword()));

            final User userDetails = userDetailsService
                    .loadUserByUsername(myUserDetails.getUsername());

            final String jwt = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect user name / password", e);
        }


    }
}