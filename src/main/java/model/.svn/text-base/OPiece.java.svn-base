/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Allows the creation of O shaped Pieces that have one distinct
 * rotational state.
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 *
 */
public class OPiece extends AbstractPiece {
  
  /**
   * Represents an O Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_O = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(1, 0), new ImmutablePoint(1, -1)  
  };
  
  /**
   * Constructs an O Piece in the 0 degree position.
   * 
   * @param the_x The x coordinate of this Piece on the board.
   * @param the_y The y coordinate of this Piece on the board.
   */
  public OPiece(final int the_x, final int the_y) {
    super(the_x, the_y, MY_0_O);
  }

  /**
   * Rotates this Piece by returning itself.
   * 
   * @return This Piece.
   */
  @Override
  public Piece rotate() {
    return this;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveLeft() {
    return new OPiece(getX() - 1, getY());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveRight() {
    return new OPiece(getX() + 1, getY());
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Piece moveDown() {
    return new OPiece(getX(), getY() + 1);
  }
}
