/*
Problem : 
Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.

Each person may dislike some other people, and they should not go into the same group. 

Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.

Return true if and only if it is possible to split everyone into two groups in this way.

Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]

Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false

Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false

*/

/*
Analysis ::
Time Complexity :: O(V + E)
Space Complexity :: O(V)
*/

class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : dislikes){
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>()); 
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[N+1];
        boolean color[] = new boolean[N+1];
        for(int i=1; i<=N; i++){
            if(!visited[i])
                if(!dfs(graph, i, visited, color))
                    return false;
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int v, boolean[] visited, boolean[] color){
        visited[v] = true;
        if(!graph.containsKey(v))
            return true;
        for(int u : graph.get(v)){
            if(!visited[u]){
                visited[u] = true;
                color[u] = !color[v];
                if(!dfs(graph, u, visited, color))
                    return false;
            }
            else if(color[v] == color[u])
                return false;
        }
        return true;
    }
}