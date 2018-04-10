import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/*
 * 对于一个字符串，从前开始读和从后开始读是一样的，我们就称这个字符串是回文串
 * 问题：移除字符串中的部分字符将字符串变成回文串
 * 问：有多少种移除方案
 * 注：对于两种移除方案，如果移除的字符依次构成的序列不一样就是不同的方案。
 * 测试用例1：
 * input： XXY 
 * output：4
 * 测试用例2：
 * input：ABA
 * output：5
 */
public class HuiWenString {
	public static void main(String[] args) {
		String string = "ABCDBAB";
		Set<String> set = subStringS(string);
		System.out.println(set.toString());
		Iterator<String> iterator = set.iterator();
		int count = 0;
		for (int i = 0; i < set.size(); i++) {
			if (ifPalindromeSquene(iterator.next())) {
				count ++;
			}
		}
		System.out.println(count+repeatNum(string));
//		System.out.println(repeatNum(string));
//		String str = "abc";
//		System.out.println(ifPalindromeSquene(str));
//		System.out.println(ifPalindromeSquene(string));
//		char[] cs = string.toCharArray();
//		List<String> list = new ArrayList<String>();
//		for (int j = 0; j < cs.length; j++) {
//			String s = "";
//			for (int j2 = 0; j2 < cs.length; j2++) {
//				if (j2 == j) {
//					continue;
//				}else {
//					s += cs[j2];
//				}
//			}
//			list.add(s);
//		}
//		System.out.println(list.toString());
	}
	public static Set<String> subStringS(String str) {//输出字符串的所有子串
		List<String> list = new ArrayList<String>();
		Set<String> set = new TreeSet<String>();
		list.add(str);
		set.add(str);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).length() >= 1) {
				char[] c = list.get(i).toCharArray();
				for (int j = 0; j < c.length; j++) {
					String s = "";
					for (int j2 = 0; j2 < c.length; j2++) {
						if (j2 == j) {
							continue;
						}else {
							s += c[j2];
						}
					}
					list.add(s);
					set.add(s);
				}
			}
		}
		return set;
//		System.out.println(set.toString());
//		System.out.println(set.size());
	}
	
	public static boolean ifPalindromeSquene(String str) {//判断是不是回文字符串
		boolean flag = false;
		char[] cs = str.toCharArray();
		if (str.length() == 1) {
			flag = true;
		}else{
			for (int i = 0; i < str.length()/2; i++) {
				if (cs[i] == cs[cs.length-i-1]) {
					flag = true;
				}else {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	public static int repeatNum(String str) {//判断一个字符串中重复的字符有多少个
		int cnt = 0;
		int[] count = new int[26];
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			count[cs[i]-65] ++;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i]>1) {
				cnt += (count[i]-1);
			}
		}
		return cnt;
	}
}
