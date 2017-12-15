package cloud.dqn.server;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

public class MyLogger {
    static void ghettoLog(String name, String error, Options options) {
        HelpFormatter formatter = new HelpFormatter();
        System.out.println(error);
        formatter.printHelp(name, options);
    }
    static void ghettoLog(String message) {
        System.out.println(message);
    }
}
