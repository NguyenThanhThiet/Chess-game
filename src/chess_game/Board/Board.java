/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.Board;


import chess.Pawn;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author dell
 */
public class Board {
    private int row;
    private int column;
    private int sizeSquare;
    

    public Board(int row, int column, int sizeSquare) {
        this.row = row;
        this.column = column;
        this.sizeSquare = sizeSquare;         
    }
    public void Draw(Graphics2D g2d)
    {
        Color color;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if (i%2==0 ) {
                    if (j % 2 == 0) {
                        color = Color.decode("#dc9569");
                    } else {
                        color = Color.WHITE;
                    }
                } else {
                    if (j % 2 == 0) {
                        color = Color.WHITE;
                    } else {
                        color = Color.decode("#dc9569");
                    }
                }
                JSquare square = new JSquare(i*sizeSquare,j*sizeSquare,sizeSquare, sizeSquare, color); // Tạo ô vuông
                square.Draw(g2d);
            }
        }
        
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

    public int getSizeSquare() {
        return sizeSquare;
    }

    public void setSizeSquare(int sizeSquare) {
        this.sizeSquare = sizeSquare;
    }


    
   }
