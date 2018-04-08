import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DataClassifiedProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		int INum = sc.nextInt();
//		int[] arrINum = new int[INum];
//		for (int i = 0; i < INum; i++) {
//			arrINum[i] = sc.nextInt();
//		}
//		int RNum = sc.nextInt();
//		int[] arrRNum = new int[RNum];
//		for (int i = 0; i < RNum; i++) {
//			arrRNum[i] = sc.nextInt();
//		}
		while (sc.hasNext()) {
			String[] strI = sc.nextLine().split(" ");
			String[] strR = sc.nextLine().split(" ");
			int num1 = Integer.parseInt(strI[0]);
			String[] strICopy = new String[num1];
			for (int i = 0; i < num1; i++) {
				strICopy[i] = strI[i+1];
			}
			int num2 = Integer.parseInt(strR[0]);
			String[] strRCopy = new String[num2];
			for (int i = 0; i < num2; i++) {
				strRCopy[i] = strR[i+1];
			}
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < num2; i++) {
				set.add(strRCopy[i]);
			}
			Iterator<String> iterator = set.iterator();
//			System.out.println(set.toString());
			List<String> listStringSum = new ArrayList<String>();
			for (int i = 0; i < set.size(); i++) {
				String testStr = iterator.next();
//				System.out.println(testStr);
				boolean flag = false;
				List<String> listString = new ArrayList<String>();
				List<Integer> listInteger = new ArrayList<Integer>();
				for (int j = 0; j < strICopy.length; j++) {
					if (strICopy[j].indexOf(testStr)!=-1) {
						listString.add(strICopy[j]);
						listInteger.add(j);
						flag = true;
					}
				}
				if (flag) {
//					System.out.print(testStr+" ");
//					System.out.print(listString.size()+" ");
//					for (int j = 0; j < listString.size(); j++) {
//						System.out.print(listInteger.get(j)+" ");
//						System.out.print(listString.get(j)+" ");
//					}
					listStringSum.add(testStr);
					listStringSum.add(String.valueOf(listString.size()));
					for (int j = 0; j < listString.size(); j++) {
						listStringSum.add(String.valueOf(listInteger.get(j)));
						listStringSum.add(listString.get(j));
					}
				}
			}
//			System.out.println("Yes");
			System.out.print(listStringSum.size()+" ");
			for (int j = 0; j < listStringSum.size(); j++) {
				System.out.print(listStringSum.get(j)+" ");
			}
		}
//		String[] strI = sc.nextLine().split(" ");
//		String[] strR = sc.nextLine().split(" ");
//		int num1 = Integer.parseInt(strI[0]);
//		String[] strICopy = new String[num1];
//		for (int i = 0; i < num1; i++) {
//			strICopy[i] = strI[i+1];
//		}
//		int num2 = Integer.parseInt(strR[0]);
//		String[] strRCopy = new String[num2];
//		for (int i = 0; i < num2; i++) {
//			strRCopy[i] = strR[i+1];
//		}
//		Set<String> set = new TreeSet<String>();
//		for (int i = 0; i < num2; i++) {
//			set.add(strRCopy[i]);
//		}
//		Iterator<String> iterator = set.iterator();
////		System.out.println(set.toString());
//		List<String> listStringSum = new ArrayList<String>();
//		for (int i = 0; i < set.size(); i++) {
//			String testStr = iterator.next();
////			System.out.println(testStr);
//			boolean flag = false;
//			List<String> listString = new ArrayList<String>();
//			List<Integer> listInteger = new ArrayList<Integer>();
//			for (int j = 0; j < strICopy.length; j++) {
//				if (strICopy[j].indexOf(testStr)!=-1) {
//					listString.add(strICopy[j]);
//					listInteger.add(j);
//					flag = true;
//				}
//			}
//			if (flag) {
////				System.out.print(testStr+" ");
////				System.out.print(listString.size()+" ");
////				for (int j = 0; j < listString.size(); j++) {
////					System.out.print(listInteger.get(j)+" ");
////					System.out.print(listString.get(j)+" ");
////				}
//				listStringSum.add(testStr);
//				listStringSum.add(String.valueOf(listString.size()));
//				for (int j = 0; j < listString.size(); j++) {
//					listStringSum.add(String.valueOf(listInteger.get(j)));
//					listStringSum.add(listString.get(j));
//				}
//			}
//		}
////		System.out.println("Yes");
//		System.out.print(listStringSum.size()+" ");
//		for (int j = 0; j < listStringSum.size(); j++) {
//			System.out.print(listStringSum.get(j)+" ");
//		}
	}

}
