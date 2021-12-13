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

}
