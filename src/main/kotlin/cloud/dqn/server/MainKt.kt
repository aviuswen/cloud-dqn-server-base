package cloud.dqn.server

object MainKt {
    @JvmStatic fun main(args: Array<String>) {
        val undertowServer = UndertowServer(args)
        undertowServer.server.start()
    }
}