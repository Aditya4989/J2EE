package com.jspiders.hibernatemanytomany.dto;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		int arr[] = {10,20,30,40,50};
		int arr2 [] = {60,70,80,90,100};
		int arr3[] = new int[arr.length+arr2.length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			arr3[index] = arr[i];
			index = index+ 2;
		}
		index = 1;
		for (int i = 0; i < arr2.length; i++) {
			arr3[index] = arr2[i];
			index+= 2;
		}
		System.out.println(Arrays.toString(arr3));
		
	}
}
