package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$1 implements Runnable {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$1(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.this$0;
        if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
            return;
        }
        RecyclerView recyclerView2 = this.this$0;
        if (!recyclerView2.mIsAttached) {
            recyclerView2.requestLayout();
        } else if (recyclerView2.mLayoutSuppressed) {
            recyclerView2.mLayoutWasDefered = true;
        } else {
            recyclerView2.consumePendingUpdateOperations();
        }
    }
}
