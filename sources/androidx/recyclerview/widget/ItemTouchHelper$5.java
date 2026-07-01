package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$5 implements RecyclerView$ChildDrawingOrderCallback {
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$5(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback
    public int onGetChildDrawingOrder(int i, int i2) {
        ItemTouchHelper itemTouchHelper = this.this$0;
        View view = itemTouchHelper.mOverdrawChild;
        if (view == null) {
            return i2;
        }
        int iIndexOfChild = itemTouchHelper.mOverdrawChildPosition;
        if (iIndexOfChild == -1) {
            iIndexOfChild = itemTouchHelper.mRecyclerView.indexOfChild(view);
            this.this$0.mOverdrawChildPosition = iIndexOfChild;
        }
        if (i2 == i - 1) {
            return iIndexOfChild;
        }
        return i2 < iIndexOfChild ? i2 : i2 + 1;
    }
}
