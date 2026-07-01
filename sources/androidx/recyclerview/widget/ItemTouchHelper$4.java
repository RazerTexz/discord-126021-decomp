package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$4 implements Runnable {
    public final /* synthetic */ ItemTouchHelper this$0;
    public final /* synthetic */ ItemTouchHelper$RecoverAnimation val$anim;
    public final /* synthetic */ int val$swipeDir;

    public ItemTouchHelper$4(ItemTouchHelper itemTouchHelper, ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation, int i) {
        this.this$0 = itemTouchHelper;
        this.val$anim = itemTouchHelper$RecoverAnimation;
        this.val$swipeDir = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.this$0.mRecyclerView;
        if (recyclerView == null || !recyclerView.isAttachedToWindow()) {
            return;
        }
        ItemTouchHelper$RecoverAnimation itemTouchHelper$RecoverAnimation = this.val$anim;
        if (itemTouchHelper$RecoverAnimation.mOverridden || itemTouchHelper$RecoverAnimation.mViewHolder.getAbsoluteAdapterPosition() == -1) {
            return;
        }
        RecyclerView$ItemAnimator itemAnimator = this.this$0.mRecyclerView.getItemAnimator();
        if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !this.this$0.hasRunningRecoverAnim()) {
            this.this$0.mCallback.onSwiped(this.val$anim.mViewHolder, this.val$swipeDir);
        } else {
            this.this$0.mRecyclerView.post(this);
        }
    }
}
