package Traveller.Planets;

import Traveller.PlanetCode;
import java.util.Arrays;

public class Planet {
    public String name;
    
    public int population;

    private PlanetCode[] trade_codes;
    private PlanetCode travel_code;

    public PlanetCode[] get_planet_codes() {
        PlanetCode[] planet_codes = Arrays.copyOf(trade_codes, trade_codes.length + 1);
        planet_codes[trade_codes.length] = travel_code;
        return planet_codes;
    }
}
