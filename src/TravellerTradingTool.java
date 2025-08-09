import Traveller.Planet;
import Traveller.PlanetCode;
import Traveller.TradeGood;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TravellerTradingTool {
    public static void main(String[] args) {
        int available_credits;
        int available_storage;

        Planet buying_planet;
        Planet selling_planet;
        try (Scanner scanner = new Scanner(System.in)) {
            // Gather preliminary data about the Traveller
            System.out.println("How many credits do you have available?");
            available_credits = scanner.nextInt();
            scanner.nextLine();

            System.out.println("How many tons of storage do you have available?");
            available_storage = scanner.nextInt();
            scanner.nextLine();

            // Gather data about the planet the goods are being bought on
            System.out.println("What's the name of the planet you're buying goods on?");
            String buying_planet_name = scanner.nextLine();

            System.out.println("What is its population?");
            int buying_planet_population = scanner.nextInt();
            scanner.nextLine();

            System.out.println("What are its trade codes, separated by commas?");
            PlanetCode[] buying_planet_trade_codes = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(PlanetCode::get_code)
                .toArray(PlanetCode[]::new);

            System.out.println("What is its travel code?");
            PlanetCode buying_planet_travel_code = PlanetCode.get_code(scanner.nextLine());

            buying_planet = new Planet(buying_planet_name, buying_planet_population, buying_planet_trade_codes, buying_planet_travel_code);

            // Gather data about the planet the goods are being sold on
            System.out.println("What's the name of the planet you're selling goods on?");
            String selling_planet_name = scanner.nextLine();

            System.out.println("What are its trade codes, separated by commas?");
            PlanetCode[] selling_planet_trade_codes = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(PlanetCode::get_code)
                .toArray(PlanetCode[]::new);

            System.out.println("What is its travel code?");
            PlanetCode selling_planet_travel_code = PlanetCode.get_code(scanner.nextLine());

            selling_planet = new Planet(selling_planet_name, selling_planet_trade_codes, selling_planet_travel_code);
        }
        
        // Create a list of trade goods that can be bought
        ArrayList<TradeGood> available_trade_goods = new ArrayList<>();
        for (TradeGood checking_good : TradeGood.values()) {
            if (checking_good.is_available_on(buying_planet)) {
                available_trade_goods.add(checking_good);
            }
        }

        // CALCULATE PROFIT GAINED FROM TRADING
        for (TradeGood trade_good : available_trade_goods) {
            // Get amount of tons bought, skipping trade goods not bought at all
            int bought_tons = trade_good.get_buyable_tons(available_credits, available_storage, buying_planet);
            if (bought_tons <= 0) {
                continue;
            }

            int buying_price = (int)Math.floor(trade_good.get_purchase_price(bought_tons, buying_planet));
            int selling_price = (int)Math.floor(trade_good.get_sale_price(bought_tons, selling_planet));
            System.out.printf(
                "%d tons of %s will cost %d on %s and sell for %d on %s, creating %d of net profit.\n", 
                bought_tons, trade_good.name, buying_price, buying_planet.name, selling_price, selling_planet.name, selling_price - buying_price
            );
        }
    }
}
