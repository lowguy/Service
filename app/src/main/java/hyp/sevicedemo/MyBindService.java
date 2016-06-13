package hyp.sevicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/6/13 0013.
 */
public class MyBindService extends Service {
    private final static String INFO = "info";
    @Override
    public void onCreate() {
        Log.i(INFO, "onCreate: ");
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(INFO, "onBind: ");
        return new MyBinder();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.i(INFO, "unbindService: ");
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        Log.i(INFO, "onDestroy: ");
        super.onDestroy();
    }

    public void Play(){
        Log.i(INFO, "Play: ");
    }
    public void Pause(){
        Log.i(INFO, "Pause: ");
    }
    public void Prev(){
        Log.i(INFO, "Prev: ");
    }
    public void Next(){
        Log.i(INFO, "Next: ");
    }
    public class MyBinder extends Binder{
        public MyBindService getService(){
            return  MyBindService.this;
        }
    }
}
