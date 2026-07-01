package androidx.recyclerview.widget;

import android.util.SparseArray;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$State {
    public static final int STEP_ANIMATIONS = 4;
    public static final int STEP_LAYOUT = 2;
    public static final int STEP_START = 1;
    private SparseArray<Object> mData;
    public long mFocusedItemId;
    public int mFocusedItemPosition;
    public int mFocusedSubChildId;
    public int mRemainingScrollHorizontal;
    public int mRemainingScrollVertical;
    public int mTargetPosition = -1;
    public int mPreviousLayoutItemCount = 0;
    public int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    public int mLayoutStep = 1;
    public int mItemCount = 0;
    public boolean mStructureChanged = false;
    public boolean mInPreLayout = false;
    public boolean mTrackOldChangeHolders = false;
    public boolean mIsMeasuring = false;
    public boolean mRunSimpleAnimations = false;
    public boolean mRunPredictiveAnimations = false;

    public void assertLayoutStep(int i) {
        if ((this.mLayoutStep & i) != 0) {
            return;
        }
        StringBuilder sbU = a.U("Layout state should be one of ");
        sbU.append(Integer.toBinaryString(i));
        sbU.append(" but it is ");
        sbU.append(Integer.toBinaryString(this.mLayoutStep));
        throw new IllegalStateException(sbU.toString());
    }

    public boolean didStructureChange() {
        return this.mStructureChanged;
    }

    public <T> T get(int i) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray == null) {
            return null;
        }
        return (T) sparseArray.get(i);
    }

    public int getItemCount() {
        return this.mInPreLayout ? this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout : this.mItemCount;
    }

    public int getRemainingScrollHorizontal() {
        return this.mRemainingScrollHorizontal;
    }

    public int getRemainingScrollVertical() {
        return this.mRemainingScrollVertical;
    }

    public int getTargetScrollPosition() {
        return this.mTargetPosition;
    }

    public boolean hasTargetScrollPosition() {
        return this.mTargetPosition != -1;
    }

    public boolean isMeasuring() {
        return this.mIsMeasuring;
    }

    public boolean isPreLayout() {
        return this.mInPreLayout;
    }

    public void prepareForNestedPrefetch(RecyclerView$Adapter recyclerView$Adapter) {
        this.mLayoutStep = 1;
        this.mItemCount = recyclerView$Adapter.getItemCount();
        this.mInPreLayout = false;
        this.mTrackOldChangeHolders = false;
        this.mIsMeasuring = false;
    }

    public void put(int i, Object obj) {
        if (this.mData == null) {
            this.mData = new SparseArray<>();
        }
        this.mData.put(i, obj);
    }

    public void remove(int i) {
        SparseArray<Object> sparseArray = this.mData;
        if (sparseArray == null) {
            return;
        }
        sparseArray.remove(i);
    }

    public String toString() {
        StringBuilder sbU = a.U("State{mTargetPosition=");
        sbU.append(this.mTargetPosition);
        sbU.append(", mData=");
        sbU.append(this.mData);
        sbU.append(", mItemCount=");
        sbU.append(this.mItemCount);
        sbU.append(", mIsMeasuring=");
        sbU.append(this.mIsMeasuring);
        sbU.append(", mPreviousLayoutItemCount=");
        sbU.append(this.mPreviousLayoutItemCount);
        sbU.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
        sbU.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
        sbU.append(", mStructureChanged=");
        sbU.append(this.mStructureChanged);
        sbU.append(", mInPreLayout=");
        sbU.append(this.mInPreLayout);
        sbU.append(", mRunSimpleAnimations=");
        sbU.append(this.mRunSimpleAnimations);
        sbU.append(", mRunPredictiveAnimations=");
        sbU.append(this.mRunPredictiveAnimations);
        sbU.append('}');
        return sbU.toString();
    }

    public boolean willRunPredictiveAnimations() {
        return this.mRunPredictiveAnimations;
    }

    public boolean willRunSimpleAnimations() {
        return this.mRunSimpleAnimations;
    }
}
