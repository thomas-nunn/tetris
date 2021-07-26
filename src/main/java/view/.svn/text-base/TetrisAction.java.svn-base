/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractAction;
import javax.swing.Timer;


/**
 * A class for running the Tetris game with a timer.
 * 
 * @author Thomas Nunn
 * @version 6/1/2012
 */
@SuppressWarnings("serial")
public class TetrisAction extends AbstractAction implements Observer {
  
  /**
   * The initial timer delay.
   */
  private static final int TIMER_SETTING = 800;
  
  /**
   * The JPanel that holds the main Tetris Board.
   */
  private final TetrisPanel my_panel;
  
  /**
   * The timer for running the Tetris game.
   */
  private final Timer my_timer;

  /**
   * Constructs a new TetrisAction object.
   * 
   * @param the_panel The TetrisPanel.
   */
  public TetrisAction(final TetrisPanel the_panel) {
    super();
    my_panel = the_panel;
    my_timer = new Timer(TIMER_SETTING, this);
    my_panel.my_game_board.addObserver(this);
  }
  
  /**
   * @return The my_timer field.
   */
  public Timer getTimer() {
    return my_timer;
  }

  /**
   * Moves the current Tetris Piece down by one step.
   * 
   * @param the_arg The action event.
   */
  @Override
  public void actionPerformed(final ActionEvent the_arg) {
    my_panel.step();
  }

  /**
   * Stops the timer when the game is over.
   * 
   * @param the_observable The observable object.
   * @param the_arg The observable's parameter.
   */
  @Override
  public void update(final Observable the_observable, final Object the_arg) {
    
    if (the_arg instanceof Boolean) {
      my_timer.stop();
    }
    
    if (the_arg instanceof Character) {
      
      if ((Character) the_arg == 'a') {
        TETRISWAVES.ROTATE_DENIED.reset();
        TETRISWAVES.ROTATE_DENIED.play();

      } else {
        TETRISWAVES.ROTATE_SOUND.reset();
        TETRISWAVES.ROTATE_SOUND.play();

      }
    }
  }
}
