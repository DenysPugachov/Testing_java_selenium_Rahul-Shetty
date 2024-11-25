public class JavaCore3 {
    public static void main(String[] args){

        // String - is an object that represent sequence of characters.

        // String methods:
        String str = "Den_21"; // String literal
        String str2 = "Den_21"; // => pointing the same obj as "str";

        // create String  allocation of memory with "new" key word
        String s2 = new String("Welcome");
        String s3 = new String("Welcome"); // explicitly create new object in memory;

        // String methods:
        String testStr = "Denys Pugachov Valentinovich";
        String[] splitTestStr = testStr.split(" ");

//        System.out.println(splitTestStr);
//        System.out.println(splitTestStr[0]);
//        System.out.println(splitTestStr[1]);
////        System.out.println(splitTestStr[2]);
//        System.out.println(splitTestStr[1].trim()); // trim value

        // iterate through the String in reverse order;
        for(int i = testStr.length()-1; i>=0; i--){
//            int realIdx = i-1;
            System.out.println(i + " : " + testStr.charAt(i));
        }


    }
}
