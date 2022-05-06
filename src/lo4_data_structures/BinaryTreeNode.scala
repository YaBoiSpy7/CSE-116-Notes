package lo4_data_structures

class BinaryTreeNode[B](var value:B, var left:BinaryTreeNode[B], var right:BinaryTreeNode[B]) {
  def preOrderTraversal[B](node:BinaryTreeNode[B]):String={
    var out:String=""
    if (node!=null) {
      //top
      out += node.value+" "
      //left
      out += preOrderTraversal(node.left)
      //right
      out += preOrderTraversal(node.right)
    }
    out
  }
  def inOrderTraversal[B](node:BinaryTreeNode[B]):String={
    //left
    //top
    //right

    var out:String=""
    if (node!=null) {
      //left
      out += inOrderTraversal(node.left)
      //top
      out += node.value+" "
      //right
      out += inOrderTraversal(node.right)

    }
    out
  }
  def postOrderTraversal[B](node:BinaryTreeNode[B]):String={
    //left
    //right
    //top
    var out:String=""
    if (node!=null) {
      //left
      out += postOrderTraversal(node.left)
      //right
      out += postOrderTraversal(node.right)
      //top
      out += node.value+" "
    }
    out
  }

  def lo4Test[B](node:BinaryTreeNode[B]): Unit={
    if (node != null){
      if (node.left != null){
        lo4Test(node.left)
      } else{
        println("left")
      }
      if (node.right != null){
        lo4Test(node.right)
      } else{
        println("right")
      }
      println(node.value)
    }
  }
}


object runBTN{
  def main(args: Array[String]): Unit = {


    var root=new BinaryTreeNode[Int](0,null,null)
    root.left=new BinaryTreeNode[Int](-4,null,null)
    root.right=new BinaryTreeNode[Int](3,null,null)
    //root.left.left=new BinaryTreeNode[Int](-1,null,null)
    root.left.right=new BinaryTreeNode[Int](-1,null,null)
    //root.right.left=new BinaryTreeNode[Int](6,null,null)
    //root.right.right=new BinaryTreeNode[Int](9,null,null)

    //println(root.preOrderTraversal(root))
    //println(root.inOrderTraversal(root))
    //println(root.postOrderTraversal(root))
    root.lo4Test(root)
  }
}