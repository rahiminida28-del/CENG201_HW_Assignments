public class DischargedRecord {  //bu benim stack classm burda
    // (Last in first out(LIFO)) mantigini kullanicam
    public int patientid; //patient id who will be discharge
    public String  dischargedTime; // patients discharg time
    public DischargedRecord(int patientid, String dischargedTime){
          this.patientid=patientid;
        this.dischargedTime=dischargedTime;




    }

    public String toString()
    {
        return  "Discharged Patient ID:" + this.patientid + " Discharged Time:" + this.dischargedTime;

    }
}

