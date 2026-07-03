package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import p007b.p100d.p104b.p105a.C1643a;

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
        StringBuilder sbM833U = C1643a.m833U("LayoutState{mAvailable=");
        sbM833U.append(this.mAvailable);
        sbM833U.append(", mCurrentPosition=");
        sbM833U.append(this.mCurrentPosition);
        sbM833U.append(", mItemDirection=");
        sbM833U.append(this.mItemDirection);
        sbM833U.append(", mLayoutDirection=");
        sbM833U.append(this.mLayoutDirection);
        sbM833U.append(", mStartLine=");
        sbM833U.append(this.mStartLine);
        sbM833U.append(", mEndLine=");
        return C1643a.m813A(sbM833U, this.mEndLine, '}');
    }
}
