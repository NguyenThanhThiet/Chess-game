/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public abstract class Piece {
    private int x;
    private int y;
    private int row;
    private int column;
    private Image img;
    private Color color;
    private int preRow;
    private int preCol;
    private int  beHint;

    public Piece(int column, int row, Color color) {
        this.row = row;
        this.column = column;
        this.preRow=row;
        this.preCol=column;
        this.color = color;
        x=column*chess_game.Chess_Game.sizeSquare;
        y=row*chess_game.Chess_Game.sizeSquare;
    }

    public void Draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, chess_game.Chess_Game.sizeSquare, chess_game.Chess_Game.sizeSquare, null);
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

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPreRow() {
        return preRow;
    }

    public void setPreRow(int preRow) {
        this.preRow = preRow;
    }

    public int getPreCol() {
        return preCol;
    }

    public void setPreCol(int preCol) {
        this.preCol = preCol;
    }
    public boolean isIntoBroad(int targetRow, int targetCol)
    {
        if(targetRow<=7 && targetRow>=0 && targetCol<=7 && targetCol>=0)
            return true;
        else 
            return false;
    }
    public abstract boolean canMove(int targetRow, int targetCol);
    public Piece getEnermyPiece(int targetRow, int targetCol, ArrayList<Piece> pieces)
    {
        beHint=-1;
        for(Piece p:pieces)
        {
            if(p.getRow()==targetRow && p.getColumn()==targetCol && p!=this ){
                if(p.getColor()!=color)
                    beHint=pieces.indexOf(p);
                return p;
            }
        }
        
        return null;
    }

    public boolean isEnermyLine(int targetRow, int targetCol)
    {
        if(Math.abs(targetRow-preRow)==0)
        {
            if (targetCol - preCol > 0) {
                for (int i = preCol + 1; i <= targetCol; i++) {
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == targetRow && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                             return false;
                        }
                    }

                }
            }else
            {
                for (int i = preCol - 1; i >= targetCol; i--) {
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == targetRow && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                            return false;
                        }
                    }

                }
            }
        }else
        {
           if (targetRow - preRow > 0) {
                for (int i = preRow + 1; i <= targetRow; i++) {
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == i && p.getColumn() == targetCol && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                            return false;
                        }
                    }
                }
            }else
            {
                for (int i = preRow - 1; i >= targetRow; i--) {
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == i && p.getColumn() == targetCol && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                            return false;
                        }
                    }

                }
            } 
        }
        return true;
    }

    public boolean isEnermyCrossOver(int targetRow, int targetCol) {
       if(targetRow-preRow>0)
        {
            if (targetCol - preCol > 0) {//down right
                for (int i = preCol + 1; i <= targetCol; i++) {
                    int diff=Math.abs(i-preCol);
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == diff+preRow && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                             return false;
                        }
                    }

                }
            }else
            {
                for (int i = preCol - 1; i >= targetCol; i--) {//down left
                    int diff=Math.abs(i-preCol);
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == preRow+diff && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                            return false;
                        }
                    }

                }
            }
        }else
        {
           if (targetCol - preCol > 0) {//up right
                for (int i = preCol + 1; i <= targetCol; i++) {
                    int diff=Math.abs(i-preCol);
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == preRow-diff && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                             return false;
                        }
                    }

                }
            }else
            {
                for (int i = preCol - 1; i >= targetCol; i--) {//up left
                    int diff=Math.abs(i-preCol);
                    for (Piece p : chess_game.Chess_Game.pieces) {
                        if (p.getRow() == preRow-diff && p.getColumn() == i && p != this) {
                            if(p.getColor()!=color && p.getRow()==targetRow && p.getColumn()==targetCol)
                                return true;
                            else
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }
    public int getBeHint() {
        return beHint;
    }

    public void setBeHint(int beHint) {
        this.beHint = beHint;
    }
}
