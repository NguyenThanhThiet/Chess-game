/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author dell
 */
public class Pawn extends Piece{
    
      
    public Pawn(Color color, int x, int y) {
        super(x, y, color);
        if(color==Color.WHITE)
            this.setImg(new ImageIcon("src\\source\\White_Pieces\\Pawn.png").getImage());
        else
            this.setImg(new ImageIcon("src\\source\\Black_Pieces\\Pawn.png").getImage());
    }

    @Override
    public boolean canMove(int targetRow, int targetCol) {
        if (isIntoBroad(targetRow, targetCol)) {
            if (getPreRow() == 1 || getPreRow() == 6) {
                if (((Math.abs(targetRow-getPreRow())==1) && targetCol>= getPreCol()-1 && targetCol<=getPreCol()+1)
                        || (Math.abs(targetCol-getPreCol())==0 && Math.abs(targetRow-getPreRow())==2)) {
                    if ((getColor() == Color.BLACK && targetRow - getPreRow() < 0) || (getColor() == Color.WHITE && targetRow - getPreRow() > 0)) {
                        return false;
                    }
                    Piece p = getEnermyPiece(targetRow, targetCol, chess_game.Chess_Game.pieces);
                    if(p == null && Math.abs(targetCol-getPreCol())==0)
                        return true;
                    else if(p!=null &&p.getColor() != getColor() && Math.abs(targetCol-getPreCol())==1)
                    {
                        return true;
                    }else
                        return false;
                } else {
                    return false;
                }
            } else {
                if ((Math.abs(targetRow-getPreRow())==1) && targetCol>= getPreCol()-1 && targetCol<=getPreCol()+1) {
                    if ((getColor() == Color.BLACK && targetRow - getPreRow() < 0) || (getColor() == Color.WHITE && targetRow - getPreRow() > 0)) {
                        return false;
                    }
                    Piece p = getEnermyPiece(targetRow, targetCol, chess_game.Chess_Game.pieces);
                    if(p == null && Math.abs(targetCol-getPreCol())==0)
                        return true;
                    else if(p!=null &&p.getColor() != getColor() && Math.abs(targetCol-getPreCol())==1)
                    {
                        return true;
                    }else
                        return false;
                    
                } else {
                    return false;
                }

            }
        }
            else {
            return false;
        }
    }

    
    //2/3 1/4 2/4 3/4 2/5
}
