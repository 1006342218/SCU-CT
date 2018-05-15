package com.mycompany.myjiemian;

/**
 * Created by kirito on ${DATA}.
 */

public class Key {

      public  static int[] isIn(String substring, String[] source) {
          int y=0;
          int []sum=new int[20];
        for ( int i=0 ; i < source.length; i++) {
            String aSource = source[i];
            if (aSource.indexOf(substring)>0) {
                sum[y]=1;
                y++;
            }
            else {
                sum[y]=-1;
                y++;
            }
        }
              return sum;

    }
}
