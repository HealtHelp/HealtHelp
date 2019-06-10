package com.api.healthelp.boot.config;




import com.api.healthelp.boot.auth.AuthClaims;
import com.api.healthelp.boot.properties.Properties;
import com.api.healthelp.controller.LoginController;
import com.api.healthelp.controller.UserController;
import com.api.healthelp.controller.impl.LoginControllerImpl;
import com.api.healthelp.controller.impl.UserControllerImpl;
import com.api.healthelp.dao.UserDao;
import com.api.healthelp.dao.impl.UserDaoImpl;
import com.api.healthelp.dao.mapper.UserMapper;
import com.api.healthelp.service.LoginService;
import com.api.healthelp.service.UserService;
import com.api.healthelp.service.impl.LoginServiceImpl;
import com.api.healthelp.service.impl.UserServiceImpl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class ApiConfig {

    //properties
    @Bean
    public Properties properties(){
        return new Properties();
    }

    //database
    @Bean
    @ConditionalOnProperty(name="db.enabled")
    public BasicDataSource driverManagerDataSource(final Properties properties){
        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName(properties.getDbDriver());
        connectionPool.setUrl(properties.getDbUrl());
        connectionPool.setUsername(properties.getDbUsername());
        connectionPool.setPassword(properties.getDbPassword());
        return connectionPool;

    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(final BasicDataSource driverManagerDataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setConfigLocation(new ClassPathResource("static/config.xml"));
        sqlSessionFactory.setDataSource(driverManagerDataSource);
        return sqlSessionFactory;
    }



    @Bean
    public MapperFactoryBean<UserMapper> userMapper(final SqlSessionFactory sqlSessionFactory1){
        final MapperFactoryBean<UserMapper> mfb = new MapperFactoryBean<>();
        mfb.setMapperInterface(UserMapper.class);
        mfb.setSqlSessionFactory(sqlSessionFactory1);
        return mfb;
    }



    //dao
    @Bean
    public UserDao userDao( final UserMapper userMapper1){
        return new UserDaoImpl(userMapper1);
    }
    //services
    @Bean
    public UserService userService(final UserDao userDao){
        return new UserServiceImpl(userDao);
    }


    @Bean
    public AuthClaims authClaims(Properties properties){return new AuthClaims(properties);}

    @Bean
    public LoginService loginService (final UserDao userDao, AuthClaims authClaims){return new LoginServiceImpl(userDao,authClaims); }

    //controllers
    @Bean
    public UserController userController(final UserService userService){ return new UserControllerImpl(userService); }


    @Bean
    public LoginController loginController(final LoginService loginService){return new LoginControllerImpl(loginService);
    }


}
