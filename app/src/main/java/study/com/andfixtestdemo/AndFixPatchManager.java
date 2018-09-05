package study.com.andfixtestdemo;

import android.content.Context;

import com.alipay.euler.andfix.AndFixManager;
import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * Created by  HONGDA on 2018/9/4.
 */
public class AndFixPatchManager {
    private static AndFixPatchManager mInstance = null;
    private static PatchManager patchManager;

    public static AndFixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixManager.class) {//加锁
                if (mInstance == null) {
                    mInstance = new AndFixPatchManager();
                }
            }
        }
        return mInstance;
    }

    //初始化andFix方法
    public void initPatch(Context context) {
        patchManager = new PatchManager(context);
        patchManager.init(Utils.getVersionName(context));
        patchManager.loadPatch();
    }

    //加载我们的patch文件
    public void addPatch(String path) {
        try {
            if (patchManager != null) {
                patchManager.addPatch(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}



