package lab;

import datastr.ArrayQueue;
import datastr.ArrayStack;
import datastr.Queue;
import datastr.Stack;

import java.util.Arrays;

public class Lee {
    private static final int SPACE = -1;
    private static final int BLOCK = -9;
    private static int[][] map = new int[5][5];

    private static int findpath_stack_called = 0;
    private static int findpath_queue_called = 0;

    public static void main(String[] args) {
        // Generate Map
        int[][] gen_map = new int[5][5];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                gen_map[i][j] = SPACE;

        gen_map[0][2] = BLOCK;
        gen_map[1][4] = BLOCK;
        gen_map[3][3] = BLOCK;
        gen_map[4][0] = BLOCK;


        // Find path using queue
        map = Arrays.stream(gen_map).map(arr -> Arrays.copyOf(arr, arr.length)).toArray(int[][]::new);      // Deep Copy For Testing
        System.out.println("Map");
        printArr();

        System.out.println("Find Path queue");
        findPath_queue(new Pos(0, 0, 0, 0), new Pos(4, 4, 4, 4));
        printArr();
        System.out.println("Loop : " + findpath_queue_called + " time(s)");

        // Find path using stack
        map = Arrays.stream(gen_map).map(arr -> Arrays.copyOf(arr, arr.length)).toArray(int[][]::new);      // Deep Copy For Testing
        System.out.println("Find Path Stack");
        findPath_stack(new Pos(0, 0, 0, 0), new Pos(4, 4, 4, 4));
        printArr();
        System.out.println("Loop : " + findpath_stack_called + " time(s)");
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
            System.out.println(p);
            if (p.row == target.row && p.col == target.col) break;
            expand_stack(q, p.row, p.col, p.row + 1, p.col, map[p.row][p.col]);
            expand_stack(q, p.row, p.col, p.row - 1, p.col, map[p.row][p.col]);
            expand_stack(q, p.row, p.col, p.row, p.col + 1, map[p.row][p.col]);
            expand_stack(q, p.row, p.col, p.row, p.col - 1, map[p.row][p.col]);
        }
    }

    static void expand_stack(Stack s, int fr, int fc, int r, int c, int k) {
        if (r < 0 || r >= map.length ||
                c < 0 || c >= map[r].length ||
                map[r][c] != SPACE) return;
        if (map[r][c] == -1 || k + 1 < map[r][c]) {
            map[r][c] = k + 1;
            s.push(new Pos(fr, fc, r, c));
        }
    }

    static void findPath_queue(Pos source, Pos target) {
        map[source.row][source.col] = 0;
        map[target.row][target.col] = SPACE;
        Queue q = new ArrayQueue();
        q.enqueue(source);
        while (!q.isEmpty()) {
            findpath_queue_called++;
            Pos p = (Pos) q.dequeue();
            System.out.println(p);
            if (p.row == target.row && p.col == target.col) break;

            queue_expand(q, p.row, p.col, p.row + 1, p.col, map[p.row][p.col]);
            queue_expand(q, p.row, p.col, p.row - 1, p.col, map[p.row][p.col]);
            queue_expand(q, p.row, p.col, p.row, p.col + 1, map[p.row][p.col]);
            queue_expand(q, p.row, p.col, p.row, p.col - 1, map[p.row][p.col]);
        }
    }

    static void queue_expand(Queue q, int fr, int fc, int r, int c, int k) {
        if (r < 0 || r >= map.length ||
                c < 0 || c >= map[r].length ||
                map[r][c] != SPACE) return;
        map[r][c] = k + 1;
        q.enqueue(new Pos(fr, fc, r, c));
    }

    private static class Pos {
        int f_row, f_col;
        int row, col;

        public Pos(int f_row, int f_col, int row, int col) {
            this.f_row = f_row;
            this.f_col = f_col;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "From (" + f_row + "," + f_col + ") to (" + row + "," + col + ")";
        }
    }
}
