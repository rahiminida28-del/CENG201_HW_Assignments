import java.util.HashMap;
public class HospitalSystem {
    public patientList allPatient  = new patientList(); //patient registerd
    public TreatmentQueue normalTreatmentQueue;   //normal patient
    public TreatmentQueue emergencyTreatmentQueue;  //emergency patient
    public DischargedStack dischargedStack;    //discharged olan hastalar
    public HashMap<Integer, patient> patientMap;  //fast searching


    public HospitalSystem() {
        allPatient = new patientList();
        normalTreatmentQueue = new TreatmentQueue();
        emergencyTreatmentQueue = new TreatmentQueue();  //2 Q yaklasim
        dischargedStack = new DischargedStack();
        patientMap = new HashMap<>();
    }

    public void registerPatient(patient p) { //add new patient and update map
        allPatient.addPatient(p);
        patientMap.put(p.id, p);
    }

    public void addReq(TreatmentRequest req) {  //add treatment req according to emeregency
        if (req.isPriority) {
            this.emergencyTreatmentQueue.enqueue(req);
        } else {
            this.normalTreatmentQueue.enqueue(req);
        }
    }

    public void TreatmentProcess() {
        TreatmentRequest toProcess = null;
        if (emergencyTreatmentQueue.size() > 0) {
            toProcess = emergencyTreatmentQueue.dequeue();

        } else if (normalTreatmentQueue.size() > 0) {
            toProcess = normalTreatmentQueue.dequeue();

        }
        if (toProcess != null) {
            System.out.println("patient will be on treatment:" + toProcess.patientId);
            dischargedStack.push(new DischargedRecord(toProcess.patientId, "10:40")); //add patiemt in discharge

        }

    }
    public  void displayState(){
        System.out.println("\n-- System Status--");
        System.out.println("Emergency waitimg :" + emergencyTreatmentQueue.size());
        System.out.println("NormalWaitimg :" + normalTreatmentQueue.size());
        System.out.println(" number of Discharged patient:"+(dischargedStack.peek()!=null? "kayitli" : "dont have"));
    }
}
