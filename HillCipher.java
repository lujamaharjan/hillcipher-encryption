import java.util.Scanner;

public class HillCipher{
    private static Scanner sc = new Scanner(System.in);

    private static void encryption(String msg){
        
        //for making msg length even
        int lencheck = 0;
        if(msg.length() % 2 != 0){
            msg += "z";
            lencheck = 1;
        }
        int msgNum[] = new int [msg.length()];
        for(int i = 0;i < msg.length(); i++){
            msgNum[i] = ((int)msg.charAt(i)) - 65;
            //System.out.println(msgNum[i]);
        }

        int key[][] = new int [2][2];
        System.out.println("Enter the key(2*2 matrix having inverse):");
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                key[i][j] = sc.nextInt();
            }
        }
        String eText = "";
        for(int i = 0; i < msg.length(); i += 2){
            System.out.println(msgNum[i]);
           int temp1 = msgNum[i] * key[0][0] + msgNum[i+1] * key[1][0];
           System.out.println(temp1);
           eText += (char) ((temp1 % 26) + 65);
           System.out.println(msgNum[i+1]);
           int temp2 = msgNum[i] * key[0][1] + msgNum[i+1] * key[1][1];
           eText += (char) ((temp2 % 26) + 65);
           System.out.println(temp2);
        }
        System.out.println("Encrypted Text:" + eText);
    }
    public static void main(String[] args){
        System.out.print("Enter message(word only): ");
        String msg = sc.next();
        msg = msg.toUpperCase();
        encryption(msg);
        }
}