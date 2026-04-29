package local.sport.HTTP

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(){
    val client = myHttpClient()

    val localhost = "http://localhost:8080/events"
    val url = "http://www.example.com/"

    client.get(localhost);

}

class myHttpClient() {
    private val client = HttpClient.newBuilder().build()
    private val req = myHttpRequest();

    fun get(url:String){
        println("\nGet-Anfrage an $url startet\n")
        val response = this.client.send(this.req.get(url), HttpResponse.BodyHandlers.ofString())
        println("Response: ${response}")
        println("Response-Body:\n${response.body()}")
    }
}

private class myHttpRequest{
    //erstellt nur die Requests

    fun get(urlParam:String): HttpRequest{
        val url= URI.create( urlParam )
        return HttpRequest.newBuilder()
            .uri(url)
            .GET()
            .build()
    }

    /* fun post(urlParam: String, list: ArrayList<Any>): HttpRequest{
        val url = URI.create( urlParam )
        val body
        return request.POST().uri(url).build()
    }*/
}
