public class MonitorThread implements Runnable {

    Util oUtil = new Util();

    public void run(){

        while (true) {
            if (MerkleManager.sMerkleRoot != null){
                if (MerkleManager.sMerkleRoot.equals(MerkleManager.sExpectedMR)) {
                    System.out.println("You win: " + MerkleManager.sMerkleRoot);
                    System.exit(0);
                } else {
                    System.out.print("You lost!");
                    System.exit(0);
                }
            } else {
                if (MerkleManager.iStrikes == 3) {
                    System.out.print("You lost!");
                    System.exit(0);
                }
            }
            oUtil.sleep(1);
        }
    }
}
