package com.den.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Admin {
    private int aid;
    private String aname;
    private String apwd;
}
