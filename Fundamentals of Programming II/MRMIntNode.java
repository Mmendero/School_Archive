//******************************************************************************************
// MRMIntNode.java   Author: Matthew Ryan Mendero-Atis     Section: 02
//******************************************************************************************
public class MRMIntNode {
   private int dataVal;
   private MRMIntNode nextNodePtr;

   public MRMIntNode(int dataInit, MRMIntNode nextLoc) {
      this.dataVal = dataInit;
      this.nextNodePtr = nextLoc;
   }

   public MRMIntNode(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodePtr = null;
   }

   /* Insert node after this node.
   * Before: this -- next
   * After:  this -- node -- next
   */
   public void insertAfter(MRMIntNode nodePtr) {
      MRMIntNode tmpNext;

      tmpNext = this.nextNodePtr;    // Remember next
      this.nextNodePtr = nodePtr;    // this -- node -- ?
      nodePtr.nextNodePtr = tmpNext; // this -- node -- next
   }

   // Grab location pointed by nextNodePtr
   public MRMIntNode getNext() {
      return this.nextNodePtr;
   }
   public int getDataVal() {
      return this.dataVal;
   }
}