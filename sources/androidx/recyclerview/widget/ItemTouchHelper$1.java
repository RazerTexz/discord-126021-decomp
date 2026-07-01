package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$1 implements Runnable {
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$1(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        ItemTouchHelper itemTouchHelper = this.this$0;
        if (itemTouchHelper.mSelected == null || !itemTouchHelper.scrollIfNecessary()) {
            return;
        }
        ItemTouchHelper itemTouchHelper2 = this.this$0;
        RecyclerView$ViewHolder recyclerView$ViewHolder = itemTouchHelper2.mSelected;
        if (recyclerView$ViewHolder != null) {
            itemTouchHelper2.moveIfNecessary(recyclerView$ViewHolder);
        }
        ItemTouchHelper itemTouchHelper3 = this.this$0;
        itemTouchHelper3.mRecyclerView.removeCallbacks(itemTouchHelper3.mScrollRunnable);
        ViewCompat.postOnAnimation(this.this$0.mRecyclerView, this);
    }
}
