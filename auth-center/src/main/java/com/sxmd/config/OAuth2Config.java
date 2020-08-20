package com.sxmd.config;

import com.sxmd.base.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:  授权服务 提供 /oauth/authorize,/oauth/token,/oauth/check_token,/oauth/confirm_access
 *
 * @author cy
 * @date 2020年08月18日 17:47
 * Version 1.0
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Resource
    private DataSource dataSource;
    @Resource
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * Description:   配置客户端信息
     *
     * @param clients:
     * @return void
     * @author cy
     * @date 2020/8/18 17:59
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //这个地方指的是从jdbc查出数据来存储
        // clients.withClientDetails(clientDetails());
        clients.inMemory()
                .withClient("user-service")
                .secret(passwordEncoder.encode("123456"))
                .scopes("service")
                .autoApprove(true)
                .authorizedGrantTypes("implicit", "refresh_token", "password", "authorization_code")
                .redirectUris("http://localhost:22225/auth")
                .accessTokenValiditySeconds(12 * 300);//5min过期
    }


    /**
     * Description:   配置授权token 的节点
     *
     * @param endpoints:
     * @return void
     * @author cy
     * @date 2020/8/18 18:38
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        // token 的存储方式
        endpoints.tokenStore(jwtStore())
                // 开启密码验证 来自 WebSecurityConfigurerAdapter
                .authenticationManager(authenticationManager)
                .tokenEnhancer(jwtTokenEnhancer())
                .reuseRefreshTokens(false);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }

    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

    @Bean
    public TokenStore jwtStore() {
        TokenStore tokenStore = new JwtTokenStore(jwtTokenEnhancer());
        return tokenStore;
    }


    /**
     * Description:   jwt token 的生成
     *
     * @param :
     * @return org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
     * @author cy
     * @date 2020/8/18 18:32
     */
    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        // 重写增强token的方法，自定义返回
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter() {
            @Override
            public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
                // 与登录时候放进去的UserDetail实现类一直查看link{SecurityConfiguration}
                CustomUser user = (CustomUser) authentication.getUserAuthentication().getPrincipal();
                /** 自定义一些token属性 ***/
                final Map<String, Object> additionalInformation = new HashMap<>();
                // 里面包含了用户的权限和用户名称
                additionalInformation.put("userId", user.getId());
                ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
                OAuth2AccessToken enhancedToken = super.enhance(accessToken, authentication);
                return enhancedToken;
            }
        };
        converter.setSigningKey("123");
        return converter;
    }


}
