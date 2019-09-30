package core;

import java.util.UUID;

public class DataHelper {

    public static String getGeneratedName() {
        return UUID.randomUUID().toString();
    }
}
