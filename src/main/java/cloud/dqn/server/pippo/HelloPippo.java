package cloud.dqn.server.pippo;

import ro.pippo.core.Pippo;

/**
 * TRYING DIFFERENT CODING CONVENTION
 * Hello World example for running super simple pippo Server
 */
public class HelloPippo {
    private Pippo pippo;

    public HelloPippo(int port)
    {
        this.pippo = new Pippo();
        // todo port checking
        pippo.getServer().setPort(port);
        pippo.GET("/", routeContext ->
                routeContext.send("Hello World From Pippo Wrapper!")
        );
    }
    public void startServer()
    {
        pippo.start();
    }
}
