package org.thecarnalest.travellertool;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * {@link Planet} types and features/attributes, but not statistics. Consists of:
 * 
 * - Trade Codes
 * 
 * Descriptors relevant to the planetary economy, such as: geology, atmosphere, ecology,
 * industrial specialisation, water availability, technology level, and population size
 * and wealth.
 * 
 * - Travel Codes
 * 
 * Descriptors relevant to travel to and from this planet, specifically relating to
 * danger or galactic sanctions/protections. Red Zone is forbidden, Amber Zone is an
 * awful idea, and Green Zone is the safe default.
 * 
 * UNIMPLEMENTED: In Traveller, planet codes are automatically generated from the
 * planet's statistics. It is not currently necessary for the program to support this,
 * (they currently only exist for the sake of good practice) but it may be included in
 * the future if the scope of the program expands.
 */
public enum PlanetCode {
    AGRICULTURAL(
        "Agricultural", 
        "Ag",
        none(),
        between(4, 9),
        between(5, 7),
        none(),
        none(),
        none(),
        none()
    ),
    ASTEROID(
        "Asteroid", 
        "As",
        specific(0),
        specific(0),
        specific(0),
        none(),
        none(),
        none(),
        none()
    ),
    BARREN(
        "Barren", 
        "Ba",
        none(),
        none(),
        none(),
        specific(0),
        specific(0),
        specific(0),
        none()
    ),
    DESERT(
        "Desert", 
        "De",
        none(),
        between(2, 9),
        specific(0),
        none(),
        none(),
        none(),
        none()
    ),
    FLUID_OCEANS(
        "Fluid Oceans", 
        "Fl",
        none(),
        above(10),
        above(1),
        none(),
        none(),
        none(),
        none()
    ),
    GARDEN(
        "Garden",
        "Ga",
        between(6, 8),
        specific(5, 6, 8),
        between(5, 7),
        none(),
        none(),
        none(),
        none()
    ),
    HIGH_POPULATION(
        "High Population", 
        "Hi",
        none(),
        none(),
        none(),
        above(9),
        none(),
        none(),
        none()
    ),
    HIGH_TECH(
        "High Tech", 
        "Ht",
        none(),
        none(),
        none(),
        none(),
        none(),
        none(),
        above(12)
    ),
    ICE_CAPPED(
        "Ice-Capped", 
        "Ic",
        none(),
        between(0, 1),
        above(1),
        none(),
        none(),
        none(),
        none()
    ),
    INDUSTRIAL(
        "Industrial", 
        "In",
        none(),
        combine(between(0, 2), specific(4, 7), between(9, 12)),
        none(),
        above(9),
        none(),
        none(),
        none()
    ),
    LOW_POPULATION(
        "Low Population", 
        "Lo",
        none(),
        none(),
        none(),
        between(1, 3),
        none(),
        none(),
        none()
    ),
    LOW_TECH(
        "Low Tech", 
        "Lt",
        none(),
        none(),
        none(),
        above(1),
        none(),
        none(),
        below(5)
    ),
    NON_AGRICULTURAL(
        "Non-Agricultural", 
        "Na",
        none(),
        below(3),
        below(3),
        above(6),
        none(),
        none(),
        none()
    ),
    NON_INDUSTRIAL(
        "Non-Industrial", 
        "Ni",
        none(),
        none(),
        none(),
        between(4, 6),
        none(),
        none(),
        none()
    ),
    POOR(
        "Poor", 
        "Po",
        none(),
        between(2, 5),
        below(3),
        none(),
        none(),
        none(),
        none()
    ),
    RICH(
        "Rich", 
        "Ri",
        none(),
        specific(6, 8),
        none(),
        between(6, 8),
        between(4, 9),
        none(),
        none()
    ),
    VACUUM(
        "Vacuum", 
        "Va",
        none(),
        specific(0),
        none(),
        none(),
        none(),
        none(),
        none()
    ),
    WATERWORLD(
        "Waterworld", 
        "Wa",
        none(),
        combine(between(3, 9), above(13)),
        above(10),
        none(),
        none(),
        none(),
        none()
    ),
    // Red Zones are special and not automatically applied
    RED_ZONE(
        "Red Zone", 
        "R",
        none(),
        none(),
        none(),
        none(),
        none(),
        none(),
        none()
    ),
    AMBER_ZONE(
        "Amber Zone", 
        "A",
        none(),
        above(10),
        none(),
        none(),
        specific(0, 7, 10),
        combine(specific(0), above(9)),
        none()
    ),
    // Inverse of Amber Zone, all places where there would not be an Amber Zone
    GREEN_ZONE(
        "Green Zone", 
        "G",
        all(),
        below(9),
        all(),
        all(),
        specific(1, 2, 3, 4, 5, 6, 8, 9, 11, 12, 13, 14, 15, 16),
        between(1, 8),
        all()
    );

