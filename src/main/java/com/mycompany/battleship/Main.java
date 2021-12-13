/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;
import com.mycompany.battleship.Board;
/**
 *
 * @author Wuyuan
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        Board bs = new Board();
        Boolean shipAdded = bs.addShip(0, 0, 2, true);
        shipAdded = bs.addShip(9, 9, 2, true);
        System.out.print(bs);
    }
}
