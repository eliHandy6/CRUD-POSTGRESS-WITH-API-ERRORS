package com.zackfusnflash.day3_project.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;

}
