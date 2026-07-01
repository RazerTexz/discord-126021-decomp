package androidx.recyclerview.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$RecyclerViewDataObserver extends RecyclerView$AdapterDataObserver {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$RecyclerViewDataObserver(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onChanged() {
        this.this$0.assertNotInLayoutOrScroll(null);
        RecyclerView recyclerView = this.this$0;
        recyclerView.mState.mStructureChanged = true;
        recyclerView.processDataSetCompletelyChanged(true);
        if (this.this$0.mAdapterHelper.hasPendingUpdates()) {
            return;
        }
        this.this$0.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeChanged(int i, int i2, Object obj) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (this.this$0.mAdapterHelper.onItemRangeChanged(i, i2, obj)) {
            triggerUpdateProcessor();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeInserted(int i, int i2) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (this.this$0.mAdapterHelper.onItemRangeInserted(i, i2)) {
            triggerUpdateProcessor();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeMoved(int i, int i2, int i3) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (this.this$0.mAdapterHelper.onItemRangeMoved(i, i2, i3)) {
            triggerUpdateProcessor();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onItemRangeRemoved(int i, int i2) {
        this.this$0.assertNotInLayoutOrScroll(null);
        if (this.this$0.mAdapterHelper.onItemRangeRemoved(i, i2)) {
            triggerUpdateProcessor();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$AdapterDataObserver
    public void onStateRestorationPolicyChanged() {
        RecyclerView$Adapter recyclerView$Adapter;
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mPendingSavedState == null || (recyclerView$Adapter = recyclerView.mAdapter) == null || !recyclerView$Adapter.canRestoreState()) {
            return;
        }
        this.this$0.requestLayout();
    }

    public void triggerUpdateProcessor() {
        if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
            RecyclerView recyclerView = this.this$0;
            if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                ViewCompat.postOnAnimation(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                return;
            }
        }
        RecyclerView recyclerView2 = this.this$0;
        recyclerView2.mAdapterUpdateDuringMeasure = true;
        recyclerView2.requestLayout();
    }
}
