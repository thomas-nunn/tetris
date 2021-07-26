/*
 * ImmutablePoint
 * 
 * TCSS 305 - Spring 2012 Lecture 2
 */

package model;

/**
 * Represents a 2-dimensional point on a plane.
 * 
 * Learn more about immutable objects at
 * http://www.javapractices.com/topic/TopicAction.do?Id=29
 * 
 * @author TCSS305 Class
 * @version Spring 2012
 */
public final class ImmutablePoint {
  // immutable classes should be final to prevent the creation of mutable
  // subclasses

  // immutable classes do not typically need to implement Cloneable

  // constants

  /**
   * A format string for decimal numbers.
   */
  private static final String FORMAT = "%.3f";

  // instance fields
  // Notice that the fields are final (Immutable object)

  /**
   * The x-coordinate.
   */
  private final double my_x;

  /**
   * The y-coordinate.
   */
  private final double my_y;

  // constructors

  /**
   * Constructs a point.
   * 
   * @param the_x The x coordinate to assign to this point.
   * @param the_y The y coordinate to assign to this point.
   */
  public ImmutablePoint(final double the_x, final double the_y) {
    my_x = the_x;
    my_y = the_y;
  }

  /**
   * Constructs a point at the origin (0, 0).
   */
  public ImmutablePoint() {
    this(0, 0);
  }

  // a copy constructor is not needed in an immutable class!

  // queries (accessors)

  /**
   * @return What is your x-coordinate?
   */
  public double getX() {
    return my_x;
  }

  /**
   * @return What is your y-coordinate?
   */
  public double getY() {
    return my_y;
  }

  /**
   * Calculates the distance to the specified point.
   * 
   * @param the_point The other point.
   * @return the distance.
   */
  public double distance(final ImmutablePoint the_point) {
    final double dx = getX() - the_point.getX();
    final double dy = getY() - the_point.getY();
    return Math.sqrt(dx * dx + dy * dy);
  }

  // commands ('mutators' or 'setters')
  /*
   * An immutable class should either not have any commands (mutators)
   * 
   * OR
   * 
   * All commands should return a new ImmutablePoint and NOT modify the current
   * ImmutablePoint)
   */

  /**
   * Set the coordinates to the specified values.
   * 
   * @param the_x the x coordinate to set
   * @param the_y the y coordinate to set
   * @return An ImmutablePoint object with specified coordinates
   */
  public ImmutablePoint setLocation(final double the_x, final double the_y) {
    return new ImmutablePoint(the_x, the_y);
  }

  /**
   * Set the coordinates to those of the specified point.
   * 
   * @param the_other_point the point from which to copy coordinates
   * @return An ImmutablePoint object with coordinates copied from
   *         the_other_point
   */
  public ImmutablePoint setLocation(final ImmutablePoint the_other_point) {
    return new ImmutablePoint(the_other_point.my_x, the_other_point.my_y);
  }

  /**
   * Translates this point by (the_x, the_y).
   * 
   * @param the_x The x to translate by.
   * @param the_y The y to translate by.
   * @return the resulting point.
   */
  public ImmutablePoint translate(final double the_x, final double the_y) {
    return new ImmutablePoint(my_x + the_x, my_y + the_y);
  }

  // overridden methods from class Object

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();

    sb.append('(');
    sb.append(String.format(FORMAT, my_x));
    sb.append(", ");
    sb.append(String.format(FORMAT, my_y));
    sb.append(')');

    return sb.toString();

    // in modern VMs, this compiles to the same code as
    // return "(" + String.format(FORMAT, my_x) + ", " + String.format(FORMAT,
    // my_y) + ")";
    // because they can optimize single-line string building
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(final Object the_other) {
    boolean result = false;

    if (this == the_other) {
      result = true;
    } else if (the_other != null && getClass() == the_other.getClass()) {
      final ImmutablePoint other_point = (ImmutablePoint) the_other;
      result =
          Double.compare(my_x, other_point.my_x) == 0 &&
              Double.compare(my_y, other_point.my_y) == 0;

    }
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    /*
     * Use the hashCode() method in class String to create a hash code for this
     * MutablePoint. This will not violate the general contract for hashCode
     * because equals() and toString() use the same fields.
     */
    return toString().hashCode();
  }

  // NOTE: no clone() method needed in an immutable class

}
