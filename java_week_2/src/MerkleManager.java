public class MerkleManager {
    public static volatile String sUserEnter;
    public static String sExpectedMR;
    public static String sMerkleRoot = null;
    public static int iStrikes = 0;

    public static void manage(){

        Util oUtil = new Util();
        sExpectedMR = oUtil.promptUser("Input the expected Merkle Root:");

        MerkleThread oMerkleThread = new MerkleThread();
        oMerkleThread.sThreadName = "Merkle Thread";
        Thread oThread1 = new Thread(oMerkleThread);

        // Spawn off new thread
        oThread1.start();

        RogueThread oRogueThread = new RogueThread();
        oRogueThread.sThreadName = "Rogue Thread";
        Thread oThread2 = new Thread(oRogueThread);

        // Spawn off new thread
        oThread2.start();

        MonitorThread oMonitorThread = new MonitorThread();
        Thread oThread3 = new Thread(oMonitorThread);

        // Spawn off new thread
        oThread3.start();

        while (true) {
            sUserEnter = oUtil.promptUser("Input your word: ");
        }

    }

    public static synchronized String grabWord() {
        String sTmp;
        sTmp = sUserEnter;
        sUserEnter = null;
        return sTmp;
    }
}
