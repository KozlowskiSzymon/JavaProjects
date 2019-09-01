import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Tagging {
    public static void main(String[] args) {
        Charset charSet = Charset.forName("UTF-8");
        ArrayList keyWordsList = new ArrayList<String>();
        ArrayList textTags = new ArrayList<String>();
        ArrayList userTags = new ArrayList<String>();
        String word;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\IdeaProjects\\threads\\src\\keyWords.txt"),charSet));
            while((word = reader.readLine()) != null)
                keyWordsList.add(word);
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        String text = "Po latach służby pod wodzą Rzymian rycerze Artura mają wrócić do domów, ale zwierzchnicy zlecają im ostatnie zadanie. Muszą wyprowadzić rodzinę cesarskiego dostojnika z terenów zajętych przez Sasów";
        String text1 = "Akcja filmu dzieje się w V wieku naszej ery, w czasach kiedy nadchodzi kres zachodniej części Cesarstwa Rzymskiego. Siedmiu zasłużonych rycerzy Okrągłego Stołu wraca z trudnej 15-letniej misji po obiecaną wolność. Niestety, dostają kolejne, ale ostatnie już zadanie. Muszą dotrzeć do pewnego dostojnika przed Saksonami. Całkiem przypadkowo odnajdują młodą dziewczynę - Ginewrę z plemion Piktów i Celtów, walczących z okrutnymi Saksonami. Usiłuje ona przekonać Artura o niszczącej potędze Rzymu i namówić do walki przeciwko Saksonom. Jednak to oznaczałoby przyłączenie się do czarodzieja Merlina, którego Artur obwinia o śmierć własnej matki. Ostatecznie Artur decyduje się walczyć przeciwko Saksonom. Zdaje sobie jednak sprawę z tego, że będzie musiał poświęcić życie swoich ludzi";

        for (int i = 0; i < keyWordsList.size(); i++){
            if (text1.contains(keyWordsList.get(i).toString()))
                System.out.println(keyWordsList.get(i).toString());
                textTags.add(keyWordsList.get(i).toString());
        }

    }
}


/** zapis w utf 8
 * BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka));
 * String line = new String(("bla bla bla bla").getBytes(charSet));
 * writer.write(line);
 * writer.close();
 *
 *
 * BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka,true)); // dopisywanie
 */
