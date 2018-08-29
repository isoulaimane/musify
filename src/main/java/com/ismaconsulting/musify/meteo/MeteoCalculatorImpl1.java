package com.ismaconsulting.musify.meteo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"prod"})
@Component
public class MeteoCalculatorImpl1 implements MeteoCalculator {

    @Override
    public int calculMeteo() {
        return 40;
    }
}
