/*
Problem : 
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
*/

/*
Analysis ::
Time Complexity :: O(V + E)
Space Complexity :: O(V)
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<numCourses; i++)
            if(indegree[i] == 0)
                s.add(i);
        int count = 0;
        while(!s.isEmpty()){
            int v = s.pop();
            count++;
            if(!graph.containsKey(v))
                continue;
            for(int u : graph.get(v)){
                indegree[u]--;
                if(indegree[u] == 0)
                    s.add(u);
            }
        }
        return count==numCourses;
    }
}