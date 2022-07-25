package com.example.booking.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="User_id")
  private Integer id;
  @Column(nullable = false)
 private String username;
  @Column(nullable = false)
  private  String password;
}
