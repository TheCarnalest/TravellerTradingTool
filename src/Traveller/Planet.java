package Traveller;

import java.util.Arrays;

public class Planet {
    public final String name;
    
    private final int population;

    private final PlanetCode[] trade_codes;
    private final PlanetCode travel_code;

    public Planet(String name, PlanetCode[] trade_codes, PlanetCode travel_code) {
        this.name = name;
        this.population = 6;
        this.trade_codes = trade_codes;
        this.travel_code = travel_code;
    }

    public Planet(String name, int population, PlanetCode[] trade_codes, PlanetCode travel_code) {
        this.name = name;
        this.population = population;
        this.trade_codes = trade_codes;
        this.travel_code = travel_code;
    }

    public int get_goods_amount_modifier() {
        return population - 6;
    }

    public PlanetCode[] get_planet_codes() {
        PlanetCode[] planet_codes = Arrays.copyOf(trade_codes, trade_codes.length + 1);
        planet_codes[trade_codes.length] = travel_code;
        return planet_codes;
    }

    @Override
    public String toString() {
        return name;
    }
}
