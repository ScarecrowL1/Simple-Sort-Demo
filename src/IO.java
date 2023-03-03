import java.util.Scanner;

public class IO {
    public int[] input(){
        Scanner scan = new Scanner(System.in);
        String str =  scan.nextLine();
        String[] strArr = str.split(" ");
        int[] nums = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++){
            nums[i] = Integer.parseInt(strArr[i]);
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }

        scan.close();

        return nums;
    }

}
