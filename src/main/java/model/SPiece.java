/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of S shaped Pieces that have two distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class SPiece extends AbstractPiece {

  /**
   * Represents an S Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_S = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(1, 0), 
    new ImmutablePoint(1, -1), new ImmutablePoint(2, -1)  
  };

  /**
   * Represents an S Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_S = { 
    new ImmutablePoint(0, -1), new ImmutablePoint(0, -2), 
    new ImmutablePoint(1, 0), new ImmutablePoint(1, -1)
  };
  
  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_s_state;

  /**
   * Constructs an S Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public SPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_S);
    my_s_state = MY_0_S;
  }
  
  /**
   * Constructs an S Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private SPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_s_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_s_state, MY_0_S)) {
      result = new SPiece(this.getX(), this.getY(), MY_90_S);
    } else {
      result = new SPiece(this.getX(), this.getY(), MY_0_S);
    }

    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new SPiece(getX() - 1, getY(), my_s_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new SPiece(getX() + 1, getY(), my_s_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new SPiece(getX(), getY() + 1, my_s_state);
  }
}
