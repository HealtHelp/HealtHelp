package com.api.healthelp.model.dto;

import lombok.*;


@Data
@Builder
public class UserDTO  {
    private Integer id;
    private String username;
    private String email;
    private String profile;
    private String tenant;
}
