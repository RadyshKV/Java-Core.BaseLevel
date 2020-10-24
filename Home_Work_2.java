package ru.geekbrains.Home_Work_2;

public class Home_Work_2 {

    public static void main(String[] args) {

		int[] arrayInt1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
		int[] arrayInt2 = new int[8];
		int[] arrayInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
		int[] arrayInt4 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

		int[][] arraySquare =  {{0,0,0,0,0,0},
								{0,0,0,0,0,0},
								{0,0,0,0,0,0},
								{0,0,0,0,0,0},
								{0,0,0,0,0,0},
								{0,0,0,0,0,0}};

		int[] checkBalance1 = {1, 1, 1, 2, 1}; // → true,
		int[] checkBalance2 = {2, 1, 1, 2, 1}; // → false,
		int[] checkBalance3 = {10, 1, 2, 3, 4}; // → true.

		int[] arrayForOffset = {1, 2, 3, 4, 5};

		int[][] array1 = {{ 5, 4,  6, 9},
						  {10, 3, 12, 8},
						  { 1, 6,  3, 2}};

		int[][] array2 = {	{1,  3,  7, 15, 22, 45,  2},
							{3,  4,  5, 55,  6,  8,  1},
							{1,  3,  5,	 4,	 6,  9,  0},
							{5,  7, 10,  3, 12,  8,  2},
							{14, 9,  1,	 6,	 3,	 2,  5},
							{1,  1,  1,  1,  1,  1,  1}};
 		//1
		replaceArrayElement(arrayInt1);
		printArray(arrayInt1);

		//2
		fillInArray(arrayInt2);
		printArray(arrayInt2);

		//3
		multiplicationArray(arrayInt3);
		printArray(arrayInt3);

		//4
		findMinMaxElementArray(arrayInt4);

		//5
		setDiagonalArray(arraySquare);

		//6
		System.out.println(checkSymmetryArray(checkBalance3));

		//7
		offsetElementArray(arrayForOffset, -2);
		printArray(arrayForOffset);

		//хардкор
		int[] resultArray = getUniqueArrayElements(arrayInt4, checkBalance3);
		printArray(resultArray);

		//комбо-хардкор
		System.out.println(checkSubArray(array1, array2));
    }
	
	//вывод в консоль одномерного массива
	public static void printArray(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	//вывод в консоль двумерного массива
	public static void printArray2D(int[][] array){
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}		
	}	
	
	//1 Задать целочисленный массив, состоящий из элементов 0 и 1. 
	//Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. 
	//Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
	public static void replaceArrayElement(int[] array){
		for (int i = 0; i < array.length; i++){			
			switch(array[i]){
				case 1:
					array[i]=0;
					break;
				case 0:
					array[i]=1;
					break;
				default:
					break;
			}
		}						
	}
	
	//2 Задать пустой целочисленный массив размером 8. 
	//Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
	public static void fillInArray(int[] array){
		for (int i = 0; i < array.length; i++){			
			array[i] = 1 + i*3;			
		}
	}


	//3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], 
	//написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
	public static void multiplicationArray(int[] array){
		for (int i = 0; i < array.length; i++){
			if (array[i]<6){	
				array[i]=array[i]*2;
			}			
		}
	}

	//4 Задать одномерный массив. 
	//Написать методы поиска в нём минимального и максимального элемента;
	public static void findMinMaxElementArray(int[] array){
		if (array.length != 0){
			int minElement = array[0];
			int maxElement = array[0];
			
			for (int i = 0; i < array.length; i++){
				minElement = (array[i] < minElement) ? array[i] : minElement;
				maxElement = (array[i] > maxElement) ? array[i] : maxElement;
			}	
			System.out.println("Минимальный элемент "+ minElement);
			System.out.println("Максимальный элемент "+ maxElement);
		} else {
			System.out.println("Массив пустой");
		}
	}
	
