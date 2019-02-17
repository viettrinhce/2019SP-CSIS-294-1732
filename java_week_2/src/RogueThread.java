public class RogueThread implements Runnable {

    String sThreadName;

    public void run(){

        Util oUtil = new Util();

        while (true) {
            oUtil.sleepRandomTime(sThreadName);
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                MerkleManager.iStrikes += 1;
                System.out.println("[rogue] grabbed a word");
                System.out.println("STRIKE!");
                System.out.println("Strike: " + MerkleManager.iStrikes);
                if (MerkleManager.iStrikes == 3) {
                    oUtil.sleep(1);
                }
            }
        }
    }
}
