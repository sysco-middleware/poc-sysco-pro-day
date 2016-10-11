package no.sysco.mw.poc;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.net.JksOptions;

/**
 * Created by jeqo on 10/11/16.
 */
public class SyscoProDayVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        final HttpServer httpServer = vertx.createHttpServer(new HttpServerOptions().setSsl(true).setKeyStoreOptions(
                new JksOptions().setPath("server-keystore.jks").setPassword("wibble")
        ));
        httpServer.requestHandler(request -> request.response()
                .end("<h1>Welcome to Sysco MW Professional Day - October 2016</h1>"))
        .listen(4443);
    }
}
