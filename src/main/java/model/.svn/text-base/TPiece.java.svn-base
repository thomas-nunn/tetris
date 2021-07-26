/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of T shaped Pieces that have four distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class TPiece extends AbstractPiece {
  
  /**
   * Represents an T Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_T = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(1, 0), 
    new ImmutablePoint(1, -1), new ImmutablePoint(2, 0)  
  };

  /**
   * Represents an T Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_T = { 
    new ImmutablePoint(0, -1), new ImmutablePoint(1, 0), 
    new ImmutablePoint(1, -1), new ImmutablePoint(1, -2)
  };
  
  /**
   * Represents an T Piece in the 180 degree position.
   */
  private static final ImmutablePoint[] MY_180_T = { 
    new ImmutablePoint(0, -1), new ImmutablePoint(1, 0), 
    new ImmutablePoint(1, -1), new ImmutablePoint(2, -1)
  };

  /**
   * Represents an T Piece in the 270 degree position.
   */
  private static final ImmutablePoint[] MY_270_T = { 
    new ImmutablePoint(1, 0), new ImmutablePoint(1, -1), 
    new ImmutablePoint(1, -2), new ImmutablePoint(2, -1)
  };

  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_t_state;

  /**
   * Constructs a T Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public TPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_T);
    my_t_state = MY_0_T;
  }

  /**
   * Constructs a T Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private TPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_t_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_t_state, MY_0_T)) {
      result = new TPiece(this.getX(), this.getY(), MY_90_T);
      
    } else if (java.util.Arrays.equals(my_t_state, MY_90_T)) {
      result = new TPiece(this.getX(), this.getY(), MY_180_T);
      
    } else if (java.util.Arrays.equals(my_t_state, MY_180_T)) {
      result = new TPiece(this.getX(), this.getY(), MY_270_T);
      
    } else {
      result = new TPiece(this.getX(), this.getY(), MY_0_T);
    }
    
    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new TPiece(getX() - 1, getY(), my_t_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new TPiece(getX() + 1, getY(), my_t_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new TPiece(getX(), getY() + 1, my_t_state);
  }
}
