package compression;



public class Compression {

    public static void main(String[] args) {
        
        String testStr = "C:\\Users\\Stoxhorn\\Desktop\\Vigtige filer\\Uni\\Projekter\\CurrentProjects\\Compression\\Test.txt";
        String testStr1 = "C:\\Users\\Stoxhorn\\Desktop\\Vigtige filer\\Uni\\Projekter\\CurrentProjects\\Compression\\Test1.txt";
        Encode main = new Encode(testStr);
        Decode shit = new Decode(testStr1, testStr);
    }
}
