/*
 * ����һ��ԭʼ�ַ��������ݸ��ַ�����ÿ���ַ����ֵĴ���������ASCII�����˳�����µ��������
 * ����������    eeefgghhh
 * ���������    efghegheh
 */
public class ArrayASCII {
	public static void main(String[] args) {
		String str = "eeefgghhh";
		name(str);
	}
	
	public static void name(String str) {
		int[] count = new int[62];
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i]>='0'&&cs[i]<='9') {
				count[(int)(cs[i])-48] ++;
			}else if (cs[i]>='A'&&cs[i]<='Z') {
				count[(int)(cs[i])-65+10] ++;
			}else {
				count[(int)(cs[i])-97+36] ++;
			}
		}
		int max = count[0];
		for (int i = 1; i < count.length; i++) {
			if (count[i]>max) {
				max = count[i];
			}
		}
		for (int j = 0; j < max; j++) {
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
