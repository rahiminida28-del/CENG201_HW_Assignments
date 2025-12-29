public class TreatmentRequest {
    public int patientId;    //bekleyen hasta nin id sine bakar
    public long arrivalTime; //burda hasta icin talebin  olusturma zamani
    public String patient;
    public boolean isPriority;  // for Emergency


    public TreatmentRequest(int patientId, boolean isPriority) {
        this.patientId = patientId;
        this.isPriority = isPriority;
        this.arrivalTime = System.currentTimeMillis();
        //sistem saati millisaniye cinsinden alir
        //system will take time in millis
    }

    public String toString() {
        return "patient ID: " + patientId +  (isPriority ? " [Emergency]" : " [Normal]");

    }
 public TreatmentRequest(int patientId, long arrivalTime, String patient) {
        this.patientId = patientId;
        this.arrivalTime = arrivalTime;
        this.patient = patient;
        this.isPriority = false;
 }

  public TreatmentRequest(int patientId) {
        this.patientId = patientId;
        this.arrivalTime = System.currentTimeMillis();
        this.isPriority = false;
        this.patient = "unknown";
  }
}
