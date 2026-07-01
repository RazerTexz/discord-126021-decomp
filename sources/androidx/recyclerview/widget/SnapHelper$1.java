package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class SnapHelper$1 extends RecyclerView$OnScrollListener {
    public boolean mScrolled = false;
    public final /* synthetic */ SnapHelper this$0;

    public SnapHelper$1(SnapHelper snapHelper) {
        this.this$0 = snapHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (i == 0 && this.mScrolled) {
            this.mScrolled = false;
            this.this$0.snapToTargetExistingView();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.mScrolled = true;
    }
}
