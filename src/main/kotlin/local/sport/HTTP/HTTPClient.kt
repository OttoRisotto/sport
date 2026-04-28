package local.sport.HTTP

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main(){
    val client: myHttpClient = myHttpClient()

    val localhost: String = "http://localhost:8080/"
    val url: String = "http://www.example.com/"

    client.get(localhost);

}

class myHttpClient() {
    private val client = HttpClient.newBuilder().build()
    private val req = myRequest();

    fun get(url:String){
        println("\nGet-Anfrage an $url startet\n")
        val response = this.client.send(this.req.get(url), HttpResponse.BodyHandlers.ofString())
        println("Response: ${response}")
        println("Response-Body: ${response.body()}")
    }
}

private class myRequest(){
    val request = HttpRequest.newBuilder()

    fun get(urlParam:String): HttpRequest{
        val url= URI.create( urlParam )
        return request.GET().uri(url).build()
    }
}
