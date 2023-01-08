public class Struct{
    Struct(){
       x = 0;
       y = 0;
       filled = false;
    }
    private int x;
    private int y;
    private boolean filled;
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void toggle(){
        filled = true;
    }
    public boolean getfill(){
        return filled;
    }
    public void changex(int a){
       x = a;
    }
    public void changey(int b){
       y = b;
    }
}

