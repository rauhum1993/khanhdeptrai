package lesson19_string_and_regex.thuc_hanh.crawl_menu_songs;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {
    public static void main(String[] args) {

            try {
                URL url = new URL("https://www.youtube.com/watch?v=xjQ-w_0Ga1Y");

                // open the stream and put it into BufferedReader
                Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
                scanner.useDelimiter("\\Z");
                String content = scanner.next();

                content = content.replaceAll("\\n+", "");

                Pattern p = Pattern.compile("name_song\">(.*?)</a>");
                Matcher m = p.matcher(content);
                while (m.find()) {
                    System.out.println(m.group(1));
                }
// close scanner
                scanner.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

