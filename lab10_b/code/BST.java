//65011544 Sorawis Chongterdtoonskul

package code;

public class BST {
  TreeNode root;
  public BST() {
    root = null;
  }
  public TreeNode getRoot() {
    return root;
  }

  public void insert(int d) {
    if (root == null) {
      root = new TreeNode(d);
    } else {
      TreeNode cur = root;
      while (cur != null) {
        if (d < cur.data) {
          if (cur.left != null)
            cur = cur.left;
          else {
            cur.left = new TreeNode(d);
            cur.left.parent = cur;
            return;

          }
        } else { //! (d < p.data)
          if (cur.right != null)
            cur = cur.right;

          else {
            cur.right = new TreeNode(d);
            cur.right.parent = cur;
            return;
          }
        }
      } //while
    }
  } //insert by iteration
  public void printPreOrder() {
    printPreOrderRecurse(root);
  }
  private void printPreOrderRecurse(TreeNode node) {
    if (node == null) return;
    System.out.print(node.data + " ");
    printPreOrderRecurse(node.left);
    printPreOrderRecurse(node.right);
  }

  public void printInOrder() {
    printInOrderRecurse(root);
  }
  private void printInOrderRecurse(TreeNode node) {
    if (node == null) return;
    printInOrderRecurse(node.left);
    System.out.print(node.data + " ");
    printInOrderRecurse(node.right);
  }
  public void printPostOrder() {
    printPostOrderRecurse(root);
  }
  private void printPostOrderRecurse(TreeNode node) {
    if (node == null) return;
    printPostOrderRecurse(node.left);
    printPostOrderRecurse(node.right);
    System.out.print(node.data + " ");

  }

  public TreeNode search(int d) {
    TreeNode result = searchRecurse(d, root);
    return result;
  }
  public TreeNode searchRecurse(int d, TreeNode n) {
    if (n == null) return null;
    if (d == n.data) return n;

    if (d < n.data)
      return searchRecurse(d, n.left);
    else
      return searchRecurse(d, n.right); //should work?
  }

  public TreeNode searchIter(int key) {
    TreeNode current = root;
    while (current != null) {
      if (current.data == key)
        return current;
      else if (key < current.data) {
        if (current.left != null)
          current = current.left;
        else
          break;
      } else {
        if (current.right != null)
          current = current.right;
        else
          break;
      }
    }
    return null;
  }

  public int height() {
	return root == null ? 0 : height(root);
	}
	public int height(TreeNode node) {
	if (node == null)
		return 0;
	else {
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		return 1 + Math.max(leftHeight, rightHeight);
		}
	}

	public TreeNode findMaxFrom(TreeNode subtreeHead) {
		TreeNode current = subtreeHead;
		while (current != null && current.right != null)
			current = current.right;
		
	return current;
	}

}