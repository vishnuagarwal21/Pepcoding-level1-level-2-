import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(maxDistance(arr));

  }
  
  public static class Pair{
      int row;
      int col;
      
      Pair(int row, int col){
          this.row = row;
          this.col = col;
      }
  }
  statuc int[][] dirs = {{1,0}, {0, -1}, {-1, 0}, {0, 1}};

  public static int maxDistance(int[][] arr) {
     boolean visited[][] = new boolean[arr.length][arr[0].length];
    Queue<Pair> queue = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j <arr[i].length ; j++) {
        if (arr[i][j] == 1) {
         visited[i][j] = true;
          queue.add(new Pair(i,j));
        }
      }
    }
    if (queue.size() == 0 || queue.size() == arr.length* arr[0].length) {
      return -1;
    }
    int count = -1;
    while(!queue.isEmpty()) {
        count++;
      int size = queue.size();
      while(size-- > 0) {
        Pair cell = queue.remove();
        for (int i = 0; i < dirs.length; i++) {
          int r = cell.row + dirs[i][0];
          int c = cell.row + dirs[i][1];
          if (r >=0  && r < arr.length && c >=0 && c < arr[0].length && visited[r][c] == false && arr[r][c] == 0) {
             visited[r][c] = true;
            queue.add(new Pair(r, c));
          }
        }
      }
    
    }
    return count; 
  }
  }
