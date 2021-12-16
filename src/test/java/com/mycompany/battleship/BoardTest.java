/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.battleship;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wuyuan
 */
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of toString method, of class Board.
     */
    @org.junit.Test
    public void testToString() {
    }

    /**
     * Test of addShip method, of class Board.
     */
    @org.junit.Test
    public void testAddShip1() {
        Board bs = new Board();
        Boolean res = bs.addShip(0, 0, 1, true);
        assertEquals("test valid horizontal placement", res, true);
    }

    @org.junit.Test
    public void testAddShip2() {
        Board bs = new Board();
        Boolean res = bs.addShip(0, 0, 0, true);
        assertEquals("test horizontal ship length is zero", res, false);
    }
    
    @org.junit.Test
    public void testAddShip3() {
        Board bs = new Board();
        bs.addShip(0, 0, 4, true);
        Boolean res = bs.addShip(0, 3, 2, true);
        assertEquals("test horizontal intersection", res, false);
    }

    @org.junit.Test
    public void testAddShip4() {
        Board bs = new Board();
        bs.addShip(0, 0, 4, true);
        Boolean res = bs.addShip(0, 4, 2, true);
        assertEquals("test horizontal valid placement", res, true);
    }

    @org.junit.Test
    public void testAddShip5() {
        Board bs = new Board();
        Boolean res = bs.addShip(0, 9, 1, true);
        assertEquals("test horizontal valid placement", res, true);
    }
    
    @org.junit.Test
    public void testAddShip6() {
        Board bs = new Board();
        Boolean res = bs.addShip(0, 9, 2, true);
        assertEquals("test horizontal out of bound placement", res, false);
    }
    
    @org.junit.Test
    public void testAddShip7() {
        Board bs = new Board();
        Boolean res = bs.addShip(0, 9, 2, false);
        assertEquals("test vertical valid placement", res, true);
    }
    
    @org.junit.Test
    public void testAddShip8() {
        Board bs = new Board();
        bs.addShip(0, 9, 2, false);
        Boolean res = bs.addShip(1, 9, 2, false);
        assertEquals("test vertical intersect placement", res, false);
    }
    
    @org.junit.Test
    public void testAddShip9() {
        Board bs = new Board();
        bs.addShip(0, 9, 2, false);
        Boolean res = bs.addShip(2, 9, 2, false);
        assertEquals("test vertical valid placement", res, true);
    }
    
    @org.junit.Test
    public void testAddShip10() {
        Board bs = new Board();
        bs.addShip(0, 9, 2, false);
        Boolean res = bs.addShip(9, 9, 1, false);
        assertEquals("test vertical in bound placement", res, true);
    }
    
    @org.junit.Test
    public void testAddShip11() {
        Board bs = new Board();
        bs.addShip(0, 9, 2, false);
        Boolean res = bs.addShip(10, 9, 1, false);
        assertEquals("test vertical out of bound placement", res, false);
    }
    
    @org.junit.Test
    public void foundShip1() {
        Board bs = new Board();
        bs.addShip(0, 1, 2, true);
        boolean res = bs.foundShip(2);
        assertEquals("test found horizontal ship", res, true);
    }
    
    @org.junit.Test
    public void foundShip2() {
        Board bs = new Board();
        bs.addShip(0, 1, 2, true);
        boolean res = bs.foundShip(5);
        assertEquals("test no match", res, false);
    }

    @org.junit.Test
    public void foundShip3() {
        Board bs = new Board();
        bs.addShip(5, 5, 4, false);
        boolean res = bs.foundShip(4);
        assertEquals("test found vertical ship", res, true);
    }
    
    @org.junit.Test
    public void shoot1() {
        Board bs = new Board();
        bs.addShip(5, 5, 4, false);
        int res = bs.shoot(5, 5);
        assertEquals("hit ship", res, 1);
    }
    
    @org.junit.Test
    public void shoot2() {
        Board bs = new Board();
        bs.addShip(5, 5, 4, false);
        int res = bs.shoot(5, 6);
        assertEquals("miss ship", res, 0);
    }
    
    @org.junit.Test
    public void shoot3() {
        Board bs = new Board();
        bs.addShip(5, 5, 4, false);
        bs.shoot(5, 5);
        int res = bs.shoot(5, 5);
        assertEquals("miss ship", res, 2);
    }
}
