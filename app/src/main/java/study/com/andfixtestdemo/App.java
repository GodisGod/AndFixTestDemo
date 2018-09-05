package study.com.andfixtestdemo;

import android.app.Application;

/**
 * Created by  HONGDA on 2018/9/4.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //完成andFix模块的初始化
        initAndFix();

    }

    private void initAndFix() {
        AndFixPatchManager.getInstance().initPatch(this);
    }

}
