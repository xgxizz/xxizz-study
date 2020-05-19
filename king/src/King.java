import java.util.Stack;

public class King {

    public static void main(String[] args) {


    }

    public static void choose(Graph graph){

        if (graph.getEdges().length == 0){
            return;
        }
        else if (graph.getEdges().length == 1){
            Edge edge = graph.getEdges()[0];
            System.out.println("公主："+ edge.getVertex0() +"，王子："+edge.getVertex1() + "最大彩礼数：" + edge.getWeight());
        }else{
            //选出最大值，输出，去边

        }
    }

    Edge selectMaxEdge(Graph graph){
        Edge maxEdge = graph.getEdges()[0];
        for (Edge e: graph.getEdges()) {
            //if ()
            maxEdge = e;
        }
        return maxEdge;
    }
}
