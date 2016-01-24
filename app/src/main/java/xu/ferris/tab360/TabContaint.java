package xu.ferris.tab360;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 标签页面容器
 * Created by ferris on 2016/1/24.
 */
public class TabContaint extends FrameLayout{
    private CenterViewPager mTabsViewpage;
    private TabAdapter mTabAdapter;
    public TabContaint(Context context) {
        super(context);
    }

    public TabContaint(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabContaint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTabsViewpage= (CenterViewPager) findViewById(R.id.mTabsViewpage);
    }

    public void createTabs() {
        mTabsViewpage.setPageMargin(SizeUtils.dip2px(30));
        mTabAdapter=new TabAdapter(getContext());
        mTabAdapter.update(TabDataUtils.createTabs());
        mTabsViewpage.setAdapter(mTabAdapter);
        mTabsViewpage.setClipChildren(false);
    }

    /**
     * 将图片缩放
     * @param drawable
     */
    public void scaleHome(final ImageView iv_home) {
        iv_home.clearAnimation();
        Drawable drawable=iv_home.getDrawable();
        int position=mTabsViewpage.getCurrentItem();
        ImageView dstImageVIew= (ImageView) mTabsViewpage.getChildAt(position);
        dstImageVIew.clearAnimation();
        int[] location=new int[2];
        dstImageVIew.getLocationOnScreen(location);

        int centerX=location[0]+dstImageVIew.getWidth()/2;
        int centerY=location[1]+dstImageVIew.getHeight()/2-SizeUtils.dip2px(80);

        float ddd=dstImageVIew.getWidth();
        float fff=iv_home.getWidth();
        float scaleX=ddd/fff;

        float ddd2=dstImageVIew.getHeight();
        float fff2=iv_home.getHeight();
        float scaleY=ddd2/fff2;

        ScaleAnimation mScaleAnimation=new ScaleAnimation(1.0f,scaleX,1.0f,scaleY,centerX,centerY);
        mScaleAnimation.setDuration(500);
        mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv_home.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv_home.setAnimation(mScaleAnimation);
    }

    public void scaleHomeBack(final ImageView iv_home) {
        iv_home.clearAnimation();
        int position=mTabsViewpage.getCurrentItem();
        ImageView dstImageVIew= (ImageView) mTabsViewpage.getChildAt(position);


        dstImageVIew.clearAnimation();

        Drawable drawable=dstImageVIew.getDrawable();
        iv_home.setImageDrawable(drawable);


        int[] location=new int[2];
        dstImageVIew.getLocationOnScreen(location);

        int centerX=location[0]+dstImageVIew.getWidth()/2;
        int centerY=location[1]+dstImageVIew.getHeight()/2-SizeUtils.dip2px(80);

        float ddd=dstImageVIew.getWidth();
        float fff=iv_home.getWidth();
        float scaleX=ddd/fff;

        float ddd2=dstImageVIew.getHeight();
        float fff2=iv_home.getHeight();
        float scaleY=ddd2/fff2;

        ScaleAnimation mScaleAnimation=new ScaleAnimation(scaleX,1.0f,scaleY,1.0f,centerX,centerY);
        mScaleAnimation.setDuration(500);

        mScaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                iv_home.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv_home.setAnimation(mScaleAnimation);
    }
}
