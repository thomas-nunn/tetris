/* 
 * Thomas Nunn
 * 
 * TCSS 305A - Spring 2012
 * Project Tetris
 */

package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import model.IPiece;
import model.ImmutablePoint;
import model.JPiece;
import model.LPiece;
import model.OPiece;
import model.Piece;
import model.SPiece;
import model.TPiece;
import model.ZPiece;


/**
 * A class for creating Tetris game boards that includes three different
 * game play styles: random, sequence, and single piece.
 * 
 * @author Thomas Nunn
 * @version 5/3/2012
 *
 */
public class Board extends Observable {

  /**
   * Represents the height of the default game board.
   */
  private static final int DEFAULT_ROWS = 20;

  /**
   * Represents the width of the default game board.
   */
  private static final int DEFAULT_COLUMNS = 10;

  /**
   * Represents the number of Pieces available for game play.
   */
  private static final int PIECE_TOTAL = 7;
  
  /**
   * The background Color of the Board.
   */
  private static final Color BOARD_COLOR = Color.BLACK;
  
  /**
   * A map for holding Piece type keys and their associated Colors.
   */
  private static final Map<String, Color> COLOR_MAP = createColorMap();

  /**
   * Represents the index of the my_pieces array that determines which
   * piece will be used for the single piece style of game play.
   */
  private int my_single_piece;

  /**
   * The different Pieces available for game play.
   */
  private Piece[] my_pieces = new Piece[PIECE_TOTAL];

  /**
   * A two dimensional Color array to represent the game board.
   */
  private final Color[][] my_board;

  /**
   * The Piece currently in play.
   */
  private Piece my_current_piece;

  /**
   * The next Piece to drop.
   */
  private Piece my_next_piece;

  /**
   * Determines random or sequence game style. Random if true,
   * sequence if false.
   */
  private final boolean my_random_style;

  /**
   * Determines if single piece game style is used.
   */
  private final boolean my_single_style;

  /**
   * The dimensions of a Board object.
   */
  private final Dimension my_board_dimensions;

  /**
   * For selecting a Piece in the sequence game style.
   */
  private int my_counter;

  /**
   * For keeping track of rows cleared.
   */
  private Integer my_score_count = 0;

  /**
   * True if frozen Pieces stack up to the top of the board.
   */
  private Boolean my_game_is_over = false;

  /**
   * A no-arg constructor that creates a Board of standard width and
   * height and uses random game style.
   */
  public Board() {
    super();
    my_board = new Color[DEFAULT_ROWS][DEFAULT_COLUMNS];
    my_random_style = true;
    my_single_style = false;
    my_single_piece = 0;
    my_pieces = loadPieces();
    my_current_piece = randomPiece();
    my_next_piece = randomPiece();
    my_board_dimensions = new Dimension(DEFAULT_COLUMNS, DEFAULT_ROWS);
    colorBoard();
  }

  /**
   * Constructs a new Tetris board for use in the single piece style
   * of game play.
   * 
   * @param the_rows The number of columns in the board.
   * @param the_columns The number of rows in the board.
   * @param the_piece_number An int in the range of 0 - 6.
   */
  public Board(final int the_rows, final int the_columns, final int the_piece_number) {
    super();
    my_board = new Color[the_rows][the_columns];
    my_random_style = false;
    my_single_style = true;
    my_pieces = loadPieces();
    my_board_dimensions = new Dimension(the_columns, the_rows);
    initSinglePiece(the_piece_number);
    colorBoard();
  }

  /**
   * Constructs a new Tetris board.
   * 
   * @param the_rows The number of columns in the board.
   * @param the_columns The number of rows in the board.
   * @param the_style The style of game play, random or sequence.
   */
  public Board(final int the_rows, final int the_columns, final boolean the_style) {
    super();
    my_board = new Color[the_rows][the_columns];
    my_random_style = the_style;
    my_single_style = false;
    my_single_piece = 0;
    my_pieces = loadPieces();
    my_board_dimensions = new Dimension(the_columns, the_rows);
    initRandomPiece();
    colorBoard();
  }
  
  /**
   * Initializes current and next Pieces for the single Piece
   * style of game play.
   * 
   * @param the_piece_number The int that represents a Piece.
   */
  private void initSinglePiece(final int the_piece_number) {
    
    if (the_piece_number < 0 || the_piece_number > PIECE_TOTAL - 1) {
      my_single_piece = PIECE_TOTAL - 1;
    } else {
      my_single_piece = the_piece_number;
    }

    my_current_piece = my_pieces[my_single_piece];
    my_next_piece = my_pieces[my_single_piece];
  }
  
  /**
   * Initializes current and next Pieces for the random Piece
   * style of game play.
   */
  private void initRandomPiece() {
    
    if (my_random_style) {
      my_current_piece = randomPiece();
      my_next_piece = randomPiece();
    } else {
      my_current_piece = sequencePiece();
      my_next_piece = sequencePiece();
    }
  }
  
