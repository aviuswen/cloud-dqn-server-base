package cloud.dqn.server;

import io.undertow.Undertow;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import org.apache.commons.cli.*;



public class UndertowServer {
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAULT_PORT = 9999;
    private static final String NAME = "'My' Hello World Java Undertow Server";

    Undertow server;

    public UndertowServer(String[] args) {
        Options options = new Options();

        Option portOpt = new Option("p", "port", true, "http port listener");
        portOpt.setRequired(false); // default is already false?
        options.addOption(portOpt);

        Option hostOpt = new Option("h", "host", true, "host is listening on");
        hostOpt.setRequired(false);
        options.addOption(hostOpt);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            MyLogger.ghettoLog(NAME, e.getMessage(), options);
            System.exit(1);
            return;
        }

        int port = DEFAULT_PORT;
        // todo check valid port ranges
        String portArgs = cmd.getOptionValue("p");
        if (portArgs != null) {
            try {
                port = Integer.parseUnsignedInt(portArgs);
            } catch (NumberFormatException n) {
                MyLogger.ghettoLog(NAME, "Invalid port option", options);
            }
        }

        String host = DEFAULT_HOST;
        String hostArgs = cmd.getOptionValue("h");
        if (hostArgs != null) {
            host = hostArgs;
        }

        MyIoCallback callback = new MyIoCallback(NAME);

        this.server = Undertow.builder()
                .addHttpListener(port, host)
                .setHandler( (HttpServerExchange exchange) -> {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Hello Again from Java\n");
                    sb.append("Query String: ");
                    sb.append(exchange.getQueryString());
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send(sb.toString(), callback);
                }).build();
    }
}
