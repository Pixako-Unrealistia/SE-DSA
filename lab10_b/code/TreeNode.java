package code;




public class TreeNode {
  public int data;
  TreeNode left, right, parent;
  public TreeNode(int d) {
    data = d;
  }
  @Override
  public String toString() {
    // There are 4 cases no child,
    // left-child-only,
    // right-child-only,
    //and both children

	if (left != null && right != null)
	  return left.data + "<-" + data + "->" + right.data;
	if (left != null)
	  return left.data + "<-" + data + "->null";
	if (right != null)
	  return "null<-" + data + "->" + right.data;
	  
    return "null<-" + data + "->null";
    // no child
  }
}
