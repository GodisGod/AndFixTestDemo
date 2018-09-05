package study.com.andfixtestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apatch";
    private String mPatchDir;

    private Button btnCreateBug;
    private Button btnFixBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mPatchDir = getExternalCacheDir().getAbsolutePath() + "/apatch/";
//        Log.i("LHD", "补丁文件路径： " + mPatchDir);
//        //是为了创建我们的文件夹
//        File file = new File(mPatchDir);
//        if (file == null || !file.exists()) {
//            file.mkdir();
//        }
        btnCreateBug = findViewById(R.id.btn_create_bug);
        btnFixBug = findViewById(R.id.btn_fix_bug);
        btnCreateBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createBug();
            }
        });
        btnFixBug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fixBug();
            }
        });

        startPatchService();

    }

    private void startPatchService() {
        Intent intent = new Intent(this, AndFixService.class);
        startService(intent);
    }

    //按钮点击事件1
    public void createBug() {
        Utils.printLog();
    }

    //按钮点击事件2
    public void fixBug() {
        Log.i("LHD", "fixBug");
        AndFixPatchManager.getInstance().addPatch(getPatchName());
    }

    //构造patch文件名
    private String getPatchName() {//"/storage/emulated/0/Android/data/study.com.andfixtestdemo/cache/apatch"
        String path = mPatchDir.concat("study").concat(FILE_END);
        Log.i("LHD", "加载补丁文件: " + path);
        return path;
    }

}
