/*
// My BFS Solution

class Solution {
    boolean visited[];
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Mark all the vertices as not visited(By default
        // set as false)
        visited = new boolean[wordList.size()];

        // Create a queue for BFS
        LinkedList<Pair<String, Integer>> queue = new LinkedList();

        // Mark the current node as visited and enqueue it
        queue.add(new Pair(beginWord, 0));

        while (queue.size() != 0) {
            Pair<String, Integer> p = queue.poll();

            if(endWord.equals(p.getKey())) return p.getValue() + 1;


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            List<Integer> adj = findNeighbor(p.getKey(), wordList);
            for(int i = 0; i < adj.size(); i++) {
                int n = adj.get(i);
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(new Pair(wordList.get(n), p.getValue()+1));
                }
            }
        }
        return 0;
    }

    private boolean isOneDiff(String s1, String s2){
        int count = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 1)
                    return false;
            }
        }
        return true;
    }

    private List<Integer> findNeighbor(String s, List<String> list){
        List<Integer> res = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            if(visited[i]) continue;
            if(isOneDiff(s, list.get(i))) res.add(i);
        }
        return res;
    }
}
*/
// Better Performance Solution
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
                        List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
