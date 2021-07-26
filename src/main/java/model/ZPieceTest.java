package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Thomas Nunn
 * @version 4/19/2012
 * 
 */
public class ZPieceTest {
  
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
   * A Piece for testing.
   */
  private ZPiece my_z;

  /**
   * Creates a new Piece before each method is run.
   */
  @Before
  public void setUp() {
    my_z = new ZPiece(0, 0);
  }

  /**
   * Test initial position.
   */
  @Test
  public void testInitialPosition() {
    Assert.assertArrayEquals(MY_0_Z, my_z.getCoords());
  }
  
  /**
   * Test rotate method.
   */
  @Test
  public void testRotate() {
    Assert.assertArrayEquals(MY_90_Z, my_z.rotate().getCoords());
  }
  
  /**
   * Test rotate method twice.
   */
  @Test
  public void testRotateTwice() {
    Assert.assertArrayEquals(MY_0_Z, my_z.rotate().rotate().getCoords());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testLeft() {
    assertEquals("X value should be -1", -1, my_z.moveLeft().getX());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testRight() {
    assertEquals("X value should be 1", 1, my_z.moveRight().getX());
  }

  /**
   * Test moveLeft method.
   */
  @Test
  public void testDown() {
    assertEquals("Y value should be 1", 1, my_z.moveDown().getY());
  }
  
  /**
   * Test moveLeft and moveRight and moveDown.
   */
  @Test
  public void testAllMoves() {
    assertEquals("X value should be 0", 0, my_z.moveLeft().moveRight().getX());
    assertEquals("Y value should be 2", 2, my_z.moveDown().moveRight().moveDown().getY());
  }
}
