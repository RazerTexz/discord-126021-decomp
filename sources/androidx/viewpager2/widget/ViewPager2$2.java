package androidx.viewpager2.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$2 extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$2(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageScrollStateChanged(int i) {
        if (i == 0) {
            this.this$0.updateCurrentItem();
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageSelected(int i) {
        ViewPager2 viewPager2 = this.this$0;
        if (viewPager2.mCurrentItem != i) {
            viewPager2.mCurrentItem = i;
            viewPager2.mAccessibilityProvider.onSetNewCurrentItem();
        }
    }
}
