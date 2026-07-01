package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$ItemAnimatorRestoreListener implements RecyclerView$ItemAnimator$ItemAnimatorListener {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$ItemAnimatorRestoreListener(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener
    public void onAnimationFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        recyclerView$ViewHolder.setIsRecyclable(true);
        if (recyclerView$ViewHolder.mShadowedHolder != null && recyclerView$ViewHolder.mShadowingHolder == null) {
            recyclerView$ViewHolder.mShadowedHolder = null;
        }
        recyclerView$ViewHolder.mShadowingHolder = null;
        if (recyclerView$ViewHolder.shouldBeKeptAsChild() || this.this$0.removeAnimatingView(recyclerView$ViewHolder.itemView) || !recyclerView$ViewHolder.isTmpDetached()) {
            return;
        }
        this.this$0.removeDetachedView(recyclerView$ViewHolder.itemView, false);
    }
}
