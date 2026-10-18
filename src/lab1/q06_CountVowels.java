package lab1;

public class q06_CountVowels {
    public static int vovelCount(String string){
        int count = 0;
        String loweredString = string.toLowerCase();
        int length = loweredString.length();
        for (int i = 0; i < length;i++){
            char ch = string.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Vovels in 'varun' is: " + vovelCount("varun"));
        System.out.println("Vovels in 'msis manipal' is: " + vovelCount("msis manipal"));
    }
}
