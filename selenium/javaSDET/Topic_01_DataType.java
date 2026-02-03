package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Topic_01_DataType {
    //Cách Khai báo
    // Access modifier: Phạm vi truy cập (public/ private/ protected/ default)
    // Cách 1: Access modifier - Kiểu dữ liệu - Tên biến - Giá trị của biến (trong hàm/ ngoài hàm đều được)
    public char cName = 'b';



    // Cách 2: Access modifier - Kiểu dữ liệu -  Tên biến ==> Sau đó khai báo Tên biến - Giá trị của biến (Sử dụng trong hàm)
    private char cAdress;
    public void clickToElement(){
        cAdress = 'a';
    }
    //2 nhóm kiểu dữ liệu
    //Nhóm 1 - Kiểu dữ liệu nguyên thuỷ (8 loại): Kí tự (char) - Số nguyên (byte/ short/ int/ long) - Số thực (float/ double) - Logic (boolean)
    char cZip = 'b';
    byte bNumber = -120;
    short cNumber = 1200;
    int dNumber = 35000;
    long aNumber = 22434833;

    float qNumber = 2.2222f;
    double pNumber = 2.3232d;

    boolean aGender = true;


    //Nhóm 2 - Kiểu dữ liệu tham chiếu: Kiểu chuỗi (string) - Lớp (class) - interface - object - array - list/set/queue - map
    String fullName = "Automation FC";
    FirefoxDriver fDriver = new FirefoxDriver();
    WebDriver driver;
    String[] studentName = {"Hiền", "Nam", "Khánh", "An"};
    Integer[] studentPhone = {8223212, 21323222, 32132122};
    List<String> studenAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<String>();

}
