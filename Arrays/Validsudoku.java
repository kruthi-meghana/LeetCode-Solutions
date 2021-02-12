/**
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true

@Author Kruthi Meghana
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    ArrayList<Integer> al = new ArrayList<Integer>();
                    al.add(i);
                    al.add(j);
                    if(hashMap.containsKey(board[i][j] - '0')) {
                        if (isDuplicate(hashMap.get(board[i][j]-'0'), i, j))
                            return false;
                        ArrayList<Integer> dup = new ArrayList<Integer>();
                        dup.addAll(hashMap.get(board[i][j]-'0'));
                        dup.addAll(al);
                        hashMap.put(board[i][j] - '0', dup);
                    } else {
                        hashMap.put(board[i][j] - '0', al);   
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isDuplicate(ArrayList<Integer> x, int i, int j) {
        for(int index = 0; index < x.size()-1;) {
            if(x.get(index) == i || x.get(index+1) == j || ((x.get(index) / 3) * 3 + x.get(index+1) / 3) == ((i / 3) * 3 + j / 3))
                return true;
            index += 2;
        }
        return false;
    }
}
