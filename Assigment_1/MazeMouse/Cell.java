// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/** Cell Class
   * Author:  pondy
   * Description: Provides the kinds of cells for a maze.
   * currently, just spaces and walls.
   */

public class Cell{

  public static final Cell SPACE = new Cell();
  public static final Cell WALL = new Cell();
 
  private Cell(){
  }
  
 
  public Cell invert(){
    if (this == SPACE)
      return WALL;
    else
      return SPACE;
  }
} 
  
