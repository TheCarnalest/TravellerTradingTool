package Traveller.TradeGoods;

import Traveller.PlanetCodes.PlanetCode;
import Traveller.Planets.Planet;
import java.util.HashMap;

public abstract class TradeGood {
    /// Name or type of the trade good
    public String name;

    /// Planet codes on which this trade good can be bought, empty if it can be bought anywhere
    private PlanetCode[] availability;

    /// How many 6-sided dice are rolled to determine how many tons can be bought, result multiplied by tons_multiplier
    private int tons_dice;
    /// Multiplier to the result of the tons_dice roll on how many tons can be bought
    private int tons_multiplier;

    /// Price in credits for one ton of the trade good
    public double base_price;

    /// Planet codes and their modifiers added when purchasing, or subtracted when selling
    private HashMap<PlanetCode, Integer> purchase_modifiers;
    /// Planet codes and their modifiers added when selling, or subtracted when purchasing
    private HashMap<PlanetCode, Integer> sale_modifiers;

    /// The assumed outcome of rolling 2D6 for trading, for simplicity
    private static final int NORMAL_TRADE_ROLL = 8;
    /// The assumed Broker skill of buyers and suppliers trading goods
    private static final int NORMAL_BROKER_SKILL = 2;

    /// Where a lower trade roll outcome stops creating worse trade outcomes
    private static final int MINIMUM_TRADE_ROLL = -3;
    /// Where a higher trade roll outcome stops creating better trade outcomes
    private static final int MAXIMUM_TRADE_ROLL = 25;

    /// Multipliers for purchase price, with trade roll outcome as a pseudo-index
    private static final float[] PURCHASE_MULTIPLIERS = new float[] {
        3.00f, 2.50f, 2.00f, 1.75f, 1.50f, 1.35f, 1.25f, 1.20f, 1.15f, 1.10f,
        1.05f, 1.00f, 0.95f, 0.90f, 0.85f, 0.80f, 0.75f, 0.70f, 0.65f, 0.60f,
        0.55f, 0.50f, 0.45f, 0.40f, 0.35f, 0.30f, 0.25f, 0.20f, 0.15f
    };
    /// Multipliers for sale price, with trade roll outcome as a pseudo-index
    private static final float[] SALE_MULTIPLIERS = new float[] {
        0.10f, 0.20f, 0.30f, 0.40f, 0.45f, 0.50f, 0.55f, 0.60f, 0.65f, 0.70f,
        0.75f, 0.80f, 0.85f, 0.90f, 1.00f, 1.05f, 1.10f, 1.15f, 1.20f, 1.25f,
        1.30f, 1.40f, 1.50f, 1.60f, 1.75f, 2.00f, 2.50f, 3.00f, 4.00f
    };

    public int get_maximum_tons(Planet planet) {
        int dice_modifier = planet.population - 6;
        return (tons_dice * 6 + dice_modifier) * tons_multiplier;
    }

    public int get_maximum_tons() {
        return tons_dice * 6 * tons_multiplier;
    }

    public boolean is_available_on(Planet planet) {
        for (PlanetCode planet_code : planet.get_planet_codes()) {
            if (is_available_on(planet_code)) {
                return true;
            }
        }

        return false;
    }

    public boolean is_available_on(PlanetCode planet_code) {
        // Empty availability indicates the trade good is always available
        if (availability.length == 0) {
            return true;
        }

        for (PlanetCode availability_code : availability) {
            if (planet_code == availability_code) {
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the price to purchase a number of tons of this trade good
     * on a certain planet.
     * 
     * @param tons How many tons to purchase
     * @param planet What planet the trade good is being bought on
     * @return Total price of purchasing the number of tons of this trade good on the planet
     */
    public double get_purchase_price(int tons, Planet planet) {
        return tons * get_base_purchase_price(planet);
    }

    /**
     * Gets the price to sell a number of tons of this trade good
     * on a certain planet.
     * 
     * @param tons How many tons to sell
     * @param planet What planet the trade good is being sold on
     * @return Total price of selling the number of tons of this trade good on the planet
     */
    public double get_sale_price(int tons, Planet planet) {
        return tons * get_base_sale_price(planet);
    }

    private double get_base_purchase_price(Planet planet) {
        int modifier = get_total_purchase_modifier(NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
        float multiplier = get_price_multiplier(NORMAL_TRADE_ROLL + modifier, PURCHASE_MULTIPLIERS);
        return base_price * multiplier;
    }

    private double get_base_sale_price(Planet planet) {
        int modifier = get_total_sale_modifier(NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
        float multiplier = get_price_multiplier(NORMAL_TRADE_ROLL + modifier, SALE_MULTIPLIERS);
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

        for (PlanetCode trade_code : planet.get_planet_codes()) {
            modifier += get_purchase_modifier(trade_code);
        }

        return modifier;
    }

    private int get_planet_sale_modifier(Planet planet) {
        int modifier = 0;

        for (PlanetCode trade_code : planet.get_planet_codes()) {
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

    /**
     * Gets price multiplier for buying/selling for the given roll.
     * 
     * @param total_roll Dice roll + modifiers for buying/selling
     * @param modifier_array Which array of multipliers the result is being taken from (buying/selling)
     * @return Price multiplier for the roll from the array
     */
    private float get_price_multiplier(int total_roll, float[] modifier_array) {
        total_roll = Math.clamp(total_roll, MINIMUM_TRADE_ROLL, MAXIMUM_TRADE_ROLL);
        return modifier_array[total_roll - MINIMUM_TRADE_ROLL];
    }
}
