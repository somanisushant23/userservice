package com.sushant.userservice.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import jakarta.persistence.Entity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@JsonDeserialize(as = Role.class)
@Entity
public class Role extends BaseModel {
    private String role;
}
