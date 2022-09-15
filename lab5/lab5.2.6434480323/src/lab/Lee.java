package lab;

import datastr.ArrayQueue;
import datastr.ArrayStack;
import datastr.Queue;
import datastr.Stack;

import java.util.Arrays;

public class Lee {
    private static final int SPACE = -1;
    private static final int BLOCK = -9;
    private static int[][] map = new int[10][10];

    private static int findpath_stack_called = 0;
    private static int findpath_queue_called = 0;

    public static void main(String[] args) {
        // Generate Map
        int[][] gen_map = new int[10][10];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                gen_map[i][j] = Math.random() < 0.2 ? BLOCK : SPACE;

        // Find path using queue
        map = Arrays.stream(gen_map).map(arr -> Arrays.copyOf(arr, arr.length)).toArray(int[][]::new);      // Deep Copy For Testing
        System.out.println("Map");
        printArr();

        System.out.println("Find Path queue");
        findPath_queue(new Pos(0, 0), new Pos(0, map[0].length - 1));
        printArr();
        System.out.println("Loop : " + findpath_queue_called + " time(s)") ;

        // Find path using stack
        map = Arrays.stream(gen_map).map(arr -> Arrays.copyOf(arr, arr.length)).toArray(int[][]::new);      // Deep Copy For Testing
        System.out.println("Find Path Stack");
        findPath_stack(new Pos(0, 0), new Pos(0, map[0].length - 1));
        printArr();
        System.out.println("Loop : " + findpath_stack_called + " time(s)") ;
    }

    private static void printArr() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++)
                System.out.printf("%4d", map[i][j]);
            System.out.println();
        }
    }

    static void findPath_stack(Pos source, Pos target) {
        map[source.row][source.col] = 0;
        map[target.row][target.col] = SPACE;
        Stack q = new ArrayStack();
        q.push(source);
        while (!q.isEmpty()) {
            findpath_stack_called++;
            Pos p = (Pos) q.pop();
            if (p.row == target.row && p.col == target.col) break;
            expand_stack(q, p.row + 1, p.col, map[p.row][p.col]);
            expand_stack(q, p.row - 1, p.col, map[p.row][p.col]);
            expand_stack(q, p.row, p.col + 1, map[p.row][p.col]);
            expand_stack(q, p.row, p.col - 1, map[p.row][p.col]);
        }
    }

    static void expand_stack(Stack q, int r, int c, int k) {
        if (r < 0 || r >= map.length ||
                c < 0 || c >= map[r].length ||
                map[r][c] != SPACE) return;
        map[r][c] = k + 1;
        q.push(new Pos(r, c));
    }

    static void findPath_queue(Pos source, Pos target) {
        map[source.row][source.col] = 0;
        map[target.row][target.col] = SPACE;
        Queue q = new ArrayQueue();
        q.enqueue(source);
        while (!q.isEmpty()) {
            findpath_queue_called++;
            Pos p = (Pos) q.dequeue();
            if (p.row == target.row && p.col == target.col) break;
            queue_expand(q, p.row + 1, p.col, map[p.row][p.col]);
            queue_expand(q, p.row - 1, p.col, map[p.row][p.col]);
            queue_expand(q, p.row, p.col + 1, map[p.row][p.col]);
            queue_expand(q, p.row, p.col - 1, map[p.row][p.col]);
        }
    }

    static void queue_expand(Queue q, int r, int c, int k) {
        if (r < 0 || r >= map.length ||
                c < 0 || c >= map[r].length ||
                map[r][c] != SPACE) return;
        map[r][c] = k + 1;
        q.enqueue(new Pos(r, c));
    }

    private static class Pos {
        int row, col;

        Pos(int r, int c) {
            row = r;
            col = c;
        }
    }
}
