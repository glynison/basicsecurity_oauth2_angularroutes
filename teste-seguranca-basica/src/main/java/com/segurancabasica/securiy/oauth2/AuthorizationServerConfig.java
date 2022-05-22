package com.segurancabasica.securiy.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer.AuthorizationEndpointConfig;

@Profile("oauth-security")
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
        .withclient("angular").secret("{noop}Angular") //Angular
        .scope("read", "write").authorizedGrantTypes("password").accessTokenValiditySeconds(1800)
        .and()
        .whitClient("android").secret("{noop}Android") //Android
        .scope("read").authorizedGrantTypes("password").accessTokenValiditySeconds(1800)
        
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
        .tokenStore(tokenStore()).authenticationManager(authenticationManager;)
        
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
    
}
