package xu.ferris.tab360;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/1/24.
 */
public class TabAdapter extends PagerAdapter {
    Context context;
    List<Tab> mTabs;
    public TabAdapter(Context context) {
        this.context = context;
    }

    public void update(List<Tab> mTabs){
        this.mTabs=mTabs;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mTabs==null?0:mTabs.size();
    }

    public Tab getItems(int position){
        return mTabs.get(position);
    }
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView v = new ImageView(context);
        Tab mTab=getItems(position);
        v.setImageResource(mTab.getPreview_image());
        v.setScaleType(ImageView.ScaleType.FIT_XY);

        int widthparent=container.getWidth()/2;
        int hightparent=(container.getHeight()-SizeUtils.dip2px(56 * 2))/2;
        ViewGroup.LayoutParams lp=new ViewGroup.LayoutParams(widthparent, hightparent);
        container.addView(v , lp);
        return v;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.7f;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
