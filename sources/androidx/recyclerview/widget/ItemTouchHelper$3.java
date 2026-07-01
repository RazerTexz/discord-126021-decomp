package androidx.recyclerview.widget;

import android.animation.Animator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$3 extends ItemTouchHelper$RecoverAnimation {
    public final /* synthetic */ ItemTouchHelper this$0;
    public final /* synthetic */ RecyclerView$ViewHolder val$prevSelected;
    public final /* synthetic */ int val$swipeDir;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemTouchHelper$3(ItemTouchHelper itemTouchHelper, RecyclerView$ViewHolder recyclerView$ViewHolder, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        super(recyclerView$ViewHolder, i, i2, f, f2, f3, f4);
        this.this$0 = itemTouchHelper;
        this.val$swipeDir = i3;
        this.val$prevSelected = recyclerView$ViewHolder2;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (this.mOverridden) {
            return;
        }
        if (this.val$swipeDir <= 0) {
            ItemTouchHelper itemTouchHelper = this.this$0;
            itemTouchHelper.mCallback.clearView(itemTouchHelper.mRecyclerView, this.val$prevSelected);
        } else {
            this.this$0.mPendingCleanup.add(this.val$prevSelected.itemView);
            this.mIsPendingCleanup = true;
            int i = this.val$swipeDir;
            if (i > 0) {
                this.this$0.postDispatchSwipe(this, i);
            }
        }
        ItemTouchHelper itemTouchHelper2 = this.this$0;
        View view = itemTouchHelper2.mOverdrawChild;
        View view2 = this.val$prevSelected.itemView;
        if (view == view2) {
            itemTouchHelper2.removeChildDrawingOrderCallbackIfNecessary(view2);
        }
    }
}
