package ch.fhnw.thrift.data.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.swagger.v3.oas.annotations.Hidden;

import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden

    private Long id;

    private String username;
    private String password;
    private String role; // Role can be 'USER', 'ADMIN'

    // Default constructor

  //  public User(){}

    // Constructor

  //  public User(String username, String password, String role){
  //      this.username = username;
  //      this.password = password;
  //      this.role = role;
  //  }

    // getters and setters

    public User(String string, String string2, String string3) {
        //TODO Auto-generated constructor stub
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    @Override
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(() -> "ROLE_" + role);
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;

    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
}
