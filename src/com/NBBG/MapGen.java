package com.NBBG;

import java.awt.*;

public class MapGen {

    public int[][] map;
    public int b_w;
    public int b_h;

    public MapGen(int row,int col){
        map = new int[row][col];
        for(int i = 0; i < map.length; i++ ){
          for(int j = 0 ; j < map[0].length; j++){
              map[i][j] = 1; // 1 means that the brick is present
          }
        }
        b_w = 450/col;
        b_h = 150/row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if(map[i][j] > 0){
                    g.setColor(Color.white);
                    g.fillRect(j * b_w + 50,i * b_h + 65,b_w,b_h);

                    g.setStroke(new BasicStroke(10));
                    g.setColor(Color.black);
                    g.drawRect(j * b_w + 50,i * b_h + 65,b_w,b_h);
                }
            }
        }
    }

    public void destroy(int val,int row,int col){
        map[row][col] = val;
    }
}
