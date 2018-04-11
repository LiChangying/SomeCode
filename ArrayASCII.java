/*
 * 给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
 * 输入描述：    eeefgghhh
 * 输出描述：    efghegheh
 */
public class ArrayASCII {
	public static void main(String[] args) {
		String str = "eeefgghhh";
		name(str);
	}
	
	public static void name(String str) {
		int[] count = new int[62];//建立一个有所有可能输入的整型数组
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {//遍历输入数据，将输入数据存入相应位置处，如果有多个相同元素进行累加
			if (cs[i]>='0'&&cs[i]<='9') {
				count[(int)(cs[i])-48] ++;
			}else if (cs[i]>='A'&&cs[i]<='Z') {
				count[(int)(cs[i])-65+10] ++;
			}else {
				count[(int)(cs[i])-97+36] ++;
			}
		}
		int max = count[0];//确定统计数组中出现重复元素最多的字符的个数
		for (int i = 1; i < count.length; i++) {
			if (count[i]>max) {
				max = count[i];
			}
		}
		for (int j = 0; j < max; j++) {//遍历输出，遍历一次将相应数据位置减一
			for (int i = 0; i < count.length; i++) {
				if (count[i]!=0) {
					if (i>=0&&i<=9) {
						System.out.print((char)(48+i));
					}else if (i>=10&&i<=35) {
						System.out.print((char)(55+i));
					}else {
						System.out.print((char)(61+i));
					}
					count[i]--;
				}
			}
		}
	}
}
