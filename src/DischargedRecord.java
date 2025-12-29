public class DischargedRecord {  //bu benim stack classm burda
    // (Last in first out(LIFO)) mantigini kullanicam
    public int patientid; //patient id who will be discharge
    public long dischargedTime; // patients discharg time

    {
        this.patientid=patientid;
        this.dischargedTime=dischargedTime;

    }

    public DischargedRecord(int patientid, String time) {
    }

    public String toString()
    {
        return  "Discharged Patient ID:" + this.patientid + " Discharged Time:" + this.dischargedTime;

    }
}

