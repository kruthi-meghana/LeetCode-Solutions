/**
 Question: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 
 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [[7,4,1],[8,5,2],[9,6,3]]
 
 @Author: Kruthi Meghana
*/

void rotate(int** matrix, int matrixSize, int* matrixColSize){
    
    for (int col = 0; col < matrixSize;  col++) {
        for(int i=0, j=matrixSize-1; i < j; i++, j--) {
            int swap = matrix[i][col];
            matrix[i][col] = matrix[j][col];
            matrix[j][col] = swap;
        }
    }
    
    for(int row=0; row < matrixSize; row++) {
        for(int i=row+1; i < matrixSize; i++) {
            int swap = matrix[row][i];
            matrix[row][i] = matrix[i][row];
            matrix[i][row] = swap;
        }
    }

}
