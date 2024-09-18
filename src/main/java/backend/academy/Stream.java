package backend.academy;

import java.io.PrintStream;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Stream {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final PrintStream OUT = System.out;
}
