package org.thecarnalest;

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

    /**
     * Get this planet's roll modifier for how many
     * of a good are available on it, which is 
     * population - 6, so more goods at high
     * populations, less at low populations.
     * 
     * @return Roll modifier for trade good ton availability
     */
    public int get_goods_amount_modifier() {
        return population - 6;
    }

    /**
     * Get all of a planet's planet codes, which are its
     * trade codes + travel code in one array.
     * 
     * @return The planet's trade codes and its travel code
     */
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
