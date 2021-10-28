 /**
    思路：和课程表1一样的拓扑排序，但在排序过程中记录出Queue的顺序，最后判断是否有环。若有环返回[]，无环返回记录的顺序。
    空间复杂度：O(n)。要记录图的出边和节点的入度。
    时间复杂度：假设节点的平均出度为k。O(nk)
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            Set<Integer> pres = graph.getOrDefault(prerequisites[i][1], new HashSet<>());
            pres.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], pres);
            inDegrees[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()) {
            int course = q.poll();
            result[index++] = course;
            Set<Integer> nexts = graph.getOrDefault(course, new HashSet<>());
            for(int n : nexts) {
                inDegrees[n]--;
                if(inDegrees[n] == 0) {
                    q.offer(n);
                }
            }
            graph.remove(course);
        }
        return graph.isEmpty() ? result : new int[]{};
    }
}
