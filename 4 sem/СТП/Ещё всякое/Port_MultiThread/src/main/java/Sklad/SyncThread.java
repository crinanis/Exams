package Sklad;

public class SyncThread extends Thread{

    private ResourceObj logistCenter;

    public SyncThread(String str, ResourceObj rs){
        super(str);
        this.logistCenter = rs;
    }

    @Override
    public void run() {
        for(int i=0;i<6;++i){
            logistCenter.dumping(getName(),i);
        }
    }
}
