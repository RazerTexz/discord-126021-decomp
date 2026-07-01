package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$4 implements ViewInfoStore$ProcessCallback {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$4(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
    public void processAppeared(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        this.this$0.animateAppearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
    }

    @Override // androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
    public void processDisappeared(RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @Nullable RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        this.this$0.mRecycler.unscrapView(recyclerView$ViewHolder);
        this.this$0.animateDisappearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
    }

    @Override // androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
    public void processPersistent(RecyclerView$ViewHolder recyclerView$ViewHolder, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, @NonNull RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        recyclerView$ViewHolder.setIsRecyclable(false);
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mDataSetHasChangedAfterLayout) {
            if (recyclerView.mItemAnimator.animateChange(recyclerView$ViewHolder, recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2)) {
                this.this$0.postAnimationRunner();
            }
        } else if (recyclerView.mItemAnimator.animatePersistence(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2)) {
            this.this$0.postAnimationRunner();
        }
    }

    @Override // androidx.recyclerview.widget.ViewInfoStore$ProcessCallback
    public void unused(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        RecyclerView recyclerView = this.this$0;
        recyclerView.mLayout.removeAndRecycleView(recyclerView$ViewHolder.itemView, recyclerView.mRecycler);
    }
}
