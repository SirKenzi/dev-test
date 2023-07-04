package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public enum AddEdgeStrategy {
    CREATE_NEW_GRAPH(
            Collection::isEmpty,
            (graphs, edge) -> new GraphResolver.Graph(edge)
    ),
    ADD_EDGE_TO_GRAPH(
            graphs -> graphs.size() == 1,
            (graphs, edge) -> graphs.get(0).addEdge(edge)
    ),
    JOIN_GRAPHS(
            graphs -> graphs.size() == 2,
            (graphs, edge) -> graphs.get(0).join(graphs.get(1))
    );

    private final Predicate<Collection<GraphResolver.Graph>> predicate;
    private final BiFunction<List<GraphResolver.Graph>, GraphResolver.Edge, GraphResolver.Graph> resolver;

    AddEdgeStrategy(Predicate<Collection<GraphResolver.Graph>> predicate, BiFunction<List<GraphResolver.Graph>, GraphResolver.Edge, GraphResolver.Graph> resolver) {
        this.predicate = predicate;
        this.resolver = resolver;
    }

    public GraphResolver.Graph resolve(List<GraphResolver.Graph> graphs, GraphResolver.Edge edge){
        return this.resolver.apply(graphs, edge);
    }

    public static Optional<AddEdgeStrategy> find(Collection<GraphResolver.Graph> graphs){
        return Arrays.stream(values()).filter( strategy -> strategy.predicate.test(graphs)).findFirst();
    }


}
