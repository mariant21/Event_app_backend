package com.licenta.auth.payload.request;

import jakarta.validation.constraints.*;

import java.util.Set;
 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 23)
    private String nume;

    @NotBlank
    @Size(min = 3, max = 30)
    private String prenume;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }
 
    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
