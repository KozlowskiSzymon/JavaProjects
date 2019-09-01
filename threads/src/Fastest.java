import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Fastest {
    public static void main(String[] args) {
        String[] url1 = {"https://www.telemagazyn.pl/",
                "https://www.telemagazyn.pl/?od=tv_puls#programTV",
                "https://www.telemagazyn.pl/?od=ttv#programTV",
                "https://www.telemagazyn.pl/?od=tvp_abc#programTV",
                "https://www.telemagazyn.pl/?od=zoom_tv#programTV",
                "https://www.telemagazyn.pl/?od=4fun_dance#programTV",
                "https://www.telemagazyn.pl/?od=epic_drama#programTV",
                "https://www.telemagazyn.pl/?od=canal_1#programTV",
                "https://www.telemagazyn.pl/?od=canal_discovery#programTV",
                "https://www.telemagazyn.pl/?od=hbo3#programTV",
                "https://www.telemagazyn.pl/?od=filmbox_extra#programTV",
                "https://www.telemagazyn.pl/?od=axn_white#programTV",
                "https://www.telemagazyn.pl/?od=cbs_europa#programTV",
                "https://www.telemagazyn.pl/?od=tvn_24#programTV",
                "https://www.telemagazyn.pl/?od=superstacja#programTV",
                "https://www.telemagazyn.pl/?od=polsat_sport#programTV",
                "https://www.telemagazyn.pl/?od=extreme_sports#programTV",
                "https://www.telemagazyn.pl/?od=polsat_doku#programTV",
                "https://www.telemagazyn.pl/?od=investigation_discovery#programTV",
                "https://www.telemagazyn.pl/?od=planete#programTV"};


        for (String url : url1)
            getVectorsFromOnePage(url, "Dramat");
    }


    /**
     * Function getting tables of content from all programs selected by genre
     *
     * @param urlString URL of the page from TV guide
     * @param genre genre user wants to watch
     */
    public static void getVectorsFromOnePage(String urlString, String genre){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Document document = getDocumentFromPage(urlString); // get whole page
                //"progKontener" - class with all played programs listed
                Elements info = document.getElementsByClass("progKontener").select("span.info");
                Elements genreSelectedElements = getGenreSelectedElements(genre,info); // get only the genre you want
                if (genreSelectedElements != null){
                    String[] newUrls = getNewUrlForEveryElement(genreSelectedElements);    // open every site to get more info
                    int i =0;
                    String [][] vectors = new String[newUrls.length][7];
                    for (String str : newUrls){
                        vectors[i++] = getDataAboutProgram(str);
                    }
                }

            }
        });
        thread.start();
    }

    /**
     * Function getting all info about single program
     *
     * @param url URL of the program with specified data
     * @return table of useful data as title, country the film was made in, date of creation, genre, producer, score, channel
     */
    public static String[] getDataAboutProgram(String url){
            Document doc = getDocumentFromPage(url);
            String title = doc.getElementsByClass("dwieKolumny prawaZnika").select("meta[itemprop = headline]").attr("content");
            String score = doc.getElementsByClass("ocena-spolecznosci").text();
            String channel = doc.getElementsByClass("emisjaSzczegoly").select("a:not(.emisjaOdcinek)").text();
            if (title.equals("")){
                Document newDoc = getDocumentFromPage(makeUrl(doc.getElementsByClass("odcinekKontener").select("a").attr("href")));
                title = newDoc.getElementsByClass("dwieKolumny prawaZnika").select("meta[itemprop = headline]").attr("content");
                score = newDoc.getElementsByClass("ocena-spolecznosci").text();
            }
            String genre = doc.getElementsByClass("informacje").select("meta[itemprop = genre]").attr("content");
            String producer = doc.getElementsByClass("informacje").select("meta[itemprop = producer]").attr("content");
            String date = doc.getElementsByClass("belkaInfo").select("meta[itemprop = dateCreated]").attr("content");
            String country = doc.getElementsByClass("belkaInfo").select("meta[itemprop = contentLocation]").attr("content");
            //System.out.println(title + " " + country + " " + date + " " + genre + " " + producer + " " + score);
            System.out.println(title);
            String[] table = {title, country, date, genre, producer, score, channel};
        return table;
    }

    /**
     * Function getting document from new URL - document with more info
     *
     * @param urlString URL of specific program of the genre user wants
     * @return whole document
     */
    public static Document getDocumentFromPage(String urlString){
        Connection connection = Jsoup.connect(urlString);
        Document document = new Document("");
        try {
            document = connection.get();
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
        return document;
    }

    /**
     *  Function selects the genre user wants from all programs from TV guide
     *
     * @param genre of programs user want to watch
     * @param allElementsFromPage every program form one page of TV guide
     * @return collection of genre selected elements
     */
    public static Elements getGenreSelectedElements(String genre, Elements allElementsFromPage){
        Elements genreSelectedElements = new Elements();
        for(Element el : allElementsFromPage){
            if(el.text().contains(genre)){
                genreSelectedElements.add(el.parent().parent().parent());
            }
        }
        if(genreSelectedElements.size() == 0)
            return null;
        return genreSelectedElements;
    }

    /**
     *  Function that creates URLs which allow to access more info for collection of elements
     *
     * @param genreSelectedElements data about every program selected by genre
     * @return table of URLs with data after you click on program
     */
    public static String[] getNewUrlForEveryElement(Elements genreSelectedElements){
        String[] tableOfNewUrls = new String[genreSelectedElements.size()];
        int i =0;
        for (Element el : genreSelectedElements){
            String newUrl = makeUrl(el.select("a").attr("href"));
            tableOfNewUrls[i++] = newUrl;
        }
        return tableOfNewUrls;
    }

    /**
     * Function generates one new URL
     *
     * @param appendix rest of the URL
     * @return whole URL that appears after clicking on program
     */
    public static String makeUrl(String appendix){
        String newUrl = "https://www.telemagazyn.pl" + appendix;
        return newUrl;
    }

}




