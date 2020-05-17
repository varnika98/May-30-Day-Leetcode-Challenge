/*
Problem : 
mplement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

class Trie {
    
    private final TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    private class TrieNode{
        char data;
        boolean eow;
        TrieNode[] childrens;
        
        public TrieNode(){
            childrens = new TrieNode[26];
        }
        
        public TrieNode(char data){
            this.data = data;
            this.eow = false;
            this.childrens = new TrieNode[26];
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.childrens[index] == null)
                current.childrens[index] = new TrieNode(c);
            current = current.childrens[index];
        }
        current.eow = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(current.childrens[index] == null)
                return false;
            current = current.childrens[index];
        }
        return current.eow;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(current.childrens[index] == null)
                return false;
            current = current.childrens[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */



// Hash Map Implementation
// class Trie {
    
//     private final TrieNode root;

//     /** Initialize your data structure here. */
//     public Trie() {
//         root = new TrieNode();
//     }
    
//     private class TrieNode{
//         Map<Character, TrieNode> children;
//         boolean eow;
        
//         public TrieNode(){
//             children = new HashMap<>();
//             eow = false;
//         }
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         TrieNode current = root;
//         for(int i=0; i<word.length(); i++){
//             char c = word.charAt(i);
//             TrieNode node = current.children.get(c);
//             if(node == null){
//                 node = new TrieNode();
//                 current.children.put(c, node);
//             }
//             current = node;
//         }
//         current.eow = true;
//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         TrieNode current = root;
//         for(int i=0; i<word.length(); i++){
//             char c = word.charAt(i);
//             TrieNode node = current.children.get(c);
//             if(node == null)
//                 return false;
//             current = node;
//         }
//         return current.eow;
//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         TrieNode current = root;
//         for(int i=0; i<prefix.length(); i++){
//             char c = prefix.charAt(i);
//             TrieNode node = current.children.get(c);
//             if(node == null)
//                 return false;
//             current = node;
//         }
//         return true;
//     }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */