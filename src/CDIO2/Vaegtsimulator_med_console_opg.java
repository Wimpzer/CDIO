package CDIO2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Vaegtsimulator_med_console_opg {
	static ServerSocket listener;
    private static double brutto=0;
    private static double tara=0;
    private static String inline;
    private static String IndstruktionsDisplay= "";
    private static int portdst = 8000;
    private static Socket sock;
    private static BufferedReader instream;
    private static DataOutputStream outstream;
    static Scanner scan = new Scanner(System.in);
    
    public static void printmenu(){
        for (int i=0;i<25;i++)
        System.out.println("                                                 ");
        System.out.println("*************************************************");
        System.out.println("Netto: " + (brutto-tara)+ " kg"                   );
        System.out.println("Instruktionsdisplay: " +  IndstruktionsDisplay    );
        System.out.println("*************************************************");
        System.out.println("                                                 ");
        System.out.println("                                                 ");
        System.out.println("Debug info:                                      ");
        System.out.println("Hooked up to " + sock.getInetAddress()            );
        System.out.println("Brutto: " + (brutto)+ " kg"                       );
        System.out.println("Streng modtaget: "+inline)                         ;
        System.out.println("                                                 ");
        System.out.println("Denne vegt simulator lytter p� ordrene           ");
        System.out.println("D, DN, S, T, B, Q                                ");
        System.out.println("paa kommunikationsporten.                        ");
        System.out.println("******");
        System.out.println("Tast T for tara (svarende til knaptryk paa vegt)");
        System.out.println("Tast B for ny brutto (svarende til at belastningen paa vegt �ndres)");
        System.out.println("Tast Q for at afslutte program program");
        System.out.println("Indtast (T/B/Q for knaptryk / brutto �ndring / quit)");
        System.out.print  ("Tast her: ");
    }

    public static void main(String[] args) throws IOException{
        listener = new ServerSocket(portdst);
        	System.out.println("Tryk 1 for at benytte portnr 8000 eller 2 for at indtaste anden portnr");
        	int i = scan.nextInt();
        	while(i != 1 || i != 2){
        	System.out.println("Du har tastet forkert, benyt venligst 1 eller 2. Proev igen:");
        	i = scan.nextInt();}
    		if(i == 1){
    		portdst = 8000;}
    		else{
    		System.out.println("Indtast portnr: ");
    		int j = scan.nextInt();
    		portdst = j;}	
  
            System.out.println("Venter paa connection paa port " + portdst );
            System.out.println("Indtast eventuel portnummer som 1. argument");
            System.out.println("paa kommando linien for andet portnr");
        sock = listener.accept();
        instream = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        outstream = new DataOutputStream(sock.getOutputStream());
        printmenu();
        try{
            while (!(inline = instream.readLine().toUpperCase()).isEmpty()){
                if (inline.startsWith("DN")){
                    // ikke implimenteret
                
                }
                else if (inline.startsWith("D")){
                    if (inline.equals("D"))
                        IndstruktionsDisplay="";
                    else
                        IndstruktionsDisplay=(inline.substring(2, inline.length()));
                        printmenu();
                        outstream.writeBytes("DB"+"\r\n");
                }
                else if (inline.startsWith("T")){
                    outstream.writeBytes("T " + (tara) + " kg "+"\r\n");
                    tara=brutto;
                    printmenu();
                }
                else if (inline.startsWith("S")){
                    printmenu();
                    outstream.writeBytes("S " + (brutto-tara)+ " kg "  +"\r\n");
                }
                else if (inline.startsWith("B")){ // denne ordre findes 
                                                  //ikke p� en fysisk v�gt
                    String temp= inline.substring(2,inline.length());
                    brutto = Double.parseDouble(temp);
                    printmenu();
                    outstream.writeBytes("DB"+"\r\n");
                }
                else if ((inline.startsWith("Q"))){
                    System.out.println("");
                    System.out.println("Program stoppet Q modtaget paa com   port");
                    System.in.close();
                    System.out.close();
                    instream.close();
                    outstream.close();
                    System.exit(0);
                }
            }
        }
        catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
  }

}
