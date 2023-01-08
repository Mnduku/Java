import java.util.Scanner;
public class TicTacToe
{
    public static void main(String [] args)
    {
        Player q;
        Player p;
        if(args.length == 0){
           q = new Realplayer('X');
           p = new Realplayer('O');
        }
        else if(args.length == 1){
            if(args[0].equals("-c") == true){
               q = new Botplayer('X');
               p = new Botplayer('O');
            }
            else{
               System.out.println(args[0]);
               System.out.println("Invalid 1. Usage: java TicTacToe [-c [1|2]]");
               return;
            }
        }
        else if(args.length == 2){
            if(args[0].equals("-c") == false){
               System.out.println("Invalid 2. Usage: java TicTacToe [-c [1|2]]");
               return;
            }
            if(args[1].equals("1") == false && args[1].equals("2") == false){
               System.out.println("Invalid 3. Usage: java TicTacToe [-c [1|2]]");
               return;
            }
            if(args[1].equals("1") == true){
                q = new Botplayer('X');
                p = new Realplayer('O');
                System.out.println("TESTINGGGggg");
               
            }
            else if(args[1].equals("2") == true){
                q = new Realplayer('X');
                p = new Botplayer('O');
                System.out.println("TESTINGGGggg");
            } 
            else{
               System.out.println("Invalid 4. Usage: java TicTacToe [-c [1|2]]");
               return;
            }
        }
        else{
           System.out.println("Invalid 5. Usage: java TicTacToe [-c [1|2]]");
            return;
        }


        //Player q = new Realplayer('X');
      // P layer p = new Botplayer('O');     
        Gboard newgame;
        newgame = new Gboard();
        newgame.printboard();
        boolean gameover = false;
        int turns = 0;
        while(gameover == false){
            q.makemove(newgame.getarray(), newgame.getfarray()); 
            newgame.printboard();
            gameover = newgame.didwin();
            if(gameover == true){
                continue;
            }
            turns++;
            if(turns == 10){
                System.out.println("Game has ended in a draw!");
                break;
            }
            p.makemove(newgame.getarray(), newgame.getfarray());
            newgame.printboard();
            gameover = newgame.didwin();
            if(gameover == true){
                continue;
            }
            turns++;
            if(turns == 10){
                System.out.println("Game has ended in a draw!");
                break;
            }

        }
        System.out.println("Game ended Sucessfully");
        return;
    }
}









