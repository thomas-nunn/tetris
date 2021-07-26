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
public class OPieceTest {
  
  /**
   * Represents an O Piece in the 0 degree position.
   */
  private static final ImmutablePoint[] MY_0_O = { 
    new ImmutablePoint(0, 0), new ImmutablePoint(0, -1), 
    new ImmutablePoint(1, 0), new ImmutablePoint(1, -1)  
  };

  /**
   * A Piece for testing.
   */
  private OPiece my_o;

  /**
   * Creates a new Piece before each method is run.
   */
  @Before
  public void setUp() {
    my_o = new OPiece(0, 0);
  }

  /**
   * Test initial position.
   */
  @Test
  public void testInitialPosition() {
    Assert.assertArrayEquals(MY_0_O, my_o.getCoords());
  }
  
  /**
   * Test rotate method.
   */
  @Test
  public void testRotate() {
    Assert.assertArrayEquals(MY_0_O, my_o.rotate().getCoords());
  }
  
  /**
   * Test rotate method twice.
   */
  @Test
  public void testRotateTwice() {
    Assert.assertArrayEquals(MY_0_O, my_o.rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateThree() {
    Assert.assertArrayEquals(MY_0_O, my_o.rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test rotate method three times.
   */
  @Test
  public void testRotateFour() {
    Assert.assertArrayEquals(MY_0_O, my_o.rotate().rotate().rotate().rotate().getCoords());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testLeft() {
    assertEquals("X value should be -1", -1, my_o.moveLeft().getX());
  }
  
  /**
   * Test moveLeft method.
   */
  @Test
  public void testRight() {
    assertEquals("X value should be 1", 1, my_o.moveRight().getX());
  }

  /**
   * Test moveLeft method.
   */
  @Test
  public void testDown() {
    assertEquals("Y value should be 1", 1, my_o.moveDown().getY());
  }
  
  /**
   * Test moveLeft and moveRight and moveDown.
   */
  @Test
  public void testAllMoves() {
    assertEquals("X value should be 0", 0, my_o.moveLeft().moveRight().getX());
    assertEquals("Y value should be 2", 2, my_o.moveDown().moveRight().moveDown().getY());
  }
}
