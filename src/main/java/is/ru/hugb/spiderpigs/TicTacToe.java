package is.ru.hugb.spiderpigs;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

/**
 * Created with IntelliJ IDEA.
 * User: Grimur
 * Date: 22.11.2013
 * Time: 12:11
 * To change this template use File | Settings | File Templates.
 */
public class TicTacToe {
    public static void main(String[] args) {
        staticFileLocation("/public");



        post(new Route("/play") {
            @Override
            public Object handle(Request request, Response response) {
                // Create array that looks like game board
                // We then get the board from the request and put it
                // into the array.
                String[][] ticTacToeBoard = new String[3][3];
                ticTacToeBoard[0][0] = request.queryParams("x0y0");
                ticTacToeBoard[1][0] = request.queryParams("x1y0");
                ticTacToeBoard[2][0] = request.queryParams("x2y0");
                ticTacToeBoard[0][1] = request.queryParams("x0y1");
                ticTacToeBoard[1][1] = request.queryParams("x1y1");
                ticTacToeBoard[2][1] = request.queryParams("x2y1");
                ticTacToeBoard[0][2] = request.queryParams("x0y2");
                ticTacToeBoard[1][2] = request.queryParams("x1y2");
                ticTacToeBoard[2][2] = request.queryParams("x2y2");


                return null;
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
