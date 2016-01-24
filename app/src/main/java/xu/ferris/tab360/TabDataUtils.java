package xu.ferris.tab360;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试tabs
 * 459821731@qq.com
 * Created by ferris on 2016/1/24.
 */
public class TabDataUtils {
   static int[] tabsRes={R.drawable.iv_preview01,R.drawable.iv_preview02,R.drawable.iv_preview03,R.drawable.iv_preview04,R.drawable.iv_preview07};
    static  String[] tabsTitle={"test01","test02","test03","test04","test05"};

    /**
     * 创建tabs
     * @return
     */
    public static List<Tab> createTabs(){
        List<Tab> mTabs=new ArrayList<>();
        for(int i=0;i<tabsRes.length;i++){
            Tab mTab=new Tab();
            mTab.setTitle(tabsTitle[i]);
            mTab.setPreview_image(tabsRes[i]);
            mTabs.add(mTab);
            mTab=null;
        }
        return mTabs;
    }
}
