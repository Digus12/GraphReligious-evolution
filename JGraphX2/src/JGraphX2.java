import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
public class JGraphX2 extends JFrame
{

    private static final long serialVersionUID = -2707712944901661771L;
    SimpleTreeNode<String> root = createSimpleTreeNode();

    public void fillGraphFromModel( mxGraph graph)  {
        graphUpdate();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            Object root = graph.insertVertex(parent, "treeRoot", "Nostratic", 0, 0, 60, 40);

            Object v1 = graph.insertVertex(parent, "v1", "Proto-Indo Europeans", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v1);

            Object v2 = graph.insertVertex(parent, "v2", "Arabian ", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v2);

            Object v3 = graph.insertVertex(parent, "v3", "Asian", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v3);

            Object v4 = graph.insertVertex(parent, "v4", "Vedic", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", root, v4);



            Object v111 = graph.insertVertex(parent, "v11", "Greek", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v1, v111);

            Object v1111 = graph.insertVertex(parent, "v111", "Greco-Roman", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v111, v1111);

            Object v11111 = graph.insertVertex(parent, "v11111", "Hermeticism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v1111, v11111);

            Object v12 = graph.insertVertex(parent, "v12", "Indo-Iranian", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v1, v12);
            Object v122 = graph.insertVertex(parent, "v12", "Zoroastrianism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v12, v122);

            Object v21 = graph.insertVertex(parent, "v21", "Egyptian", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2, v21);

            Object v22 = graph.insertVertex(parent, "v22", "Mesopotamian", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2, v22);

            Object v222 = graph.insertVertex(parent, "v222", "Canaanite", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v22, v222);
            Object v2222 = graph.insertVertex(parent, "v2222", "Judaism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v222, v2222);
            Object v22222 = graph.insertVertex(parent, "v2222", "Christianity", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2222, v22222);
            Object v222222 = graph.insertVertex(parent, "v2222", "Islam", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v2222, v222222);



            Object v31 = graph.insertVertex(parent, "v31", "Shenism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v3, v31);
            Object v311 = graph.insertVertex(parent, "v311", "Taoism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v31, v311);
            Object v3111 = graph.insertVertex(parent, "v3111", "Shinto", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v31, v3111);


            Object v41 = graph.insertVertex(parent, "v41", "Buddhism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v4, v41);

            Object v411 = graph.insertVertex(parent, "v41", "Bon", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v41, v411);
            Object v4111 = graph.insertVertex(parent, "v411", "Vajrayana", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v41, v4111);
            Object v41111 = graph.insertVertex(parent, "v4111", "Mahayana", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v41, v41111);

            Object v42 = graph.insertVertex(parent, "v41", "Hinduism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v4, v42);
            Object v422 = graph.insertVertex(parent, "v42", "Sikthism", 0, 0, 60, 40);
            graph.insertEdge(parent, null, "", v42, v422);


            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);

            layout.execute(parent);
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
    }

    public JGraphX2()
    {
        super("Simple Tree Node");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);


    }

    public SimpleTreeNode<String> createSimpleTreeNode() {
        root = new SimpleTreeNode<>("Animism");



        SimpleTreeNode<String> child1 = new SimpleTreeNode<>("Nostratic");
        child1.addChild("Proto-Indo European ");
        child1.addChild("Asian");


        SimpleTreeNode<String> child2 = new SimpleTreeNode<>("Aboriginal");


        root.addChild(child1);
        root.addChild(child2);
        SimpleTreeNode<String> child3 = new SimpleTreeNode<>("Arabian");
        root.addChild(child3);

        root.addChildren(Arrays.asList(
                new SimpleTreeNode<>("Indian"),
                new SimpleTreeNode<>("New Guinean"),
                new SimpleTreeNode<>("Polynesian ")
        ));
        for (SimpleTreeNode child: root.getChildren()) {
            root.printChildren(child);
        }
        return root;
    }


    // Backup not used
    public void graphUpdate() {
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();
        try
        {
            //Notice that the parent is the default parent...
            //The hierarchical structure looks great but I cannot collapse/expand the tree.
            Object vDogsRoot = graph.insertVertex(parent, null, "Whale", 80, 0, 80, 30);
            Object v2 = graph.insertVertex(parent, null, "Shar Pei", 0, 0, 80, 30);
            Object v3 = graph.insertVertex(parent, null, "Pug", 0, 0, 80, 30);
            Object v4 = graph.insertVertex(parent, null, "Cocker Spaniel", 0, 0, 80, 30);
            Object v5 = graph.insertVertex(parent, null, "Pit Bull", 0, 0, 80, 30);
            Object v6 = graph.insertVertex(parent, null, "Chihuahua", 0, 0, 80, 30);
            Object v7 = graph.insertVertex(null, null, "GrandPuppy", 0,0,90,30);
            Object v8 = graph.insertVertex(null, null, "GrandPuppy2", 0,0,90,30);
            Object v9 = graph.insertVertex(null, null, "GrandPuppy3", 0,0,90,30);
            graph.insertEdge(parent, null, "", vDogsRoot, v2);
            graph.insertEdge(parent, null, "", vDogsRoot, v3);
            graph.insertEdge(parent, null, "", vDogsRoot, v4);
            graph.insertEdge(parent, null, "", vDogsRoot, v5);
            graph.insertEdge(parent, null, "", vDogsRoot, v6);
            graph.insertEdge(v6, null, "", v6, v7);
            graph.insertEdge(v6, null, "", v6, v8);
            graph.insertEdge(v6, null, "", v6, v9);

            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);

            layout.execute(parent);
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);
    }

    public static void main(String[] args)
    {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 420);
        frame.setVisible(true);
    }

}