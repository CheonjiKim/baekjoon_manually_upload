package backjoon_studying;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
      
		try (Scanner sc = new Scanner(System.in)) {
			int totalMins;
			totalMins = sc.nextInt();
			sc.nextLine();
			
			int[] scoresArr = new int[totalMins]; // 점수만 쏙 골라서 저장
			int[] ordersArr = new int[totalMins]; // 시간과 0 만 저장
			int[] stackArr = new int[totalMins]; // 스택처럼 쓸 배열
			int currentOrderValue;

			int i;
			for (i = 0; i < totalMins; i++) scoresArr[i] = -1; // scoresArr의 모든 값을 -1로 할당.
				
			
			int count = 0;
			for (i = 0; i < totalMins; i++){ // scoresArr과 ordersArr에 값을 담는 과정이다.
				currentOrderValue = sc.nextInt(); 
				
				if (currentOrderValue == 0){
					ordersArr[i] = 0;
					sc.nextLine();
				}

				else {
					scoresArr[count] = sc.nextInt();
					count++;

					ordersArr[i] = sc.nextInt();
					sc.nextLine();
				}
			}
			
			// System.out.println("____________");
			// System.out.println(Arrays.toString(scoresArr));
			// System.out.println(Arrays.toString(ordersArr));
			//System.out.println(Arrays.toString(stackArr));

			count = 0; // count는 마지막 값이 담긴 배열의 인덱스보다 1만큼 크다.
			int totalScore = 0;
			int scoreCount = 0;

			for (i = 0; i < totalMins; i++) if(scoresArr[i] != -1) scoreCount++;
			
			int currentTaskDuration, topLocValue;
			for (i = 0; i < totalMins; i++) {
				// System.out.println("---");
				currentOrderValue = ordersArr[i];
				currentTaskDuration = currentOrderValue;
				topLocValue = stackArr[count];
				//System.out.println(Arrays.toString(stackArr));

				if(currentOrderValue != 0){ // 새로운 값 입장.
					topLocValue = currentTaskDuration - 1;
					stackArr[count] = topLocValue;
					// System.out.println("새 값 입장 후의 topLocValue: " + topLocValue);
					if (topLocValue == 0){ // 입력받은 값이 1인 경우, 즉, 새 일을 받자마자 끝나는 경우
						totalScore += scoresArr[scoreCount - 1];
						// System.out.println("새 작업이 1분이라서 받자마자 끝남요. " + totalScore + " 만큼 더한다.");
						scoreCount--;
					}
					else count++;
				}

				else { // 새로운 값이 없는 경우
					// System.out.println("새 작업이 없습니다. " + "topLocValue: " + topLocValue);
					// System.out.println("새 작업이 없습니다. 카운트 : " + count);

					if (count > 0) { // 스택에 값이 있을 때.
						// System.out.println("스택에 값이 있군요. ");
						count--;
						topLocValue = stackArr[count];
						topLocValue--;
						stackArr[count] = topLocValue;
						count++;

						// System.out.println("topLocValue: " + topLocValue);


						if (topLocValue == 0){
							totalScore += scoresArr[scoreCount - 1];
							// System.out.println("새 작업은 없고 기존 작업 끝남요. " + totalScore + " 만큼 더한다.");
							scoreCount--;
							count--;
						}
					}
				}
			}
			
			sc.close();
			System.out.println(totalScore);
		}
		
	}
}	



