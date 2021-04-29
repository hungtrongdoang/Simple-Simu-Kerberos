package kerberos;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.crypto.*;
import java.time.*;
import javax.xml.bind.DatatypeConverter;

public class Server_2 {
    
    //khởi tạo 2 biến để lập trình socket 
    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 9001;
    
    //khởi tạo biến chuỗi mang ID]
    public static final String ID_C = "CIS3319USERID";
    public static final String ID_V = "CIS3319SERVERID";
    public static final String ID_TGS = "CIS3319TGSID";
    
    //địa chỉ network address bên phía Client
    public static final String AD_C = "127.0.0.1:"+SERVER_PORT;
    
    //khởi tạo biến epoch time ( thời gian theo UNIX tính bằng giây )
    public static final long TS_5 = System.currentTimeMillis()/1000;
    
    //khởi tạo biến lifetime_2 và lifetime_4
    public static final long lifetime_2 = 60, lifetime_4 = 86400;
    
    
    //lifetime
    public static final long lifetime_10 = 60, lifetime_11 = 1;
   
    
    private static Cipher encrypt; //encryption cipher
    private static Cipher decrypt; //decryption cipher
    
    //khai báo các biến KEY
    private static SecretKey KEY_C, KEY_TGS, KEY_V, KEY_C_V;
        
    public static void main(String srgs[]) throws IOException{
        Socket s = new Socket(SERVER_IP, SERVER_PORT); //thiết lập kết nối socket với máy chủ 
        
        BufferedReader clientMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String recvMsg = clientMsg.readLine();
        System.out.println("Received message: " + recvMsg);
        checkValidity(); //kiểm tra tính hợp lệ của TGS Ticket
        
        //tạo Key mới để chia sẻ giữa Client và TGS 
        PrintStream key_c_v_file;
        String write_key_c_v = "";
        try{
            KEY_C_V = KeyGenerator.getInstance("DES").generateKey(); //gọi phương thức Key Generator để tạo khóa DES
            write_key_c_v = Base64.getEncoder().encodeToString(KEY_C_V.getEncoded()); //chuyển đổi từ secret key thành chuỗi
            key_c_v_file = new PrintStream(new File("KEY_C_V.txt")); //tạo file text mới để lưu chuỗi Key
            key_c_v_file.println(write_key_c_v); //ghi Key vào file txt
        }catch(Exception e){
            System.out.println(e);
        }
        
        //In ra màn hình Plaintext và Cipher text
        System.out.println("Plaintext : " + String.valueOf(TS_5 + 1));
        System.out.println("Ciphertext : " + encryption(KEY_C_V, String.valueOf(TS_5 + 1)));
        PrintWriter output = new PrintWriter(s.getOutputStream(), true);
        output.println(encryption(KEY_C_V, String.valueOf(TS_5 + 1))); //gửi Ciphertext tới Client
        
        s.close(); //Đóng socket
    }
    
    //encryption method
    public static String encryption(SecretKey key, String combinedText){        
        try{
            //Ecrypt chuỗi nối bằng thuật toán DES
            encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding"); 
            encrypt.init(Cipher.ENCRYPT_MODE, key); // khởi tạo biến Cipher sang chế độ ENCRYPT_MODE với khóa bí mật làm tham số
            byte []text = combinedText.getBytes();
            byte []ciphertext = encrypt.doFinal(text); //encrypt text
           // System.out.println("Cyphertext is: " + DatatypeConverter.printHexBinary(ciphertext)); //convert from bytes to Hex format
            return DatatypeConverter.printHexBinary(ciphertext);
        }catch(Exception e){
            System.out.println(e);
        }
        return "";
    }
    
    //method checkValidity 
    
    public static void checkValidity(){
        if((Instant.now().getEpochSecond() - TS_5) < lifetime_4)
            System.out.println("Ticket is valid.");
        else
            System.out.println("Ticket is not valid.");
    }
}
