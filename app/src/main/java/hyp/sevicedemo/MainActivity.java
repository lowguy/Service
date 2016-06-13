package hyp.sevicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * 后台运行 不可见 没有界面
 * 优先级高于Activity
 * ！！！！！！！！！！！！
 * 运行在主线程不能用来做耗时操作，可以在服务中开一个线程，在线程里做耗时操作
 * ！！！！！！！！！！！！
 * 【本地服务】 应用程序内部
 *              --startService stopService stopSelf stopSelfResult
 *              --bindService unbindService
 *
 *
 * 【远程服务】 Android系统内部的应用程序之间
 *              --IBinder接口
 *
 */
public class MainActivity extends AppCompatActivity {
    private Intent intent1;
    private Intent intent2;
    private MyBindService service;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = ((MyBindService.MyBinder) binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doClick(View view){
        switch (view.getId()){
            case R.id.start:{
                intent1 = new Intent(MainActivity.this,MyStartService.class);
                startService(intent1);
                break;
            }
            case R.id.stop:{
                stopService(intent1);
                break;
            }
            case R.id.bind:{
                intent2 = new Intent(MainActivity.this,MyBindService.class);
                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            }
            case R.id.play:{
                service.Play();
                break;
            }
            case R.id.pause:{
                service.Pause();
                break;
            }
            case R.id.prev:{
                service.Prev();
                break;
            }
            case R.id.next:{
                service.Next();
                break;
            }
            case R.id.unbind:{
                unbindService(conn);
                break;
            }
        }
    }
}
