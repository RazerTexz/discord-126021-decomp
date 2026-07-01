package androidx.viewpager2.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$3 extends ViewPager2$OnPageChangeCallback {
    public final /* synthetic */ ViewPager2 this$0;

    public ViewPager2$3(ViewPager2 viewPager2) {
        this.this$0 = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback
    public void onPageSelected(int i) {
        this.this$0.clearFocus();
        if (this.this$0.hasFocus()) {
            this.this$0.mRecyclerView.requestFocus(2);
        }
    }
}
