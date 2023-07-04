package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
class AddEdgeStrategyTest {

    @Test
    void testStrategyPredicate(){
        GraphResolver.Graph graph = new GraphResolver.Graph(Collections.emptyList());
        List<GraphResolver.Graph> emptyList = Collections.emptyList();
        List<GraphResolver.Graph> oneElementList = List.of(graph);
        List<GraphResolver.Graph> twoElementList = List.of(graph, graph);
        List<GraphResolver.Graph> manyElementList = List.of(graph, graph, graph);

        AddEdgeStrategy strategy1 = AddEdgeStrategy.find(emptyList).get();
        AddEdgeStrategy strategy2 = AddEdgeStrategy.find(oneElementList).get();
        AddEdgeStrategy strategy3 = AddEdgeStrategy.find(twoElementList).get();
        boolean strategy4 = AddEdgeStrategy.find(manyElementList).isPresent();

        Assertions.assertEquals(AddEdgeStrategy.CREATE_NEW_GRAPH, strategy1);
        Assertions.assertEquals(AddEdgeStrategy.ADD_EDGE_TO_GRAPH, strategy2);
        Assertions.assertEquals(AddEdgeStrategy.JOIN_GRAPHS, strategy3);
        Assertions.assertFalse(strategy4);
    }

}
