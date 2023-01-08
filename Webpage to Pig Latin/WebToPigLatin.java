import java.util.ArrayList;
import java.lang.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
//import java.io.StringBuilder; 
class WebToPigLatin{
    public static void main ( String[] args)
    {
       if(args.length != 2){
          System.out.println("Usage: java WebToPigLatin inputFile outputFile");
          System.out.println("Must have two command-line parameters");
          return;
       }
       FileReader read;
       try{
          read = new FileReader(args[0]);
       }
       catch(Exception e){
          System.out.println("File to be read could not be found");
          return;
       }
       FileWriter write;
       try{
          write = new FileWriter(args[1]);
       }
       catch(Exception e){
           System.out.println("File to be written could not be found");
           return;
        }
        String add1 = "way";
        String add2 = "ay";
        ArrayList<Character> buffer = new ArrayList<Character>();
        int bufferi = 0;
        StringBuilder word = new StringBuilder();
        BufferedReader br = new BufferedReader(read);
        int c = 0;

 //====================================================== 
        try
        { 
        while((c = br.read()) != -1){
           word = new StringBuilder();   
           char readchar = (char) c;



           if(isVowel(readchar) == true){
              boolean upper = false;
              if(Character.isUpperCase(readchar) == true){
                 upper = true;
                 readchar = Character.toLowerCase(readchar);
              }
            
             
            //  while(isPunc(readchar) == false && isNum(readchar) == false && isHtml(readchar) == false){
                 while(isNum(readchar) == false && readchar != ' ' && readchar != '&'  && readchar != '>' && readchar != '<' && readchar != ')' && readchar
              != '(' && readchar != '"' && readchar != '?' && readchar != '!' && readchar != '\n' && readchar != '.' && readchar != ','){
  

                 word.append(readchar);
                 try
                 {
                    int d = br.read();                                                                       //TRANSLATION IF FIRST LETTER IS VOWEL
                    readchar = (char) d;
                 }
                 catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read next char(1)");
                 }  
              }  
              word.append(add1);

              String print;
              if(upper == true){
                  print = word.substring(0,1).toUpperCase() + word.substring(1);
                  try{write.write(print, 0,print.length());
                     write.flush();}
                  catch(IOException ex){
                       System.out.println (ex.toString());
                       System.out.println("Could not read next char(2)");
                  }
               
              }
              else{
                 print = word.toString();
                 try{write.write(print, 0 , print.length());
                     write.flush();}
                 catch(IOException ex){
                       System.out.println (ex.toString());
                       System.out.println("Could not read next char(2)");
                 } 
              }

            if(upper == true){
              System.out.println("writing: " + print); // TESTTTTT
            }
            else if(upper == false){
              System.out.println("writing: " + word.toString()); // TESTTTTT
            }
           }
  
//==========================================================

           if(isVowel(readchar) ==  false && isNum(readchar) == false && readchar != ' ' && readchar != '&'  && readchar != '>' && readchar != '<' && readchar != ')' && readchar
              != '(' && readchar != '"' && readchar != '?' && readchar != '!' && readchar != '\n' && readchar != '.' && readchar != ','){
               boolean upper = false;
               if(Character.isUpperCase(readchar) == true){
                 upper = true;
                 readchar = Character.toLowerCase(readchar);
              }
             while(isVowel(readchar) != true &&  readchar != ' ' && readchar != '&' && readchar != '>' && readchar != '<' && readchar != ')' && readchar
              != '(' && readchar != '"' && readchar != '?' && readchar != '!' && readchar != '\n' && readchar != '.' && readchar != ','){
                 buffer.add(readchar);
                 bufferi++;
                 try{int d = br.read();
                    readchar = (char) d;
                 }
                 catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read next char(3)");
                 }
              }
              while(readchar != ' ' && readchar != '.' && readchar != 'y' && readchar != '?' && readchar != '!'
              && readchar != ',' && readchar != '\n'){
                 word.append(readchar);
                 try{int d = br.read();
                 readchar = (char) d;}
                 catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read next char(4)");
                 }
              }
              for(int j = 0; j < buffer.size(); j++){
                 word.append(buffer.get(j));
              }
              
              buffer.clear();
              word.append(add2);
              String print;

            if(upper == true){
                  print = word.substring(0,1).toUpperCase() + word.substring(1,word.length());
                  try{write.write(print, 0, print.length());
                     write.flush();}
                  catch(IOException ex){
                       System.out.println (ex.toString());
                       System.out.println("Could not read next char(2)");
                  }

              }
              else{
                 print = word.toString();
                 try{write.write(print, 0 , print.length());
                     write.flush();}
                 catch(IOException ex){
                       System.out.println (ex.toString());
                       System.out.println("Could not read next char(2)");
                 }
              }
            if(upper == true){
              System.out.println("writing: " + print); // TESTTTTT
            }
            else if(upper == false){
              System.out.println("writing: " + word.toString()); // TESTTTTT
            }

           }
           
//========================================================================           

           if( isNum(readchar) == true || readchar == '!' ||readchar ==  '.' ||readchar ==  ',' ||
              readchar ==  '(' ||readchar ==  ')'                                //IF THE READ CHAR IS PUNCTUATION
              ||readchar ==  '#' ||readchar ==  '?' ||
              readchar ==  ':' ||readchar ==  ';' ||readchar ==  '"' ||
              readchar ==  '+' ||readchar == 
              '=' || readchar == ' '  || readchar == '\n'){
                  try{
                     String print = Character.toString(readchar);
                     write.write(print,0,print.length());
                     write.flush();
                     if(readchar == '\n')
                        System.out.println("PRINT NEWLINE HERE");
                    
                     System.out.println("writing: " + readchar);
                  }
                  catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not write next char(3)");
                 } 
              }
                 
              else if(readchar == '&'){
                 while(readchar != ';'){                    //IF THERE IS AN AMPERSAND
                    try{
                    String print = Character.toString(readchar);
                    write.write(print,0,print.length());
                    write.flush();
                    int d = br.read();
                    readchar = (char) d;
                    }
                    catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read or write next char (5)");
                    }
                 }
              }

      
              else if(readchar == '<'){
                 while(readchar != '>'){  
                    try{                                                                  //IF THERE IS AN HTML < TAG
                    String print = Character.toString(readchar);
                    write.write(print,0,print.length());
                    write.flush();
                    int d = br.read();
                    readchar = (char) d;}
                    catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read or write next char(6)");
                    }
                 }
              }
        } // end of try statement
      } // end of while loop


      catch(IOException ex){
                    System.out.println (ex.toString());
                    System.out.println("Could not read next char");
      }
    System.out.println("REACHED THE END");
    return;
    }// end of main

//==========================================================================

    static boolean isVowel(char c){
    return (c == 'A' || c == 'E' || c == 'I' ||
            c == 'O' || c == 'U' || c == 'a' ||
            c == 'e' || c == 'i' || c == 'o' ||
            c == 'u');
    }
    
    static boolean isNum(char c){
    return (c == '0' || c == '1' || c == '2' ||
            c == '5' || c == '4' || c == '3' ||
            c == '6' || c == '7' || c == '8' ||
            c == '9');
    }
   
    static boolean isPunc(char c){
    return (c == '\'' || c == '"' || c == ':' ||
            c == ')' || c == '(' || c == ';' ||
            c == '!' || c == '@' || c == '#' ||
            c == '?' || c == ',' || c == '.' || c == '+' || c == '-'
            || c == '=');
    }
 
    static boolean isHtml(char c){
    return (c == '>' || c == '<' || c == '&');}


};

