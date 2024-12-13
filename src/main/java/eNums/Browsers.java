package eNums;

import java.util.Arrays;
import java.util.Objects;

public enum Browsers {
    CHROME("CHROME"),
   EDGE("EDGE"),
    FIREFOX("FIREFOX");

    public final String label;

    private Browsers(String label) {
        this.label = label;
    }
    public static Browsers valueOfBrowsers(String label) {
            return Arrays.stream(values())
                    .filter(e-> Objects.equals(e.label, label))
                    .findFirst()
                    .orElseThrow();

    }
}