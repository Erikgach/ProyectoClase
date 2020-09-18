package org.una.tramites.jwt;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.una.tramites.dto.AuthenticationRequest;

import java.util.Date;

@Component
public class JwtProvider{
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;



        public String generateToken(AuthenticationRequest authenticationRequest) {

            return Jwts.builder().setSubject(authenticationRequest.getCedula())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                    .signWith(SignatureAlgorithm.HS512, secret).compact();
        }


        public String getSubject(String token) {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }

        public boolean isValid(String token) {
            try {
                Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                return true;


            }catch (ExpiredJwtException e) {
                logger.error("token expirado");
            }catch (MalformedJwtException e){
                logger.error("token mal formado");
            }catch (SignatureException e){
                logger.error("fail en la firma");
            }catch ( UnsupportedJwtException e){
                logger.error("token no soportado");
            }catch (IllegalArgumentException e){
                logger.error("token vacio");
            }
            return false;
    }


}




