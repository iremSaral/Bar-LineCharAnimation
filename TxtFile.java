package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TxtFile {

    public ArrayList<String> nameList = new ArrayList<>();
    public ArrayList<String> categoryList = new ArrayList<>();
    public ArrayList<String> countryList = new ArrayList<>();
    public ArrayList<Integer> valueList = new ArrayList<>();
    public ArrayList<Integer> yearList = new ArrayList<>();

    public ArrayList<String> readtxt() {
        ArrayList<String> dene = new ArrayList<>();
        try {
            FileAndChartChooser getFile = new FileAndChartChooser();
            String fileName = getFile.getFileName();
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String str;
                while ((str = bufferedReader.readLine()) != null) {
                    //System.out.println(str +"\n");
                    dene.add(str + "\n");
                }
                bufferedReader.close();
            }

        } catch (IOException e) {
            System.out.println("file not found");

        }
        return dene;
    }


    public void decompose_txt() {
        ArrayList<Integer> tempyear = new ArrayList<>();
        ArrayList<Integer> tempmonth = new ArrayList<>();
        ArrayList<String> parsedtxt = readtxt();
        Pattern pattern = Pattern.compile("([0-9],)");
        for (int i = 0; i < parsedtxt.size(); i++) {
            Matcher match = pattern.matcher(parsedtxt.get(i));
            if (match.find()) {
                String[] array = parsedtxt.get(i).split(",");

                if (array[0].contains("-")) {
                    String[] temp = array[0].split("-");
                    yearList.add(Integer.parseInt(temp[0]));
                } else {
                    yearList.add(Integer.parseInt(array[0]));
                }
                nameList.add(array[1]);
                countryList.add(array[2]);
                valueList.add(Integer.parseInt(array[3]));
                categoryList.add(array[4]);
            }
        }

    }
}
