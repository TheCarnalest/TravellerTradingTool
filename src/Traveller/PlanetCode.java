package Traveller;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum PlanetCode {
    // Enums copied directly from ChatGPT 5 Thinking using the Traveller core rulebook
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

    private final String name;
    private final String code;

    PlanetCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String get_name() { return name; }
    public String get_code() { return code; }

    private static final Map<String, PlanetCode> CODES_BY_NAME = Arrays.stream(values())
        .collect(Collectors.toUnmodifiableMap(PlanetCode::name, planet_code -> planet_code));

    public static PlanetCode get_code(String name) {
        return CODES_BY_NAME.get(name);
    }
}
