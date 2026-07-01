package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerView$SmoothScroller {
    private RecyclerView$LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private boolean mRunning;
    private boolean mStarted;
    private View mTargetView;
    private int mTargetPosition = -1;
    private final RecyclerView$SmoothScroller$Action mRecyclingAction = new RecyclerView$SmoothScroller$Action(0, 0);

    @Nullable
    public PointF computeScrollVectorForPosition(int i) {
        Object layoutManager = getLayoutManager();
        if (layoutManager instanceof RecyclerView$SmoothScroller$ScrollVectorProvider) {
            return ((RecyclerView$SmoothScroller$ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
        }
        StringBuilder sbU = a.U("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
        sbU.append(RecyclerView$SmoothScroller$ScrollVectorProvider.class.getCanonicalName());
        Log.w(RecyclerView.TAG, sbU.toString());
        return null;
    }

    public View findViewByPosition(int i) {
        return this.mRecyclerView.mLayout.findViewByPosition(i);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildLayoutPosition(view);
    }

    @Nullable
    public RecyclerView$LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    @Deprecated
    public void instantScrollToPosition(int i) {
        this.mRecyclerView.scrollToPosition(i);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public void normalize(@NonNull PointF pointF) {
        float f = pointF.x;
        float f2 = pointF.y;
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f * f));
        pointF.x /= fSqrt;
        pointF.y /= fSqrt;
    }

    public void onAnimation(int i, int i2) {
        PointF pointFComputeScrollVectorForPosition;
        RecyclerView recyclerView = this.mRecyclerView;
        if (this.mTargetPosition == -1 || recyclerView == null) {
            stop();
        }
        if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
            float f = pointFComputeScrollVectorForPosition.x;
            if (f != 0.0f || pointFComputeScrollVectorForPosition.y != 0.0f) {
                recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
        }
        this.mPendingInitialRun = false;
        View view = this.mTargetView;
        if (view != null) {
            if (getChildPosition(view) == this.mTargetPosition) {
                onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                this.mRecyclingAction.runIfNecessary(recyclerView);
                stop();
            } else {
                Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                this.mTargetView = null;
            }
        }
        if (this.mRunning) {
            onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
            boolean zHasJumpTarget = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(recyclerView);
            if (zHasJumpTarget && this.mRunning) {
                this.mPendingInitialRun = true;
                recyclerView.mViewFlinger.postOnAnimation();
            }
        }
    }

    public void onChildAttachedToWindow(View view) {
        if (getChildPosition(view) == getTargetPosition()) {
            this.mTargetView = view;
        }
    }

    public abstract void onSeekTargetStep(@Px int i, @Px int i2, @NonNull RecyclerView$State recyclerView$State, @NonNull RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action);

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onTargetFound(@NonNull View view, @NonNull RecyclerView$State recyclerView$State, @NonNull RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action);

    public void setTargetPosition(int i) {
        this.mTargetPosition = i;
    }

    public void start(RecyclerView recyclerView, RecyclerView$LayoutManager recyclerView$LayoutManager) {
        recyclerView.mViewFlinger.stop();
        if (this.mStarted) {
            StringBuilder sbU = a.U("An instance of ");
            sbU.append(getClass().getSimpleName());
            sbU.append(" was started more than once. Each instance of");
            sbU.append(getClass().getSimpleName());
            sbU.append(" is intended to only be used once. You should create a new instance for each use.");
            Log.w(RecyclerView.TAG, sbU.toString());
        }
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = recyclerView$LayoutManager;
        int i = this.mTargetPosition;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.mState.mTargetPosition = i;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.postOnAnimation();
        this.mStarted = true;
    }

    public final void stop() {
        if (this.mRunning) {
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }
}
