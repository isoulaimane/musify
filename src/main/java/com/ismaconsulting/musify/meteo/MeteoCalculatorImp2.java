package com.ismaconsulting.musify.meteo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("integ")
@Component
public class MeteoCalculatorImp2 implements MeteoCalculator {

    @Override
    public int calculMeteo() {
        return 20;
    }
}
