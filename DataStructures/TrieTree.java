/*Trie Tree*/
/*
 Trie Tree is an extremely special and useful data-structure that are based on the prefix of a string.
 They are used to represent the “Retrieval” of data and thus the name Trie.
 Trie stores strings that can be visualized like a graph. It consists of nodes and edges.
 Each node consists of at max 26 children and edges connect each parent node to its children.
 Strings are stored in a top to bottom manner on the basis of their prefix in a trie.

*/


 /*
  Implement a trie tree with insert, search and startWith methods*/
Class TrieNode{
	char ch;
	HashMap<Character, TrieNode> children;
    boolean hasWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }
    
    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }
}

public class Trie{
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String s){
		
	}
 }