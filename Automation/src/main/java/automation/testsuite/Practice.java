package automation.testsuite;

import java.util.Scanner;

import org.testng.annotations.Test;
public class Practice {
		@Test
		public void tinhTongMang()
		{
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" Nhap doi dai cua mang: ");
			int n = sc.nextInt();
			int []a = new int[n];
			int sum=0;
			for(int i=0;i<n;i++)
			{
				System.out.println("Nhap vao phan tu mang thu: "+(i+1)+" ");
				a[i]=sc.nextInt();
				sum+=a[i];
			}
			System.out.println("Tong Mang la: "+sum);
		}
		@Test
		public void timMaxMang()
		{
			
			Scanner sc = new Scanner(System.in);
			System.out.println(" Nhap doi dai cua mang: ");
			int n = sc.nextInt();
			int []a = new int[n];
			int max=0;
			for(int i=0;i<n;i++)
			{
				System.out.println("Nhap vao phan tu mang thu: "+(i+1)+" ");
				a[i]=sc.nextInt();
				if(max<a[i]) max=a[i];
			}
			System.out.println("Số lớn nhất  la: "+max);
		}
}
