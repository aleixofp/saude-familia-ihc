package br.com.ihc.projetosaudefamilia;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ProjetoSaudeFamiliaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoSaudeFamiliaApplication.class, args);
    }

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

}
