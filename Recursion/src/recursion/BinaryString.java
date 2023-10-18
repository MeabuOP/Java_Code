
package recursion;

public class BinaryString {
    public static void main(String[] args) {
        BinaryString(new String(""), 4);
    }
    
    public static void BinaryString(String result,int n){
        if (result.length() == n){
            System.out.println(result);
            return;
        }
        for (int i=0;i<2;i++){
            BinaryString(result + i, n);
        }
    }
}


