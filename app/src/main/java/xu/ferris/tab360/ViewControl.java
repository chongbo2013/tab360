package xu.ferris.tab360;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by ferris on 2016/1/24.
 */
public class ViewControl implements IViewAnimation, View.OnClickListener {
    private BrowserActivity browserActivity;
    private TabContaint mTabsview;

    private View mTitlebar, mWebview, mBottombar;

    public static boolean isHome=true;

    private ImageView iv_home;

    private Button btn_back;
    public ViewControl(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }


    public void findView() {
        SizeUtils.reset(browserActivity);
        mTabsview = (TabContaint) browserActivity.findViewById(R.id.mTabsview);
        mTitlebar = browserActivity.findViewById(R.id.mTitlebar);
        mWebview = browserActivity.findViewById(R.id.mWebview);
        mBottombar = browserActivity.findViewById(R.id.mBottombar);
        iv_home= (ImageView) mWebview.findViewById(R.id.iv_home);
        mBottombar.setOnClickListener(this);


        //
        btn_back= (Button) mTabsview.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }

    public void titlebarShowOrHide(boolean isShow) {
        if (isShow) {
            mTitlebar.animate().setDuration(500).translationY(0).start();
        } else {
            mTitlebar.animate().setDuration(500).translationY(-SizeUtils.dip2px(56)).start();
        }
    }

    public void bottombarShowOrHide(boolean isShow) {
        if (isShow) {
            mBottombar.animate().setDuration(500).translationY(0).start();
        } else {
            mBottombar.animate().setDuration(500).translationY(SizeUtils.dip2px(56)).start();
        }
    }

    /**
     * 关闭标签
     */
    @Override
    public void openTabs() {
        if(isHome) {
            titlebarShowOrHide(false);
            bottombarShowOrHide(false);
            iv_home.setVisibility(View.GONE);
            mTabsview.scaleHome(iv_home);
            isHome=false;
        }
    }

    /**
     * 打开标签
     */
    @Override
    public void closeTabs() {
        if(!isHome) {
            titlebarShowOrHide(true);
            bottombarShowOrHide(true);
            mTabsview.scaleHomeBack(iv_home);
            isHome=true;
        }
    }

    @Override
    public void createTabs() {
        mTabsview.createTabs();
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBottombar:
                openTabs();
                break;
            case R.id.btn_back:
                closeTabs();
            break;
        }
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
