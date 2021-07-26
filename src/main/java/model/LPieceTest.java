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
public class LPieceTest {
  
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
   * A Piece for testing.
   */
  private LPiece my_l;

  /**
   * Creates a new IPiece before each method is run.
   */
  @Before
  public void setUp() {
    my_l = new LPiece(0, 0);
  }

  /**
   * Test initial position.
   */
  @Test
  public void testInitialPosition() {
    Assert.assertArrayEquals(MY_0_L, my_l.getCoords());
  }
  
  /**
   * Test rotate method.
   */
  @Test
  public void testRotate() {
    Assert.assertArrayEquals(MY_90_L, my_l.rotate().getCoords());
  }
  
  /**
   * Test rotate method twice.
   */
  @Test
  public void testRotateTwice() {
    Assert.assertArrayEquals(MY_180_L, my_l.rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateThree() {
    Assert.assertArrayEquals(MY_270_L, my_l.rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateFour() {
    Assert.assertArrayEquals(MY_0_L, my_l.rotate().rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testLeft() {
    assertEquals("X value should be -1", -1, my_l.moveLeft().getX());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testRight() {
    assertEquals("X value should be 1", 1, my_l.moveRight().getX());
  }

  /**
   * Test moveLeft method.
   */
  @Test
  public void testDown() {
    assertEquals("Y value should be 1", 1, my_l.moveDown().getY());
  }
  
  /**
   * Test moveLeft and moveRight and moveDown.
   */
  @Test
  public void testAllMoves() {
    assertEquals("X value should be 0", 0, my_l.moveLeft().moveRight().getX());
    assertEquals("Y value should be 2", 2, my_l.moveDown().moveRight().moveDown().getY());
  }
}
