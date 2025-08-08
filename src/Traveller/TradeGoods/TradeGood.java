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
    double base_price;

    /// Planet codes and their modifiers added when purchasing, or subtracted when selling
    HashMap<PlanetCode, Integer> purchase_modifiers;
    /// Planet codes and their modifiers added when selling, or subtracted when purchasing
    HashMap<PlanetCode, Integer> sale_modifiers;

    private static final int NORMAL_TRADE_ROLL = 8;
    private static final int NORMAL_BROKER_SKILL = 2;

    private static final int MINIMUM_TRADE_ROLL = -3;
    private static final int MAXIMUM_TRADE_ROLL = 25;

    private static final float[] PURCHASE_MODIFIERS = new float[] {
        3.00f, 2.50f, 2.00f, 1.75f, 1.50f, 1.35f, 1.25f, 1.20f, 1.15f, 1.10f,
        1.05f, 1.00f, 0.95f, 0.90f, 0.85f, 0.80f, 0.75f, 0.70f, 0.65f, 0.60f,
        0.55f, 0.50f, 0.45f, 0.40f, 0.35f, 0.30f, 0.25f, 0.20f, 0.15f
    };
    private static final float[] SALE_MODIFIERS = new float[] {
        0.10f, 0.20f, 0.30f, 0.40f, 0.45f, 0.50f, 0.55f, 0.60f, 0.65f, 0.70f,
        0.75f, 0.80f, 0.85f, 0.90f, 1.00f, 1.05f, 1.10f, 1.15f, 1.20f, 1.25f,
        1.30f, 1.40f, 1.50f, 1.60f, 1.75f, 2.00f, 2.50f, 3.00f, 4.00f
    };

    public double get_purchase_price(int tons, Planet planet) {
        return tons * get_base_purchase_price(planet);
    }

    public double get_sale_price(int tons, Planet planet) {
        return tons * get_base_sale_price(planet);
    }

    private double get_base_purchase_price(Planet planet) {
        int modifier = get_total_purchase_modifier(NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
        float multiplier = get_price_multiplier(NORMAL_TRADE_ROLL + modifier, PURCHASE_MODIFIERS);
        return base_price * multiplier;
    }

    private double get_base_sale_price(Planet planet) {
        int modifier = get_total_sale_modifier(NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
        float multiplier = get_price_multiplier(NORMAL_TRADE_ROLL + modifier, SALE_MODIFIERS);
        return base_price * multiplier;
    }

    private int get_total_purchase_modifier(int buyer_skill, int supplier_skill, Planet planet) {
        return buyer_skill - supplier_skill + get_planet_purchase_modifier(planet);
    }

    private int get_total_sale_modifier(int supplier_skill, int buyer_skill, Planet planet) {
        return supplier_skill - buyer_skill + get_planet_sale_modifier(planet);
    }

    private int get_planet_purchase_modifier(Planet planet) {
        int modifier = 0;

        modifier += get_purchase_modifier(planet.travel_code);

        for (TradeCode trade_code : planet.trade_codes) {
            modifier += get_purchase_modifier(trade_code);
        }

        return modifier;
    }

    private int get_planet_sale_modifier(Planet planet) {
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
    private int get_purchase_modifier(PlanetCode planet_code) {
        return get_modifier(planet_code, purchase_modifiers) - get_modifier(planet_code, sale_modifiers);
    }

    /**
     * Gets the net dice modifier for selling this good on the given planet code.
     * 
     * @param planet_code Planet code the dice modifier is being found for
     * @return Total dice modifier or 0 if no matches are found
     */
    private int get_sale_modifier(PlanetCode planet_code) {
        return get_modifier(planet_code, sale_modifiers) - get_modifier(planet_code, purchase_modifiers);
    }

    /**
     * Gets the given planet code's trade dice modifier for this trade good in the given hashmap of modifiers.
     * 
     * @param planet_code Planet code the modifier is being fetched for
     * @param modifier_map Hashmap of planet codes to modifiers that the modifier is being fetched from
     * @return The found modifier, or 0 if none is found
     */
    private int get_modifier(PlanetCode planet_code, HashMap<PlanetCode, Integer> modifier_map) {
        if (modifier_map.containsKey(planet_code)) {
            return modifier_map.get(planet_code);
        } else {
            return 0;
        }
    }

    private float get_price_multiplier(int total_roll, float[] modifier_array) {
        total_roll = Math.clamp(total_roll, MINIMUM_TRADE_ROLL, MAXIMUM_TRADE_ROLL);
        return modifier_array[total_roll - MINIMUM_TRADE_ROLL];
    }
}
