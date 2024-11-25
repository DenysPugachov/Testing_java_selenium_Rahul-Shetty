public class CoreJavaBrushUp1 {
    public static void main(String[] args){
        int num = 5;
        String website = "this is a string type";
        char letter = 'a';
        double dec = 4.333;
        boolean isDirty = true;
//        System.out.println(num + " this is string");

        // Array
        int[] arr =  new int[3]; // assign memory for 3 elem.
        arr[0] = 3;
        arr[1]= 2;
        arr[2] = 4;

        // 2. method to init array
        int[] arr2 = {1,2,4,2,4,4,4,2,2};
        System.out.println("index 2 in arr2  is " + arr[2]);

        // Loop:
        // for loop:
//        for(int i = 0; i<arr2.length; i++){
//            System.out.println("element " + i + " = "+ arr2[i]);
//        }

        String[] arrOfNames = {"Den", "Alice", "Jane"};

//        for(int i = 0; i<arrOfNames.length; i++){
//            System.out.println("name " + arrOfNames[i]);
//        }

        // Enhanced array loop:
        for(String s: arrOfNames){
            System.out.println("name: " + s);
        }

        for(int b: arr2){
            System.out.println("integer: " + b);
        }
    }
}
