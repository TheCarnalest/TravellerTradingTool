import Traveller.PlanetCode;
import Traveller.Planets.Planet;
import java.util.Arrays;
import java.util.Scanner;

public class TravellerTradingTool {
    public static void main(String[] args) {
        Planet buying_planet;
        Planet selling_planet;
        try (Scanner scanner = new Scanner(System.in)) {
            // Gather preliminary data about the Traveller
            System.out.println("How many credits do you have available?");
            double available_credits = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("How many tons of storage do you have available?");
            int available_storage = scanner.nextInt();
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
        }
    }
}
