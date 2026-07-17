package com.asagao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        /*
        * CORSの設定
        *  addMapping       : どのパスに対してCORSを適用するか
        *  allowedOrigins   : リクエストを許可するオリジン
        *  allowedMethods   : リクエスト可能なHTTPメソッド
        *  allowCredentials : Cookieなどの資格情報を含むリクエストの受入可否
        */
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
