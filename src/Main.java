import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        IO io = new IO();
        Sort sort = new Sort();

        sort.setNums(io.input());

        sort.QuickSort();

        io.printRes(sort.getNums());
    }


}