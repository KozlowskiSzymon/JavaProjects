import info.talacha.filmweb.api.FilmwebApi;
import info.talacha.filmweb.connection.HttpMethod;
import info.talacha.filmweb.search.models.FilmSearchResult;
import info.talacha.filmweb.settings.Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;

/**
 * Testy działania metod API nie wymagających logowania
 * @author Paweł Talacha
 */
public class TestingAPI {

        private static FilmwebApi fa;

        public void testFindFilmList_CorrectTitle() {
            String polishTitle = "Żandarm się żeni";
            List<FilmSearchResult> filmList = fa.findFilm(polishTitle);
        }

    public static void main(String[] args) {
        fa = new FilmwebApi();
        fa.findFilm("Eldorado", 1967);
    }


}