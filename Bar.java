package sample;

import java.util.ArrayList;
import java.util.Collections;

public class Bar extends BarAndLine implements Comparable<Bar> {

    public ArrayList<Bar> groupBar = new ArrayList<>();
    public Bar() {

    }

    public Bar(ArrayList<String> country, ArrayList<String> category, ArrayList<Integer> value, ArrayList<Integer> year) {
        for (int i = 0; i < country.size(); i++) {
            Bar b = new Bar();
            b.country = country.get(i);
            b.category = category.get(i);
            b.value = value.get(i);
            b.year = year.get(i);
            groupBar.add(i, b);
            Collections.sort(groupBar);
            if (!categoryList.contains(category.get(i))) {
                categoryList.add(category.get(i));

            }
            if (!yearList.contains(year.get(i))) {
                yearList.add(year.get(i));
            }

        }
     /* test
     for(int i=0;i<groupBar.size();i++){ //Sıralama Başarılı
          System.out.println(groupBar.get(i).year);
        }*/
    }


    @Override
    public int compareTo(Bar other) {

        return new Integer(this.value).compareTo(other.value);
    }
}
