package Pr1;

import java.util.Arrays;
import java.util.function.Function;

class MinValueClass implements Function<int[], String> {

    @Override
    public String apply(int[] nums) {
        String res = Arrays.stream(nums)
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
        return res.isEmpty() ? "0" : res;
    }
}
class Main {
    public static void main(String[] args) {
        MinValueClass m = new MinValueClass();
        int [] nums = {1,3,1,2,3,3,4,5,8};
        String minValue = m.apply(nums);
        System.out.println("minValue " + minValue);

    }
}
