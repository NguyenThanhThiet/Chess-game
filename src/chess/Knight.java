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
public class Knight extends Piece{
    
    public Knight(int x, int y, Color color) {
        super(x, y, color);
    if(color==Color.WHITE)
            this.setImg(new ImageIcon("src\\source\\White_Pieces\\Knight.png").getImage());
        else
            this.setImg(new ImageIcon("src\\source\\Black_Pieces\\Knight.png").getImage());
    }

    @Override
    public boolean canMove(int targetRow, int targetCol) {
        if(isIntoBroad(targetRow, targetCol)){
            if(Math.abs(targetCol-getPreCol())+Math.abs(targetRow-getPreRow())==3 && (Math.abs(targetCol-getPreCol())!=0 && Math.abs(targetRow-getPreRow())!=0))
            {
                Piece p=getEnermyPiece(targetRow, targetCol, chess_game.Chess_Game.pieces);
                if(p==null || p.getColor()!=getColor())
                {
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }else
            return false;
    }
   
}
