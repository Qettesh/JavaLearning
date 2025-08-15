package dev.lpa;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;


public class Main {

    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    /**
     * Prints a grid of characters from a Google Doc.
     *
     * @param url The URL of the Google Doc.
     */
    public static void printGrid(String url){
        try{
            //Send HTTP request to retrieve the Google Doc content

            HttpResponse<String> response =sendHttpRequest(url);
            //Parse the HTML using Jsoup
            Document doc = Jsoup.parse(response.body());
            Map<String, Character> charMap = new HashMap<>();

            if (!charMap.isEmpty()){
                int maxX = getMaxCoordinate(charMap, 0);
                int maxY = getMaxCoordinate(charMap, 1);

                printCharacterGrid(charMap,maxX,maxY);
            } else {
                System.out.println("No grid elements found");
            }
        } catch (IOException e) {
            System.err.println("Error fetching or parsing the url: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("HTTP request interrupted: " + e.getMessage());
            Thread.currentThread().interrupt(); //Restore the interrupted status
        } catch (NumberFormatException e){
            System.err.println("Error parsing integer from data attributes: " + e.getMessage());
        }
    }
    /**
     * Sends an HTTP request to the specified URL and returns the response.
     *
     * @param url The URL to send the request to.
     * @return The HTTP response.
     * @throws IOException          If an I/O error occurs.
     * @throws InterruptedException If the operation is interrupted.
     */

    private static HttpResponse<String> sendHttpRequest(String url) throws IOException,
            InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }
    /**
     * Parses the grid elements from the provided document.
     *
     * @param doc The document to parse.
     * @return A map of character coordinates to characters.
     */

    private static Map<String, Character> parseGridElements(Document doc){
        Map<String, Character> charMap = new HashMap<>();
        Elements gridElements = doc.select(".grid");

        for (Element gridElement : gridElements){
            int x = Integer.parseInt(gridElement.attr("data-x"));
            int y = Integer.parseInt(gridElement.attr("data-Y"));
            String unicode = gridElement.attr("data-unicode").replace("\\u", "");

            charMap.put(x + "," + y, (char) Integer.parseInt(unicode, 16));
        }
        return charMap;
    }
    /**
     * Gets the maximum coordinate value from the provided map.
     *
     * @param charMap The map of character coordinates.
     * @param index   The index of the coordinate (0 for x, 1 for y).
     * @return The maximum coordinate value.
     */
    private static int getMaxCoordinate(Map<String, Character> charMap, int index){
        int max = 0;
        for (String key : charMap.keySet()){
            String[] coordinates = key.split(",");
            int value = Integer.parseInt(coordinates[index]);
            max = Math.max(max, value);
        }
        return max;
    }
    /**
     * Prints the character grid.
     *
     * @param charMap The map of character coordinates to characters.
     * @param maxX    The maximum x coordinate.
     * @param maxY    The maximum y coordinate.
     */
    private static void printCharacterGrid(Map<String, Character> charMap, int maxX, int maxY) {
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                char c = charMap.get(x + "," + y);
                System.out.print(c);
            }
            System.out.println(); //Add a new line after each row
        }
    }
    public static void main(String[] args){
        printGrid("https://docs.google.com/document/d/e/2PACX-1vRPzbNQcx5UriHSbZ-9vmsTow_R6RRe7eyAU60xIF9Dlz-vaHiHNO2TKgDi7jy4ZpTpNqM7EvEcfr_p/pub"); // Replace with the actual URL
    }
}
