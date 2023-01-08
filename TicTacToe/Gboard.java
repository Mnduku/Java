public class Gboard
{
   public Gboard()
   {
      farray = new Struct[9];
      int z = 0;
      while(z<9){
          farray[z] = new Struct();
//          farray[z].toggle();
          z++;
      }
      int a = 0;
      int b = 0;
      int c = 0;
      while( a < width){
         b = 0;
         while( b < length){
            farray[c].changex(b);
            farray[c].changey(a);
            b++;
            c++;
         }
         a++;
      }

      array = new char[length][width];
      int i = 0;
      int j = 0;
      int k = 0;
      while(i < length){
         j = 0;
         while(j < width){
             array[i][j] = ' ';  
             j++;
         }
       i++;
      }
   } 
   public char[][] getarray(){
       return array;
   }
   public Struct[] getfarray(){
       return farray;
   }           
   public void printboard()
   {
      int i = 0;
      int j = 0;
      System.out.println("________");
      while(i < length){
         j = 0;
         while(j < width){
             System.out.print("|");
             System.out.print(array[i][j]);
             j++;
         }
       System.out.print("|");
       System.out.println();
       i++;
       System.out.println("--------");
      }
      System.out.println("\n");


      i = 0; 
      j = 0; 
      int k = 0;
      System.out.println("________");
      while(i < length){
         j = 0;
         while(j < width){
             System.out.print("|");
             System.out.print(k);
             j++;
             k++;
         }
       System.out.print("|");
       System.out.println();
       i++;
       System.out.println("--------");
      }
      System.out.println("\n");

      
   }

   public void add(int r, int c, char choice)
   {
      if((r == 0) || (r == length) || (r == length - 1) || (c == 0) || (c == width - 1) || (c == length)){
          System.out.println("Invalid cell");
          return;
      }
      if((array[r][c] == '|')  || (array[r][c] == '-') || (array[r][c] == '|') || (array[r][c] == '_')){
          System.out.println("Invalid cell");
          return;
      }
      array[r][c] = choice;
      return;
   }

    public boolean didwin(){
       boolean win = false;
       if(array[0][0] == 'X' && array[0][1] == 'X' && array[0][2] == 'X'){
            win = true;
       }
       else if(array[1][0] == 'X' && array[1][1] == 'X' && array[1][2] == 'X'){
            win = true;
       }
       else if(array[2][0] == 'X' && array[2][1] == 'X' && array[2][2] == 'X'){
            win = true;
       }
       else if(array[0][0] == 'X' && array[1][0] == 'X' && array[2][0] == 'X'){
            win = true;
       }
       else if(array[0][1] == 'X' && array[1][1] == 'X' && array[2][1] == 'X'){
            win = true;
       }
       else if(array[0][2] == 'X' && array[1][2] == 'X' && array[2][2] == 'X'){
            win = true;
       }
       else if(array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X'){
            win = true;
       }
       else if(array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X'){
            win = true;
       }
       if(win == true){
           System.out.println("Player X has won the game!!!");
           return true;
       }
       
   
       if(array[0][0] == 'O' && array[0][1] == 'O' && array[0][2] == 'O'){
            win = true;
       }
       else if(array[1][0] == 'O' && array[1][1] == 'O' && array[1][2] == 'O'){
            win = true;
       }
       else if(array[2][0] == 'O' && array[2][1] == 'O' && array[2][2] == 'O'){
            win = true;
       }
       else if(array[0][0] == 'O' && array[1][0] == 'O' && array[2][0] == 'O'){
            win = true;
       }
       else if(array[0][1] == 'O' && array[1][1] == 'O' && array[2][1] == 'O'){
            win = true;
       }
       else if(array[0][2] == 'O' && array[1][2] == 'O' && array[2][2] == 'O'){
            win = true;
       }
       else if(array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O'){
            win = true;
       }
       else if(array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O'){
            win = true;
       }
       if(win == true){
           System.out.println("Player O has won the game!!!");
           return true;
       }
       return false;
   } 
   private int length = 3;
   private int width = 3;
   private char array[][];
   private Struct farray[];
}









