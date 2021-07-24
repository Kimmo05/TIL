

## 💡 Counting Sort [계수 정렬 / 카운팅 정렬]
---
카운팅 정렬은 수많은 정렬 알고리즘 중  시간복잡도가 𝚶(𝑛) 으로 엄청난 성능을 보여주는 알고리즘이다.

기본적으로 정렬이라하면 데이터끼리 직접 비교하는 경우가 많다. 그렇기 때문에 데이터 직접 비교를 사용하는 정렬 알고리즘의 경우  𝚶(nlogn) 보다 작아질 수 없는 것이 한계다. 그렇다면 카운팅 정렬은 어떻게 이를 극복했는지와
그럼에도 왜 퀵 정렬같은 𝚶(nlogn)  의 정렬 알고리즘을 많이 사용하는 이유를 카운팅정렬이 어떻게 작동하는지 이해하고 나면
이해할수있게 된다.

### ✔️ 정렬 방법

데이터의 값이 몇 번 나왔는지를 세주는 것
말 그대로 카운팅 하는것

arr[7,2,3,5,7,1,4,6,7,5,0,1] 


array를 한번 순회하면서 각 값이 나올때마다 해당 값을 index로 하는 새로운 배열(counting)의 값을 증가시킨다.

과정으로 보면<br>
array[0] = 7 이므로 counting[7] 값을 1 증가,

array[1] = 2 이므로 counting[2] 값을 1 증가,

...

array[11] = 1 이므로 count[1] 값을 1 증가. <br>

arr[7,2,3,5,7,1,4,6,7,5,0,1]  <br>
counting [1,2,1,1,1,2,1,3] <br>
counting 배열의 의미는 다음과 같다.

0의 개수는 1개

1의 개수는 2개

2의 개수는 1개
...<br>
7의 개수는 3개

이런식으로 counting 배열은 각 값의 개수가 담겨있는 배열이 된다.

counting 배열의 각 값을 누적합으로 변환시킨다.

counting [1,2,1,1,2,1,3] counting[1] += counting [0]<br> 
counting [1,3,1,1,1,2,1,3] <br>

counting [1,2,1,1,2,1,3] counting[2] += counting [0]<br>
counting [1,3,4,1,1,2,1,3] <br>

counting [1,2,1,1,2,1,3] <br>
counting [1,3,4,5,1,2,1,3] <br>
...
counting [1,2,1,1,2,1,3] <br>
counting [1,3,4,5,6,8,9,12] <br>

누적값을 설정해주면 아래와 같은 두 배열을 가진다

arr[7,2,3,5,7,1,4,6,7,5,0,1]  <br>
counting [1,3,4,5,6,9,12] <br>
counting 배열의 각 값은 (시작점-1)을 알려준다는 것

앞서 잠깐 언급했듯이, counting 배열의 각 값은 (시작점 - 1)을 알려준다고 했다. 즉, 해당 값에 대응되는 위치에 배정하면 된다는 의미다. 간단하게 예를 들면 이렇게 되는 것이다.

 

array[0] = 7 이고, counting[7] = 12 이다. 여기서 countin[7] 의 값에 1 을 빼준 뒤 해당 값이 새로운 배열의 인덱스 11에 위치하게 된다. 

array[1] = 2 이고, counting[2] = 4 이다. 여기서 countin[2] 의 값에 1 을 빼준 뒤 해당 값이 새로운 배열의 인덱스 3에 위치하게 된다. 

 array의 마지막 index 부터 순회하면

arr[7,2,3,5,7,1,4,6,7,5,0,1] = 11인덱스값 1<br> 

counting [1,3,4,5,6,8,9,12] =카운팅배열의 1의값 인덱스 3

counting [1,2,4,5,6,8,9,12] =2로 줄어듬

result [@,@,1,@,@,@,@,@,@,@,@,@]  =result[2]에 위치
이런식으로 반복하면 
하면 result 배열은 array 배열의 정렬된 형태로 있게 된다.

단점은 counting 배열이라는 새로운 배열을 선언해주어야 하므로
array 안에 있는 max값의 범위에 따라 counting 배열의 길이가 달라지게 된다

 ex)10개의 원소를 정렬하고자 하는데, 수의 범위가 0~1억이라면 메모리가 매우 낭비가 된다.


## 🤖 코드
```java
public class CountingSort {
	public static void main(String[] args) {
		
		int[] array = new int[100];		// 수열의 원소 : 100개
		int[] counting = new int[31];	// 수의 범위 : 0 ~ 30
		int[] result = new int[100];	// 정렬 될 배열 
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*31);	// 0 ~ 30
		}
 
		
		// Counting Sort
		// 과정 1 
		for(int i = 0; i < array.length; i++) {
			// array 의 value 값을 index 로 하는 counting 배열 값 1 증가 
			counting[array[i]]++;			
		}
		
		// 과정 2 
		for(int i = 1; i < counting.length; i++) {
			// 누적 합 해주기 
			counting[i] += counting[i - 1];
		}
		
		// 과정 3
		for(int i = array.length - 1; i >= 0; i--) {
			/*
			 *  i 번쨰 원소를 인덱스로 하는 counting 배열을 1 감소시킨 뒤 
			 *  counting 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			 */
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		
		
		
		/* 비교 출력 */
		
		// 초기 배열 
		System.out.println("array[]");
		for(int i = 0; i < array.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(array[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// Counting 배열 
		System.out.println("counting[]");
		for(int i = 0; i < counting.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(counting[i] + "\t");
		}
		System.out.println("\n\n");
		
		
		// 정렬된 배열
		System.out.println("result[]");
		for(int i = 0; i < result.length; i++) {
			if(i % 10 == 0) System.out.println();
			System.out.print(result[i] + "\t");
		}
		System.out.println();
	}
 
}
 
 ```
