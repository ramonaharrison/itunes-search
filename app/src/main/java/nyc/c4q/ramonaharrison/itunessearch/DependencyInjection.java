package nyc.c4q.ramonaharrison.itunessearch;

/**
 * Created by Ramona Harrison
 * on 12/5/15.
 */

public class DependencyInjection {
    public static void main(String[] args) {

        // 3 ways to inject dependencies:

        // constructor injection
        TwitterApi api = new TwitterApi(new HttpClient() {});

        // field injection
        api.client = new HttpClient() {};

        // method injection
        api.setClient(new HttpClient() {});
    }
}

interface HttpClient {

}

class TwitterApi {
    HttpClient client;

    public TwitterApi(HttpClient client) {
        this.client = client;
    }

    void post() {
        //client.post(/* fetch data */);
    }

    void setClient(HttpClient client) {
        this.client = client;
    }
}

// factory method
// reflection
// model or value object

