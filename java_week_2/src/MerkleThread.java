import java.util.ArrayList;

public class MerkleThread implements Runnable {

    public static volatile ArrayList<String> lstWords;
    private int iMerkleTreeInputs = 4;
    String sThreadName;

    public void run(){

        Util oUtil = new Util();
        lstWords = new ArrayList();

        while (true) {
            oUtil.sleepRandomTime(sThreadName);
            String sNewWord = MerkleManager.grabWord();
            if (sNewWord != null) {
                System.out.println("[merkle] grabbed a word");
                lstWords.add(sNewWord);
                System.out.println("Words: " + lstWords.size());
                if (lstWords.size() == iMerkleTreeInputs){
                    MerkleManager.sMerkleRoot = oUtil.getMerkleRoot(lstWords);
                    oUtil.sleep(1);
                }
            }
        }
    }
}
