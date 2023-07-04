package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class GraphResolverTest {

    @Test
    void testGraphResolver(){
        List<GraphResolver.Edge> edges = List.of(
                new GraphResolver.Edge(3, 2),
                new GraphResolver.Edge(1, 3),
                new GraphResolver.Edge(7, 9),
                new GraphResolver.Edge(10, 12),
                new GraphResolver.Edge(2, 7)
        );

        GraphResolver graphResolver = new GraphResolver();
        edges.forEach(graphResolver::addEdge);

        Assertions.assertEquals(2, graphResolver.getGraphsAmount());
    }

}
