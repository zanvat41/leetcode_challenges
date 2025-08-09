class GNode {
    public Integer inDegrees = 0;
    public List<Integer> outNodes = new LinkedList<Integer>();
}


class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = {};
        List<Integer> resList = new ArrayList<Integer>();

        if (prerequisites.length == 0){
            res = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
                res[i] = i;
            return res;
        }

        // course -> list of next courses
        HashMap<Integer, GNode> graph = new HashMap<>();

        // build the graph first
        for (int[] relation : prerequisites) {
            // relation[1] -> relation[0]
            GNode prevCourse = this.getCreateGNode(graph, relation[1]);
            GNode nextCourse = this.getCreateGNode(graph, relation[0]);

            prevCourse.outNodes.add(relation[0]);
            nextCourse.inDegrees += 1;
        }

        // We start from courses that have no prerequisites.
        int totalDeps = prerequisites.length;
        LinkedList<Integer> nodepCourses = new LinkedList<Integer>();
        for (Map.Entry<Integer, GNode> entry : graph.entrySet()) {
            GNode node = entry.getValue();
            if (node.inDegrees == 0)
                nodepCourses.add(entry.getKey());
        }

        for(int i = 0; i < numCourses; i++) {
            if(!graph.containsKey(i))
                resList.add(i);
        }

        int removedEdges = 0;
        while (nodepCourses.size() > 0) {
            Integer course = nodepCourses.pop();
            resList.add(course);

            for (Integer nextCourse : graph.get(course).outNodes) {
                GNode childNode = graph.get(nextCourse);
                childNode.inDegrees -= 1;
                removedEdges += 1;
                if (childNode.inDegrees == 0)
                    nodepCourses.add(nextCourse);
            }
        }
        if (removedEdges != totalDeps)
            // if there are still some edges left, then there exist some cycles
            // Due to the dead-lock (dependencies), we cannot remove the cyclic edges
            return res;
        else {
            res = new int[numCourses];
            int i;
            for(i = 0; i < resList.size(); i++){
                res[i] = resList.get(i);
            }

            return res;
        }
    }

    /**
     * Retrieve the existing <key, value> from graph, otherwise create a new one.
     */
    protected GNode getCreateGNode(HashMap<Integer, GNode> graph, Integer course) {
        GNode node = null;
        if (graph.containsKey(course)) {
            node = graph.get(course);
        } else {
            node = new GNode();
            graph.put(course, node);
        }
        return node;
    }
}
