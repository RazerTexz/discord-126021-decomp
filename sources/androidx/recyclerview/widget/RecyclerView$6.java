package androidx.recyclerview.widget;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$6 implements AdapterHelper$Callback {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$6(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void dispatchUpdate(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int i = adapterHelper$UpdateOp.cmd;
        if (i == 1) {
            RecyclerView recyclerView = this.this$0;
            recyclerView.mLayout.onItemsAdded(recyclerView, adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            return;
        }
        if (i == 2) {
            RecyclerView recyclerView2 = this.this$0;
            recyclerView2.mLayout.onItemsRemoved(recyclerView2, adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.this$0;
            recyclerView3.mLayout.onItemsUpdated(recyclerView3, adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount, adapterHelper$UpdateOp.payload);
        } else {
            if (i != 8) {
                return;
            }
            RecyclerView recyclerView4 = this.this$0;
            recyclerView4.mLayout.onItemsMoved(recyclerView4, adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount, 1);
        }
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public RecyclerView$ViewHolder findViewHolder(int i) {
        RecyclerView$ViewHolder recyclerView$ViewHolderFindViewHolderForPosition = this.this$0.findViewHolderForPosition(i, true);
        if (recyclerView$ViewHolderFindViewHolderForPosition == null || this.this$0.mChildHelper.isHidden(recyclerView$ViewHolderFindViewHolderForPosition.itemView)) {
            return null;
        }
        return recyclerView$ViewHolderFindViewHolderForPosition;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void markViewHoldersUpdated(int i, int i2, Object obj) {
        this.this$0.viewRangeUpdate(i, i2, obj);
        this.this$0.mItemsChanged = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void offsetPositionsForAdd(int i, int i2) {
        this.this$0.offsetPositionRecordsForInsert(i, i2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void offsetPositionsForMove(int i, int i2) {
        this.this$0.offsetPositionRecordsForMove(i, i2);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void offsetPositionsForRemovingInvisible(int i, int i2) {
        this.this$0.offsetPositionRecordsForRemove(i, i2, true);
        RecyclerView recyclerView = this.this$0;
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i2;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
        this.this$0.offsetPositionRecordsForRemove(i, i2, false);
        this.this$0.mItemsAddedOrRemoved = true;
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void onDispatchFirstPass(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        dispatchUpdate(adapterHelper$UpdateOp);
    }

    @Override // androidx.recyclerview.widget.AdapterHelper$Callback
    public void onDispatchSecondPass(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        dispatchUpdate(adapterHelper$UpdateOp);
    }
}
