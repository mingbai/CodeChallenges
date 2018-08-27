/*
1.	What is segment tree?
Segment tree is binary tree。The structure is almost the same as binary tree.
Each node has two child nodes:
	left node
	right node
Each node is constructed with a segment, which states the start and end of the segment:
	start
	end
Thus, some problems which are based on segments can be efficiently solved by using segment tree.

2.	Operations on segment tree
	a.	build segment tree: O(n)
	b.	modify segment tree: O(log(n))
	c.	retrieve segment tree: O(log(n))s
*/



/*Operations on SegmentTree/
// 1. build segment tree
/*
The structure of Segment Tree is a binary tree which each node has two attributes start and end denote an segment/interval.

Start and end are both integers, they should be assigned in following rules:
	The root's start and end is given by build method.
	The left child of node A has start=A.left, end=(A.left + A.right) / 2.
	The right child of node A has start=(A.left + A.right) / 2 + 1, end=A.right.
	if start equals to end, there will be no children for this node.
	Implement a build method with two parameters start and end, so that we can create a corresponding segment tree with every node has the correct start and end value,
	return the root of this segment tree.
*/

public class SegmentTreeNode {
	public int start;
	public int end;
	public SegmentTreeNode left;
	public SegmentTreeNode right;

	SegmentTreeNode(int start, int end) {
		this.start = start;
		this.end = end;
		this.left = this.right = null;
	}
}

public SegmentTreeNode buildSegmentTree(int start, int end) {
	if (start > end) {
		return null;
	}

	SegmentTreeNode node = new SegmentTreeNode(start, end);
	if (start != end) {
		int mid = (start + end) / 2;
		node.left = buildSegmentTree(start, mid);
		node.right = buildSegmentTree(mid + 1, end);
	}

	return node;
}

/*
Implement a build method with a given array, so that we can create a corresponding segment tree
with every node value represent the corresponding interval max value in the array, 
return the root of this segment tree.
*/
public class SegmentTreeNode {
	public int start;
	public int end;
	public int max;

	public SegmentTreeNode left;
	public SegmentTreeNode right;

	SegmentTreeNode(int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = this.right = null;
	}
}

public SegmentTreeNode buildSegmentTree2(int[] A) {
	root = buildTree(0, A.length - 1, A);

	return root;
}

public SegmentTreeNode buildTree(int start, int end, int[] A) {
	if (start > end) {
		return null;
	}
	if (start == end) {
		return buildTree(start, end, A[start]);
	}

	SegmentTreeNode node = new SegmentTreeNode(start, end, A[start]);

	int mid = (start + end) / 2;
	node.left = buildTree(start, mid, A);
	node.right = buildTree(mid + 1, end, A);
	
	if (node.left != null && node.left.max > node.max)
		node.max = node.left.max;
    
    if (node.right != null && node.right.max > node.max)
    	node.max = node.right.max;
    
    return node;

}

// 2. modify segment tree
/*
For a Maximum Segment Tree, which each node has an extra value max to store the maximum value in this node's interval.
Implement a modify function with three parameter root, index and value to change the node's value with [start, end] = [index, index] to the new given value.
Make sure after this change, every node in segment tree still has the max attribute with the correct value.
*/
// SegmentTreeNode is defined as above with a max value.

// index < start || index > end return
// start < index < end
//		
//		start~mid => left tree
//		mid+1 ~ end => right tree
// index == start and index == end
//		update max = value;

public void modifySegmentTree(SegmentTreeNode root, int index, int valud) {
	if (index < root.start || index > root.end) {
		return;
	}
	if (index == root.start && index == root.end) {
		root.max = value;
		return;
	}

	int mid = (root.start + root.end) / 2;
	if(root.start <= index && index <= mid) {
		modify(root.left, index, value);
	}
	if(mid < index && index <= root.end) {
		modify(root.right, index, value);
	}

	root.value = Math.max(root.left.max, root.right.max);

}


// 3. query segment tree
/*
For an integer array (index from 0 to n-1, where n is the size of this array), in the corresponding SegmentTree,
each node stores an extra attribute max to denote the maximum number in the interval of the array (index from start to end).
Design a query method with three parameters root, start and end, find the maximum number in the interval [start, end] by the given root of segment tree.
*/


// a. start == root.start && end == root.end => return root.max;
// b. on left
// c. on right
// d. seperated by mid, max(left, right)
//		mid = (root.start + root.end) / 2
// 		start could be 
public int query(SegmentTreeNode root, int start, int end) {
	if (root.start == start && root.end == end) {
		return root.max;
	}

	int mid = (root.start + root.end) / 2;
	int left = Integer.MIN_VALUE;
	int right = Integer.MIN_VALUE;

	// on left
	if (end <= mid) {
		return query(root.left, start, end);
	}
	// on right
	if (start > mid) {
		return query(root.right, start, end);
	}
	// seperated by mid
	left = query(root.left, start, mid);
	right = query(root.right, mid + 1, end);

	return Math.max(left, right);
}


/*
For an array, we can build a SegmentTree for it, each node stores an extra attribute count to denote the number of elements in the array,
which value is between interval start and end. (The array may not fully filled by elements)
Design a query method with three parameters root, start and end, find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.
*/

// first define the segment tree node, it's almost the same as above, just replace max with count
class SegmentTreeNode {
	public int start;
	public int end;
	public int count;
	public SegmentTreeNode left;
	public SegmentTreeNode right;

	public SegmentTreeNode(int start, int end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
		this.left = null;
		this.right = null;
	}
}

public int query(SegmentTreeNode root, int start, int end) {
        if (start > end || root == null) {
            return 0;
        }
        
        if (start <= root.start && root.end <= end) {
            return root.count;
        }
        
        int mid = root.start + (root.end - root.start) / 2;
        int left = 0;
        int right = 0;
        
        if (start <= mid) {
            if (mid < end) {
                left = query(root.left, start, mid);
            }
            else {
                left = query(root.left, start, end);
            }
        }
        
        if (mid < end) {
            if (start <= mid) {
                right = query(root.right, mid + 1, end);
            }
            else {
                right = query(root.right, start, end);
            }
        }
        return left + right;
    }


