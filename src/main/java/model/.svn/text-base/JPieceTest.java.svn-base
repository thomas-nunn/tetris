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
public class JPieceTest {
  
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
   * A Piece for testing.
   */
  private JPiece my_j;

  /**
   * Creates a new Piece before each method is run.
   */
  @Before
  public void setUp() {
    my_j = new JPiece(0, 0);
  }

  /**
   * Test initial position.
   */
  @Test
  public void testInitialPosition() {
    Assert.assertArrayEquals(MY_0_J, my_j.getCoords());
  }
  
  /**
   * Test rotate method.
   */
  @Test
  public void testRotate() {
    Assert.assertArrayEquals(MY_90_J, my_j.rotate().getCoords());
  }
  
  /**
   * Test rotate method twice.
   */
  @Test
  public void testRotateTwice() {
    Assert.assertArrayEquals(MY_180_J, my_j.rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateThree() {
    Assert.assertArrayEquals(MY_270_J, my_j.rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateFour() {
    Assert.assertArrayEquals(MY_0_J, my_j.rotate().rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testLeft() {
    assertEquals("X value should be -1", -1, my_j.moveLeft().getX());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testRight() {
    assertEquals("X value should be 1", 1, my_j.moveRight().getX());
  }

  /**
   * Test moveLeft method.
   */
  @Test
  public void testDown() {
    assertEquals("Y value should be 1", 1, my_j.moveDown().getY());
  }
  
  /**
   * Test moveLeft and moveRight and moveDown.
   */
  @Test
  public void testAllMoves() {
    assertEquals("X value should be 0", 0, my_j.moveLeft().moveRight().getX());
    assertEquals("Y value should be 2", 2, my_j.moveDown().moveRight().moveDown().getY());
  }
}
