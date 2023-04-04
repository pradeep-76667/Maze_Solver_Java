/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author welcome
 */
public class NewClass extends JFrame{
    
    private int[][]maze = 
    {{1,1,1,1,1,1,1,1,1,1,1,1,1},                      // 1 represent the boundary or obstacle
     {1,0,1,0,1,0,1,0,0,0,0,0,1},                      // 0 represent the traversing through
     {1,0,1,0,0,0,1,0,1,1,1,0,1},                      // 9 is the destination
     {1,0,1,1,1,1,1,0,0,0,0,0,1},
     {1,0,0,1,0,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,0,0,1},
     {1,0,1,0,1,0,0,0,1,1,1,0,1},
     {1,0,1,0,1,1,1,0,1,0,1,0,1},
     {1,0,0,0,0,0,0,0,0,0,1,9,1},
     {1,1,1,1,1,1,1,1,1,1,1,1,1}};
    
      public List<Integer> path = new ArrayList<>();
      
      public NewClass(){
          setTitle("Maze Solver");
          setSize(640,720);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          depthFirstSearch.searchPath(maze, 1, 1, path);
//          System.out.println(path);
          
      }
      
      @Override
      public void paint(Graphics g){
          
          g.translate(150,150);
          
          for(int i=0;i<maze.length;i++){
              for(int j=0;j<maze[0].length;j++){
                  Color color;
                  switch(maze[i][j]){
                      case 1 : color = Color.black; break;
                      case 9 : color = Color.red; break;
                      default : color = Color.white; break;
                  }
                  g.setColor(color);
                  g.fillRect(35*j, 35*i, 35, 35);
                  g.setColor(Color.red);
                  g.drawRect(35*j, 35*i, 35, 35);
              }
          }
          for(int i=0;i<path.size();i+=2){
              int pathx = path.get(i);
              int pathy = path.get(i+1);
              
              System.out.println("xCoordinates" + pathx);
              System.out.println("yCoordinates" + pathy);
              
              g.setColor(Color.cyan);
              g.fillRect(35*pathx, 35*pathy, 25, 30);
          }
      }
      
      public static void main(String[] args){
          NewClass view = new NewClass();
          view.setVisible(true);
      }
    }


