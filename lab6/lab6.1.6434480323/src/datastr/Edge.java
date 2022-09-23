package datastr;

import java.util.Objects;

public class Edge {
    private Vertex st, end;

    public Edge(Vertex b, Vertex e) {
        st = b;
        end = e;
    }

    public int getSource() {
        return st.getName();
    }

    public int getDest() {
        return end.getName();
    }

    // เพิ่มเติมสำหรับ Hashmap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge edge)) return false;

        if (edge.getSource() != this.getSource()) return false;
        return edge.getDest() == edge.getDest();
    }

    @Override
    public int hashCode() {
        int result = st.getName();
        result = 32 * result + end.getName();
        return result;
    }
}
