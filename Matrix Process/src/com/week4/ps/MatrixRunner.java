package com.week4.ps;
import java.util.Scanner;

public class MatrixRunner {
		private int[][] mat;
		private int size;
		
		//Constructor
		private MatrixRunner() {
			mat = new int[3][3];
			size=3;
		}
		
		//Parameterized constructor
		private MatrixRunner(int size) {
			mat= new int[size][size];
			this.size =size;
		}
		
		//Copy constructor
		public MatrixRunner(MatrixRunner obj) {
			this.size = obj.mat.length;
			this.mat = new int[size][size];
			this.mat = obj.mat;
		}
		
		public void adoptMatrix(int[][] m) {
		      size = m.length;
		      mat=m;
			
		}
			
		public void readMatrix() {
			System.out.println("Enter the elements of the Matrix: ");
			Scanner sc= new Scanner(System.in);
			for(int i=0;i<size;i++) {
				for(int j=0;j<size;j++) {
					int num = sc.nextInt();
					mat[i][j]=num;}
			}	
		}
		
		public void displayMatrix() {
			System.out.println("MATRIX");
			for(int i=0;i<size;i++) {
				for(int j : mat[i]) {
					System.out.print(j+ " ");}
				System.out.println();
			}
		}

		public int[][] addMatrix(int[][] m) {
			int[][] newMat=new int[m.length][m[0].length];
		    for(int i=0;i<m.length;i++)
		    {
		        for(int j=0;j<m[0].length;j++)
		        {
		            newMat[i][j]=m[i][j]+mat[i][j];
		        }
		    }
		    return newMat;   
		}
		
		public int[][] mulMatrix(int[][] m){
			int[][] newMat=new int[size][size];
			
			for(int i=0;i<size;i++){    
				for(int j=0;j<size;j++){    
					newMat[i][j]=0;      
					for(int k=0;k<size;k++)      
					{      
					newMat[i][j]+=mat[i][k]*m[k][j];      
					}
				}
			}

			return newMat;
			
		}
		
		public Boolean isScalar() {
			 for (int i = 0; i < size; i++) {
			        for (int j = 0; j < size; j++) { 
			            if ((i != j) && (mat[i][j] != 0)) 
			                return false; 
			        }
			 }
			    
		    for (int i = 0; i < size - 1; i++) {
		        if (mat[i][i] != mat[i + 1][i + 1]) 
		            return false; }
			
		    return true; 

		}
	
		public static void main(String[] args) {
			int[][] mat = { { 2, 0 }, 
                    { 0, 2}};
			int out[][];
			MatrixRunner obj = new MatrixRunner(2);
			obj.readMatrix();
			obj.displayMatrix();
			obj.adoptMatrix(mat);
			out=obj.addMatrix(mat);
			System.out.println("matrix after addition");
			
			for(int i=0;i<2;i++) {
				for(int j : out[i]) {
					System.out.print(j+ " ");}
				System.out.println();
			}
			
			out=obj.mulMatrix(mat);
			
			for(int i=0;i<2;i++) {
				for(int j : out[i]) {
					System.out.print(j+ " ");}
				System.out.println();
			}
			
			System.out.println(obj.isScalar());
	
		}

}
