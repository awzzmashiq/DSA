/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        HashMap<Node,Node> map=new HashMap<>();
        //map.put(null,null);

        Node curr=head;
        
        while(curr!=null){
            Node copy= new Node(curr.val);
            map.put(curr,copy);
            //System.out.println(map.get(curr).val);
            curr=curr.next;
        }

        curr=head;

        while(curr!=null){
            Node cpy=map.get(curr);
            cpy.next=map.get(curr.next);
            cpy.random=map.get(curr.random);
            //System.out.println(cpy.val+" "+cpy.next.val+" "+cpy.random.val+" "+curr.val+" "+curr.next.val+" "+curr.random.val);
            curr=curr.next;
        }
        return map.get(head);
        
    }
}