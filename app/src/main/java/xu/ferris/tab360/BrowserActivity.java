package xu.ferris.tab360;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 高仿360浏览器tab效果
 */
public class BrowserActivity extends AppCompatActivity {
    private IViewAnimation mViewControl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        mViewControl=new ViewControl(BrowserActivity.this);
        mViewControl.findView();
        mViewControl.createTabs();
    }

    @Override
    public void onBackPressed() {
        if(!mViewControl.onBackPressed()){
            super.onBackPressed();
        }
    }
}
