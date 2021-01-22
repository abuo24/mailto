package com.example.self_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailPayload {
    private String name;
    private String title;
    private String message;
    private String email;

}
