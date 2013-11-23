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

    public static void main(String[] args) {

        final Board ttt = new Board();

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

                ttt.setTicTacToeBoard(ticTacToeBoard);
                ttt.setCurrentPlayer(request.queryParams("current-player"));

                if(!ttt.someoneWinner()) {
                    ttt.changePlayer();

                    String responseHtml = "<form method=\"post\" action=\"/play\" class=\"hidden\" id=\"game-form\">\n"
                            + "<input type=\"hidden\" name=\"current-player\" id=\"current-player\" value=\"" + ttt.getCurrentPlayer() +"\"/>\n"
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
                            + "<td class=\"tile" + (!ticTacToeBoard[0][0].isEmpty() ? " checked" : "" ) + " id=\"x0y0\">"+ (ticTacToeBoard[0][0].isEmpty() ? " " : ticTacToeBoard[0][0]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[1][0].isEmpty() ? " checked" : "" ) +  "\" id=\"x1y0\">"+ (ticTacToeBoard[1][0].isEmpty() ? " " : ticTacToeBoard[1][0]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[2][0].isEmpty() ? " checked" : "" ) +  " \" id=\"x2y0\">"+ (ticTacToeBoard[2][0].isEmpty() ? " " : ticTacToeBoard[2][0]) + "</td>\n"
                            + "</tr>\n"
                            + "<tr>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[0][1].isEmpty() ? " checked" : "" ) +  "\" id=\"x0y1\">"+ (ticTacToeBoard[0][1].isEmpty() ? " " : ticTacToeBoard[0][1]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[1][1].isEmpty() ? " checked" : "" ) +  "\" id=\"x1y1\">"+ (ticTacToeBoard[1][1].isEmpty() ? " " : ticTacToeBoard[1][1]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[2][1].isEmpty() ? " checked" : "" ) +  "\" id=\"x2y1\">"+ (ticTacToeBoard[2][1].isEmpty() ? " " : ticTacToeBoard[2][1]) + "</td>\n"
                            + "</tr>\n"
                            + "<tr>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[0][2].isEmpty() ? " checked" : "" ) + "\" id=\"x0y2\">"+ (ticTacToeBoard[0][2].isEmpty() ? " " : ticTacToeBoard[0][2]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[1][2].isEmpty() ? " checked" : "" ) +  "\" id=\"x1y2\">"+ (ticTacToeBoard[1][2].isEmpty() ? " " : ticTacToeBoard[1][2]) + "</td>\n"
                            + "<td class=\"tile"  + (!ticTacToeBoard[2][2].isEmpty() ? " checked" : "" ) +  "\" id=\"x2y2\">"+ (ticTacToeBoard[2][2].isEmpty() ? " " : ticTacToeBoard[2][2]) + "</td>\n"
                            + "\n"
                            + "</tr>\n"
                            + "</table>\n"
                            + "</div>";

                    return responseHtml;
                }
                return "lol";
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

        get(new Route("/getCurrentPlayer") {
            @Override
            public Object handle(Request request, Response response) {
                return ttt.getCurrentPlayer();
            }
        });

        post(new Route("/newGame") {
            @Override
            public Object handle(Request request, Response response) {
                response.redirect("/");
                return "newGameSet";
            }
        });
    }
}
