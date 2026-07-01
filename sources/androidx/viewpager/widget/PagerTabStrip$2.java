package androidx.viewpager.widget;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes.dex */
public class PagerTabStrip$2 implements View$OnClickListener {
    public final /* synthetic */ PagerTabStrip this$0;

    public PagerTabStrip$2(PagerTabStrip pagerTabStrip) {
        this.this$0 = pagerTabStrip;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        ViewPager viewPager = this.this$0.mPager;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }
}
