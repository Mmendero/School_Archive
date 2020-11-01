import java.net.*;
import java.io.*;
import java.util.*;

public class HaikuServer
{
    static final int PORT = 5575;
    static final String FILENAME = "./Rando_Haikus.txt";

    public static String getRandomHaiku(Set<String> all_haikus) {
        Random random = new Random();
        Iterator<String> iterator = all_haikus.iterator();
        String randomHaiku;
        int randomNumber = random.nextInt(all_haikus.size());
        int curr_index = 0;

        while(iterator.hasNext()){
            randomHaiku = iterator.next();

            //if current index is equal to random number
            if(curr_index == randomNumber)
                return randomHaiku;

            //increase the current index
            curr_index++;
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Server Started.");

        //Initialize files needed for haiku storage/filename
        Set<String> all_haikus = new HashSet<String>();
        File file = new File(FILENAME);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder haiku = new StringBuilder();
        String line;

        //Iterate through file and construct Haikus
        while ((line = br.readLine()) != null) {
            if(line.contains("-1")) {
                all_haikus.add(haiku.toString());
                haiku.setLength(0);
            }
            else{
                haiku.append(line);
                haiku.append("\n");
            }
        }

        System.out.println("Listening on Port: " + PORT);
        try{//Listens on Port
            //Create instance of client
            //initialize input and output for client
            ServerSocket server_socket = new ServerSocket(PORT);
            Socket client_socket = server_socket.accept();
            PrintWriter out = new PrintWriter(client_socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));

            String str = in.readLine();
            System.out.println("Client: " + str);

            String rando_haiku = getRandomHaiku(all_haikus);
            out.println(rando_haiku);
        }
        catch(IOException err){
            System.out.println("Error Listening on Port: " + PORT);
        }
    }

}