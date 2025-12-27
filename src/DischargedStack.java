public class DischargedStack {
    private class  Node{
        DischargedRecord record;
        Node next;
        Node(DischargedRecord record){
            this.record = record;
            this.next = null;

        }
    }
    private Node top;   //stcaks top
    public void push(DischargedRecord record){  //push will add new recosrd on the top
        Node newNode = new Node(record);
        newNode.next = top;
        top = newNode;
    }
     public DischargedRecord pop(){ //pop en ustteki record cikarir ve dondurur
        if(top == null) return null;
        DischargedRecord rec = top.record;
            top = top.next;
            return rec;

     }
     public DischargedRecord peek(){ //peek  view the top recorad without delete
        if(top != null) return top.record;
        else return null;

     }

public void printStack(){
        Node curr = top;
        while(curr != null){
            System.out.println(curr.record);
            curr = curr.next;
        }
}
}
