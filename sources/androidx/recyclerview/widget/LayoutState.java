package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;

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

    public boolean hasMore(RecyclerView.State state) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < state.getItemCount();
    }

    public View next(RecyclerView.Recycler recycler) {
        View viewForPosition = recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public String toString() {
        StringBuilder sbU = outline.U("LayoutState{mAvailable=");
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
        return outline.A(sbU, this.mEndLine, '}');
    }
}
