/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chess_game;

import chess.Bishop;
import chess.King;
import chess.Knight;
import chess.Pawn;
import chess.Piece;
import chess.Queen;
import chess.Rook;
import chess_game.Board.Board;
import chess_game.Board.JSquare;
import chess_game.Board.Mouse;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;

public class Chess_Game extends JPanel implements Runnable{
    public static final int sizeSquare=80;
    private Board board=new Board(8,8,sizeSquare);
    public static ArrayList<Piece> pieces=new ArrayList<>();
    private Thread gameThread;
    private Mouse mouse=new Mouse();
    private Piece acticePiece;
    private Color currentColor=Color.BLACK;
    public Chess_Game()
    {
        setPreferredSize(new Dimension(640,640));
        setBackground(Color.WHITE);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        
        
        pieces.add(new Pawn(Color.BLACK, 0, 1));
        pieces.add(new Pawn(Color.BLACK, 1, 1));
        pieces.add(new Pawn(Color.BLACK, 2, 1));
        pieces.add(new Pawn(Color.BLACK, 3, 1));
        pieces.add(new Pawn(Color.BLACK, 4, 1));
        pieces.add(new Pawn(Color.BLACK, 5, 1));
        pieces.add(new Pawn(Color.BLACK, 6, 1));
        pieces.add(new Pawn(Color.BLACK, 7, 1));
        pieces.add(new Rook(0, 0,Color.BLACK));
        pieces.add(new Knight(1, 0,Color.BLACK));
        pieces.add(new Bishop(2, 0,Color.BLACK));
        pieces.add(new Queen(3, 0,Color.BLACK));
        pieces.add(new King(4, 0,Color.BLACK));
        pieces.add(new Bishop(5, 0,Color.BLACK));
        pieces.add(new Knight(6, 0,Color.BLACK));
        pieces.add(new Rook(7, 0,Color.BLACK));
        
        
        pieces.add(new Pawn(Color.WHITE, 0, 6));
        pieces.add(new Pawn(Color.WHITE, 1, 6));
        pieces.add(new Pawn(Color.WHITE, 2, 6));
        pieces.add(new Pawn(Color.WHITE, 3, 6));
        pieces.add(new Pawn(Color.WHITE, 4, 6));
        pieces.add(new Pawn(Color.WHITE, 5, 6));
        pieces.add(new Pawn(Color.WHITE, 6, 6));
        pieces.add(new Pawn(Color.WHITE, 7, 6));
        pieces.add(new Rook(0, 7,Color.WHITE));
        pieces.add(new Knight(1, 7,Color.WHITE));
        pieces.add(new Bishop(2, 7,Color.WHITE));
        pieces.add(new King(3, 7,Color.WHITE));
        pieces.add(new Queen(4, 7,Color.WHITE));
        pieces.add(new Bishop(5, 7,Color.WHITE));
        pieces.add(new Knight(6, 7,Color.WHITE));
        pieces.add(new Rook(7, 7,Color.WHITE));
    }
    
    public void lauch()
    {
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        Graphics2D g2d=(Graphics2D)g;
        board.Draw(g2d);
        for(Piece p:pieces)
        {
            p.Draw(g2d);
        }
        if(acticePiece!=null)
        {
            if (acticePiece.canMove(acticePiece.getRow(), acticePiece.getColumn())) {
                g2d.setColor(Color.RED);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                g2d.fillRect(acticePiece.getColumn() * sizeSquare, acticePiece.getRow() * sizeSquare, sizeSquare, sizeSquare);
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
                acticePiece.Draw(g2d);
            }else
            {
                
            }
        }
    }
    public void update()
    {
        if(mouse.isPressed())
        {
            System.out.println("X: "+mouse.getX()+",Y: "+mouse.getY());
            
            if(acticePiece==null)
            {
                System.out.println("Null");
                for(Piece p:pieces)
                {
                    System.out.println(p.getX());
                    if(p.getColumn()==mouse.getX()/sizeSquare && p.getRow()==mouse.getY()/sizeSquare && currentColor==p.getColor())
                    {
                        acticePiece=p;
                    }
                }
            }else
            {
                System.out.println("Not null");
                acticePiece.setX(mouse.getX()-(sizeSquare/2));
                acticePiece.setY(mouse.getY()-(sizeSquare/2));
                acticePiece.setRow((acticePiece.getY()+(sizeSquare/2))/sizeSquare);
                acticePiece.setColumn((acticePiece.getX()+(sizeSquare/2))/sizeSquare);
            }
        }
        if(!mouse.isPressed())
        {
            if(acticePiece!=null)
            {
                if (acticePiece.canMove(acticePiece.getRow(), acticePiece.getColumn())) {
                    int index=acticePiece.getBeHint();
                    if(index!=-1)
                        pieces.remove(index);
                    acticePiece.setPreRow(acticePiece.getRow());
                    acticePiece.setPreCol(acticePiece.getColumn());
                    acticePiece.setX(acticePiece.getColumn() * sizeSquare);
                    acticePiece.setY(acticePiece.getRow() * sizeSquare);
                    acticePiece = null;
                    currentColor=currentColor==Color.WHITE?Color.BLACK:Color.WHITE;
                    
                }else
                {
                    acticePiece.setColumn(acticePiece.getPreCol());
                    acticePiece.setRow(acticePiece.getPreRow());
                    acticePiece.setX(acticePiece.getColumn()* sizeSquare);
                    acticePiece.setY(acticePiece.getRow()* sizeSquare);
                    acticePiece = null;
                }
                
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame game=new JFrame();
        Chess_Game frame=new Chess_Game();
        
        
        
        
        JPanel jpanel=new JPanel();
        jpanel.setSize(800,800);
        jpanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        jpanel.add(frame,gbc);
        
        GridBagConstraints gbcBtnL = new GridBagConstraints();
        gbcBtnL.anchor = GridBagConstraints.EAST;
        
        
        game.add(jpanel);
        game.setSize(800,800);
        game.setVisible(true);
        game.setLocationRelativeTo(null);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.lauch();
    }
    public boolean checkWin()
    {
        
        boolean colorWhite=false;
        boolean colorBlack=false;
        for(Piece p:pieces)
        {
           if(p.getImg()==new ImageIcon("src\\source\\wk.png").getImage() || p.getImg()==new ImageIcon("src\\source\\bk.png").getImage() )
            {
                if(p.getColor()==Color.WHITE)
                    colorWhite=true;
                if(p.getColor()==Color.BLACK)
                    colorBlack=true;
            }
        }
        if(!colorWhite || !colorBlack)
        {
            System.out.println("WIN");
            if(!colorWhite)
             JOptionPane.showMessageDialog(this, "Đội đen thắng");
            else
              JOptionPane.showMessageDialog(this, "Đội trắng thắng");  
            return true;
        }
        return false;
    }
    @Override
    public void run() {
        double drawInterval=1000000000/60;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        while(gameThread!=null)
        {
             currentTime=System.nanoTime();
             delta+=(currentTime-lastTime)/drawInterval;
             if(delta>=1)
             {
                 update();
                 repaint();
//                 if(checkWin())
//                     break;
                 delta--;
             }
        }
    }
    
}
