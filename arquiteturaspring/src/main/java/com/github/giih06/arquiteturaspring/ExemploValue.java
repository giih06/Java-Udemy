package com.github.giih06.arquiteturaspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExemploValue {

    @Value("${app.config.variavel}")
    private String variavel;

    public void imprimirVariavel() {
      System.out.println(variavel);
    }
}