  /**
   * Creates a map of class names and Colors.
   * 
   * @return The map for coloring each Piece.
   */
  private static Map<String, Color> createColorMap() {
    final Map<String, Color> result = new HashMap<String, Color>();
    
    result.put("model.IPiece", Color.BLUE);
    result.put("model.JPiece", Color.MAGENTA);
    result.put("model.LPiece", Color.CYAN);
    result.put("model.OPiece", Color.GREEN);
    result.put("model.SPiece", Color.PINK.darker());
    result.put("model.TPiece", Color.YELLOW);
    result.put("model.ZPiece", Color.RED);
    
    return Collections.unmodifiableMap(result);
  }

  /**
   * @return The my_board_dimensions field.
   */
  public Dimension getBoardDimensions() {
    return my_board_dimensions;
  }

  /**
   * Fills the game board with a color.
   */
  private void colorBoard() {

    for (int i = 0; i < my_board.length; i++) {
      for (int j = 0; j < my_board[i].length; j++) {
        my_board[i][j] = BOARD_COLOR;
      }
    }
  }

  /**
   * Clears my_current_piece's colors before it moves.
   */
  private void clearColor() {
    
    for (int i = 0; i < my_current_piece.getBoardCoords().length; i++) {
      final int x = (int) my_current_piece.getBoardCoords()[i].getX();
      final int y = (int) my_current_piece.getBoardCoords()[i].getY();

      if (y >= 0 && y < my_board.length) {
        my_board[y][x] = BOARD_COLOR;
      }
    }
  }

  /**
   * Colors my_current_piece on the board.
   */
  private void addColor() {

    for (int i = 0; i < my_current_piece.getBoardCoords().length; i++) {
      final int x = (int) my_current_piece.getBoardCoords()[i].getX();
      final int y = (int) my_current_piece.getBoardCoords()[i].getY();

      if (y >= 0 && y < my_board.length) {
        my_board[y][x] = COLOR_MAP.get(my_current_piece.getClass().getName());
      }

    }
  }

  /**
   * Checks the type of change (movement or rotation) that the current_piece
   * is trying to make and then calls the appropriate method to determine if
   * the change can be made.
   * 
   * @param the_test_piece The new Piece that represents a change
   * in my_current_piece.
   * @return True if there is no collision and the change can be made.
   */
  private boolean canChange(final Piece the_test_piece) {
    boolean result = false;
    final ImmutablePoint[] test_coords = the_test_piece.getBoardCoords();

    if (my_game_is_over) {
      result = false;

    } else if (java.util.Arrays.equals(my_current_piece.moveLeft().
                                       getBoardCoords(), test_coords)) {
      result = canMoveLeft(test_coords);

    } else if (java.util.Arrays.equals(my_current_piece.moveRight().
                                       getBoardCoords(), test_coords)) {
      result = canMoveRight(test_coords);

    } else if (java.util.Arrays.equals(my_current_piece.moveDown().
                                       getBoardCoords(), test_coords)) {
      result = canMoveDown(test_coords, the_test_piece.getY());

    } else {
      result = canRotate(test_coords);
    }


    return result;
  }

