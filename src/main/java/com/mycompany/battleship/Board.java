/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

/**
 *
 * @author Wuyuan
 */
public class Board {

    private int SIZE = 10;
    private String[][] board = new String[SIZE][SIZE];

    Board() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "-";
            }
        }
    } //end constructor

    public String toString() {
        String sBoard = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sBoard += (board[i][j] + " ");
                if (j == (SIZE - 1)) {
                    sBoard += "\n";
                }
            }
        }
        return sBoard;
    }

    public Boolean addShip(int row, int col, int len, boolean horizontal) {
        if (len <= 0) {
            return false;
        }
        if (horizontal) {
            int end = col + len;
            // check for out of bound
            if (end > SIZE) {
                return false;
            }
            // check for intersection
            for (int i = col; i < end; i++) {
                if (!board[row][i].equals("-")) {
                    return false;
                }
            }
            
            for (int i = col; i < end; i++) {
                board[row][i] = "b";
            }
        } else {
            int end = row + len;
            // check for out of bound
            if (end > SIZE) {
                return false;
            }
            
            // check for intersection
            for (int i = row; i < end; i++) {
                if (!board[i][col].equals("-")) {
                    return false;
                }
            }
            
            for (int i = row; i < end; i++) {
                board[i][col] = "b";
            }
        }
        
        return true;
    }
    
    public boolean foundShip(int len) {
        int foundShipLen = 0;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col ++) {
                if ((col + len) >= SIZE) {
                    break;
                }
                
                if ((row + len) >= SIZE) {
                    break;
                }
                
                // check horizontal ships
                for (int i = 0; i < len; i++) {
                    if (board[row][col+i] == "b") {
                        foundShipLen++;
                    }
                }
                if (foundShipLen == len) {
                    return true;
                }
                foundShipLen = 0; //reset foundShipLen
                
                // check vertical ships
                for (int i = 0; i < len; i++) {
                    if (board[row+i][col] == "b") {
                        foundShipLen++;
                    }
                }
                if (foundShipLen == len) {
                    return true;
                }
                foundShipLen = 0;
            }
        }
        return false;
    }
    
    public int shoot(int row, int col) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ((i != row) || (j != col)) {
                    continue;
                }
                if (board[row][col] == "b") {
                    board[row][col] = "x";
                    return 1;
                } else if (board[row][col] == "-") {
                    board[row][col] = "m";
                    return 0;
                } else {
                    return 2;
                }
            }
        }
        return 2;
    }

}
