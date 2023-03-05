

public class Main {

    public static void main(String[] args) {
        IO io = new IO();
        Sort sort = new Sort();

        int[] nums = io.input();

        sort.sort(nums);

        io.printRes(nums);
    }


}