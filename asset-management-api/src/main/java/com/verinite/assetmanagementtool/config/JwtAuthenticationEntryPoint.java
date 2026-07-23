package com.verinite.assetmanagementtool.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetTime;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String timestamp= OffsetTime.now().toString();

        response.getWriter().write("""
                "timestamp": "%s",
                 "status": 401,
                 "error": "Unauthorized",
                 "message": "Invalid or Expired Token"
                """.formatted(timestamp));

        response.getWriter().flush();
    }
}
