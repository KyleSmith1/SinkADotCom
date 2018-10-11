package dotcombust;

import java.util.ArrayList;

/**
 * @author 14001835
 */
public class DotCom {

    private ArrayList<String> locationCells;
    String name;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public void setName(String dotComName) {
        name = dotComName;
    }

    public String checkYourself(String stringGuess) {
        String result = "miss";
        int index = locationCells.indexOf(stringGuess);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You have won!");
            } else {
                result = "hit";
            }
        }

        System.out.println(result);
        return result;
    }

}
