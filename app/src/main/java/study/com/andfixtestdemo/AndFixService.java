package study.com.andfixtestdemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;

import java.io.File;

/**
 * Created by  HONGDA on 2018/9/5.
 */
public class AndFixService extends Service {

    private static final String TAG = AndFixService.class.getSimpleName();

    private static final String FILE_END = ".apatch";
    private static final int UPDATE_PATCH = 0X02;
    private static final int DOWNLOAD_PATCH = 0X01;

    private String mPatchFileDir;
    private String mPatchFile;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_PATCH:
                    checkPatchUpdate();
                    break;
                case DOWNLOAD_PATCH:
                    downloadPatch();
                    break;
            }
        }
    };




    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessage(UPDATE_PATCH);
        return START_NOT_STICKY;
    }

    //构造文件目录
    private void init() {
        mPatchFileDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
        File patchDir = new File(mPatchFileDir);

        try {
            if (patchDir == null || !patchDir.exists()) {
                patchDir.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
            stopSelf();
        }

    }

    //检查服务器是否有patch文件，获取需要下载的patch的路径
    private void checkPatchUpdate() {
        //发起请求，处理回调
    }

    //下载patch文件
    private void downloadPatch() {
        //初始化patch文件下载路径
        mPatchFile = mPatchFileDir.concat(String.valueOf(System.currentTimeMillis())).concat(FILE_END);
        //发起请求下载文件
    }

}
