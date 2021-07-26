/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package view;

import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * A class for creating Jmenus with JmenuItems.
 * 
 * @author Thomas Nunn
 * @version 6/1/2012
 */
@SuppressWarnings("serial")
public class TetrisMenu extends JMenu {
  
  
  /**
   * Constructs a Menu object with name.
   * 
   * @param the_name The Menu name.
   */
  public TetrisMenu(final String the_name) {
    super();
    setText(the_name);
  }
  
  /**
   * Create a JMenuItem and add it to the JMenu.
   * @param the_action The action listener for the item.
   */
  public void createMenuItem(final Action the_action) {
    final JMenuItem menu_item = new JMenuItem(the_action);
    add(menu_item);
  }
  
  /**
   * Create a JCheckBoxMenuItem and add it to the JMenu.
   * 
   * @param the_action The action listener for the item.
   */
  public void createCheckBoxItem(final Action the_action) {
    final JCheckBoxMenuItem check_item = new JCheckBoxMenuItem(the_action);
    check_item.setSelected(true);
    add(check_item);
  }
}
