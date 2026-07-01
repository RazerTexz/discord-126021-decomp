package androidx.recyclerview.widget;

import android.view.View;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager$AnchorInfo {
    public int mCoordinate;
    public boolean mLayoutFromEnd;
    public OrientationHelper mOrientationHelper;
    public int mPosition;
    public boolean mValid;

    public LinearLayoutManager$AnchorInfo() {
        reset();
    }

    public void assignCoordinateFromPadding() {
        this.mCoordinate = this.mLayoutFromEnd ? this.mOrientationHelper.getEndAfterPadding() : this.mOrientationHelper.getStartAfterPadding();
    }

    public void assignFromView(View view, int i) {
        if (this.mLayoutFromEnd) {
            this.mCoordinate = this.mOrientationHelper.getTotalSpaceChange() + this.mOrientationHelper.getDecoratedEnd(view);
        } else {
            this.mCoordinate = this.mOrientationHelper.getDecoratedStart(view);
        }
        this.mPosition = i;
    }

    public void assignFromViewAndKeepVisibleRect(View view, int i) {
        int totalSpaceChange = this.mOrientationHelper.getTotalSpaceChange();
        if (totalSpaceChange >= 0) {
            assignFromView(view, i);
            return;
        }
        this.mPosition = i;
        if (!this.mLayoutFromEnd) {
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(view);
            int startAfterPadding = decoratedStart - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = decoratedStart;
            if (startAfterPadding > 0) {
                int endAfterPadding = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view))) - (this.mOrientationHelper.getDecoratedMeasurement(view) + decoratedStart);
                if (endAfterPadding < 0) {
                    this.mCoordinate -= Math.min(startAfterPadding, -endAfterPadding);
                    return;
                }
                return;
            }
            return;
        }
        int endAfterPadding2 = (this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - this.mOrientationHelper.getDecoratedEnd(view);
        this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - endAfterPadding2;
        if (endAfterPadding2 > 0) {
            int decoratedMeasurement = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(view);
            int startAfterPadding2 = this.mOrientationHelper.getStartAfterPadding();
            int iMin = decoratedMeasurement - (Math.min(this.mOrientationHelper.getDecoratedStart(view) - startAfterPadding2, 0) + startAfterPadding2);
            if (iMin < 0) {
                this.mCoordinate = Math.min(endAfterPadding2, -iMin) + this.mCoordinate;
            }
        }
    }

    public boolean isViewValidAsAnchor(View view, RecyclerView$State recyclerView$State) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        return !recyclerView$LayoutParams.isItemRemoved() && recyclerView$LayoutParams.getViewLayoutPosition() >= 0 && recyclerView$LayoutParams.getViewLayoutPosition() < recyclerView$State.getItemCount();
    }

    public void reset() {
        this.mPosition = -1;
        this.mCoordinate = Integer.MIN_VALUE;
        this.mLayoutFromEnd = false;
        this.mValid = false;
    }

    public String toString() {
        StringBuilder sbU = a.U("AnchorInfo{mPosition=");
        sbU.append(this.mPosition);
        sbU.append(", mCoordinate=");
        sbU.append(this.mCoordinate);
        sbU.append(", mLayoutFromEnd=");
        sbU.append(this.mLayoutFromEnd);
        sbU.append(", mValid=");
        sbU.append(this.mValid);
        sbU.append('}');
        return sbU.toString();
    }
}
