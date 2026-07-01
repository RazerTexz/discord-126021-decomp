package androidx.viewpager.widget;

import android.database.DataSetObserver;

/* JADX INFO: loaded from: classes.dex */
public class PagerTitleStrip$PageListener extends DataSetObserver implements ViewPager$OnPageChangeListener, ViewPager$OnAdapterChangeListener {
    private int mScrollState;
    public final /* synthetic */ PagerTitleStrip this$0;

    public PagerTitleStrip$PageListener(PagerTitleStrip pagerTitleStrip) {
        this.this$0 = pagerTitleStrip;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnAdapterChangeListener
    public void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        this.this$0.updateAdapter(pagerAdapter, pagerAdapter2);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        PagerTitleStrip pagerTitleStrip = this.this$0;
        pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
        PagerTitleStrip pagerTitleStrip2 = this.this$0;
        float f = pagerTitleStrip2.mLastKnownPositionOffset;
        if (f < 0.0f) {
            f = 0.0f;
        }
        pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        this.mScrollState = i;
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        if (f > 0.5f) {
            i++;
        }
        this.this$0.updateTextPositions(i, f, false);
    }

    @Override // androidx.viewpager.widget.ViewPager$OnPageChangeListener
    public void onPageSelected(int i) {
        if (this.mScrollState == 0) {
            PagerTitleStrip pagerTitleStrip = this.this$0;
            pagerTitleStrip.updateText(pagerTitleStrip.mPager.getCurrentItem(), this.this$0.mPager.getAdapter());
            PagerTitleStrip pagerTitleStrip2 = this.this$0;
            float f = pagerTitleStrip2.mLastKnownPositionOffset;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.updateTextPositions(pagerTitleStrip2.mPager.getCurrentItem(), f, true);
        }
    }
}
