/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of L shaped Pieces that have four distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class LPiece extends AbstractPiece {

  /**
   * Represents an L Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_L = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(0, -2), new ImmutablePoint(1, 0)  
  };

  /**
   * Represents an L Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_L = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(1, 0), 
    new ImmutablePoint(2, 0), new ImmutablePoint(2, -1)
  };
  
  /**
   * Represents an L Piece in the 180 degree position.
   */
  private static final ImmutablePoint[] MY_180_L = { 
    new ImmutablePoint(1, 0), new ImmutablePoint(1, -1), 
    new ImmutablePoint(1, -2), new ImmutablePoint(0, -2)
  };

  /**
   * Represents an L Piece in the 270 degree position.
   */
  private static final ImmutablePoint[] MY_270_L = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(1, -1), new ImmutablePoint(2, -1)
  };

  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_l_state;
  
  /**
   * Constructs an L Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public LPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_L);
    my_l_state = MY_0_L;
  }

  /**
   * Constructs an L Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private LPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_l_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_l_state, MY_0_L)) {
      result = new LPiece(this.getX(), this.getY(), MY_90_L);
      
    } else if (java.util.Arrays.equals(my_l_state, MY_90_L)) {
      result = new LPiece(this.getX(), this.getY(), MY_180_L);
      
    } else if (java.util.Arrays.equals(my_l_state, MY_180_L)) {
      result = new LPiece(this.getX(), this.getY(), MY_270_L);
      
    } else {
      result = new LPiece(this.getX(), this.getY(), MY_0_L);
    }
    
    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new LPiece(getX() - 1, getY(), my_l_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new LPiece(getX() + 1, getY(), my_l_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new LPiece(getX(), getY() + 1, my_l_state);
  }
}
