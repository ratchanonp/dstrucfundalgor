package datastr;

import java.util.HashMap;
import java.util.Random;

public class Graph {

    private Vertex[] vertices;
    private Edge[] edges;
    private HashMap<Edge, Integer> weight;

    /* constructor ที่รับจำนวน vertex และจำนวน edge ในกราฟมาแล้วสร้าง weighted graph โดยสุ่ม edge และน้ำหนักของ edge (1-4) */
    public Graph(int nVertex, int nEdge) {
        Random random = new Random();

        /* Allocation Part */
        vertices = new Vertex[nVertex];
        edges = new Edge[nEdge];
        weight = new HashMap<>();

        /* Graph Generation Part */
        for (int i = 0; i < nVertex; i++) vertices[i] = new Vertex(i);  // Loop สร้าง Vertex จำนวน nVertex

        int nEdgeCreated = 0;
        while(nEdgeCreated < nEdge) {
            Vertex srcVertex = vertices[random.nextInt(nVertex)];       // สุ่ม Source Vertex
            Vertex destVertex = vertices[random.nextInt(nVertex)];      // สุ่ม Destination Vertex

            Edge newEdge = new Edge(srcVertex, destVertex);              // สร้าง Edge ที่ได้จาก Vertex ที่สุ่ม
            int randomWeight = random.nextInt(1, 5);        // สุ่มน้ำหนักของ edge (1-4)

            // Check ว่ามี newEdge แล้วไหม
            if (!weight.containsKey(newEdge)){                          // ถ้าไม่มี
                edges[nEdgeCreated] = newEdge;                          // ใส่ Edge ใน Edge[] edges
                weight.put(edges[nEdgeCreated], randomWeight);          // ใส่ Edge ใน Hashmap <Key: Edge, Value: weight>
                nEdgeCreated++;                                         // นับเป็น 1 Edge ที่ไม่ซ้ำ
            }
        }
    }

    /*
        constructor ที่รับ adjacency matrix ของกราฟ (คือ array 2 มิติที่เก็บน้ำหนักของ edge ในกราฟ ค่าที่ตำแหน่ง [a, b] ใน array
        นี้เป็นน้ำหนักของ edge ระหว่าง vertex ที่ตำแหน่ง a และตำแหน่ง b ) แล้วมากราฟที่มี edge ที่มีน้ำหนักตามที่กำหนดด้วย
        adjacency matrix
     */
    public Graph(int[][] adjMat) {

        int nVertex = adjMat.length;
        int nEdge = 0;

        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] != 0) {
                    nEdge++;                                            // นับ Edge จากตำแหน่งที่ Weight ของ Edge ไม่เท่ากับ 0
                }
            }
        }

        /* Allocation Part */
        vertices = new Vertex[nVertex];
        edges = new Edge[nEdge];
        weight = new HashMap<>();

        for (int i = 0; i < adjMat.length; i++) vertices[i] = new Vertex(i);  // Loop สร้าง Vertex จำนวน nVertex

        int e = 0;
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                int weight = adjMat[i][j];

                if (weight != 0) {
                    edges[e] = new Edge(vertices[i], vertices[j]);
                    this.weight.put(edges[e], weight);
                    e++;
                }
            }
        }
    }

    /* ที่ตรวจสอบว่ามี edge e ในกราฟนี้หรือไม่ ถ้ามี ให้คืนค่าเป็นน้ำหนักของ edge e ถ้าไม่มี ให้คืนค่าเป็น 0 */
    public int weight(Edge e) {
        if (!weight.containsKey(e)) return 0;       // ถ้าไม่มี ให้คืนค่าเป็น 0
        return weight.get(e);                       // ถ้ามี ให้คืนค่าเป็นน้ำหนักของ edge e
    }

    /*
        toMatrix() ที่คืนค่าเป็น adjacency matrix ของกราฟ (adjacency matrix ของกราฟเป็น array 2 มิติที่เก็บน้ำหนักของ edge ใน
        กราฟ ค่าที่ตำแหน่ง [a, b] ใน array นี้เป็นน้ำหนักของ edge ระหว่าง vertex ที่ตำแหน่ง a และตำแหน่ง b )
     */
    public int[][] toMatrix() {
        int[][] result = new int[vertices.length][vertices.length];

        for (Edge edge : edges) {
            int sourceVertex = edge.getSource();
            int destVertex = edge.getDest();
            int edgeWeight = weight.get(edge);

            result[sourceVertex][destVertex] = edgeWeight;
        }

        return result;
    }
}
