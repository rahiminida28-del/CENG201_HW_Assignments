public class Main {
    private static DischargedStack dStack =new DischargedStack();
    HospitalSystem hospital = new HospitalSystem();


    public static <Patient> void main(String[] args) {
        // first i create list of patients
        patientList hospital = new patientList();

        System.out.println(".... Hospital System Registration...");
        // U can register patients with name id age & sickness
        //5 tane haste ismi yazdim
        hospital.addPatient(new patient (101, "Aslı Altınbaş" , 6, 25));
        hospital.addPatient(new patient(102,"Deniz Bakırcıoğlu" ,2,27));
        hospital.addPatient(new patient(103, "Sema ağırbaş",5, 20));
        hospital.addPatient(new patient(104,"Sümmeye akgül",10,23));
        hospital.addPatient(new patient(105,"Selin bozoğlu",8,34));

        // 5 person patient list
        System.out.println("\n5 add five patients."); //2.adim olarak hasta ekledim
        hospital.printPatientList();

        //3.adim hastalari silme
        System.out.println("\n__ remove patient (ID : 101)__"); // 101 olan hasta siliniyor
        hospital.removePatient(101);

        //4.adim olarak da yazildigi nolu hastayi ariyor
        System.out.println("\n--- find patient (ID:102) ---");// i want to find the patient so i use this
        patient p = hospital.findPatient(102);
        if (p != null) {
            System.out.println("found patient: " + p.name);

        } else{
            System.out.println("patient not found");

        }
        //Final listeyi yazdircam
        System.out.println("\n--- list of final patient ---"); //this is final patient
        hospital.printPatientList();

        //2. taskin Q  kuyrugu burdan basliyo
        System.out.println("\n\n=== Task 2 : Treatment Q will start ===");
        TreatmentQueue tkuyruk = new TreatmentQueue();

        System.out.println(" 8 Q will adding ...");
        tkuyruk.enqueue (new TreatmentRequest((101)));
        tkuyruk.enqueue(new TreatmentRequest((102)));
        tkuyruk.enqueue(new TreatmentRequest((103)));
        tkuyruk.enqueue(new TreatmentRequest((104)));
        tkuyruk.enqueue(new TreatmentRequest((105)));
        tkuyruk.enqueue(new TreatmentRequest((106)));
        tkuyruk.enqueue(new TreatmentRequest((107)));
        tkuyruk.enqueue(new TreatmentRequest((108)));

        System.out.println("\nIslem oncesi Queue liste:"); //current q
        tkuyruk.printQueue();
        System.out.println(("n/___3 patient will given for treatment ")); //dequeue task
        for (int  i =0; i<3; i++) {
            TreatmentRequest proceesed = tkuyruk.dequeue();
            if (proceesed != null) {
                System.out.println("Tedavi edilen hasta Id " + proceesed.patient);
                //hocam bazi kelimelerin ve cumleleri o an ingilizceye ceviremedigim icin turkce yazdim netten bakip
                //cevirmek istemedim ne kadar biliyorsam o kadarini yapmaya calistim
            }
            System.out.println("\nIslem patient remaining aster Q (Size: "+tkuyruk.size()+")");
            //remaining Q print
            tkuyruk.printQueue();
        }
        System.out.println("\n\n== Discharge Record =="); //3 task stack
        DischargedStack discharged = new DischargedStack(); //2 discharged recorad
        dStack.push(new DischargedRecord(101, "10:40"));
        dStack.push(new DischargedRecord(102, "1:43"));
        dStack.push(new DischargedRecord(103, "14:12"));
        dStack.push(new DischargedRecord(104, "11:20"));
        dStack.push(new DischargedRecord(105,"14:40"));
        //delete 2 patient using LIFO
        System.out.println(" last 2 discharged recoad being processed (pop)");
        System.out.println("Delete" +dStack.pop());
        System.out.println(" Delete" +dStack.pop());
        System.out.println("\nRemaining Discharge Record ==");
        dStack.printStack();

        System.out.println("\n\n===="); //final test
        System.out.println("integrated system starting");
        System.out.println("==");
        HospitalSystem hospitalSystem = new HospitalSystem();

        System.out.println("10 patient will add in System "); //hasta eklendi
        hospitalSystem.registerPatient(new patient(101,"Aslı Altınbaş",6,25));
        hospitalSystem.registerPatient(new patient(102,"Deniz Bakırcıoğlu",2,27));
        hospitalSystem.registerPatient(new patient(103,"Sema ağırbaş",5,20));
        hospitalSystem.registerPatient(new patient(104,"Sümmeye akgül",10,23));
        hospitalSystem.registerPatient(new patient(105,"Selin bozoğlu",8,34));
        hospitalSystem.registerPatient(new patient(106,"Can Yilmaz",2,29));
        hospitalSystem.registerPatient(new patient(107,"Noriya Burhan",10,24));
        hospitalSystem.registerPatient(new patient(108,"Yasemin Amini",9,17));
        hospitalSystem.registerPatient(new patient(109,"Mehmet Oz ",6,65));
        hospitalSystem.registerPatient(new patient(110,"Fatma Veli",1,39));

        System.out.println("\nTedavi talepleri kuyruga ekleniyor.."); //Q of patient who is emergency and who is normal
        hospitalSystem.addReq(new TreatmentRequest(101,false)); //normal
        hospitalSystem.addReq(new TreatmentRequest((102),true)); //acil hasta siddet 9
        hospitalSystem.addReq(new TreatmentRequest((103),true)); //emergency patient fever is 10
        hospitalSystem.addReq(new TreatmentRequest((104),true)); //emergency patient fever is 9
        hospitalSystem.addReq(new TreatmentRequest((105),false)); //normal

        System.out.println("\n--Tedavi Isleniyor (Oncelik Sirasina Gore) ---"); //firts emergency patient will be treat
        for (int  i =0; i<3; i++) {
            hospitalSystem.TreatmentProcess();

        }
        hospitalSystem.displayState(); //Sistem Durumunu Görüntüle
        System.out.println("\n--- Patient will Q by fever-- ");
        hospitalSystem.allPatient.sortBySickness(); //patient icindeki method
        hospitalSystem.allPatient.printPatientList();



    }




}



