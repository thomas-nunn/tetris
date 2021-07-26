/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import controller.Board;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Piece;

/**
 * A class for displaying a Tetris board in a JPanel.
 * 
 * @author Thomas Nunn
 * @version 6/1/2012
 */
@SuppressWarnings("serial")
public class TetrisPanel extends JPanel implements Observer {
  

  /**
   * Determines the grid spacing.
   */
  private static final int GRID_SPACING = 30;

  /**
   * The title for the menu item and dialog.
   */
  private static final String MY_GAME_OVER = "Game Over";

  /**
   * The Tetris Board.
   */
  protected Board my_game_board;

  /**
   * The default size of this panel.
   */
  private final Dimension my_board_dimensions;

  /**
   * The next Piece to drop.
   */
  private Piece my_next_piece;
  
  /**
   * The JFrame that holds this panel.
   */
  private final TetrisFrame my_frame;
  
  /**
   * Constructs a new TetrisPanel object and initializes the fields of
   * the class. 
   * 
   * @param the_frame The Tetris frame.
   */
  public TetrisPanel(final TetrisFrame the_frame) {
    super();
    my_frame = the_frame;
    my_game_board = new Board();
    my_board_dimensions = new Dimension(my_game_board.getBoardDimensions());
    my_next_piece = my_game_board.getNextPiece();
    my_game_board.addObserver(this);
    buildPanel();
  }

  /**
   * Advances the game one step by moving the current
   * Piece down.
   */
  public void step() {
    my_game_board.step();
    repaint();
  }

  /**
   * Moves the current Piece to the right.
   */
  public void moveRight() {
    my_game_board.moveRight();
    repaint();
  }

  /**
   * Moves the current Piece to the left.
   */
  public void moveLeft() {
    my_game_board.moveLeft();
    repaint();
  }

  /**
   * Rotates the current Piece.
   */
  public void rotate() {
    my_game_board.rotate();
    repaint();
  }

  /**
   * Drops a Piece all the way down.
   */
  public void dropDown() {
    my_game_board.moveLeft();
    repaint();
  }

  /**
   * Builds the JPanel.
   */
  private void buildPanel() {
    final int width = my_board_dimensions.width * GRID_SPACING;
    final int height = my_board_dimensions.height * GRID_SPACING;
    final Dimension game_dimensions = new Dimension(width, height);
    setPreferredSize(game_dimensions);
  }

  /**
   * Paints the JPanel with the Tetris Board representation.
   * 
   * @param the_graphics The Graphics object.
   */
  @Override
  public void paintComponent(final Graphics the_graphics) {
    super.paintComponent(the_graphics);
    final Graphics2D g2d = (Graphics2D) the_graphics;

    int x = 0;
    int y = 0;

    for (int i = 0; i < my_game_board.getMyBoard().length; i++) {
      for (int j = 0; j < my_game_board.getMyBoard()[i].length; j++) {

        g2d.setColor(my_game_board.getMyBoard()[i][j]);
        g2d.fill(new Rectangle2D.Double(x, y, GRID_SPACING, GRID_SPACING));
        x += GRID_SPACING;

      }
      y += GRID_SPACING;
      x = 0;
    }
    drawGrid(g2d);
  }

  /**
   * Helper method for paintCompenent that draws a grid.
   * 
   * @param the_graphics The graphics object for drawing.
   */
  private void drawGrid(final Graphics2D the_graphics) {
    final Graphics2D g2d = (Graphics2D) the_graphics;
    g2d.setColor(Color.BLACK);
    for (int i = 0; i < this.getHeight(); i += GRID_SPACING) {
      g2d.drawLine(i, 0, i, this.getHeight());
      g2d.drawLine(0, i, this.getWidth(), i);
    }
  }

  /**
   * Notifies the user that the game is over and offers a
   * replay option.
   * 
   * @param the_observed The Observed object.
   * @param the_arg The passed in data.
   */
  @Override
  public void update(final Observable the_observed, final Object the_arg) {
    
    if (the_arg instanceof Boolean) {
      TETRISWAVES.GAME_OVER.play();
      TETRISWAVES.BACKGROUND_MUSIC.stop();

      JOptionPane.showMessageDialog(this, MY_GAME_OVER, MY_GAME_OVER, 0);
      final int selection = JOptionPane.
          showConfirmDialog(this, "Would you like to play again?");
      
      if (selection == 0) {

        my_frame.dispose();
        my_game_board = new Board();
        final String[] args = {""};
        TetrisFrame.main(args);
        TETRISWAVES.GAME_OVER.reset();
        TETRISWAVES.BACKGROUND_MUSIC.reset();

      } else {
        System.exit(0);
      }
      
    }
  }

  /**
   * @return The next Piece to drop.
   */
  public Piece getNextPiece() {
    my_next_piece = my_game_board.getNextPiece();
    return my_next_piece;
  }
}
