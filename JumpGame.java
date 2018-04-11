
public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,1,4};
		System.out.println(jumpII(arr));
	}
	/*
	Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Determine if you are able to reach the last index.

	For example: A = [2,3,1,1,4], return true.

	A = [3,2,1,0,4], return false.
	*/
	public static boolean jumpI(int[] arr) {
		int max = 0, i = 0;
        for(i = 0; i <= max && i < arr.length; i++){
            max = Math.max(max, arr[i] + i);
        }
        return i == arr.length;
	}
	/*
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

	Each element in the array represents your maximum jump length at that position.

	Your goal is to reach the last index in the minimum number of jumps.

	For example:
	Given array A = [2,3,1,1,4]

	The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	 */
	public static int jumpII(int[] arr) {
		int len = arr.length;
		int ret = 0;//目前为止的jump数
		int curMax = 0;//从arr[0]进行ret次jump之后达到的最大范围
		int curRch = 0;//从0~i个A元素中能达到的最大范围
		//当curRch<i时，表示经过ret次jump已经不足以覆盖当前第i个元素，因此需要增加一次jump，使之达到记录的curMax
		for (int i = 0; i < len; i++) {
			if (curRch < i) {
				ret ++;
				curRch = curMax;
			}
			curMax = Math.max(curMax, arr[i] + i);
		}
		return ret;
//		return 1;
	}

}
