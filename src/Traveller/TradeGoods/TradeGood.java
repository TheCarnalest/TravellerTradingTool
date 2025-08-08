package Traveller.TradeGoods;

import Traveller.PlanetCodes.PlanetCode;
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

    /// Planet codes corresponding to modifiers on the purchase roll granted when the good is bought on those planet types, 
    /// and reversed modifiers granted when the good is sold on those planet types.
    HashMap<PlanetCode, Integer> purchase_modifiers;
    /// Planet codes corresponding to modifiers on the sale roll granted when the good is sold on those planet types, 
    /// and reversed modifiers granted when the good is purchased on those planet types.
    HashMap<PlanetCode, Integer> sale_modifiers;

    int get_planet_purchase_modifiers(Planet buying_planet) {

    }

    int get_code_purchase_modifier(PlanetCode planet_code) {
        int modifier;

        int purchase_modifier = purchase_modifiers.get(planet_code);
        if (purchase_modifier isnull) {
            modifier += purchase_modifier;
        }

        return modifier;
    }
}
