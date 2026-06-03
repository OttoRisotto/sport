package local.sport.xHTTP

import com.sun.net.httpserver.HttpExchange
import com.sun.net.httpserver.HttpHandler
import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main(){
    val server = HttpServer.create(InetSocketAddress("127.0.0.1", 8080), 0)
    val h1 = myHandler()
    server.createContext("/", h1)
    server.start()
}

class myHandler: HttpHandler{
    override fun handle(exchange: HttpExchange?) {
        val payload = "this is se payload"
        exchange?.sendResponseHeaders(200, payload.length.toLong())
        val output = exchange?.responseBody
        output?.write(payload.toByteArray())
        output?.close()
    }
}
