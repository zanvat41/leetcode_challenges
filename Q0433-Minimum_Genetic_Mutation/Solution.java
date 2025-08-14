class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) return 0;

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;

        char[] genesChars = new char[] {'A', 'C', 'G', 'T'};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);
        visited.add(startGene);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++; // increment level at the start of BFS layer (mutations count)

            for (int i = 0; i < size; i++) {
                char[] gene = queue.poll().toCharArray();

                for (int j = 0; j < gene.length; j++) {
                    char originalChar = gene[j];

                    for (char g : genesChars) {
                        if (g == originalChar) continue;

                        gene[j] = g;
                        String mutated = new String(gene);

                        if (mutated.equals(endGene)) {
                            return level;
                        }

                        if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                            visited.add(mutated);
                            queue.add(mutated);
                        }
                    }
                    gene[j] = originalChar; // revert for next iteration
                }
            }
        }

        return -1;
    }
}