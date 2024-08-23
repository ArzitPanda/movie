package com.arz.movie.exceptions;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(new Customizer<CsrfConfigurer<HttpSecurity>>() {
                      @Override
                      public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                          httpSecurityCsrfConfigurer.disable();
                      }
                  })
                .authorizeRequests()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .oauth2Login(oauth2 -> oauth2
                                .userInfoEndpoint(userInfo -> userInfo
                                        .oidcUserService(oidcUserService())
                                )

                        )
                        .logout(logout -> logout
                                .logoutUrl("/logout")
                                .clearAuthentication(true)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")
                                .permitAll()
                        );

        return http.build();
    }

    @Bean
    public OidcUserService oidcUserService() {
        return new OidcUserService();
    }

}
