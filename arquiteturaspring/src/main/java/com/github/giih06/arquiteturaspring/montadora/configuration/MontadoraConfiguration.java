package com.github.giih06.arquiteturaspring.montadora.configuration;

import com.github.giih06.arquiteturaspring.montadora.Motor;
import com.github.giih06.arquiteturaspring.montadora.TipoMotor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class MontadoraConfiguration {

    @Bean(name = "motorAspirado")
    @Scope("singleton")
    public Motor motorAspirado() {
        var motor = new Motor();
        motor.setCavalos(120);
        motor.setCilindros(4);
        motor.setModelo("XPTO-0");
        motor.setLitragem(2.0);
        motor.setTipo(TipoMotor.ASPIRADO);
        return motor;
    }

    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        var motor = new Motor();
        motor.setCavalos(90);
        motor.setCilindros(3);
        motor.setModelo("TH-30");
        motor.setLitragem(1.9);
        motor.setTipo(TipoMotor.ELETRICO);
        return motor;
    }

    @Primary
    @Bean(name = "motorTurbo")
    public Motor motorTurbo() {
        var motor = new Motor();
        motor.setCavalos(170);
        motor.setCilindros(5);
        motor.setModelo("XPTO-02");
        motor.setLitragem(1.7);
        motor.setTipo(TipoMotor.TURBO);
        return motor;
    }
}
