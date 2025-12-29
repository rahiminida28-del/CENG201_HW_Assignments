import org.w3c.dom.Node;

public class patientList {
    public patientList allPatient;
    private Node head;

    public void TreatmentProcess() {
    }

    public void displayState() {
    }

    private class Node {
        patient data;  //burda hastanin datalarini tutcam
        Node next;

        Node(patient p) {
            this.data = p;
            this.next = null;

        }
    }

    //yeni hasta eklemek icin
    public void addPatient(patient p) {
        Node newNode = new Node(p);
        if (head == null) {
            head = newNode;

        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;


            }
            current.next = newNode;
        }
    }

    public void removePatient(int id) { //look id and then remove
        if (head == null) return; //if list was empty then do nothing
        if (head.data.id == id) { //if patient is on the top
            head = head.next;
            return;


        }
        Node current = head; //Silinecek ID'den bir önceki düğümü bulana kadar ilerle
        while (current.next != null) {
            if (current.next.data.id == id) {  // Eğer ID bulunduysa, aradaki bağı kopar ve bir sonrakine bağla
                current.next = current.next.next;
                return;
            }
        }
    }

    public patient findPatient(int id) { //id gore hastayi bulma
        Node current = head;
        while (current!= null) {
            if (current.data.id == id){
                return  current.data; // Hastayı bulursa döndürür

            }
            current = current.next;
        }
        return null; //if patient couldnt found then it will be null means empty

    }
    public void printPatientList() {
        Node current = head;
        if (current == null) {
            System.out.println("patient not found");
            return;


        }
        while (current != null) {
            System.out.println(current.data.toString());
            current = current.next;

        }
    }
    public void sortBySickness() { //Null hatasini cozmek icin hospital nesnesini ve listeyi new ile baslattim
        if (head == null) {
            System.out.println("No patient found");


            boolean swap;
            do {
                swap = false;
                Node current = head;
                while (current.next != null) {
                    if (current.next.data.sickness > current.next.data.sickness) { //high fever will on the top
                        patient temp = current.data;
                        current.next = current.next.next;
                        current.next.data = temp;
                        swap = true;
                    }
                    current = current.next;
                }


            } while (swap);


        }
    }
}