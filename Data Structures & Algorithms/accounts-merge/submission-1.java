class Solution {
    Map<String, String> parent = new HashMap<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!parent.containsKey(email)) {
                    parent.put(email, email);
                }
                emailToName.put(email, name);
                union(firstEmail, email);
            }
        }

        Map<String, List<String>> groups = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = find(email);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (String root : groups.keySet()) {
            List<String> mergedAccount = groups.get(root);
            Collections.sort(mergedAccount);
            mergedAccount.add(0, emailToName.get(root));
            result.add(mergedAccount);
        }

        return result;
    }

    private String find(String i) {
        if (parent.get(i).equals(i)) {
            return i;
        }
        parent.put(i, find(parent.get(i)));
        return parent.get(i);
    }

    private void union(String i, String j) {
        String rootI = find(i);
        String rootJ = find(j);
        if (!rootI.equals(rootJ)) {
            parent.put(rootI, rootJ);
        }
    }
}