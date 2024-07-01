import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		while(true){
        System.out.printf(":/LeoxDev/FastLog/_ ");
        String input = scanner.nextLine().trim();
        String[] urls = input.split(",");
        for (int i = 0; i < urls.length; i++) {
            String url = urls[i].trim();
			if(!url.contains("h") || url.contains("H") && url.contains("t") || url.contains("T") && url.contains("p") || url.contains("P") || url.contains("w") || url.contains("W")){
				url = "https://"+url;
			}
            System.out.println("\nFetching data from link " + (i + 1) + " : (" + url + ")\n");
            try {
                URL website = new URL(url);
                URLConnection connection = website.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) 
                    System.out.println(inputLine);
                in.close();
				System.out.println("");
            } catch (MalformedURLException e) {
                System.out.println("URL is not valid : " + url);
            } catch (IOException e) {
                System.out.println("Unable to retrieve data from : " + url);
				}
            }
        }
    }
}
