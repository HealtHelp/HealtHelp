package com.api.healthelp.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserKeyValueDTO {
    private Long id;
    private String email;
    private Long profileId;
    private Long tenantId;
}
