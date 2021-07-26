/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Superclass for Piece objects.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public abstract class AbstractPiece implements Piece {

  /**
   * A coordinate grid for displaying a Piece.
   */
  private static final ImmutablePoint[][] MY_GRID = {
    {new ImmutablePoint(0, 3), new ImmutablePoint(1, 3), 
      new ImmutablePoint(2, 3), new ImmutablePoint(3, 3)},
    {new ImmutablePoint(0, 2), new ImmutablePoint(1, 2), 
      new ImmutablePoint(2, 2), new ImmutablePoint(3, 2)},
    {new ImmutablePoint(0, 1), new ImmutablePoint(1, 1), 
      new ImmutablePoint(2, 1), new ImmutablePoint(3, 1)},
    {new ImmutablePoint(0, 0), new ImmutablePoint(1, 0), 
      new ImmutablePoint(2, 0), new ImmutablePoint(3, 0)}
  };

  /**
   * The x coordinate of this Piece on the board.
   */
  private final int my_x;

  /**
   * The y coordinate of this Piece on the board.
   */
  private final int my_y;

  /**
   * Represents the current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_state;
  
  /**
   * Super Constructor for the Piece classes.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of this Piece.
   */
  public AbstractPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    my_x = the_x;
    my_y = the_y;
    my_state = copyCoords(the_coords);
  }
  
  /**
   * Makes a copy of an ImmutablePoint array.
   * 
   * @param the_array_to_copy The array to be copied.
   * @return A deep copy of an array.
   */
  protected final ImmutablePoint[] copyCoords(final ImmutablePoint[] the_array_to_copy) {
    final ImmutablePoint[] result = new ImmutablePoint[the_array_to_copy.length];
    System.arraycopy(the_array_to_copy, 0, result, 0, result.length);
    return result;
  }
  
  /**
   * Gives a Piece's board coordinates.
   * 
   * @return The board coordinates.
   */
  public ImmutablePoint[] getBoardCoords() {
    final ImmutablePoint[] result = new ImmutablePoint[my_state.length];
    
    for (int i = 0; i < my_state.length; i++) {
      final double temp_x = my_state[i].getX();
      final double temp_y = my_state[i].getY();
      result[i] = new ImmutablePoint(temp_x + my_x, temp_y + my_y);
    }
    
    return result;
  }

  /**
   * Gives the x coordinate of this Piece on the board.
   * 
   * @return The x coordinate.
   */
  @Override
  public int getX() {
    return my_x;
  }

  /**
   * Gives the y coordinate of this Piece on the board.
   * 
   * @return The y coordinate.
   */
  @Override
  public int getY() {
    return my_y;
  } 
  
  /**
   * Gives the local coordinates of a Piece.
   * 
   * @return The local coordinates.
   */
  public ImmutablePoint[] getCoords() {
    return copyCoords(my_state);
  }
  
  /**
   * Tests if a Piece contains a specific Point coordinate.
   * 
   * @param the_point The Immutable Point to look for.
   * @return True if the Piece contains the point.
   */
  public boolean containsPoint(final ImmutablePoint the_point) {
    boolean result = false;
    final ImmutablePoint[] piece_coords = getBoardCoords();
    
    for (ImmutablePoint ip : piece_coords) {
      
      if (ip.equals(the_point)) {
        result = true;
        break;
      }
    }
    
    return result;
  }
  
  /**
   * Overridden toString that displays this Piece in a 4x4 grid.
   * 
   * @return The overridden toString of this Piece.
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < MY_GRID.length; i++) {
      for (int j = 0; j < MY_GRID.length; j++) {
        
        if (MY_GRID[i][j].equals(my_state[0]) || 
            MY_GRID[i][j].equals(my_state[1]) || 
            MY_GRID[i][j].equals(my_state[2]) || 
            MY_GRID[i][j].equals(my_state[2 + 1])) {
          sb.append("[]");
        } else {
          sb.append("  ");
        }

      }
      sb.append("\n");
    }
    return sb.toString();
  }
}
