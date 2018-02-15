/* UnionFind
Union-Find is a data structure that maintains disjoint set(connected components) memberships.
And make it easier to merge (Union) two components and find if two components are connected or not.

*/

class UnionFind {

	int i;
	int[] father;

	UnionFind(int i){
		father = new int[i];
	}

	public void Union(int a, intb) {
		int f_a = father[a];
		int f_b = father[b];
		if(f_a != f_b) {
			father[f_a] = f_b; 
		}
	}

	public int Find(int a) {
		if (x == father[x]) {
			return x;
		} else {
			return find(father[x]);
		}
	}
}

