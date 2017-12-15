package cloud.dqn.server

import io.undertow.Undertow
import io.undertow.util.Headers

object UndertowServerKt {
    val server = Undertow.builder()
            .addHttpListener(9999, "0.0.0.0")
            .setHandler { exchange ->
                exchange.responseHeaders.put(Headers.CONTENT_TYPE, "text/plain")
                exchange.responseSender.send("Hello World Again")
            }.build()
    // to start server
    // server.start()
}