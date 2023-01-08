import java.util.Random;
public class Botplayer extends Player{
    public Botplayer(){
        super();
    }
    public Botplayer(char x){
       xoro = x;
    }
    public void makemove(char[][]  a, Struct[] b){
        if(a[1][1] == ' '){
           a[1][1] = xoro;
           System.out.println("Computer has made it's move!");
           return;
        }
        int i = 0;
        boolean movemade = false;
        Random rand = new Random();
        int maybe;
        while(movemade == false){
           maybe = rand.nextInt(9);
           if(b[maybe].getfill() == true){
               continue;
           }
        int y = b[maybe].gety();
        int x = b[maybe].getx();
        a[y][x] = xoro;
        b[maybe].toggle();
        movemade = true;        
        System.out.println("Automated player has made its move!!");
        }        
        return;
    }
}

