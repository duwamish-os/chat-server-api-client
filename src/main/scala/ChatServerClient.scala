object ChatServerClient {

  import featherbed.circe._
  import io.circe.generic.auto._
  //import shapeless.Coproduct
  import java.net.URL
  import com.twitter.util.Await

  case class Post(userId: Int, id: Int, title: String, body: String)

  case class Comment(postId: Int, id: Int, name: String, email: String, body: String)

  class JSONPlaceholderAPI(baseUrl: URL) {

    private val client = new featherbed.Client(baseUrl)

    object posts {

      private val listRequest = client.get("posts").withHeader("a", "b").accept("application/json")
      private val getRequest = (id: Int) => client.get(s"posts/$id").accept("application/json")

      def list() = listRequest.send[Seq[Post]]()

      def get(id: Int) = getRequest(id).send[Post]()

    }

    object comments {
      private val listRequest = client.get("comments").accept("application/json")
      private val getRequest = (id: Int) => client.get(s"comments/$id").accept("application/json")

      def list() = listRequest.send[Seq[Comment]]()

      def get(id: Int) = getRequest(id).send[Comment]()
    }

  }

  def main(args: Array[String]): Unit = {
    val apiClient = new JSONPlaceholderAPI(new URL("http://jsonplaceholder.typicode.com/"))

    val result = Await.result(apiClient.posts.list())

    println(result)
  }

}
