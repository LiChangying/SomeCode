/*
 * 实现两个任意长度的长整数（正数）相乘，输出结果
 * 输入描述		1234
 * 				4321
 * 输出描述		5332114
 */
public class LargeNumberCalculate {
	
	public static void main(String[] args) {
		String str1 = "1234";
		String str2 = "4321";
		multi(str1, str2);//大数相乘
//		add(str1, str2);//大数相加
	}
	
	//大数相乘
	public static void multi(String str1,String str2) {//将一个字符串拆分，变成大数与一个个位数相乘
		char[] multiCs = new char[str1.length()];//将相乘结果的每次个位存储
		String string2 = "0";//每次相乘后与（上一个相乘得到的结果）的和
		for (int j = 0; j < str2.length(); j++) {
			char top = '0';//每次相乘后的最高位进位
			int multi = 0;
			int mGeWei = 0;
			int mShiWei = 0;
			for (int i = str1.length()-1; i >= 0; i--) {
				multi = ((int)(str1.charAt(i)-'0'))*((int)(str2.charAt(j)-'0'))+mShiWei;
				mGeWei = multi%10;
				mShiWei = multi/10;
				multiCs[i] = (char)(mGeWei+48);
				top = (char)(mShiWei+48);
			}
			String str = "";//str是每次大数与str2的每位相乘后的结果
			if (top!='0') {
				str += top;
			}
			for (int i = 0; i < multiCs.length; i++) {
				str += multiCs[i];
			}
//			System.out.print(str+" ");
			string2 = add(string2, str);
			string2 += "0";
//			System.out.println(string2);
//			string2.
		}
//		System.out.println();
		String outstr = "";//两个大数相乘后的结果，需要去掉末尾的0，因为最后一次相加结果末尾又追加了一个字符0
		for (int i = 0; i < string2.length()-1; i++) {
			outstr += string2.charAt(i);
		}
		System.out.println(outstr);
	}
	
	//大数相加
	public static String add(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int max = Math.max(len1, len2);
		int dev = max - Math.min(len1, len2);//确定两个大数位数的差值，将位数少的补零相加
		char[] cs = new char[max];//两个大数相加，每个位置的值
		char top = '0';//最高位的进位
		if (len1>len2) {
//			char[] cs = str1.toCharArray();
			int geWei = 0;//和的个位
			int shiWei = 0;//进位
			int sum = 0;
			for (int i = max-1; i >= 0; i--) {
				if (i>=max-len2) {
					sum = (int)(str1.charAt(i)-'0')+(int)(str2.charAt(i-dev)-'0')+shiWei;
				}else {
					sum = (int)(str1.charAt(i)-'0')+shiWei;
				}
				geWei = sum%10;
				shiWei = sum/10;
				cs[i] = (char)(geWei+48);
				top = (char)(shiWei+48);
			}
		}else {
//			char[] cs = str2.toCharArray();
			int geWei = 0;
			int shiWei = 0;
			int sum = 0;
			for (int i = max-1; i >= 0; i--) {
				if (i>=max-len1) {
					sum = (int)(str2.charAt(i)-'0')+(int)(str1.charAt(i-dev)-'0')+shiWei;
				}else {
					sum = (int)(str2.charAt(i)-'0')+shiWei;
				}
				geWei = sum%10;
				shiWei = sum/10;
				cs[i] = (char)(geWei+48);
				top = (char)(shiWei+48);
			}
		}
		String newStr = "";
		if (top!='0') {//若最高位有进位，则先赋值进位
			newStr += top;
		}
		for (int i = 0; i < max; i++) {
			newStr += cs[i];
		}
//		System.out.println(newStr);
		return newStr;//返回大数相加的结果
	}
	
}
