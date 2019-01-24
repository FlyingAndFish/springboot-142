package com.wz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ems implements Serializable {
    private String id;
    private String name;
    private String tel;
    private String address;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
