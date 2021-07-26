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
public class TPieceTest {
  
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
   * A Piece for testing.
   */
  private TPiece my_t;

  /**
   * Creates a new Piece before each method is run.
   */
  @Before
  public void setUp() {
    my_t = new TPiece(0, 0);
  }

  /**
   * Test initial position.
   */
  @Test
  public void testInitialPosition() {
    Assert.assertArrayEquals(MY_0_T, my_t.getCoords());
  }
  
  /**
   * Test rotate method.
   */
  @Test
  public void testRotate() {
    Assert.assertArrayEquals(MY_90_T, my_t.rotate().getCoords());
  }
  
  /**
   * Test rotate method twice.
   */
  @Test
  public void testRotateTwice() {
    Assert.assertArrayEquals(MY_180_T, my_t.rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateThree() {
    Assert.assertArrayEquals(MY_270_T, my_t.rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateFour() {
    Assert.assertArrayEquals(MY_0_T, my_t.rotate().rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testLeft() {
    assertEquals("X value should be -1", -1, my_t.moveLeft().getX());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testRight() {
    assertEquals("X value should be 1", 1, my_t.moveRight().getX());
  }

  /**
   * Test moveLeft method.
   */
  @Test
  public void testDown() {
    assertEquals("Y value should be 1", 1, my_t.moveDown().getY());
  }
  
  /**
   * Test moveLeft and moveRight and moveDown.
   */
  @Test
  public void testAllMoves() {
    assertEquals("X value should be 0", 0, my_t.moveLeft().moveRight().getX());
    assertEquals("Y value should be 2", 2, my_t.moveDown().moveRight().moveDown().getY());
  }
}
