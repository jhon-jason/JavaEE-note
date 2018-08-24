package Day_12.Test04;

import java.util.Random;
public class RandomUtil {
    private Random random = new Random();

    public int nextInt(int... nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("pls认真一点！");
        }
        //生成1到nums[0](包含1和nums[0])之间的随机数
        if (nums.length == 1) return random.nextInt(nums[0]) + 1;

        //生成nums[0]到nums[1](包含nums[0]和nums[1])之间的随机数
        if (nums.length == 2) return random.nextInt(nums[1] + 1 - nums[0]) + nums[0];

        //从数组nums中取出一个随机元素
        return nums[random.nextInt(nums.length)];
    }
}

