package cloud.dqn.server;

import io.undertow.io.IoCallback;
import io.undertow.io.Sender;
import io.undertow.server.HttpServerExchange;

import java.io.IOException;

public class MyIoCallback implements IoCallback{
    private String name;

    public MyIoCallback(String name) {
        this.name = name;
    }

    @Override
    public void onComplete(HttpServerExchange exchange, Sender sender) {
        MyLogger.ghettoLog("COMPLETION");
    }

    @Override
    public void onException(HttpServerExchange exchange, Sender sender, IOException exception) {
        MyLogger.ghettoLog("EXCEPTION POST SEND" + exception.toString());
    }
}
