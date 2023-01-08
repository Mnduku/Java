
import java.util.Random;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.Random;

public class Guess extends JFrame implements ActionListener{

   Guess() {
   }

   private static int guess = 0;
   private static JTextField text;
   private static JButton button;
   private static JFrame frame;
   private static JLabel label;
   private static JPanel panel;
   private static JPanel panel3;
   private static JLabel label2;
   private static JLabel label3;
   private static int x = 1;
   private static int number;
   private static int difference = 999;

   public static void main(String [] args){
      Guess newgame = new Guess();
      newgame.gameready();
   }



   static void gameready(){
     guess = 0;
     System.out.println("Running guess game....");
     Random random = new Random();
     number = random.nextInt(1000);
     System.out.println("Random number is: " + number);
      frame = new JFrame("Guess the Number");
      label = new JLabel();
      label2 = new JLabel();
      button = new JButton();
      button.setBackground(Color.BLACK);
      button.setForeground(Color.RED);
      text = new JTextField(7);
      label2.setText("Please enter a guess ");
      label.setText(" I have a number between 1 and 1000. Can you guess my number?");
      panel = new JPanel();
      label3 = new JLabel();
      label3.setText("Good Luck !!");

      Guess guess = new Guess();
      button.addActionListener(guess);

      panel.add(label);
      panel.add(label2);
      panel.add(text);
      panel.add(button);
      panel.add(label3);
      frame.add(panel);


      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      frame.setSize(500, 200);
      frame.setVisible( true );
   }


   public void actionPerformed(ActionEvent e){
      String input = text.getText();
      int a = Integer.parseInt(input);
      guess++;

      if(a == number) {
         panel.removeAll();
         panel.setBackground(Color.GREEN);
         JLabel end = new JLabel();
         end.setText("You guessed the correct number in " + guess + " guesses! \nPlay again?!");
         panel.add(end);
         JButton button2 = new JButton();
          button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible( false );
                gameready();
            }
        });
         panel.add(button2);
         frame.setSize(500,200);
         frame.setLayout(null);
         frame.setVisible(true);
         return;

      }
      int b;
      b = number - a;
      if(b < 0){
         b = b * -1;
      }
      else{}

      if(b > difference){
         difference = b;
         panel.setBackground(Color.BLUE);
         label3.setText("Getting Colder !");
      }
      else if(b < difference){
         difference = b;
         panel.setBackground(Color.RED);
         label3.setText("Getting Warmer !"); 
      }
      else if(b == difference){
          panel.setBackground(Color.WHITE);
         label3.setText("Neither warmer or colder!");
      }
   }

};


