package com.example.self_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class Email implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String title;
    @Column
    private String message;
    @Column
    private String email;

}
