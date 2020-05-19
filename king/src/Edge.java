public class Edge {
    private int vertex0;//公主
    private int vertex1;//王子
    private int weight;//权重

    public Edge(int vertex0, int vertex1, int weight) {
        this.vertex0 = vertex0;
        this.vertex1 = vertex1;
        this.weight = weight;
    }

    public int getVertex0() {
        return vertex0;
    }

    public int getVertex1() {
        return vertex1;
    }

    public int getWeight() {
        return weight;
    }
}
