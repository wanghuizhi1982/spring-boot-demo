package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User implements Serializable {
   
   @Id
   @GeneratedValue
   //@ApiModelProperty(name = "ID", value = "用户ID", dataType = "Long")
   public long id;
   @Column(name = "name")
   //@ApiModelProperty(name = "name", value = "用户名", dataType = "String")
   public String name;
   //@ApiModelProperty(name = "name", value = "用户名", dataType = "String")
   public String phone;

}
