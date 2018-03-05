// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/** Coord Class
   * Author:  pondy
   * Description: Provides row-column pairs for specifying cells of a maze
   */


public class Coord{
  
  public  int row;
  public int col;

  
  public Coord(int r, int c){
    row = r;
    col = c;
  }
  
  public Coord next(Direction d){
    if  (this == null) 
      return null;
    if (d == Direction.NORTH) {
      return new Coord(row - 1, col);
    }
    else if (d == Direction.SOUTH) {
      return new Coord(row + 1, col);
    }
    else if (d == Direction.EAST) {
      return new Coord(row, col + 1);
    }
    else if (d == Direction.WEST) {
      return new Coord(row, col - 1);
    }
    else
      return null;
  }
}
