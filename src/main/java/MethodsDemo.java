public class MethodsDemo {
    public static void main(String[] args){
        // FOR CODE EXECUTION

        // create object of this class and run method declared outside ot main block
        MethodsDemo objD1 = new MethodsDemo();
        String d1 = objD1.getData();
        System.out.println(d1);

        // create obj + run method form another class
        MethodsAnotherDemo objD2 = new MethodsAnotherDemo();
        String d2 = objD2.getUserData();
        System.out.println(d2);

        String testString = testMethod();
        System.out.println(testString);

//        public void testInMainNotAllowCreateMethods(){
//            System.out.println("do not allow to create methods inside a main block.");
//        }
    }


    public static String getData(){
        System.out.println("Hello from MethodsDemo class!");
        return "Returned form getData()";
    }

    // "static" key word => bind method to the class, (no need to instantiate new Obj)
    public static String testMethod(){
        return "Return from static testMethod()";
    }
}
