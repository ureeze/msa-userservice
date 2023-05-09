package com.example.userservice.dto;

import com.example.userservice.entity.UserEntity;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;

    public UserDto(RequestUser requestUser) {
        this.email = requestUser.getEmail();
        this.name = requestUser.getName();
        this.pwd = requestUser.getPwd();
    }

    public UserDto(UserEntity userEntity) {
        this.email = userEntity.getEmail();
        this.name = userEntity.getName();
        this.userId = userEntity.getUserId();
        this.encryptedPwd = userEntity.getEncryptedPwd();
    }

    public static UserEntity toEntity(UserDto userDto) {
        return UserEntity.builder()
                .email(userDto.getEmail())
                .name(userDto.getName())
                .userId(userDto.getUserId())
                .encryptedPwd(userDto.getEncryptedPwd())
                .build();
    }


}
