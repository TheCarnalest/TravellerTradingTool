package org.thecarnalest.travellertool;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public enum TradeGood {
    // Enums directly copied from ChatGPT using the Traveller core rulebook with no edits of my own
    COMMON_ELECTRONICS(
        "Common Electronics",
        set(),                    // All
        2, 10,                    // 2D x 10
        20000,                    // Cr20000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 3),
            entry(PlanetCode.RICH, 1)
        ),
        enum_map(
            entry(PlanetCode.NON_INDUSTRIAL, 2),
            entry(PlanetCode.LOW_TECH, 1),
            entry(PlanetCode.POOR, 1)
        )
    ),
    COMMON_INDUSTRIAL_GOODS(
        "Common Industrial Goods",
        set(),                    // All
        2, 10,
        10000,                    // Cr10000
        enum_map(
            entry(PlanetCode.NON_AGRICULTURAL, 2),
            entry(PlanetCode.INDUSTRIAL, 5)
        ),
        enum_map(
            entry(PlanetCode.NON_INDUSTRIAL, 3),
            entry(PlanetCode.AGRICULTURAL, 2)
        )
    ),
    COMMON_MANUFACTURED_GOODS(
        "Common Manufactured Goods",
        set(),                    // All
        2, 10,
        20000,                    // Cr20000
        enum_map(
            entry(PlanetCode.NON_AGRICULTURAL, 2),
            entry(PlanetCode.INDUSTRIAL, 5)
        ),
        enum_map(
            entry(PlanetCode.NON_INDUSTRIAL, 3),
            entry(PlanetCode.HIGH_POPULATION, 2)
        )
    ),
    COMMON_RAW_MATERIALS(
        "Common Raw Materials",
        set(),                    // All
        2, 20,
        5000,                     // Cr5000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 3),
            entry(PlanetCode.GARDEN, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.POOR, 2)
        )
    ),
    COMMON_CONSUMABLES(
        "Common Consumables",
        set(),                    // All
        2, 20,
        500,                      // Cr500
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 3),
            entry(PlanetCode.WATERWORLD, 2),
            entry(PlanetCode.GARDEN, 1),
            entry(PlanetCode.ASTEROID, -4)
        ),
        enum_map(
            entry(PlanetCode.ASTEROID, 1),
            entry(PlanetCode.FLUID_OCEANS, 1),
            entry(PlanetCode.ICE_CAPPED, 1),
            entry(PlanetCode.HIGH_POPULATION, 1)
        )
    ),
    COMMON_ORE(
        "Common Ore",
        set(),                    // All
        2, 20,
        1000,                     // Cr1000
        enum_map(
            entry(PlanetCode.ASTEROID, 4)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 3),
            entry(PlanetCode.NON_INDUSTRIAL, 1)
        )
    ),
    ADVANCED_ELECTRONICS(
        "Advanced Electronics",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        100000,                   // Cr100000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 3)
        ),
        enum_map(
            entry(PlanetCode.NON_INDUSTRIAL, 1),
            entry(PlanetCode.RICH, 2),
            entry(PlanetCode.ASTEROID, 3)
        )
    ),
    ADVANCED_MACHINE_PARTS(
        "Advanced Machine Parts",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        75000,                    // Cr75000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 1)
        ),
        enum_map(
            entry(PlanetCode.ASTEROID, 2),
            entry(PlanetCode.NON_INDUSTRIAL, 1)
        )
    ),
    ADVANCED_MANUFACTURED_GOODS(
        "Advanced Manufactured Goods",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        100000,                   // Cr100000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 1)
        ),
        enum_map(
            entry(PlanetCode.HIGH_POPULATION, 1),
            entry(PlanetCode.RICH, 2)
        )
    ),
    ADVANCED_WEAPONS(
        "Advanced Weapons",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        150000,                   // Cr150000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 2)
        ),
        enum_map(
            entry(PlanetCode.POOR, 1),
            entry(PlanetCode.AMBER_ZONE, 2),
            entry(PlanetCode.RED_ZONE, 4)
        )
    ),
    ADVANCED_VEHICLES(
        "Advanced Vehicles",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        180000,                   // Cr180000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 2)
        ),
        enum_map(
            entry(PlanetCode.ASTEROID, 2),
            entry(PlanetCode.RICH, 2)
        )
    ),
    BIOCHEMICALS(
        "Biochemicals",
        set(PlanetCode.AGRICULTURAL, PlanetCode.WATERWORLD),
        1, 5,
        50000,                    // Cr50000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 1),
            entry(PlanetCode.WATERWORLD, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2)
        )
    ),
    CRYSTALS_AND_GEMS(
        "Crystals & Gems",
        set(PlanetCode.ASTEROID, PlanetCode.DESERT, PlanetCode.ICE_CAPPED),
        1, 5,
        20000,                    // Cr20000
        enum_map(
            entry(PlanetCode.ASTEROID, 2),
            entry(PlanetCode.DESERT, 1),
            entry(PlanetCode.ICE_CAPPED, 1)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 3),
            entry(PlanetCode.RICH, 2)
        )
    ),
    CYBERNETICS(
        "Cybernetics",
        set(PlanetCode.HIGH_TECH),
        1, 1,                     // 1D
        250000,                   // Cr250000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 1)
        ),
        enum_map(
            entry(PlanetCode.ASTEROID, 1),
            entry(PlanetCode.ICE_CAPPED, 1),
            entry(PlanetCode.RICH, 2)
        )
    ),
    LIVE_ANIMALS(
        "Live Animals",
        set(PlanetCode.AGRICULTURAL, PlanetCode.GARDEN),
        1, 10,
        10000,                    // Cr10000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 2)
        ),
        enum_map(
            entry(PlanetCode.LOW_POPULATION, 3)
        )
    ),
    LUXURY_CONSUMABLES(
        "Luxury Consumables",
        set(PlanetCode.AGRICULTURAL, PlanetCode.GARDEN, PlanetCode.WATERWORLD),
        1, 10,
        20000,                    // Cr20000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 2),
            entry(PlanetCode.WATERWORLD, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 2),
            entry(PlanetCode.HIGH_POPULATION, 2)
        )
    ),
    LUXURY_GOODS(
        "Luxury Goods",
        set(PlanetCode.HIGH_POPULATION),
        1, 1,                     // 1D
        200000,                   // Cr200000
        enum_map(
            entry(PlanetCode.HIGH_POPULATION, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 4)
        )
    ),
    MEDICAL_SUPPLIES(
        "Medical Supplies",
        set(PlanetCode.HIGH_TECH, PlanetCode.HIGH_POPULATION),
        1, 5,
        50000,                    // Cr50000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.POOR, 1),
            entry(PlanetCode.RICH, 1)
        )
    ),
    PETROCHEMICALS(
        "Petrochemicals",
        set(PlanetCode.DESERT, PlanetCode.FLUID_OCEANS, PlanetCode.ICE_CAPPED, PlanetCode.WATERWORLD),
        1, 10,
        10000,                    // Cr10000
        enum_map(
            entry(PlanetCode.DESERT, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.AGRICULTURAL, 1),
            entry(PlanetCode.LOW_TECH, 2)
        )
    ),
    PHARMACEUTICALS(
        "Pharmaceuticals",
        set(PlanetCode.ASTEROID, PlanetCode.DESERT, PlanetCode.HIGH_POPULATION, PlanetCode.WATERWORLD),
        1, 1,                     // 1D
        100000,                   // Cr100000
        enum_map(
            entry(PlanetCode.ASTEROID, 2),
            entry(PlanetCode.HIGH_POPULATION, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 2),
            entry(PlanetCode.LOW_TECH, 1)
        )
    ),
    POLYMERS(
        "Polymers",
        set(PlanetCode.INDUSTRIAL),
        1, 10,
        7000,                     // Cr7000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 2),
            entry(PlanetCode.NON_INDUSTRIAL, 1)
        )
    ),
    PRECIOUS_METALS(
        "Precious Metals",
        set(PlanetCode.ASTEROID, PlanetCode.DESERT, PlanetCode.ICE_CAPPED, PlanetCode.FLUID_OCEANS),
        1, 1,                     // 1D
        50000,                    // Cr50000
        enum_map(
            entry(PlanetCode.ASTEROID, 3),
            entry(PlanetCode.DESERT, 1),
            entry(PlanetCode.ICE_CAPPED, 2)
        ),
        enum_map(
            entry(PlanetCode.RICH, 3),
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 1)
        )
    ),
    RADIOACTIVES(
        "Radioactives",
        set(PlanetCode.ASTEROID, PlanetCode.DESERT, PlanetCode.LOW_POPULATION),
        1, 1,                     // 1D
        1_000_000,                // MCr1
        enum_map(
            entry(PlanetCode.ASTEROID, 2),
            entry(PlanetCode.LOW_POPULATION, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 3),
            entry(PlanetCode.HIGH_TECH, 1),
            entry(PlanetCode.NON_INDUSTRIAL, -2),
            entry(PlanetCode.AGRICULTURAL, -3)
        )
    ),
    ROBOTS(
        "Robots",
        set(PlanetCode.INDUSTRIAL),
        1, 5,
        400000,                   // Cr400000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 1)
        ),
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 2),
            entry(PlanetCode.HIGH_TECH, 1)
        )
    ),
    SPICES(
        "Spices",
        set(PlanetCode.GARDEN, PlanetCode.DESERT, PlanetCode.WATERWORLD),
        1, 10,
        6000,                     // Cr6000
        enum_map(
            entry(PlanetCode.DESERT, 2)
        ),
        enum_map(
            entry(PlanetCode.HIGH_POPULATION, 2),
            entry(PlanetCode.RICH, 3),
            entry(PlanetCode.POOR, 3)
        )
    ),
    TEXTILES(
        "Textiles",
        set(PlanetCode.AGRICULTURAL, PlanetCode.NON_INDUSTRIAL),
        1, 20,
        3000,                     // Cr3000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 7)
        ),
        enum_map(
            entry(PlanetCode.HIGH_POPULATION, 3),
            entry(PlanetCode.NON_AGRICULTURAL, 2)
        )
    ),
    UNCOMMON_ORE(
        "Uncommon Ore",
        set(PlanetCode.ASTEROID, PlanetCode.ICE_CAPPED),
        1, 20,
        5000,                     // Cr5000
        enum_map(
            entry(PlanetCode.ASTEROID, 4)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 3),
            entry(PlanetCode.NON_INDUSTRIAL, 1)
        )
    ),
    UNCOMMON_RAW_MATERIALS(
        "Uncommon Raw Materials",
        set(PlanetCode.AGRICULTURAL, PlanetCode.DESERT, PlanetCode.WATERWORLD),
        1, 10,
        20000,                    // Cr20000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 2),
            entry(PlanetCode.WATERWORLD, 1)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 1)
        )
    ),
    WOOD(
        "Wood",
        set(PlanetCode.AGRICULTURAL, PlanetCode.GARDEN),
        1, 20,
        1000,                     // Cr1000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 6)
        ),
        enum_map(
            entry(PlanetCode.RICH, 2),
            entry(PlanetCode.INDUSTRIAL, 1)
        )
    ),
    VEHICLES(
        "Vehicles",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 10,
        15000,                    // Cr15000
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_TECH, 1)
        ),
        enum_map(
            entry(PlanetCode.NON_INDUSTRIAL, 2),
            entry(PlanetCode.HIGH_POPULATION, 1)
        )
    ),
    ILLEGAL_BIOCHEMICALS(
        "Illegal Biochemicals",
        set(PlanetCode.AGRICULTURAL, PlanetCode.WATERWORLD),
        1, 5,
        50000,                    // Cr50000
        enum_map(
            entry(PlanetCode.WATERWORLD, 2)
        ),
        enum_map(
            entry(PlanetCode.INDUSTRIAL, 6)
        )
    ),
    CYBERNETICS_ILLEGAL(
        "Cybernetics, Illegal",
        set(PlanetCode.HIGH_TECH),
        1, 1,                     // 1D
        250000,                   // Cr250000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 1)
        ),
        enum_map(
            entry(PlanetCode.ASTEROID, 4),
            entry(PlanetCode.ICE_CAPPED, 4),
            entry(PlanetCode.RICH, 8),
            entry(PlanetCode.AMBER_ZONE, 6),
            entry(PlanetCode.RED_ZONE, 6)
        )
    ),
    DRUGS_ILLEGAL(
        "Drugs, Illegal",
        set(PlanetCode.ASTEROID, PlanetCode.DESERT, PlanetCode.HIGH_POPULATION, PlanetCode.WATERWORLD),
        1, 1,                     // 1D
        100000,                   // Cr100000
        enum_map(
            entry(PlanetCode.ASTEROID, 1),
            entry(PlanetCode.DESERT, 1),
            entry(PlanetCode.GARDEN, 1),
            entry(PlanetCode.WATERWORLD, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 6),
            entry(PlanetCode.HIGH_POPULATION, 6)
        )
    ),
    LUXURIES_ILLEGAL(
        "Luxuries, Illegal",
        set(PlanetCode.AGRICULTURAL, PlanetCode.GARDEN, PlanetCode.WATERWORLD),
        1, 1,                     // 1D
        50000,                    // Cr50000
        enum_map(
            entry(PlanetCode.AGRICULTURAL, 2),
            entry(PlanetCode.WATERWORLD, 1)
        ),
        enum_map(
            entry(PlanetCode.RICH, 6),
            entry(PlanetCode.HIGH_POPULATION, 4)
        )
    ),
    WEAPONS_ILLEGAL(
        "Weapons, Illegal",
        set(PlanetCode.INDUSTRIAL, PlanetCode.HIGH_TECH),
        1, 5,
        150000,                   // Cr150000
        enum_map(
            entry(PlanetCode.HIGH_TECH, 2)
        ),
        enum_map(
            entry(PlanetCode.POOR, 6),
            entry(PlanetCode.AMBER_ZONE, 8),
            entry(PlanetCode.RED_ZONE, 10)
        )
    );
    // End ChatGPT code

    /// Name or type of the trade good
    public final String name;

    /// Planet codes on which this trade good can be bought, empty if it can be bought anywhere
    private final Set<PlanetCode> availability;

    /// How many 6-sided dice are rolled to determine how many tons can be bought, result multiplied by tons_multiplier
    private final int tons_dice;
    /// Multiplier to the result of the tons_dice roll on how many tons can be bought
    private final int tons_multiplier;

    /// Price in credits for one ton of the trade good
    public final int base_price;

    /// Planet codes and their modifiers added when purchasing, or subtracted when selling
    private final Map<PlanetCode, Integer> purchase_modifiers;
    /// Planet codes and their modifiers added when selling, or subtracted when purchasing
    private final Map<PlanetCode, Integer> sale_modifiers;

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

    TradeGood(
        String name,
        Set<PlanetCode> availability,
        int tons_dice,
        int tons_multiplier,
        int base_price,
        Map<PlanetCode, Integer> purchase_modifiers,
        Map<PlanetCode, Integer> sale_modifiers
    ) {
        this.name = name;
        this.availability = availability;
        this.tons_dice = tons_dice;
        this.tons_multiplier = tons_multiplier;
        this.base_price = base_price;
        this.purchase_modifiers = purchase_modifiers;
        this.sale_modifiers = sale_modifiers;
    }

    /**
     * Get how many tons a trader can actually buy and transport from a planet. 
     * AKA how many tons can be afforded, are available to buy, and can be stored. 
     * Limited by available credits, storage, and maximum possible supply on a planet.
     * 
     * @param available_credits Credits available to buy goods with
     * @param available_storage Ship storage space available to store goods in
     * @param planet Planet the goods are being bought on
     * @return Amount of tons that can be traded/bought and transported.
     */
    public int get_tradeable_tons(int available_credits, int available_storage, Planet planet) {
        // Get how many tons can be afforded
        int price = get_purchase_price(1, planet);
        int affordable_tons = (int)Math.floor(available_credits / price);

        // Get the smaller of how many tons are available and can be stored
        int maximum_tons = Math.min(get_maximum_available_tons(planet), available_storage);

        return Math.min(affordable_tons, maximum_tons);
    }

    /**
     * Get if this trade good can be bought on a certain planet
     * 
     * @param planet Planet being checked for if this trade good can be bought on it
     * @return If the trade good can be bought on the planet
     */
    public boolean is_available_on(Planet planet) {
        // Empty availability indicates the trade good is always available
        if (availability.isEmpty())
            return true;

        for (PlanetCode planet_code : planet.get_planet_codes()) {
            if (availability.contains(planet_code)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get if this trade good can be bought on a certain planet code
     * 
     * @param planet_code Planet code being checked for if this trade good can be bought on it
     * @return If the trade good can be bought on the planet code
     */
    public boolean is_available_on(PlanetCode planet_code) {
        // Empty availability indicates the trade good is always available
        return availability.isEmpty() || availability.contains(planet_code);
    }

    /**
     * Gets the price to purchase a number of tons of this trade good
     * on a certain planet.
     * 
     * @param tons How many tons to purchase
     * @param planet What planet the trade good is being bought on
     * @return Total price of purchasing the number of tons of this trade good on the planet
     */
    public int get_purchase_price(int tons, Planet planet) {
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
    public int get_sale_price(int tons, Planet planet) {
        return tons * get_base_sale_price(planet);
    }

    /**
     * Get how many tons can be bought with a maximum roll result
     * on a certain planet.
     * 
     * @param planet Planet the trade good is being bought on
     * @return How many tons can be bought on the planet at maximum
     */
    private int get_maximum_available_tons(Planet planet) {
        return get_available_tons(tons_dice * 6, planet);
    }

    /**
     * Get how many tons can be bought with a certain roll on a
     * certain planet.
     * 
     * @param roll Result of the trade dice roll
     * @param planet Planet the trade good is being bought on
     * @return How many tons can be bought with the roll on the planet
     */
    private int get_available_tons(int roll, Planet planet) {
        return get_available_tons(roll + planet.get_goods_amount_modifier());
    }

    /**
     * Get how many tons can be bought with a certain roll with
     * no planet modifiers.
     * 
     * @param roll Result of the trade dice roll
     * @return How many tons can be bought with the roll
     */
    private int get_available_tons(int roll) {
        return roll * tons_multiplier;
    }

    /**
     * Get purchase price per ton on a certain planet, assuming average roll
     * and equal Broker skill between buyer and supplier.
     * 
     * @param planet Planet the trade good is being bought on
     * @return Purchase price on the planet with average roll and default Broker skills
     */
    private int get_base_purchase_price(Planet planet) {
        return get_base_purchase_price(NORMAL_TRADE_ROLL, NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
    }

    /**
     * Get purchase price per ton on a certain planet with a certain trade roll, buyer
     * Broker skill and supplier Broker skill
     * 
     * @param roll Result of the 2D6 trading dice roll
     * @param buyer_skill Broker skill of the buyer
     * @param supplier_skill Broker skill of the supplier
     * @param planet Planet the trade good is being bought on
     * @return Purchase price on the planet with the roll, buyer skill, and supplier skill
     */
    private int get_base_purchase_price(int roll, int buyer_skill, int supplier_skill, Planet planet) {
        int roll_modifier = get_total_purchase_modifier(buyer_skill, supplier_skill, planet);
        float multiplier = get_price_multiplier(roll + roll_modifier, PURCHASE_MULTIPLIERS);
        return (int)Math.round(base_price * multiplier);
    }

    /**
     * Get sale price per ton on a certain planet, assuming average roll
     * and equal Broker skill between supplier and buyer.
     * 
     * @param planet Planet the trade good is being sold on
     * @return Sale price on the planet with average roll and default Broker skills
     */
    private int get_base_sale_price(Planet planet) {
        return get_base_sale_price(NORMAL_TRADE_ROLL, NORMAL_BROKER_SKILL, NORMAL_BROKER_SKILL, planet);
    }

    /**
     * Get sale price per ton on a certain planet with a certain trade roll, supplier
     * Broker skill and buyer Broker skill.
     * 
     * @param roll Result of the 2D6 trading dice roll
     * @param supplier_skill Broker skill of the supplier
     * @param broker_skill Broker skill of the buyer
     * @param planet Planet the trade good is being sold on
     * @return Sale price on the planet with the roll, supplier skill, and buyer skill
     */
    private int get_base_sale_price(int roll, int supplier_skill, int buyer_skill, Planet planet) {
        int roll_modifier = get_total_sale_modifier(supplier_skill, buyer_skill, planet);
        float multiplier = get_price_multiplier(roll + roll_modifier, SALE_MULTIPLIERS);
        return (int)Math.round(base_price * multiplier);
    }

    /**
     * Get roll modifiers for purchasing on a certain planet with a certain buyer skill
     * and supplier skill.
     * 
     * @param buyer_skill Broker skill of the buyer
     * @param supplier_skill Broker skill of the supplier
     * @param planet Planet the trade good is being bought on
     * @return Roll modifiers for buying with buyer skill, supplier skill, and planet
     */
    private int get_total_purchase_modifier(int buyer_skill, int supplier_skill, Planet planet) {
        return buyer_skill - supplier_skill + get_planet_purchase_modifier(planet);
    }

    /**
     * Get roll modifiers for selling on a certain planet with a certain supplier skill
     * and buyer skill.
     * 
     * @param supplier_skill Broker skill of the supplier
     * @param buyer_skill Broker skill of the buyer
     * @param planet Planet the trade good is being sold on
     * @return Roll modifiers for selling with supplier skill, buyer skill, and planet
     */
    private int get_total_sale_modifier(int supplier_skill, int buyer_skill, Planet planet) {
        return supplier_skill - buyer_skill + get_planet_sale_modifier(planet);
    }

    /**
     * Gets the total trade roll modifier for purchasing on a
     * certain planet.
     * 
     * @param planet Planet the trade good is being bought on
     * @return Roll modifier for buying the good on the planet 
     */
    private int get_planet_purchase_modifier(Planet planet) {
        int modifier = 0;

        for (PlanetCode trade_code : planet.get_planet_codes()) {
            modifier += get_purchase_modifier(trade_code);
        }

        return modifier;
    }

    /**
     * Gets the total trade roll modifier for selling on a
     * certain planet.
     * 
     * @param planet Planet the trade good is being sold on
     * @return Roll modifier for selling the good on the planet 
     */
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
    private int get_modifier(PlanetCode planet_code, Map<PlanetCode, Integer> modifier_map) {
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

    // The code below is taken directly from ChatGPT with some edits to conform to my style
    private static Set<PlanetCode> set(PlanetCode... codes) {
        return (codes.length == 0) ? Set.of() : EnumSet.of(codes[0], codes);
    }

    @SafeVarargs
    private static Map<PlanetCode, Integer> enum_map(Map.Entry<PlanetCode, Integer>... entries) {
        EnumMap<PlanetCode, Integer> code_map = new EnumMap<>(PlanetCode.class);
        for (Map.Entry<PlanetCode, Integer> entry : entries) {
            code_map.put(entry.getKey(), entry.getValue());
        }
        return Map.copyOf(code_map);
    }

    // tiny entry() utility to avoid verbose put()s in constants
    private static Map.Entry<PlanetCode, Integer> entry(PlanetCode planet_code, int dice_modifier) {
        return Map.entry(planet_code, dice_modifier); // Java 9+
    }
    // End ChatGPT code

    @Override
    public String toString() {
        return name;
    }
}
