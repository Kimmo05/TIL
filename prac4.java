package ��������;

public class prac4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k,i,j,m;
		int[] a  =new int[99] ; //�Ҽ� ���� �Ǻ�
		k = 1;
		do {
			k++;
			a[k-2] = k;
		}while(k<100); 
		i = -1; 
		j = 0;
		while(true) {
		i++;
		if(i>98) {
			System.out.println(j);
			break;
		}
		if(a[i] ==0)
			continue;
		j++;
		m = i;
		while(true) {
			m += a[i];
			if(m>98)
				break;
			a[m] = 0;
		}
		}
	}

}
