import java.util.Scanner;
public abstract class Player{
    public Player(){
    } 
    public Player(char h){
       xoro = h;
    }
    public abstract void makemove(char[][] a, Struct[] b);
    private boolean first;
    char xoro;

}

