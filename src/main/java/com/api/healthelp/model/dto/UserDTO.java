package com.api.healthelp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO  {
    private Integer id;
    private String username;
    private String password;
    private Integer tenantId;
    private Integer profileId;
    private String email;

}
