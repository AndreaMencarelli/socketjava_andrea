
package socketjava_andrea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Studente
 */
public class Server { 
        ServerSocket ss; 
        Socket so;
        BufferedWriter bw;// serve per scrivere 
        BufferedReader br;// serve per leggere
        // oggetti 
        
    public Server(int porta) { // metodo costruttore 
            try {
                ss = new ServerSocket(porta);
                System.out.println("Server avviato") ; 
                ss.setSoTimeout(3000); // avvio countdown 

            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
         
    }
    
    public void ascolto() // metodo che mette in ascolto il server 
    {
            try {
                so = ss.accept(); // server soket accetta una richesta di comunicazione 
                System.out.println("Connessione stabilita");
                br = new BufferedReader(new InputStreamReader(so.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void scrivi(String messaggio)  // metodo per scrivere un messaggio per comunicare con il client  
    {
            try {
                bw.write(messaggio+"\n");
                bw.flush();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public String leggi() // metodo per leggere un messago inviato dal client 
    {
        
            try {
                return br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                return "Errore";
            }
    }
   
    
}