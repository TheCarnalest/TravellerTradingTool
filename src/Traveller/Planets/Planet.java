package Traveller.Planets;

import Traveller.PlanetCodes.PlanetCode;
import Traveller.PlanetCodes.TradeCodes.TradeCode;
import Traveller.PlanetCodes.TravelCodes.TravelCode;
import java.util.Arrays;

public class Planet {
    public String name;
    
    public int population;

    private TradeCode[] trade_codes;
    private TravelCode travel_code;

    public PlanetCode[] get_planet_codes() {
        PlanetCode[] planet_codes = Arrays.copyOf(trade_codes, trade_codes.length + 1);
        planet_codes[trade_codes.length] = travel_code;
        return planet_codes;
    }
}
