/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

/**
 *
 * @author dell
 */
public class King extends Piece{
    
    public King(int x, int y, Color color) {
        super(x, y, color);
    if(color==Color.WHITE)
            this.setImg(new ImageIcon("src\\source\\White_Pieces\\King.png").getImage());
        else
            this.setImg(new ImageIcon("src\\source\\Black_Pieces\\King.png").getImage());
    }
    @Override
    public boolean canMove(int targetRow, int targetCol)
    {
        if(isIntoBroad(targetRow, targetCol)){
            if(Math.abs(getPreRow()-targetRow)==1 && Math.abs(getPreCol()-targetCol)==1 || (Math.abs(getPreRow()-targetRow)+ Math.abs(getPreCol()-targetCol)==1))
            {
                Piece p=getEnermyPiece(targetRow, targetCol, chess_game.Chess_Game.pieces);
                if(p==null || p.getColor()!=getColor())
                   return true;
                else
                    return false;
            }
            else
                return false;
        }else
            return false;
    }
  
}
