/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package controller;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * A class for testing Board objects. All tests require that a board
 * may only use "J" type pieces.
 * 
 * @author Thomas Nunn
 * @version 5/3/2012
 *
 */
public class BoardTest {


  /**
   * The number of rows in the board.
   */
  private static final int MY_ROWS = 10;

  /**
   * The number of columns in the board.
   */
  private static final int MY_COLUMNS = 6;

  /**
   * The background Color of the Board.
   */
  private static final Color BOARD_COLOR = Color.BLACK;

  /**
   * A game board to be tested.
   */
  private Board my_board;

  /**
   * A two dimensional array to represent the game board.
   */
  private Color[][] my_test_board;


  /**
   * Creates a new game board and a Color[][] for use in testing.
   */
  @Before
  public void setUp() {
    my_board = new Board(MY_ROWS, MY_COLUMNS, 1);
    my_test_board = new Color[MY_ROWS][MY_COLUMNS];
  }

  /**
   * Calls the step method.
   * 
   * @param the_steps The number of times to call the step() method.
   */
  private void placePieces(final int the_steps) {

    for (int i = 0; i < the_steps; i++) {
      my_board.step();
    }

  }

  /**
   * Tests various collisions.
   */
  @Test
  public void testCollisions() {
    placePieces(MY_ROWS * 2 + 2);
    my_board.moveRight();
    my_board.moveRight();

    // try to rotate against right wall
    my_board.step();
    my_board.rotate();
    my_board.step();
    my_board.rotate();
    my_board.step();
    
    // try to move left against frozen pieces
    my_board.moveLeft();
    my_board.step();
    my_board.moveLeft();
    my_board.step();
    my_board.moveLeft();
    my_board.step();
    
    // try to rotate against a frozen piece and then rotate under
    // a frozen piece
    placePieces(MY_COLUMNS);
    my_board.moveLeft();
    my_board.moveLeft();
    placePieces(MY_COLUMNS - 2);
    my_board.rotate();
    my_board.step();
    my_board.rotate();

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    // Build test board for comparison
    my_test_board[MY_COLUMNS + 1][0] = Color.RED;
    my_test_board[MY_COLUMNS + 1][1] = Color.RED;
    my_test_board[MY_COLUMNS + 1][2] = Color.RED;
    my_test_board[MY_ROWS - 2][2] = Color.RED;
    
    my_test_board[MY_COLUMNS - 2][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_COLUMNS - 1][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_COLUMNS][2] = Color.RED;
    my_test_board[MY_COLUMNS][MY_COLUMNS / 2] = Color.RED;

    my_test_board[MY_COLUMNS + 1][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - 2][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - 1][2] = Color.RED;

    my_test_board[MY_ROWS - 1][MY_COLUMNS - 2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS - 1] = Color.RED;
    my_test_board[MY_ROWS - 2][MY_COLUMNS - 1] = Color.RED;
    my_test_board[MY_COLUMNS + 1][MY_COLUMNS - 1] = Color.RED;

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());
  }

  /**
   * Tests the moveLeft() method.
   */
  @Test
  public void testLeft() {
    placePieces(MY_ROWS);

    /* Move the Piece left more times than is possible to check that
    it stays in the proper position.*/ 
    my_board.moveLeft();
    my_board.moveLeft();
    my_board.moveLeft();
    my_board.moveLeft();
    
    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    // Build test board for comparison
    my_test_board[MY_ROWS - 1][0] = Color.RED;
    my_test_board[MY_ROWS - 1][1] = Color.RED;
    my_test_board[MY_ROWS - 2][1] = Color.RED;
    my_test_board[MY_ROWS - (MY_COLUMNS / 2)][1] = Color.RED;

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());

  }

  /**
   * Tests the moveRight() method.
   */
  @Test
  public void testRight() {
    placePieces(MY_ROWS);

    /* Move the Piece right more times than is possible to check that
    it stays in the proper position.*/ 
    my_board.moveRight();
    my_board.moveRight();
    my_board.moveRight();
    my_board.moveRight();

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    // Build test board for comparison
    my_test_board[MY_ROWS - 1][MY_COLUMNS - 2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS - 1] = Color.RED;
    my_test_board[MY_ROWS - 2][MY_COLUMNS - 1] = Color.RED;
    my_test_board[MY_ROWS - (MY_COLUMNS / 2)][MY_COLUMNS - 1] = Color.RED;

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());

  }

  /**
   * Drops six pieces and places them on the board using the four methods
   * available; step(), rotate(), moveLeft(), and moveRight().
   */
  private void dropSix() {

    // Piece 1
    placePieces(MY_ROWS);
    my_board.moveRight();
    my_board.moveRight();

    // Piece 2
    placePieces(MY_ROWS);
    my_board.moveLeft();
    my_board.moveLeft();

    // Piece 3
    placePieces(MY_ROWS);

    // Piece 4
    placePieces(MY_COLUMNS);
    my_board.rotate();
    my_board.rotate();
    my_board.moveRight();
    my_board.moveRight();
    placePieces(MY_COLUMNS - 1);

    // Piece 5
    placePieces(MY_COLUMNS);
    my_board.rotate();
    my_board.rotate();
    my_board.moveLeft();
    my_board.moveLeft();
    placePieces(MY_COLUMNS - 1);

    // Piece 6
    placePieces(MY_COLUMNS);
    my_board.rotate();
    my_board.rotate();
    placePieces(MY_COLUMNS + 2);
  }

  /**
   * Drops thirty pieces that should all be cleared. Calls the
   * dropSix() method five times.
   */
  @Test
  public void testThirty() {

    for (int i = 0; i < MY_COLUMNS - 1; i++) {
      dropSix();
    }

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());
  }

  /**
   * Tests the toString method of a Board with one Piece.
   */
  @Test
  public void testToString() {
    placePieces(MY_ROWS);

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    // Build test board for comparison
    my_test_board[MY_ROWS - 1][2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - 2][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - (MY_COLUMNS / 2)][MY_COLUMNS / 2] = Color.RED;

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());
  }

  /**
   * Tests that two non-adjacent rows clear properly.
   */
  @Test
  public void testNonAdjacent() {

    // Piece 1
    placePieces(MY_ROWS);
    my_board.moveRight();
    my_board.moveRight();

    // Piece 2
    placePieces(MY_ROWS);
    my_board.moveLeft();
    my_board.rotate();
    my_board.rotate();
    my_board.rotate();
    my_board.moveLeft();

    // Piece 3
    placePieces(MY_COLUMNS);
    my_board.rotate();
    my_board.moveLeft();
    my_board.moveLeft();
    placePieces(MY_COLUMNS / 2);

    // Piece 4
    placePieces(MY_COLUMNS);
    my_board.rotate();
    my_board.rotate();
    my_board.moveRight();
    placePieces(MY_COLUMNS + 2);

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {
        my_test_board[i][j] = BOARD_COLOR;
      }
    }

    // Build test board for comparison
    my_test_board[MY_ROWS - 1][0] = Color.RED;
    my_test_board[MY_ROWS - 1][2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS / 2] = Color.RED;
    my_test_board[MY_ROWS - 1][MY_COLUMNS - 1] = Color.RED;

    final String tester = buildString();
    Assert.assertEquals(tester, my_board.toString());
  }

  /**
   * Builds a String representation of a Color[][] for the
   * purpose of comparison with the state of a Board. All tests
   * call this method.
   * 
   * @return A String representation for comparison.
   */
  private String buildString() {
    final StringBuilder result = new StringBuilder();

    for (int i = 0; i < MY_ROWS; i++) {
      for (int j = 0; j < MY_COLUMNS; j++) {

        if (my_test_board[i][j].equals(Color.BLACK)) {
          result.append("[ ]");
        } else {
          result.append("[F]");
        }

      }
      result.append("\n");
    }

    return result.toString();
  }
}
