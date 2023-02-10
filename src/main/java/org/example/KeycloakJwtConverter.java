package org.example;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakJwtConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Map<String, Object> realmRoles = jwt.getClaim("realm_access");
        List<SimpleGrantedAuthority> authorities;
        if (realmRoles != null) {
            List<String> roles = (List<String>) realmRoles.get("roles");
            authorities = roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        } else {
            authorities = new ArrayList<>();
        }
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
