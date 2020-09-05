package com.zackfusnflash.day3_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_TBL")

public class Employee {
    @Id
    @GeneratedValue
    private int id;
    private  String firstName;
    private  String lastName;
    private String email;

}
