/*
 * ʵ���������ⳤ�ȵĳ���������������ˣ�������
 * ��������		1234
 * 				4321
 * �������		5332114
 */
public class LargeNumberCalculate {
	
	public static void main(String[] args) {
		String str1 = "1234";
		String str2 = "4321";
		multi(str1, str2);//�������
//		add(str1, str2);//�������
	}
	
	//�������
	public static void multi(String str1,String str2) {//��һ���ַ�����֣���ɴ�����һ����λ�����
		char[] multiCs = new char[str1.length()];//����˽����ÿ�θ�λ�洢
		String string2 = "0";//ÿ����˺��루��һ����˵õ��Ľ�����ĺ�
		for (int j = 0; j < str2.length(); j++) {
			char top = '0';//ÿ����˺�����λ��λ
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
			String str = "";//str��ÿ�δ�����str2��ÿλ��˺�Ľ��
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
		String outstr = "";//����������˺�Ľ������Ҫȥ��ĩβ��0����Ϊ���һ����ӽ��ĩβ��׷����һ���ַ�0
		for (int i = 0; i < string2.length()-1; i++) {
			outstr += string2.charAt(i);
		}
		System.out.println(outstr);
	}
	
	//�������
	public static String add(String str1,String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		int max = Math.max(len1, len2);
		int dev = max - Math.min(len1, len2);//ȷ����������λ���Ĳ�ֵ����λ���ٵĲ������
		char[] cs = new char[max];//����������ӣ�ÿ��λ�õ�ֵ
		char top = '0';//���λ�Ľ�λ
		if (len1>len2) {
//			char[] cs = str1.toCharArray();
			int geWei = 0;//�͵ĸ�λ
			int shiWei = 0;//��λ
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
		if (top!='0') {//�����λ�н�λ�����ȸ�ֵ��λ
			newStr += top;
		}
		for (int i = 0; i < max; i++) {
			newStr += cs[i];
		}
//		System.out.println(newStr);
		return newStr;//���ش�����ӵĽ��
	}
	
}
