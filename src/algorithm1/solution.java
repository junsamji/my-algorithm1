package algorithm1;

import java.util.LinkedHashMap;

public class solution {

	public static void main(String[] args) {
		int[] times = {4, 2, 2, 1, 3};
		int n = 3;
		
		int[] result = solution(times, n);
		
		for (int i=0; i<result.length; i++) {
			if (i == result.length - 1) {
				System.out.println(result[i]);
			} else {
				System.out.print(result[i]+", ");
			}
		}

	}
	
	private static int[] solution(int[] times, int n) {
		int index = 0;
		int[] answer = new int[times.length];
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
				
		if (n == 1) {
			for (int i=0; i<times.length; i++) {
				answer[i] = i+1;
			}
			
			return answer;
		}
		
		for (int j=0; j<times.length; j++) {
			map.put(j+1, times[j]);
		}
		
		
		while (index < times.length) {
			int count = 1;
			
			for (int key : map.keySet()) {
				if (map.get(key) > 0 && count <= n) {
					map.put(key, map.get(key) - 1);
					
					
					if (map.get(key) == 0) {
						answer[index] = key;
						index++;
					}
					
					count++;
				}
			}
			
			for (int a : answer) {
				if (a > 0 && map.containsKey(a)) map.remove(a);
			}
			
		}
		
		
		return answer;
	}

}
