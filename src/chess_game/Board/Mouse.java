/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.Board;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author dell
 */
public class Mouse extends MouseAdapter{
    private int x;
    private int y;
    private boolean pressed;
    @Override
    public void mouseMoved(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        System.out.println("mouse Moved");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        System.out.println("mouse Dragged");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed=false;
        System.out.println("mouse Released");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed=true;    
        System.out.println("mouse Pressed");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
    
}
