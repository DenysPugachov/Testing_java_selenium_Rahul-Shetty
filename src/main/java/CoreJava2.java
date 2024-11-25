import org.openqa.selenium.devtools.v85.domsnapshot.model.StringIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoreJava2 {
    public static void main(String[] args){

        int[] arrOfNumbers = {1,2,3,4,5,6,7};

        for(int n: arrOfNumbers){
            if(n %2 == 0){
                System.out.println("even: " +n);
                break;
            }else{
                System.out.println("odd: " + n);
            }
        }

        int counter = 0;

        // reverse oder of an array:
        for(int i = arrOfNumbers.length; i>0; i--){
            System.out.println(i);
        }

        // sum of numbers of the arr:
        for(int n: arrOfNumbers){
            counter = counter + n;
        }

        System.out.println("counter: " + counter);

        //ArrayList => declare with new, no size limit,
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add("test");
        arrList.add("2");
        arrList.add("Den");
        arrList.add("Alice");

        System.out.println("arrList: " + arrList.size());
        System.out.println("arrList second el: " + arrList.get(1));

        // How to iterate  through an arrayList:
        for(int i = 0; i<arrList.size(); i++){
            System.out.println(i+ " = "+ arrList.get(i));
        }

        for(String s: arrList){
            System.out.println(s + " = " + s);
        }

        System.out.println("arrList contain el: " + arrList.contains("Den"));

        // Create ArrayList form normal Array:
        String[] names = {"Den", "Alice", "Jane"};
        System.out.println("name[2] from names => " + names[2]);

        List<String> namesArrList = Arrays.asList(names);
        System.out.println("get(2) form namesArrList => "+ namesArrList.get(2));


    }
}
