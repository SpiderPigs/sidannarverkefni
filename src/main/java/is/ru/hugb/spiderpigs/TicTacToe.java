package is.ru.hugb.spiderpigs;

import spark.*;

import static spark.Spark.*;

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
        for(int i = 0; i < 3; i++)
            for(int k = 0; k < 3; k++)
                ticTacToeBoard[i][k] = "0";
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean isFull() {
        return true;
    }

    public boolean someoneWinner() {

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
            if( (ticTacToeBoard[0][i] == ticTacToeBoard[1][i]) && (ticTacToeBoard[1][i] == ticTacToeBoard[2][i]) && (ticTacToeBoard[0][i] != "0") )
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

        setPort(Integer.valueOf(System.getenv("PORT")));

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

                String currentPlayer = request.queryParams("current-player");
                if(currentPlayer.equals("X"))
                {
                    currentPlayer = "O";
                }
                else if(currentPlayer.equals("O"))
                {
                    currentPlayer = "X";
                }

                String responseHtml = "<form method=\"post\" action=\"/play\" class=\"hidden\" id=\"game-form\">\n"
                        + "<input type=\"hidden\" name=\"current-player\" id=\"current-player\" value=\"" + currentPlayer +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x0y0\" value=\"" + ticTacToeBoard[0][0] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x1y0\" value=\"" + ticTacToeBoard[1][0] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x2y0\" value=\"" + ticTacToeBoard[2][0] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x0y1\" value=\"" + ticTacToeBoard[0][1] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x1y1\" value=\"" + ticTacToeBoard[1][1] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x2y1\" value=\"" + ticTacToeBoard[2][1] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x0y2\" value=\"" + ticTacToeBoard[0][2] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x1y2\" value=\"" + ticTacToeBoard[1][2] +"\"/>\n"
                        + "<input type=\"hidden\" name=\"x2y2\" value=\"" + ticTacToeBoard[2][2] +"\"/>\n"
                        + "</form>\n"
                        + "<div id=\"game\">\n"
                        + "<table>\n"
                        + "<tr>\n"
                        + "<td class=\"tile\" id=\"x0y0\">"+ (ticTacToeBoard[0][0].isEmpty() ? " " : ticTacToeBoard[0][0]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x1y0\">"+ (ticTacToeBoard[1][0].isEmpty() ? " " : ticTacToeBoard[1][0]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x2y0\">"+ (ticTacToeBoard[2][0].isEmpty() ? " " : ticTacToeBoard[2][0]) + "</td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td class=\"tile\" id=\"x0y1\">"+ (ticTacToeBoard[0][1].isEmpty() ? " " : ticTacToeBoard[0][1]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x1y1\">"+ (ticTacToeBoard[1][1].isEmpty() ? " " : ticTacToeBoard[1][1]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x2y1\">"+ (ticTacToeBoard[2][1].isEmpty() ? " " : ticTacToeBoard[2][1]) + "</td>\n"
                        + "</tr>\n"
                        + "<tr>\n"
                        + "<td class=\"tile\" id=\"x0y2\">"+ (ticTacToeBoard[0][1].isEmpty() ? " " : ticTacToeBoard[0][2]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x1y2\">"+ (ticTacToeBoard[1][1].isEmpty() ? " " : ticTacToeBoard[1][2]) + "</td>\n"
                        + "<td class=\"tile\" id=\"x2y2\">"+ (ticTacToeBoard[2][1].isEmpty() ? " " : ticTacToeBoard[2][2]) + "</td>\n"
                        + "\n"
                        + "</tr>\n"
                        + "</table>\n"
                        + "</div>";

                return responseHtml;
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
