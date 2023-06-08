package sample;

import java.util.ArrayList;

public class Line extends BarAndLine{
    public ArrayList<Line> groupLine = new ArrayList<>();

    public Line() {

    }

    public Line(ArrayList<String> country, ArrayList<String> category, ArrayList<Integer> value, ArrayList<Integer> year) {
        for (int i = 0; i < country.size(); i++) {
            Line line = new Line();
            line.country = country.get(i);
            line.category = category.get(i);
            line.value = value.get(i);
            line.year = year.get(i);
            groupLine.add(i, line);
            if (!categoryList.contains(category.get(i))) {
                categoryList.add(category.get(i));

            }
            if (!yearList.contains(year.get(i))) {
                yearList.add(year.get(i));
            }
        }
    }


}
