package com.api.healthelp.boot.properties;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Properties {
    //DB connection pool
    @Value("${db.enabled}")
    private String dbEnabled;

    @Value("${db.driver}")
    private String dbDriver;

    @Value("${db.url}")
    private String dbUrl;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;

    //Security
    @Value("${security.token.bitSecret}")
    private String bitSecret;

    @Value("${security.token.header}")
    private String header;


    @Value("${security.token.id}")
    private String id;

    @Value("${security.token.bearer}")
    private String bearer;


    @Value("${security.token.role}")
    private String role;



}
