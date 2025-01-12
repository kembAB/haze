package org.fungover.haze;

import java.util.HashMap;
import java.util.Map;

public class Initialize {

    private static final Map<String, String> cliOptions = new HashMap<>();


    public void importCliOptions(String[] args) {

        for (int i = 0; i < args.length; i++) {
            if (i + 1 == args.length)
                break;
            cliOptions.put(args[i], args[i + 1]);
        }
    }

    public int getPort() {

        if (cliOptions.containsKey("-p")) {
            return Integer.parseInt(cliOptions.get("-p"));
        } else if (cliOptions.containsKey("--port")) {
            return Integer.parseInt(cliOptions.get("--port"));
        } else if ((System.getenv("HAZE_PORT") != null)) {
            return Integer.parseInt(System.getenv("HAZE_PORT"));
        } else return 6379;
    }

    public void clearCliOptions() {
        cliOptions.clear();
    }

}
