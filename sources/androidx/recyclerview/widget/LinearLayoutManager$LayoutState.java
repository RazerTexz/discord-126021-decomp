package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import b.d.b.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager$LayoutState {
    public static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    public static final int ITEM_DIRECTION_HEAD = -1;
    public static final int ITEM_DIRECTION_TAIL = 1;
    public static final int LAYOUT_END = 1;
    public static final int LAYOUT_START = -1;
    public static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    public static final String TAG = "LLM#LayoutState";
    public int mAvailable;
    public int mCurrentPosition;
    public boolean mInfinite;
    public int mItemDirection;
    public int mLastScrollDelta;
    public int mLayoutDirection;
    public int mOffset;
    public int mScrollingOffset;
    public boolean mRecycle = true;
    public int mExtraFillSpace = 0;
    public int mNoRecycleSpace = 0;
    public boolean mIsPreLayout = false;
    public List<RecyclerView$ViewHolder> mScrapList = null;

    private View nextViewFromScrapList() {
        int size = this.mScrapList.size();
        for (int i = 0; i < size; i++) {
            View view = this.mScrapList.get(i).itemView;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
            if (!recyclerView$LayoutParams.isItemRemoved() && this.mCurrentPosition == recyclerView$LayoutParams.getViewLayoutPosition()) {
                assignPositionFromScrapList(view);
                return view;
            }
        }
        return null;
    }

    public void assignPositionFromScrapList() {
        assignPositionFromScrapList(null);
    }

    public boolean hasMore(RecyclerView$State recyclerView$State) {
        int i = this.mCurrentPosition;
        return i >= 0 && i < recyclerView$State.getItemCount();
    }

    public void log() {
        StringBuilder sbU = a.U("avail:");
        sbU.append(this.mAvailable);
        sbU.append(", ind:");
        sbU.append(this.mCurrentPosition);
        sbU.append(", dir:");
        sbU.append(this.mItemDirection);
        sbU.append(", offset:");
        sbU.append(this.mOffset);
        sbU.append(", layoutDir:");
        sbU.append(this.mLayoutDirection);
        Log.d(TAG, sbU.toString());
    }

    public View next(RecyclerView$Recycler recyclerView$Recycler) {
        if (this.mScrapList != null) {
            return nextViewFromScrapList();
        }
        View viewForPosition = recyclerView$Recycler.getViewForPosition(this.mCurrentPosition);
        this.mCurrentPosition += this.mItemDirection;
        return viewForPosition;
    }

    public View nextViewInLimitedList(View view) {
        int viewLayoutPosition;
        int size = this.mScrapList.size();
        View view2 = null;
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            View view3 = this.mScrapList.get(i2).itemView;
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view3.getLayoutParams();
            if (view3 != view && !recyclerView$LayoutParams.isItemRemoved() && (viewLayoutPosition = (recyclerView$LayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection) >= 0 && viewLayoutPosition < i) {
                view2 = view3;
                if (viewLayoutPosition == 0) {
                    break;
                }
                i = viewLayoutPosition;
            }
        }
        return view2;
    }

    public void assignPositionFromScrapList(View view) {
        View viewNextViewInLimitedList = nextViewInLimitedList(view);
        if (viewNextViewInLimitedList == null) {
            this.mCurrentPosition = -1;
        } else {
            this.mCurrentPosition = ((RecyclerView$LayoutParams) viewNextViewInLimitedList.getLayoutParams()).getViewLayoutPosition();
        }
    }
}
