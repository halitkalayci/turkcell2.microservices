package com.turkcell.identity_service.entity;

import java.util.Collection;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails
{
    @Id
    @UuidGenerator
    private UUID id;
    
    private String username;
    private String password;
    private String email;
   /* private String phoneNumber;
    private String address;
    private String city;
    private String country; */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return null;
    }
}
// Denormalizasyon -> Customer -> UserId 
// CustomerService -> UserService -> UserID'ı  User veritabanından getirir.
