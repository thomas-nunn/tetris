/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import model.Piece;

/**
 * A KeyAdapter class that sets the controls for playing a 
 * Tetris game.
 * 
 * @author Thomas Nunn
 * @version 6/1/2012
 */
public class KeyAction extends KeyAdapter implements Observer {

  /**
   * The JPanel that holds the main Tetris Board.
   */
  private final TetrisPanel my_panel;

  /**
   * True if the current piece has frozen.
   */
  private boolean my_piece_froze;
  
  /**
   * True if the current game is over.
   */
  private Boolean my_game_is_over = false;

  /**
   * 
   * @param the_panel The Tetris Panel.
   */
  public KeyAction(final TetrisPanel the_panel) {
    super();
    my_panel = the_panel;
    my_panel.my_game_board.addObserver(this);
  }

  /**
   * Assigns keys for playing Tetris.
   * 
   * @param the_arg The KeyEvent.
   */
  @Override
  public void keyPressed(final KeyEvent the_arg) {

    final int key_code = the_arg.getKeyCode();

    if (key_code == KeyEvent.VK_LEFT) {
      my_panel.moveLeft();
    } else if (key_code == KeyEvent.VK_RIGHT) {
      my_panel.moveRight();
    } else if (key_code == KeyEvent.VK_DOWN) {
      my_panel.step();
    } else if (key_code == KeyEvent.VK_UP) {
      my_panel.rotate();
    } else if (key_code == KeyEvent.VK_SPACE && !my_game_is_over) {
      
      // drops a Piece to the bottom
      while (!my_piece_froze) {
        my_panel.step();
      }
    }
  }

  /**
   * @param the_arg The KeyEvent.
   */
  @Override
  public void keyReleased(final KeyEvent the_arg) {
    // Unused in this class
  }

  /**
   * @param the_arg The KeyEvent.
   */
  @Override
  public void keyTyped(final KeyEvent the_arg) {
    // Unused in this class
  }

  /**
   * Observes the Tetris Board for the current Piece freezing. When a 
   * the current Piece freezes the FREEZE sound effect is heard.
   * 
   * @param the_observable The observable object.
   * @param the_arg The observable's parameter.
   */
  @Override
  public void update(final Observable the_observable, final Object the_arg) {

    if (the_arg instanceof Piece) {
      my_piece_froze = true;
      TETRISWAVES.FREEZE.reset();
      TETRISWAVES.FREEZE.play();
    } else if (the_arg instanceof Boolean) {
      my_game_is_over = true;
    } else {
      my_piece_froze = false;
    }

  }
}
