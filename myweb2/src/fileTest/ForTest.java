package fileTest;

import java.util.ArrayList;

public class ForTest {
	public static void main(String[] args){
		String fruit[] = {"사과","배","포도","딸기","딸기"};
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		// 기능에 대한 로직 부분이 특화
		for(int i = 0 ; i < fruit.length ; i++){
			System.out.println(fruit[i]);
		}
		System.out.println("-------------------------------");
		// 모든 요소에 대한 출력에 특화
		for (String temp : fruit) {
			System.out.println(temp);
		}
		
		for(int i = 0 ; i < arr.size() ; i++){
			System.out.println(arr.get(i));
		}
		for (Integer ina : arr) {
			System.out.println(ina);
		}
	}
}
