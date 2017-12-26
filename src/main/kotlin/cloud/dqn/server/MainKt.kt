package cloud.dqn.server

import cloud.dqn.server.pippo.BaseApplication
import ro.pippo.core.Pippo

object MainKt {
    @JvmStatic fun main(args: Array<String>) {
        // val undertowServer = UndertowServer(args)
        // undertowServer.server.start()

        // val pippo = cloud.dqn.server.pippo.HelloPippo(9999)
        // pippo.startServer()

        val pippo = Pippo(BaseApplication())
        pippo.server.settings.host("127.0.0.1").port(9999)
        pippo.start()

    }
}