    /// Name of the planet code (eg. "Agricultural")
    private final String name;
    /// Shorthand code of the planet code (eg. "Agricultural" -> "Ag")
    private final String code;
    /// Planet size codes where this planet code is possible
    private final int[] sizes;
    /// Atmosphere codes where this planet code is possible
    private final int[] atmospheres;
    /// Hydrographics percentages where this planet code is possible
    private final int[] hydrographics;
    /// Population codes where this planet code is possible
    private final int[] populations;
    /// Government codes where this planet code is possible
    private final int[] governments;
    /// Law levels where this planet code is possible
    private final int[] law_levels;
    /// Tech levels where this planet code is possible
    private final int[] tech_levels;

    private static final PlanetCode[] TRADE_CODES = new PlanetCode[]{AGRICULTURAL, ASTEROID, BARREN, DESERT, FLUID_OCEANS, GARDEN, HIGH_POPULATION, 
        HIGH_TECH, ICE_CAPPED, INDUSTRIAL, LOW_POPULATION, LOW_TECH, NON_AGRICULTURAL, NON_INDUSTRIAL, POOR, RICH, VACUUM, WATERWORLD};

    private static final PlanetCode[] TRAVEL_CODES = new PlanetCode[]{RED_ZONE, AMBER_ZONE, GREEN_ZONE};

    private static final int MINIMUM_LEVEL = 0;
    private static final int MAXIMUM_LEVEL = 16;

    PlanetCode(String name, String code, int[] sizes, int[] atmospheres, int[] hydrographics, int[] populations, int[] governments, int[] law_levels, int[] tech_levels) {
        this.name = name;
        this.code = code;
        this.sizes = sizes;
        this.atmospheres = atmospheres;
        this.hydrographics = hydrographics;
        this.populations = populations;
        this.governments = governments;
        this.law_levels = law_levels;
        this.tech_levels = tech_levels;
    }

    /// Map of planet code names to planet code enums
    private static final Map<String, PlanetCode> PLANET_CODES_BY_NAME = Arrays.stream(values())
        .collect(Collectors.toUnmodifiableMap(PlanetCode::get_name, planet_code -> planet_code));

    /// Map of planet code shorthand codes to planet code enums
    private static final Map<String, PlanetCode> PLANET_CODES_BY_CODE = Arrays.stream(values())
        .collect(Collectors.toUnmodifiableMap(PlanetCode::get_code, planet_code -> planet_code));

    public String get_name() { return name; }
    
    public String get_code() { return code; }

    /**
     * Gets a PlanetCode enum from its name
     * 
     * @param name Name of the desired planet code
     * @return Matching planet code enum
     */
    public static PlanetCode get_by_name(String name) {
        return PLANET_CODES_BY_NAME.get(name);
    }

    /**
     * Gets a PlanetCode enum from its shorthand code
     * 
     * @param code Shorthand code of the desired planet code
     * @return Matching planet code enum
     */
    public static PlanetCode get_by_code(String code) {
        return PLANET_CODES_BY_CODE.get(code);
    }

    // Methods to get planet codes (trade or travel codes) on a given planet
    public PlanetCode[] get_trade_codes_on_planet(Planet planet) {
        return Arrays.stream(TRADE_CODES)
            .filter(trade_code -> trade_code.is_on_planet(planet))
            .toArray(PlanetCode[]::new);

    }

    public PlanetCode get_travel_code_on_planet(Planet planet) {
        for (PlanetCode travel_code : TRAVEL_CODES) {
            if (travel_code.is_on_planet(planet)) {
                return travel_code;
            }
        }

        return GREEN_ZONE;
    }

    private boolean is_on_planet(Planet planet) {
        return is_in_range(planet.size(), sizes) || is_in_range(planet.atmosphere(), atmospheres) || is_in_range(planet.hydrographics(), hydrographics)
            || is_in_range(planet.population(), populations) || is_in_range(planet.government(), governments) || is_in_range(planet.law_level(), law_levels)
            || is_in_range(planet.tech_level(), tech_levels);
    }

    private static boolean is_in_range(int number, int[] range) {
        for (int found_number : range) {
            if (number == found_number) {
                return true;
            }
        }
        return false;
    }

    // Helpers for defining at what levels a planet code would appear
    private static int[] none() {
        return new int[0];
    }

    private static int[] between(int lower_bound, int upper_bound) {
        int number_of_elements = upper_bound - lower_bound + 1;
        int[] between_array = new int[number_of_elements];
        for (int i = 0; i < number_of_elements; i++) {
            between_array[i] = lower_bound + i;
        }
        return between_array;
    }

    private static int[] below(int below_number) {
        return between(MINIMUM_LEVEL, below_number);
    }

    private static int[] above(int above_number) {
        return between(above_number, MAXIMUM_LEVEL);
    }

    private static int[] all() {
        return between(MINIMUM_LEVEL, MAXIMUM_LEVEL);
    }

    @SafeVarargs
    private static int[] specific(int... numbers) {
        return numbers;
    }

    @SafeVarargs
    private static int[] combine(int[]... numbers) {
        int array_length = 0;
        for (int[] number_array : numbers) {
            array_length += number_array.length;
        }
        int[] combination = new int[array_length];
        int index = 0;
        for (int[] number_array : numbers) {
            System.arraycopy(number_array, 0, combination, index, number_array.length);
            index += number_array.length;
        }
        return combination;
    }

    @Override
    public String toString() {
        return name;
    }
}
