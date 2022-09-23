package datastr;

public class Vertex {
    private int name;

    public Vertex(int name) {
        this.name = name;
    }

    public int getName() {
        return name;
    }

    public String toString() {
        return "" + name;
    }

    // เพิ่มเตืมสำหรับ Hashmap
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex vertex)) return false;

        return name == vertex.name;
    }

    @Override
    public int hashCode() {
        return name;
    }
}