  /**
   * Tests a Piece's neighboring blocks to the left to determine
   * if a move to the left is possible.
   * 
   * @param the_test_coords The coordinates of a Piece if it moved left.
   * @return True if a Piece can move left, false otherwise.
   */
  private boolean canMoveLeft(final ImmutablePoint[] the_test_coords) {
    boolean result = false;

    for (int i = 0; i < the_test_coords.length; i++) {
      final int x = (int) the_test_coords[i].getX();
      final int y = (int) the_test_coords[i].getY();
      final ImmutablePoint temp_point = 
          new ImmutablePoint(the_test_coords[i].getX(), the_test_coords[i].getY());
      
      
      if (y >= 0 && x >= 0 && (my_board[y][x].equals(BOARD_COLOR) ||
          my_current_piece.containsPoint(temp_point))) {
        result = true;
      } else {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * Tests a Piece's neighboring blocks to the right to determine
   * if a move to the right is possible.
   * 
   * @param the_test_coords The coordinates of a Piece if it moved right.
   * @return True if a Piece can move right, false otherwise.
   */
  private boolean canMoveRight(final ImmutablePoint[] the_test_coords) {
    boolean result = false;

    for (int i = 0; i < the_test_coords.length; i++) {
      final int x = (int) the_test_coords[i].getX();
      final int y = (int) the_test_coords[i].getY();
      final ImmutablePoint temp_point = 
          new ImmutablePoint(the_test_coords[i].getX(), the_test_coords[i].getY());

      if (y >= 0 && x < my_board[i].length && (my_board[y][x].
          equals(BOARD_COLOR) || my_current_piece.containsPoint(temp_point))) {
        result = true;
      } else {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * Tests a Piece's neighboring blocks to the south to determine
   * if a move down is possible.
   * 
   * @param the_test_coords The coordinates of a Piece if it moved down.
   * @param the_y The y value of the origin of a Piece.
   * @return True if a Piece can move down, false otherwise.
   */
  private boolean canMoveDown(final ImmutablePoint[] the_test_coords,
                              final int the_y) {
    boolean result = false;

    for (int i = 0; i < the_test_coords.length; i++) {
      final int x = (int) the_test_coords[i].getX();
      final int y = (int) the_test_coords[i].getY();
      final ImmutablePoint temp_point = 
          new ImmutablePoint(the_test_coords[i].getX(), the_test_coords[i].getY());

      if ((y >= 0 && y < my_board.length && (my_board[y][x].
          equals(BOARD_COLOR) || my_current_piece.containsPoint(temp_point))) ||
          (y < 0 && y != the_y)) {
        result = true;
      } else {
        result = false;
        break;
      }

    }
    return result;
  }

  /**
   * Checks a Piece's neighbors to see if it can rotate.
   * 
   * @param the_test_coords The coordinates of a Piece if it rotated.
   * @return True if a Piece can rotate, false otherwise.
   */
  private boolean canRotate(final ImmutablePoint[] the_test_coords) {
    boolean result = false;

    for (int i = 0; i < the_test_coords.length; i++) {
      final int x = (int) the_test_coords[i].getX();
      final int y = (int) the_test_coords[i].getY();
      final ImmutablePoint temp_point = 
          new ImmutablePoint(the_test_coords[i].getX(), the_test_coords[i].getY());

      if ((y < my_board.length && y >= 0) && (x >= 0 && x < my_board[i].length) &&
          ((my_board[y][x].equals(BOARD_COLOR) || 
              my_current_piece.containsPoint(temp_point)))) {
        result = true;
      } else {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * Freezes a Piece in place if it cannot move down.
   * 
   * @param the_piece The Piece to freeze in place.
   */
  private void freeze(final Piece the_piece) {

    // Check if my_current_piece extends above the top of the Board
    for (int i = 0; i < my_current_piece.getBoardCoords().length; i++) {
      final int y = (int) my_current_piece.getBoardCoords()[i].getY();

      if (y < 0) {
        // Game Over
        my_game_is_over = true;
        return;
      } 
    }

    my_current_piece = my_next_piece;

    if (my_random_style) {
      my_next_piece = randomPiece();
    } else if (my_single_style) {
      my_next_piece = my_pieces[my_single_piece];
    } else {
      my_next_piece = sequencePiece();
    }

    // after a Piece is frozen check if any rows are filled
    checkRows(the_piece);

    // set board change and notify the GUI
    setChanged();
    notifyObservers(my_next_piece);
  }

  /**
   * Checks for filled rows on the board based on the blocks of a
   * just frozen Piece.
   * 
   * @param the_piece The Piece that was just frozen.
   */
  private void checkRows(final Piece the_piece) {

    final List<Color> check_colors = new ArrayList<Color>();
    final Set<Integer> check_rows = new TreeSet<Integer>();
    final Set<Integer> filled_rows = new TreeSet<Integer>();


    // fill a Set with the y values of each block of the_piece
    for (int i = 0; i < the_piece.getBoardCoords().length; i++) {
      final int y = (int) the_piece.getBoardCoords()[i].getY();
      check_rows.add(y);
    }

    final Iterator<Integer> itr = check_rows.iterator();

    // get the lowest y value 
    final int first_row = itr.next();

    // fill an arraylist with all the colors of each row in the Set
    for (int i = first_row; i < check_rows.size() + first_row; i++) {
      for (int j = 0; j < my_board[i].length; j++) {
        check_colors.add(my_board[i][j]);
      }

      if (check_colors.contains(BOARD_COLOR)) {
        check_colors.clear();
      } else {
        // add the filled row's y value to a Set
        filled_rows.add(i);
        check_colors.clear();

      }
    }

    // call method to remove filled rows
    if (!filled_rows.isEmpty()) {
      removeRows(filled_rows, the_piece);

    }
    
    if (my_score_count > 0) {
      setChanged();
      notifyObservers(my_score_count);
      my_score_count = 0;

    }

  }

  /**
   * Removes filled rows and shifts rows down.
   * 
   * @param the_rows A set of the y values of rows that are filled
   * @param the_piece The Piece that was just frozen.
   */
  private void removeRows(final Set<Integer> the_rows, final Piece the_piece) {
    final Iterator<Integer> itr = the_rows.iterator();

    // get the highest y value 
    int last_row = 0;
    while (itr.hasNext()) {
      last_row = itr.next();

    }

    for (int i = last_row; i >= 0; i--) {
      for (int j = 0; j < my_board[i].length; j++) {

        if (i == 0) {
          my_board[i][j] = BOARD_COLOR;
        } else {
          my_board[i][j] = my_board[i - 1][j];
        }

      }
    }
    my_score_count++;
    checkRows(the_piece);
  }

  /**
   * Loads the my_pieces field with Tetris Pieces.
   * 
   * @return An array containing all Tetris Pieces.
   */
  private Piece[] loadPieces() {
    final Piece[] result = new Piece[PIECE_TOTAL];
    int count = 0;
    final int starting_x = (my_board[0].length / 2) - 1;

    my_pieces[count] = new IPiece(starting_x, -1);
    count++;
    my_pieces[count] = new JPiece(starting_x, -1);
    count++;
    my_pieces[count] = new LPiece(starting_x, -1);
    count++;
    my_pieces[count] = new OPiece(starting_x, -1);
    count++;
    my_pieces[count] = new SPiece(starting_x, -1);
    count++;
    my_pieces[count] = new TPiece(starting_x, -1);
    count++;
    my_pieces[count] = new ZPiece(starting_x, -1);

    System.arraycopy(my_pieces, 0, result, 0, my_pieces.length);
    return result;
  }

  /**
   * Selects a random Piece from the array of Pieces.
   * 
   * @return A random game Piece.
   */
  private Piece randomPiece() {
    Piece result;

    final Random rand = new Random();
    final int r_number = rand.nextInt(PIECE_TOTAL);
    result = my_pieces[r_number];

    return result;
  }

  /**
   * Selects the next Piece from the array of Pieces for the
   * sequence style of game play.
   * 
   * @return The next game Piece.
   */
  public final Piece sequencePiece() {
    Piece result;

    if (my_counter == PIECE_TOTAL) {
      my_counter = 0;
      result = my_pieces[my_counter];
    } else {
      result = my_pieces[my_counter];
    }

    my_counter++;
    return result;
  }

  /**
   * @return The current Piece in play.
   */
  public Piece getCurrentPiece() {
    return my_current_piece;
  }

  /**
   * @return The next Piece to drop.
   */
  public Piece getNextPiece() {
    return my_next_piece;
  }

  /**
   * @param the_piece The new Piece that my_current_piece becomes.
   */
  public void setCurrentPiece(final Piece the_piece) {
    my_current_piece = the_piece;
  }

  /**
   * Moves a Piece left if possible.
   */
  public void moveLeft() {

    if (canChange(my_current_piece.moveLeft())) {
      clearColor();
      my_current_piece = my_current_piece.moveLeft();
      addColor();

      // set board change and notify the GUI
      setChanged();
      notifyObservers();
    }
  }

  /**
   * Moves a Piece right if possible.
   */
  public void moveRight() {

    if (canChange(my_current_piece.moveRight())) {
      clearColor();
      my_current_piece = my_current_piece.moveRight();
      addColor();

      // set board change and notify the GUI
      setChanged();
      notifyObservers();
    }

  }

  /**
   * Moves a Piece down if possible.
   */
  public void moveDown() {

    if (my_game_is_over) {
      return;

    } else if (canChange(my_current_piece.moveDown())) {
      clearColor();
      my_current_piece = my_current_piece.moveDown();
      addColor();

      // set board change and notify the GUI
      setChanged();
      notifyObservers();

    } else {
      freeze(my_current_piece);

      if (my_game_is_over) {
        setChanged();
        notifyObservers(my_game_is_over);
        //my_game_is_over = false;
      }
    }

  }

  /**
   * Rotates a Piece if possible.
   */
  public void rotate() {
    Character ch = new Character('a');
    
    if (canChange(my_current_piece.rotate())) {
      clearColor();
      my_current_piece = my_current_piece.rotate();
      addColor();
      ch = 'b';
    }
    
    // set board change and notify the GUI
    setChanged();
    notifyObservers(ch);
    ch = 'a';
  }

  /**
   * Drops the current Piece down one row.
   */
  public void step() {
    moveDown();
  }

  /**
   * @return A copy of the Color array that represents this Board.
   */
  public Color[][] getMyBoard() {
    final Color[][] result = new Color[my_board.length][my_board[0].length];
    System.arraycopy(my_board, 0, result, 0, my_board.length);
    return result;
  }

  /**
   * Builds a String representation of this game board, complete with
   * Pieces in their current positions.
   * 
   * @return A String representation of this game board.
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    for (int i = 0; i < my_board.length; i++) {
      for (int j = 0; j < my_board[i].length; j++) {

        if (my_board[i][j].equals(Color.BLACK)) {
          sb.append("[ ]");
        } else {
          sb.append("[F]");
        }

      }
      sb.append("\n");
    }
    return sb.toString();
  }
}






