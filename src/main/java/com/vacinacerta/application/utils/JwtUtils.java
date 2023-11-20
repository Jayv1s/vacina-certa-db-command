package com.vacinacerta.application.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${security.jwt.key}")
    private String JWT_KEY;

    public Claims getClaims(String jwt) {
        return Jwts.parser()
                .setSigningKey(JWT_KEY)
                .parseClaimsJws(jwt)
                .getBody();
    }

    public boolean validateJwtClaims(Claims claims) {
        LocalDateTime localDateTime = LocalDateTime.now();

        Instant instant = localDateTime.toInstant(ZoneId.of("America/Sao_Paulo").getRules().getOffset(localDateTime));

        Date dateNow = Date.from(instant);

        return !claims.getExpiration().before(dateNow);
    }
}
