package com.api.healthelp.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserKeyValueDTO {
    private Integer id;
    private String email;
    private Integer profileId;
    private Integer tenantId;
}
