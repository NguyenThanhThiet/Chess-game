/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess_game.Board;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;
import javax.swing.JComponent;

/**
 *
 * @author dell
 */
public class JSquare extends JComponent{
    private int x;
    private int y;
    private int with;
    private int height;
    private Color color;
    private Color outLine;

    public JSquare( int x,int y,int with, int height, Color color) {
        this.x=x;
        this.y=y;
        this.with = with;
        this.height = height;
        this.color = color;
        outLine=null;
        
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                 selectSquare();
            }
            
        });
    }

    public Color getOutLine() {
        return outLine;
    }

    public void setOutLine(Color outLine) {
        this.outLine = outLine;
    }
 
    public void Draw(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fillRect(x, y, with, with);
        if (outLine != null) {
            g2d.setColor(outLine);
            g2d.setStroke(new BasicStroke(3));
            g2d.drawRect(0, 0, with , height );
        }
    }
    
    public void selectSquare()
    {
        setOutLine(Color.BLUE);
    }

    public int getWith() {
        return with;
    }

    public void setWith(int with) {
        this.with = with;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}
