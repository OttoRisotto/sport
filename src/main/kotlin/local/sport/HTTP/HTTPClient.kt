package local.sport.HTTP

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(){
    val client: myHttpClient = myHttpClient()
    client.get();
}


class myHttpClient() {
    private val client = HttpClient.newBuilder().build()
    private val req = myRequest();

    fun get(url:String="http://localhost:8080/"){
        val response = this.client.send(this.req.get(), HttpResponse.BodyHandlers.ofString())
        println("Response: ${response}")
        println("Body: ${response.body()}")
    }
}

private class myRequest(){
    val request = HttpRequest.newBuilder()

    fun get(urlParam:String = "http://localhost:8080/"): HttpRequest{
        val url= URI.create( urlParam )
        return request.GET().uri(url).build()
    }
}
