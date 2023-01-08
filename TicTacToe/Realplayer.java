import java.util.Scanner;
public class Realplayer extends Player{
    public Realplayer(){
        super();
    }
    public Realplayer(char x){
        xoro = x;
    }
    public void makemove(char[][]  a, Struct[] b){
       System.out.print("\nChoose a position --> ");
       Scanner inp = new Scanner(System.in);
       int choice = inp.nextInt();
          while(choice < 0 || choice >= 9){
             System.out.print("\nPlease try again and choose a valid position --> ");
             inp = new Scanner(System.in);
             choice = inp.nextInt();
          }
          while(b[choice].getfill() == true){
             System.out.print("\nPlease try again and choose a valid position --> ");
             inp = new Scanner(System.in);
             choice = inp.nextInt();
          }
       b[choice].toggle();
       int y = b[choice].gety();
       int x = b[choice].getx();
        a[y][x] = xoro;
//       b[choice].toggle();
       System.out.println("\nPlayer  has made their move");
       return;
    }
}
