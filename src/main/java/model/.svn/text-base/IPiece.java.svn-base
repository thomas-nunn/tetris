/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of I shaped Pieces that have two distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class IPiece extends AbstractPiece {

  /**
   * Represents an I Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_I = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(0, -2), new ImmutablePoint(0, -3)
  };

  /**
   * Represents an I Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_I = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(1, 0), 
    new ImmutablePoint(2, 0), new ImmutablePoint(3, 0)
  };

  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_i_state;

  /**
   * Constructs an I Piece in the 0 position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public IPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_I);
    my_i_state = MY_0_I;
  }

  /**
   * Constructs an I Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private IPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_i_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_i_state, MY_0_I)) {
      result = new IPiece(this.getX(), this.getY(), MY_90_I);
    } else {
      result = new IPiece(this.getX(), this.getY(), MY_0_I);
    }

    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new IPiece(getX() - 1, getY(), my_i_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new IPiece(getX() + 1, getY(), my_i_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new IPiece(getX(), getY() + 1, my_i_state);
  }
}
