package cloud.dqn.server

import io.undertow.Undertow
import io.undertow.util.Headers

object Main {
    @JvmStatic fun main(args: Array<String>) {
        println("Running undertow webserver")
        val server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler { exchange ->
                    exchange.responseHeaders.put(Headers.CONTENT_TYPE, "text/plain")
                    exchange.responseSender.send("Hello World Again")
                }.build()
        server.start()
    }
}