package cloud.dqn.server.pippo;

import ro.pippo.core.Application;
import ro.pippo.core.RequestResponseFactory;
import ro.pippo.core.gzip.GZipRequestResponseFactory;

// http://www.pippo.ro/doc/getting-started.html
public class BaseApplication extends Application {

    @Override
    protected RequestResponseFactory createRequestResponseFactory()
    {
        return new GZipRequestResponseFactory(this);
    }

    @Override
    protected void onInit() {
        GET("/hello-world", routeContext -> {
            char[] s = new char[3];

            routeContext.send("Hello World from Pippo Base Application");
        });

    }
}
