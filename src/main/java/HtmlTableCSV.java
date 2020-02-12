import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class HtmlTableCSV {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.parseBodyFragment("<table class=\"article-table sortable\" style=\"text-align: center;\" border=\"1\">\n" +
                "<tr>\n" +
                "<th> Class </th><th> Rating </th><th> Mass (T) </th><th> Capacity* </th><th> Value (CR)\n" +
                "</th></tr>\n" +
                "<tr>\n" +
                "<td> 1 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 2 </td><td style=\"text-align: right;\"> 1,000\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 2 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 4 </td><td style=\"text-align: right;\"> 3,250\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 3 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 8 </td><td style=\"text-align: right;\"> 10,563\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 4 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 16 </td><td style=\"text-align: right;\"> 34,328\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 5 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 32</td><td style=\"text-align: right;\"> 111,566\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 6 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 64 </td><td style=\"text-align: right;\"> 362,591\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 7 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 128 </td><td style=\"text-align: right;\"> 1,178,420\n" +
                "</td></tr>\n" +
                "<tr>\n" +
                "<td> 8 </td><td> E </td><td style=\"text-align: right;\"> 0.00 </td><td style=\"text-align: right;\"> 256 </td><td style=\"text-align: right;\"> 3,829,866\n" +
                "</td></tr></table>");
        Elements rows = doc.getElementsByTag("tr");
        FileWriter writer = new FileWriter("D:\\csv.txt");
        for (Element row : rows) {
            writer.write("<item>");
            Elements cells = row.getElementsByTag("td");
            for (Element cell : cells) {
                writer.write(cell.text().concat(";"));
            }
            writer.write("</item>");
            writer.write("\n");
        }
        writer.close();

    }
}
