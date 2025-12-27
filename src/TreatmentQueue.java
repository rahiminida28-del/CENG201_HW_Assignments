public class TreatmentQueue {   //
    private class Node{  //kuyruk elemanlari temsil eden ici
        TreatmentRequest req;
        Node next;
        Node(TreatmentRequest req){
            this.req = req;
            this.next = null;

        }
    }
    private Node front;    // kuyrugun basi . starting of Q or from there elements will dequeue
    private Node rear;  // kuyrugun sonu . end of Q element will add there
    private int count=0; //how people were there it will be count

    public void enqueue(TreatmentRequest req){//enqueue will add new req
        Node newNode = new Node(req);
        if(rear==null){ //  Eğer Q empty ise  yeni düğüm hem başlangıç hem bitiş olur
            front = newNode;
            rear = newNode;
        } else{  // Yeni elemanı sona ekleyip pointer'ı ear kaydırıyoruz
            rear.next = newNode;
            rear = newNode;

        }
        count++; //thz will update counting
    }
    public TreatmentRequest dequeue(){  // Q basindaki first elamanti remove yapar  ve dondurur
        if(front==null) {
            return null;
        }
        TreatmentRequest removeRequest = null; //store first elmnt which one removve
        front = front.next; //Front'u bir sonrakine atla ilk eleman listeden duser
        if(front == null){//eger son elaman remve olursa rear bosuna kakmasin ,make it zero
            rear = null;

        }
        count--; //Q size decrease
        return removeRequest; //return the remve one

    }
    public int size(){ // Q(+) talep sayısını verir
        return count;
    }
    public void printQueue(){ //it'll be listed all req
        Node current = front; //
        while(current!=null){
            System.out.println(current); //inside node yazdir
            current = current.next; //go in nxt node till empty

        }
    }


}
