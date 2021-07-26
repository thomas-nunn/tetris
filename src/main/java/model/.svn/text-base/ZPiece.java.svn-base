/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of Z shaped Pieces that have two distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class ZPiece extends AbstractPiece {

  /**
   * Represents an Z Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_Z = { 
    new ImmutablePoint(0, -1), new ImmutablePoint(1, 0), 
    new ImmutablePoint(1, -1), new ImmutablePoint(2, 0)  
  };

  /**
   * Represents an Z Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_Z = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(1, -1), new ImmutablePoint(1, -2)
  };
  
  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_z_state;

  /**
   * Constructs a Z Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public ZPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_Z);
    my_z_state = MY_0_Z;
  }

  /**
   * Constructs a Z Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private ZPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_z_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_z_state, MY_0_Z)) {
      result = new ZPiece(this.getX(), this.getY(), MY_90_Z);
    } else {
      result = new ZPiece(this.getX(), this.getY(), MY_0_Z);
    }

    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new ZPiece(getX() - 1, getY(), my_z_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new ZPiece(getX() + 1, getY(), my_z_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new ZPiece(getX(), getY() + 1, my_z_state);
  }
}
