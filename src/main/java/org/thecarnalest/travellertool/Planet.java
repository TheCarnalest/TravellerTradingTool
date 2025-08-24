package org.thecarnalest.travellertool;

import java.util.Arrays;

public class Planet {
    public String name;
    
    private int size;
    private int atmosphere;
    private int hydrographics;
    private int population;
    private int government;
    private int law_level;
    private char starport;
    private int tech_level;

    private PlanetCode[] trade_codes;
    private PlanetCode travel_code;

    private static final int DEFAULT_SIZE = 8;
    private static final int DEFAULT_ATMOSPHERE = 6;
    private static final int DEFAULT_HYDROGRAPHICS = 7;
    private static final int DEFAULT_POPULATION = 6;
    private static final int DEFAULT_GOVERNMENT = 6;
    private static final int DEFAULT_LAW_LEVEL = 6;
    private static final char DEFAULT_STARPORT = 'C';
    private static final int DEFAULT_TECH_LEVEL = 6;

    public Planet(String name, PlanetCode[] trade_codes, PlanetCode travel_code) {
        this.name = name;
        this.size = DEFAULT_SIZE;
        this.atmosphere = DEFAULT_ATMOSPHERE;
        this.hydrographics = DEFAULT_HYDROGRAPHICS;
        this.population = DEFAULT_POPULATION;
        this.government = DEFAULT_GOVERNMENT;
        this.law_level = DEFAULT_LAW_LEVEL;
        this.starport = DEFAULT_STARPORT;
        this.tech_level = DEFAULT_TECH_LEVEL;
        this.trade_codes = trade_codes;
        this.travel_code = travel_code;
    }

    public Planet(String name, int population, PlanetCode[] trade_codes, PlanetCode travel_code) {
        this.name = name;
        this.size = DEFAULT_SIZE;
        this.atmosphere = DEFAULT_ATMOSPHERE;
        this.hydrographics = DEFAULT_HYDROGRAPHICS;
        this.population = population;
        this.government = DEFAULT_GOVERNMENT;
        this.law_level = DEFAULT_LAW_LEVEL;
        this.starport = DEFAULT_STARPORT;
        this.tech_level = DEFAULT_TECH_LEVEL;
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

    private void parse_profile(String profile) {
        String[] split_profile = profile.split("");

        // Starport class is treated as a letter
        starport = profile.charAt(0);

        // Other attributes are treated as numbers
        size = Integer.parseInt(split_profile[1]);
        atmosphere = Integer.parseInt(split_profile[2]);
        hydrographics = Integer.parseInt(split_profile[3]);
        population = Integer.parseInt(split_profile[4]);
        government = Integer.parseInt(split_profile[5]);
        law_level = Integer.parseInt(split_profile[6]);
        tech_level = Integer.parseInt(split_profile[8]);
    }

    public int size() { return size; }
    public int atmosphere() { return atmosphere; }
    public int hydrographics() { return hydrographics; }
    public int population() { return population; }
    public int government() { return government; }
    public int law_level() { return law_level; }
    public int starport() { return starport; }
    public int tech_level() { return tech_level; }

    @Override
    public String toString() {
        return name;
    }
}
