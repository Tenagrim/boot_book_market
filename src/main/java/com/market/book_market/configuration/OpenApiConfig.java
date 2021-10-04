package com.market.book_market.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class OpenApiConfig {

    private final String serverUrl;
    private static final String SECURITY_SCHEME = "bearer-jwt";

    @Bean
    OpenAPI openAPI() {
        SpringDocUtils.getConfig().addAnnotationsToIgnore(AuthenticationPrincipal.class);
        return new OpenAPI()
                .addServersItem(new Server().url(serverUrl))
                .components(new Components().addSecuritySchemes(SECURITY_SCHEME,
                        new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER).name("Authorization")))
                .addSecurityItem(new SecurityRequirement().addList(SECURITY_SCHEME, Arrays.asList("read", "write")));
    }
}
