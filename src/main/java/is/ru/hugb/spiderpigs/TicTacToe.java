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

    String[][] ticTacToeBoard = new String[3][3];

    public TicTacToe(){
        for(String v : ticTacToeBoard)
        {
            v = "0";
        }
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isFull() {
        return true;
    }

    public boolean someoneWinner() {
        String[][] ticTacToeBoard = ticTacToeBoard;

        // Vertical
        for(int i = 0; i < 3; i++)
        {
            if( (ticTacToeBoard[i][0] == ticTacToeBoard[i][1]) && (ticTacToeBoard[i][1] == ticTacToeBoard[i][2]) && (ticTacToeBoard[i][0] != "0") )
            {
                return true;
            }
        }

        // Horizontal
        for(int i = 0; i < 3; i++)
        {
            if( (ticTacToeBoard[0][i] == ticTacToeBoard[1][i]) && (ticTacToeBoard[1][i] == ticTacToeBoard[2][i]) && (ticTacToeBoard[i][0] != "0") )
            {
                return true;
            }
        }

        // Diagonal - Down
        if( (ticTacToeBoard[0][0] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][2]) && (ticTacToeBoard[0][0] != "0") )
            return true;

        // Diagonal - Up
        if( (ticTacToeBoard[0][2] == ticTacToeBoard[1][1]) && (ticTacToeBoard[1][1] == ticTacToeBoard[2][0]) && (ticTacToeBoard[0][2] != "0") )
            return true;

        return false;
    }


    public static void main(String[] args) {
        staticFileLocation("/public");



        post(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                Integer a = Integer.valueOf(request.queryParams("a"));
                Integer b = Integer.valueOf(request.queryParams("b"));
                String O = String.valueOf(request.queryParams("x0y0"));
                return O;
            }
        });

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });

        get(new Route("/isWinner") {
            @Override
             public Object handle(Request request, Response response) {
                return "Hello";
             }
        });
    }
}
