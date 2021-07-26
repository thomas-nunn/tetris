/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import controller.Board;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;


/**
 * A GUI class for holding the Tetris game panel and controls.
 * 
 * @author Thomas Nunn
 * @version 6/1/2012
 */
@SuppressWarnings("serial")
public class TetrisFrame extends JFrame {


  /**
   * The JPanel that holds the main Tetris Board.
   */
  private final TetrisPanel my_board_panel;

  /**
   * A Box for holding the panels that show game stats and the
   * Start/Pause button.
   */
  private final StatsBox my_stat_box;

  /**
   * A menu bar for the GUI.
   */
  private final JMenuBar my_menu_bar = new JMenuBar();

  /**
   * Constructs a TetrisFrame object and initializes fields of the class.
   */
  public TetrisFrame() {
    super("TETRIS");
    my_board_panel = new TetrisPanel(this);
    my_stat_box = new StatsBox(my_board_panel);
    TETRISWAVES.init();
  }

  /**
   * Starts the GUI by building the JFrame and making it visible.
   */
  private void start() {

    my_board_panel.addKeyListener(new KeyAction(my_board_panel));
    my_board_panel.setFocusable(true);

    add(my_board_panel);
    add(my_stat_box, BorderLayout.EAST);
    buildMenuBar();
    setJMenuBar(my_menu_bar);

    setResizable(false);
    setSize(getPreferredSize());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    pack();
  }

  /**
   * Builds the JMenuBar for the Tetris game.
   */
  private void buildMenuBar() {

    final TetrisMenu file_menu = new TetrisMenu("File");
    final TetrisMenu options_menu = new TetrisMenu("Options");
    final TetrisMenu help_menu = new TetrisMenu("Help");
    
    file_menu.setMnemonic(KeyEvent.VK_F);
    options_menu.setMnemonic(KeyEvent.VK_O);
    help_menu.setMnemonic(KeyEvent.VK_H);

    file_menu.createMenuItem(new EndGameAction());
    file_menu.createMenuItem(new NewGameAction());
    file_menu.createMenuItem(new ExitAction());

    help_menu.createMenuItem(new HelpAction());
    help_menu.createMenuItem(new AboutAction());

    options_menu.createCheckBoxItem(new MusicAction());

    my_menu_bar.add(file_menu);
    my_menu_bar.add(options_menu);
    my_menu_bar.add(help_menu);
  }

  /**
   * Starts the game by creating a TetrisFrame and calling
   * its start() method.
   * 
   * @param the_args Ignored in this class.
   */
  public static void main(final String[] the_args) {
    
    for (String s : the_args) {
      System.out.println(s);
    }
    
    final TetrisFrame tf = new TetrisFrame();
    tf.start();

  }

  /**
   * An action class for the file menu Quit option that exits the program.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class ExitAction extends AbstractAction {

    /**
     * Constructs an ExitAction object with name and mnemonic.
     */
    public ExitAction() {
      super();
      putValue(Action.NAME, "Quit");
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_Q);
    }

    /**
     * Opens a dialog to make sure the user wants to quit the game.
     * If yes, then the program exits.
     * 
     * @param the_event The Action Event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_event) {

      final int x = JOptionPane.showConfirmDialog(TetrisFrame.this,
          "Are you sure you want to quit?");
      if (x == 0) {
        System.exit(0);
      }
    }
  }

  /**
   * An action class for restarting the game.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class NewGameAction extends AbstractAction {

    /**
     * Constructs a Restart object with name and mnemonic.
     */
    public NewGameAction() {
      super();
      putValue(Action.NAME, "New Game");
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_N);
    }

    /**
     * Disposes of the current TetrisFrame and then creates a new TetrisFrame.
     * 
     * @param the_arg The Action event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_arg) {

      final int selection = JOptionPane.
          showConfirmDialog(TetrisFrame.this, "Would you like to start a new game?");

      if (selection == 0)  {

        TETRISWAVES.BACKGROUND_MUSIC.stop();
        TETRISWAVES.BACKGROUND_MUSIC.reset();
        dispose();
        my_board_panel.my_game_board = new Board();
        final String[] args = {""};
        main(args);
      }
    }
  }

  /**
   * An action class for the Help menu item Instructions.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class HelpAction extends AbstractAction {

    /**
     * Constructs a HelpAction object with name and mnemonic.
     */
    public HelpAction() {
      super();
      putValue(Action.NAME, "Instructions");
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_I);
    }

    /**
     * Displays the game instructions.
     * 
     * @param the_arg The Action event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_arg) {
      final String message = "Objective:\n" +
          "Score as many points\nas possible by filling rows.\n\n" +
          "Scoring: \n1 Row    =    100 points\n2 Rows  =    400 points\n" +
          "3 Rows  =    900 points\n4 Rows  =  1600 points";
      JOptionPane.showMessageDialog(TetrisFrame.this, message, "Tetris Instructions", 0);      
    }
  }

  /**
   * A class for choosing whether background music plays or not.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class MusicAction extends AbstractAction {

    /**
     * Constsructs a MusicAction object with name and mnemonic.
     */
    public MusicAction() {
      super();
      putValue(Action.NAME, "Background Music");
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_B);
    }

    /**
     * @param the_arg The Action event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_arg) {

      if (TETRISWAVES.BACKGROUND_MUSIC.isRunning()) {
        TETRISWAVES.BACKGROUND_MUSIC.stop();
      } else {
        TETRISWAVES.BACKGROUND_MUSIC.reset();
        TETRISWAVES.BACKGROUND_MUSIC.play();
      }
      
    }
  }

  /**
   * An action class for ending the current game but leaving the
   * current state of play viewable.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class EndGameAction extends AbstractAction {

    /**
     * Constructs and EndGameAction object with name and mnemonic.
     */
    public EndGameAction() {
      super();
      putValue(Action.NAME, "End Game");
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_E);

    }

    /**
     * Opens a dialog for confirming that the user wants to end the game.
     * If yes is selected the current game ends.
     * 
     * @param the_arg The Action event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_arg) {

      final int selection = JOptionPane.
          showConfirmDialog(TetrisFrame.this, "Do you want to end this game?");

      if (selection == 0)  {
        my_stat_box.getPausePanel().getTetrisAction().getTimer().stop();
        my_stat_box.getPausePanel().getStartPauseButton().setEnabled(false);
        TETRISWAVES.BACKGROUND_MUSIC.stop();
        TETRISWAVES.BACKGROUND_MUSIC.reset();
        my_board_panel.setEnabled(false);
      }

    }

  }
  
  /**
   * An action class for the About button.
   * 
   * @author Thomas Nunn
   * @version 6/1/2012
   */
  private class AboutAction extends AbstractAction {
    
    /**
     * The title for the menu item and dialog.
     */
    private static final String MY_TITLE = "About...";
    
    /**
     * Constructs an AboutAction object with name and mnemonic.
     */
    public AboutAction() {
      super();
      putValue(Action.NAME, MY_TITLE);
      putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
    }
    
    /**
     * Opens a message dialog.
     * 
     * @param the_event The action event.
     */
    @Override
    public void actionPerformed(final ActionEvent the_event) {
      JOptionPane.showMessageDialog(TetrisFrame.
                                    this, "TCSS 305 Tetris Project, Spring 2012", MY_TITLE, 0);

    }
  
  }

}
