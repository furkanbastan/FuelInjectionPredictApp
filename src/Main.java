import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------");
        System.out.println("Fuel Injection Predict App");
        System.out.println(
                "Bu uygulama vites ve gaz pedalı değerlerine göre tahmin edilen yakıt miktarını hesaplar.");
        System.out.println("--------------------------------");

        Scanner in = new Scanner(System.in);

        String fclFilePathCOA = "resources/model_coa.fcl";
        String fclFilePathCOG = "resources/model_cog.fcl";

        FuelModel modelCOA = new FuelModel(fclFilePathCOA);
        FuelModel modelCOG = new FuelModel(fclFilePathCOG);

        while (true) {
            int gear = Prompt.promptValidatedValue(in, "Vites seçiniz(1-6): ",
                    Integer::parseInt, v -> v >= 1 && v <= 6,
                    "Geçersiz vites! 1 ile 6 arasında bir sayı girin.");

            double throttle = Prompt.promptValidatedValue(in, "Gaz Pedalı(0-100): ",
                    Double::parseDouble,
                    v -> v >= 0.0 && v <= 100.0,
                    "Geçersiz gaz pedalı değeri! 0.0 ile 100.0 arasında bir sayı girin.");

            double fuelCOG = modelCOG.Predict(gear, throttle);
            double fuelCOA = modelCOA.Predict(gear, throttle);

            System.out.println("--------------------------------");
            System.out.println("Sonuçlar:");
            System.out.println("Seçilen Vites: " + gear);
            System.out.println("Seçilen Gaz Pedalı: " + throttle);
            System.out.println("Tahmin Edilen Yakıt Miktarı (COG): " + String.format("%.2f", fuelCOG) + " ml");
            System.out.println("Tahmin Edilen Yakıt Miktarı (COA): " + String.format("%.2f", fuelCOA) + " ml");
            System.out.println("--------------------------------");

            modelCOA.Plot();
            modelCOG.Plot();

            if (Prompt.promptQuit(in)) {
                System.out.println("Uygulamadan çıkılıyor...");
                break;
            }
        }
    }
}