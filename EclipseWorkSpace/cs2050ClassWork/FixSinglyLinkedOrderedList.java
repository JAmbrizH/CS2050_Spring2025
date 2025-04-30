/**
 * 
 */

/**
 * 
 */

public class FixSinglyLinkedOrderedList
{

	// Test the Singly Linked List
	public static void main(String[] args)
	{


		SinglyLinkedListFix list = new SinglyLinkedListFix();
		list.insertNode(4);
		list.insertNode(2);
		list.insertNode(8);
		list.insertNode(3);

		list.printList();
		list.deleteNode(0);
		list.deleteNode(3);
		list.printList();


	}

}

/**
 * this.next = null; is a self-Referencial
 */

class NodeFix {
    int data;
    NodeFix next;

    public NodeFix(int data) {
        this.data = data; // reference to where it is 
        this.next = null;
    }
}



class SinglyLinkedListFix {
	NodeFix head;

	/**
	 * the issue is that in the else-statement the newNode connects to the previous node 
	 * but forgot to add a lick to the current node so I implemented 
	 * newNode.next = current; to fix it.
	 */
	
    public void insertNode(int number) {
    	NodeFix newNode = new NodeFix(number);
    	NodeFix current = head;
    	NodeFix previous = null;

        while (current != null && current.data < number) {
            previous = current;
            current = current.next;
        }
        
        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            previous.next = newNode;
            newNode.next = current;
        }
    }

 
    /**
     * The issues that I noted is that in the while loop on line 82
     */ 
    
    public void deleteNode(int number) {
    	NodeFix current = head;
    	NodeFix previous = null;

        while (current.next != null && current.data != number) { // Bug #3: Incorrect loop termination
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            head = current.next;
        } else {
            previous.next = null; // Bug #5: Should be previous.next = current.next
        }
    }

    public void printList() {
    	NodeFix current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}