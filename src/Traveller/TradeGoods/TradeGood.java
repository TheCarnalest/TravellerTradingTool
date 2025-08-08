package Traveller.TradeGoods;

import Traveller.PlanetCodes.PlanetCode;
import Traveller.PlanetCodes.TradeCodes.TradeCode;
import Traveller.Planets.Planet;
import java.util.HashMap;

public abstract class TradeGood {
    /// Name or type of the trade good
    String name;

    /// Planet codes on which this trade good can be bought
    PlanetCode[] availability;

    /// How many 6-sided dice are rolled to determine how many tons can be bought, result multiplied by tons_multiplier
    int tons_dice;
    /// Multiplier to the result of the tons_dice roll on how many tons can be bought
    int tons_multiplier;

    /// Price in credits for one ton of the trade good
    int base_price;

    /// Planet codes and their modifiers added when purchasing, or subtracted when selling
    HashMap<PlanetCode, Integer> purchase_modifiers;
    /// Planet codes and their modifiers added when selling, or subtracted when purchasing
    HashMap<PlanetCode, Integer> sale_modifiers;

    int get_planet_purchase_modifiers(Planet planet) {
        int modifier = 0;

        modifier += get_purchase_modifier(planet.travel_code);

        for (TradeCode trade_code : planet.trade_codes) {
            modifier += get_purchase_modifier(trade_code);
        }

        return modifier;
    }

    int get_planet_sale_modifiers(Planet planet) {
        int modifier = 0;

        modifier += get_sale_modifier(planet.travel_code);

        for (TradeCode trade_code : planet.trade_codes) {
            modifier += get_sale_modifier(trade_code);
        }

        return modifier;
    }

    /**
     * Gets the net dice modifier for purchasing this good on the given planet code.
     * 
     * @param planet_code Planet code the dice modifier is being found for
     * @return Total dice modifier or 0 if no matches are found
     */
    int get_purchase_modifier(PlanetCode planet_code) {
        return get_modifier(planet_code, purchase_modifiers) - get_modifier(planet_code, sale_modifiers);
    }

    /**
     * Gets the net dice modifier for selling this good on the given planet code.
     * 
     * @param planet_code Planet code the dice modifier is being found for
     * @return Total dice modifier or 0 if no matches are found
     */
    int get_sale_modifier(PlanetCode planet_code) {
        return get_modifier(planet_code, sale_modifiers) - get_modifier(planet_code, purchase_modifiers);
    }

    /**
     * Gets the given planet code's trade dice modifier for this trade good in the given hashmap of modifiers.
     * 
     * @param planet_code Planet code the modifier is being fetched for
     * @param modifier_map Hashmap of planet codes to modifiers that the modifier is being fetched from
     * @return The found modifier, or 0 if none is found
     */
    int get_modifier(PlanetCode planet_code, HashMap<PlanetCode, Integer> modifier_map) {
        if (modifier_map.containsKey(planet_code)) {
            return modifier_map.get(planet_code);
        } else {
            return 0;
        }
    }
}
