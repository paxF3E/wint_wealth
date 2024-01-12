import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Scraper {
    public static void main(String[] args) throws Exception {
        String targetUrl = "https://dfmye9ryu8rat.cloudfront.net/orionCipherFlow.txt";
        String outputFilePath = "./content.txt";

        URL url = new URL(targetUrl);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            File outputFile = new File(outputFilePath);
            if (!outputFile.exists()) {
                outputFile.createNewFile();
            }

            PrintWriter writer = new PrintWriter(outputFilePath, "UTF-8");
            writer.print(sb.toString());
            writer.close();
        }
    }
}
