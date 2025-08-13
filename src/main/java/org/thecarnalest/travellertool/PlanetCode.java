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
    // Enums copied directly from ChatGPT using the Traveller core rulebook
    AGRICULTURAL("Agricultural", "Ag"),
    ASTEROID("Asteroid", "As"),
    BARREN("Barren", "Ba"),
    DESERT("Desert", "De"),
    FLUID_OCEANS("Fluid Oceans", "Fl"),
    GARDEN("Garden", "Ga"),
    HIGH_POPULATION("High Population", "Hi"),
    HIGH_TECH("High Tech", "Ht"),
    ICE_CAPPED("Ice-Capped", "Ic"),
    INDUSTRIAL("Industrial", "In"),
    LOW_POPULATION("Low Population", "Lo"),
    LOW_TECH("Low Tech", "Lt"),
    NON_AGRICULTURAL("Non-Agricultural", "Na"),
    NON_INDUSTRIAL("Non-Industrial", "Ni"),
    POOR("Poor", "Po"),
    RICH("Rich", "Ri"),
    VACUUM("Vacuum", "Va"),
    WATERWORLD("Waterworld", "Wa"),
    RED_ZONE("Red Zone", "R"),
    AMBER_ZONE("Amber Zone", "A"),
    GREEN_ZONE("Green Zone", "G");
    // End ChatGPT code

    /// Name of the planet code (eg. "Agricultural")
    private final String name;
    /// Shorthand code of the planet code (eg. "Agricultural" -> "Ag")
    private final String code;

    PlanetCode(String name, String code) {
        this.name = name;
        this.code = code;
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

    @Override
    public String toString() {
        return name;
    }
}
