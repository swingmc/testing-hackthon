
import java.util.Random;


public class TestingImplement {


    private static String metamorphicChangeStr(String str) {
        Random rand = new Random();
        int n = rand.nextInt(10);
        int changeValue = rand.nextInt(10);
        switch(n%5){
            case 0:
                return str.concat("1");
            case 1:
                return str.toLowerCase();
            case 2:
                return str.concat("!");
            case 3:
                return str.replace("1", "2");
            case 4:
                return str.substring(2);
            default:
                return str;
        }
    }   

    private static Integer metamorphicChangeInt(Integer num) {
        Random rand = new Random();
        int n = rand.nextInt(4);
        switch(n){
            case 0:
                return num + 1;
            case 1:
                return num - 1;
            case 2:
                return -num;
            case 3:
                return num*1000;
        }
    }


    public static void main(String[] args) {
        //read test type from args

        //read test cases from file
        File file = new File("../test/testCases.json");

        
        
    }
}


