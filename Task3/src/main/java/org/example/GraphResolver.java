package org.example;

import java.util.*;

public class GraphResolver {

    private final List<Graph> graphs;

    public GraphResolver() {
        this.graphs = new ArrayList<>();
    }

    public void addEdge(Edge edge){
        List<Graph> foundGraphs = graphs.stream()
                .filter( graph -> graph.contains(edge.a()) || graph.contains(edge.b()))
                .toList();

        AddEdgeStrategy.find(foundGraphs).ifPresent( strategy -> {
            Graph resolvedGraph = strategy.resolve(foundGraphs, edge);
            if( resolvedGraph != null ){
                graphs.removeAll(foundGraphs);
                graphs.add(resolvedGraph);
            }
        });
    }

    public int getGraphsAmount(){
        return graphs.size();
    }

    public record Edge(int a, int b){}

    public static class Graph{
        private final Set<Integer> points;

        public Set<Integer> getPoints() {
            return points;
        }

        public Graph(Edge edge) {
            this.points = new HashSet<>(Set.of(edge.a(), edge.b()));
        }

        public Graph(Collection<Integer> points) {
            this.points = new HashSet<>(points);
        }

        public Graph addEdge(Edge edge){
            this.points.add(edge.a());
            this.points.add(edge.b());
            return null;
        }

        public Graph join(Graph other){
            this.getPoints().addAll(other.getPoints());
            return new Graph(this.getPoints());
        }

        public boolean contains(int a){
            return points.contains(a);
        }
    }


}
