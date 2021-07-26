/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package model;

/**
 * Defines behaviors for Tetris pieces.
 * 
 * @author Alan Fowler
 * @version Spring 2012
 */
public interface Piece {
  
  /*
   * Classes which implement this interface will produce immutable objects.
   * Commands in implementing classes DO NOT modify field values,
   * instead they return a new Piece with modified field values.
   */

  /** 
   * Moves a Piece one space to the left.
   * 
   * @return a new Piece shifted one space to the left of the current Piece. 
   */
  Piece moveLeft();

  /** 
   * Moves a Piece one space to the right.
   * 
   * @return a new Piece shifted one space to the right of the current Piece. 
   */
  Piece moveRight();

  /**
   * Moves a Piece one space down.
   * 
   * @return a new Piece shifted one space down from the current Piece. 
   */
  Piece moveDown();

  /** 
   * Rotates a Piece 90 degrees.
   * 
   * @return a new Piece rotated one quarter turn CCW from the state of the current Piece. 
   */
  Piece rotate();
  
  /**
   * Gives the coordinates of a Piece.
   * 
   * @return The coordinates.
   */
  ImmutablePoint[] getCoords();
  
  /**
   * Gives a Piece's board coordinates.
   * 
   * @return The board coordinates.
   */
  ImmutablePoint[] getBoardCoords();
  
  /**
   * Tests if a Piece contains a specific Point coordinate.
   * 
   * @param the_point The Immutable Point to look for.
   * @return True if the Piece contains the point.
   */
  boolean containsPoint(ImmutablePoint the_point);
  
  /**
   * Gives the x coordinate of this Piece.
   * 
   * @return the x coordinate of this Piece.
   */
  int getX();

  /**
   * Gives the y coordinate of this Piece.
   * 
   * @return the y coordinate of this Piece.
   */
  int getY();
}
