package is.ru.helloworld;

import spark.*;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        staticFileLocation("/public");
        
        

        post(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                Integer a = Integer.valueOf(request.queryParams("a"));
                Integer b = Integer.valueOf(request.queryParams("b"));
                return a + b;
            }
        });

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });
    }
}
