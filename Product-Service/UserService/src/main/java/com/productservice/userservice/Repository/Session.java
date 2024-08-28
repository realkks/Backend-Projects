package com.productservice.userservice.Repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Entity
@Getter
@Setter

public class Session extends BaseModel{
    private String token;
    private Date expirydate;
    @ManyToOne
    private User user;
    @Enumerated (EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
