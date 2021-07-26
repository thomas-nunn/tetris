/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of J shaped Pieces that have four distinct
 * rotational states.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class JPiece extends AbstractPiece {
  
  /**
   * Represents an J Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_J = { 
    new ImmutablePoint(1, -2), new ImmutablePoint(1, -1), 
    new ImmutablePoint(0, 0), new ImmutablePoint(1, 0)  
  };

  /**
   * Represents an J Piece in the 90 degree position.
   */
  private static final ImmutablePoint[] MY_90_J = { 
    new ImmutablePoint(0, -1), new ImmutablePoint(1, -1), 
    new ImmutablePoint(2, -1), new ImmutablePoint(2, 0)
  };
  
  /**
   * Represents an J Piece in the 180 degree position.
   */
  private static final ImmutablePoint[] MY_180_J = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(0, -2), new ImmutablePoint(1, -2)
  };

  /**
   * Represents an J Piece in the 270 degree position.
   */
  private static final ImmutablePoint[] MY_270_J = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(1, 0), new ImmutablePoint(2, 0)
  };

  /**
   * The current rotational state of this Piece.
   */
  private final ImmutablePoint[] my_j_state;

  /**
   * Constructs a J Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public JPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_J);
    my_j_state = MY_0_J;
  }

  /**
   * Constructs a J Piece in a rotated position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   * @param the_coords The coordinates of the new rotated Piece.
   */
  private JPiece(final int the_x, final int the_y, final ImmutablePoint[] the_coords) {
    super(the_x, the_y, the_coords);
    my_j_state = copyCoords(the_coords);
  }

  /**
   * Rotates this Piece in a counter-clockwise direction.
   * 
   * @return The new rotated Piece.
   */
  @Override
  public Piece rotate() {
    Piece result;
    
    if (java.util.Arrays.equals(my_j_state, MY_0_J)) {
      result = new JPiece(this.getX(), this.getY(), MY_90_J);
      
    } else if (java.util.Arrays.equals(my_j_state, MY_90_J)) {
      result = new JPiece(this.getX(), this.getY(), MY_180_J);
      
    } else if (java.util.Arrays.equals(my_j_state, MY_180_J)) {
      result = new JPiece(this.getX(), this.getY(), MY_270_J);
      
    } else {
      result = new JPiece(this.getX(), this.getY(), MY_0_J);
    }
    
    return result;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new JPiece(getX() - 1, getY(), my_j_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new JPiece(getX() + 1, getY(), my_j_state);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new JPiece(getX(), getY() + 1, my_j_state);
  }
}
