package androidx.recyclerview.widget;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ItemTouchHelper$ItemTouchHelperGestureListener extends GestureDetector$SimpleOnGestureListener {
    private boolean mShouldReactToLongPress = true;
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$ItemTouchHelperGestureListener(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public void doNotReactToLongPress() {
        this.mShouldReactToLongPress = false;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        View viewFindChildView;
        RecyclerView$ViewHolder childViewHolder;
        if (!this.mShouldReactToLongPress || (viewFindChildView = this.this$0.findChildView(motionEvent)) == null || (childViewHolder = this.this$0.mRecyclerView.getChildViewHolder(viewFindChildView)) == null) {
            return;
        }
        ItemTouchHelper itemTouchHelper = this.this$0;
        if (itemTouchHelper.mCallback.hasDragFlag(itemTouchHelper.mRecyclerView, childViewHolder)) {
            int pointerId = motionEvent.getPointerId(0);
            int i = this.this$0.mActivePointerId;
            if (pointerId == i) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float y2 = motionEvent.getY(iFindPointerIndex);
                ItemTouchHelper itemTouchHelper2 = this.this$0;
                itemTouchHelper2.mInitialTouchX = x2;
                itemTouchHelper2.mInitialTouchY = y2;
                itemTouchHelper2.mDy = 0.0f;
                itemTouchHelper2.mDx = 0.0f;
                if (itemTouchHelper2.mCallback.isLongPressDragEnabled()) {
                    this.this$0.select(childViewHolder, 2);
                }
            }
        }
    }
}
