import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Prompt {
    public static <T> T promptValidatedValue(
            Scanner in,
            String prompt,
            Function<String, T> parser,
            Predicate<T> validator,
            String msg) {

        while (true) {
            System.out.print(prompt);
            String line = in.nextLine();
            if (line.trim().isEmpty()) {
                System.out.println(msg);
                continue;
            }
            try {
                T value = parser.apply(line.trim());
                if (validator == null || validator.test(value)) {
                    return value;
                } else {
                    System.out.println(msg);
                }
            } catch (Exception e) {
                System.out.println(msg);
            }
        }
    }

    public static boolean promptQuit(Scanner in) {
        System.out.print("Çıkış için 'q' yazın, yeni değerlerle devam etmek için Enter'a basın: ");
        String cmd = in.nextLine();
        if (cmd == null)
            return false;
        cmd = cmd.trim();
        return cmd.equalsIgnoreCase("q") || cmd.equalsIgnoreCase("exit");
    }
}
