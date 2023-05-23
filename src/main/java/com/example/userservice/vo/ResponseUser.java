package com.example.userservice.vo;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser implements Serializable {
    private String email;
    private String name;
    private String userId;
    private List<ResponseOrder> orders;


    public ResponseUser(UserDto userDto) {
        this.email = userDto.getEmail();
        this.name = userDto.getName();
        this.userId = userDto.getUserId();
        this.orders= userDto.getOrders();
    }

    public ResponseUser(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.userId = userEntity.getUserId();
    }


}
