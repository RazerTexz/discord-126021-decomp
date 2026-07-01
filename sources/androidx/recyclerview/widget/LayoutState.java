package androidx.recyclerview.widget;

import android.view.View;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public int mAvailable;
    public int mCurrentPosition;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLayoutDirection;
    public boolean mStopInFocusable;
    public boolean mRecycle = true;
    public int mStartLine = 0;
    public int mEndLine = 0;

    public boolean hasMore(RecyclerView$State recyclerView$State) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < recyclerView$State.getItemCount();
    }

    public View next(RecyclerView$Recycler recyclerView$Recycler) {
        View viewForPosition = recyclerView$Recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder sbU = a.U("LayoutState{mAvailable=");
        sbU.append(this.mAvailable);
        sbU.append(", mCurrentPosition=");
        sbU.append(this.mCurrentPosition);
        sbU.append(", mItemDirection=");
        sbU.append(this.mItemDirection);
        sbU.append(", mLayoutDirection=");
        sbU.append(this.mLayoutDirection);
        sbU.append(", mStartLine=");
        sbU.append(this.mStartLine);
        sbU.append(", mEndLine=");
        return a.A(sbU, this.mEndLine, '}');
    }
}
