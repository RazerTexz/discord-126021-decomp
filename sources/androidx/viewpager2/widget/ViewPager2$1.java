package androidx.viewpager2.widget;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager2$1 extends ViewPager2$DataSetChangeObserver {
    public final /* synthetic */ ViewPager2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPager2$1(ViewPager2 viewPager2) {
        super(null);
        this.this$0 = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2$DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        ViewPager2 viewPager2 = this.this$0;
        viewPager2.mCurrentItemDirty = true;
        viewPager2.mScrollEventAdapter.notifyDataSetChangeHappened();
    }
}