	//5 ^ Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), 
	//заполнить его диагональные элементы единицами, используя цикл(ы);
	public static void setDiagonalArray(int[][] array){
		if (array.length != 0) {
			if (array.length == array[0].length) {
				for (int i = 0; i < array.length; i++) {
					array[i][i] = 1;
					array[i][array.length - i - 1] = 1;
				}
				printArray2D(array);
			} else {
				System.out.println("Массив не квадратный");
			}
		} else {
			System.out.println("Массив пустой");
		}
	}
	
	//6 ^^ Написать метод, в который передается не пустой одномерный целочисленный массив, 
	//метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
	//checkBalance([1, 1, 1, || 2, 1]) → true,
	//checkBalance ([2, 1, 1, 2, 1]) → false,
	//checkBalance ([10, || 1, 2, 3, 4]) → true.
	//Абстрактная граница показана символами ||, эти символы в массив не входят.
	public static boolean checkSymmetryArray(int[] array){
		int sumLeft = 0;
		int sumRight;
    	for (int i = 0; i < array.length; i++) {
			sumRight = 0;
			sumLeft += array[i];
			for (int j = i+1; j < array.length; j++) {
				sumRight += array[j];
			}
			if (sumLeft == sumRight) return true;
		}
		return false;
	}

	//	7 ^^^ Написать метод, которому на вход подаётся одномерный массив и число n
	//	(может быть положительным, или отрицательным), при этом метод должен циклически
	//	сместить все элементы массива на n позиций.
	//	[1,2,3,4,5], -2 => [3,4,5,1,2]
	//	[1,2,3,4,5], 2 => [4,5,1,2,3]
	//	8 ^^^^ Не пользоваться вспомогательным массивом при решении задачи 7.
	public static void offsetElementArray(int[] array, int offset){
		int tmpVal;
    	if (array.length != 0) {
    		if (offset>0){
				for (int i = 0; i < offset; i++) {
					tmpVal = array[array.length-1];
					for (int j = array.length-1; j > 0 ; j--) {
						array[j] = array[j-1];
					}
					array[0] = tmpVal;
				}
			} else {
				for (int i = offset; i < 0; i++) {
					tmpVal = array[0];
					for (int j = 0; j < array.length - 1; j++) {
						array[j] = array[j + 1];
					}
					array[array.length - 1] = tmpVal;
				}
			}
		} else {
			System.out.println("Массив пустой");
		}
	}

	//	Задание по хардкору. Нужен метод, который получает в параметры 2 массива (разной длины) int-чисел.
	//	Он (метод) должен вернуть массив значений, которые есть в 1 массиве, но их нет во втором
	public static int[] getUniqueArrayElements(int[] array1, int[] array2){
    	int count = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if(array1[i]==array2[j]) break;
				if (j == array2.length-1) count++;
			}
		}
		int[] resultArray = new int[count];
		count = 0;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if(array1[i]==array2[j]) break;
				if (j == array2.length-1) {
					resultArray[count]=array1[i];
					count++;
				}
			}
		}
    	return resultArray;
	}


	//	Задание комбо-хардкор: необходимо проверить, что первый двумерный массив является подмассивом
	//	второго двухмерного массива, которые подаются в метод
	public static boolean checkSubArray(int[][] array1, int[][] array2) {
  		for (int i = 0; i < array2.length; i++) {
			for (int j = 0; j < array2[i].length; j++){
				// сравниваем первый элемент первого массива с текущим элементом второго массива, при совпадении проверяем,
				// что длины оставшейся части второго массива достаточно для включения первого
				if (array2[i][j] == array1[0][0] && array2.length-i >= array1.length && array2[i].length-j >= array1[0].length) {
					for (int k = 0; k < array1.length; k++) {
						for (int l = 0; l < array1[k].length; l++) {
							if (array2[i + k][j + l] != array1[k][l]) break;
							if (k == array1.length-1 && l == array1[k].length-1) return true;
						}
					}
				}
			}
		}
  		return false;
	}

}