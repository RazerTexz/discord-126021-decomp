package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class FastScroller$2 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$2(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        this.this$0.updateScrollPosition(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
    }
}
