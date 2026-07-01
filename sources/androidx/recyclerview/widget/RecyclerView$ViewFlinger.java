package androidx.recyclerview.widget;

import android.os.Build$VERSION;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$ViewFlinger implements Runnable {
    private boolean mEatRunOnAnimationRequest;
    public Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    public OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$ViewFlinger(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
        Interpolator interpolator = RecyclerView.sQuinticInterpolator;
        this.mInterpolator = interpolator;
        this.mEatRunOnAnimationRequest = false;
        this.mReSchedulePostAnimationCallback = false;
        this.mOverScroller = new OverScroller(recyclerView.getContext(), interpolator);
    }

    private int computeScrollDuration(int i, int i2) {
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        boolean z2 = iAbs > iAbs2;
        RecyclerView recyclerView = this.this$0;
        int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
        if (!z2) {
            iAbs = iAbs2;
        }
        return Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
    }

    private void internalPostOnAnimation() {
        this.this$0.removeCallbacks(this);
        ViewCompat.postOnAnimation(this.this$0, this);
    }

    public void fling(int i, int i2) {
        this.this$0.setScrollState(2);
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        Interpolator interpolator = this.mInterpolator;
        Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
        if (interpolator != interpolator2) {
            this.mInterpolator = interpolator2;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), interpolator2);
        }
        this.mOverScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        postOnAnimation();
    }

    public void postOnAnimation() {
        if (this.mEatRunOnAnimationRequest) {
            this.mReSchedulePostAnimationCallback = true;
        } else {
            internalPostOnAnimation();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        int i2;
        int i3;
        RecyclerView recyclerView = this.this$0;
        if (recyclerView.mLayout == null) {
            stop();
            return;
        }
        this.mReSchedulePostAnimationCallback = false;
        this.mEatRunOnAnimationRequest = true;
        recyclerView.consumePendingUpdateOperations();
        OverScroller overScroller = this.mOverScroller;
        if (overScroller.computeScrollOffset()) {
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int i4 = currX - this.mLastFlingX;
            int i5 = currY - this.mLastFlingY;
            this.mLastFlingX = currX;
            this.mLastFlingY = currY;
            RecyclerView recyclerView2 = this.this$0;
            int[] iArr = recyclerView2.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            if (recyclerView2.dispatchNestedPreScroll(i4, i5, iArr, null, 1)) {
                int[] iArr2 = this.this$0.mReusableIntPair;
                i4 -= iArr2[0];
                i5 -= iArr2[1];
            }
            if (this.this$0.getOverScrollMode() != 2) {
                this.this$0.considerReleasingGlowsOnScroll(i4, i5);
            }
            RecyclerView recyclerView3 = this.this$0;
            if (recyclerView3.mAdapter != null) {
                int[] iArr3 = recyclerView3.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                recyclerView3.scrollStep(i4, i5, iArr3);
                RecyclerView recyclerView4 = this.this$0;
                int[] iArr4 = recyclerView4.mReusableIntPair;
                i2 = iArr4[0];
                i = iArr4[1];
                i4 -= i2;
                i5 -= i;
                RecyclerView$SmoothScroller recyclerView$SmoothScroller = recyclerView4.mLayout.mSmoothScroller;
                if (recyclerView$SmoothScroller != null && !recyclerView$SmoothScroller.isPendingInitialRun() && recyclerView$SmoothScroller.isRunning()) {
                    int itemCount = this.this$0.mState.getItemCount();
                    if (itemCount == 0) {
                        recyclerView$SmoothScroller.stop();
                    } else if (recyclerView$SmoothScroller.getTargetPosition() >= itemCount) {
                        recyclerView$SmoothScroller.setTargetPosition(itemCount - 1);
                        recyclerView$SmoothScroller.onAnimation(i2, i);
                    } else {
                        recyclerView$SmoothScroller.onAnimation(i2, i);
                    }
                }
            } else {
                i = 0;
                i2 = 0;
            }
            if (!this.this$0.mItemDecorations.isEmpty()) {
                this.this$0.invalidate();
            }
            RecyclerView recyclerView5 = this.this$0;
            int[] iArr5 = recyclerView5.mReusableIntPair;
            iArr5[0] = 0;
            iArr5[1] = 0;
            recyclerView5.dispatchNestedScroll(i2, i, i4, i5, null, 1, iArr5);
            RecyclerView recyclerView6 = this.this$0;
            int[] iArr6 = recyclerView6.mReusableIntPair;
            int i6 = i4 - iArr6[0];
            int i7 = i5 - iArr6[1];
            if (i2 != 0 || i != 0) {
                recyclerView6.dispatchOnScrolled(i2, i);
            }
            if (!RecyclerView.access$200(this.this$0)) {
                this.this$0.invalidate();
            }
            boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
            RecyclerView$SmoothScroller recyclerView$SmoothScroller2 = this.this$0.mLayout.mSmoothScroller;
            if ((recyclerView$SmoothScroller2 != null && recyclerView$SmoothScroller2.isPendingInitialRun()) || !z2) {
                postOnAnimation();
                RecyclerView recyclerView7 = this.this$0;
                GapWorker gapWorker = recyclerView7.mGapWorker;
                if (gapWorker != null) {
                    gapWorker.postFromTraversal(recyclerView7, i2, i);
                }
            } else {
                if (this.this$0.getOverScrollMode() != 2) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i6 < 0) {
                        i3 = -currVelocity;
                    } else {
                        i3 = i6 > 0 ? currVelocity : 0;
                    }
                    if (i7 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i7 <= 0) {
                        currVelocity = 0;
                    }
                    this.this$0.absorbGlows(i3, currVelocity);
                }
                if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                    this.this$0.mPrefetchRegistry.clearPrefetchPositions();
                }
            }
        }
        RecyclerView$SmoothScroller recyclerView$SmoothScroller3 = this.this$0.mLayout.mSmoothScroller;
        if (recyclerView$SmoothScroller3 != null && recyclerView$SmoothScroller3.isPendingInitialRun()) {
            recyclerView$SmoothScroller3.onAnimation(0, 0);
        }
        this.mEatRunOnAnimationRequest = false;
        if (this.mReSchedulePostAnimationCallback) {
            internalPostOnAnimation();
        } else {
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
        }
    }

    public void smoothScrollBy(int i, int i2, int i3, @Nullable Interpolator interpolator) {
        if (i3 == Integer.MIN_VALUE) {
            i3 = computeScrollDuration(i, i2);
        }
        int i4 = i3;
        if (interpolator == null) {
            interpolator = RecyclerView.sQuinticInterpolator;
        }
        if (this.mInterpolator != interpolator) {
            this.mInterpolator = interpolator;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), interpolator);
        }
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        this.this$0.setScrollState(2);
        this.mOverScroller.startScroll(0, 0, i, i2, i4);
        if (Build$VERSION.SDK_INT < 23) {
            this.mOverScroller.computeScrollOffset();
        }
        postOnAnimation();
    }

    public void stop() {
        this.this$0.removeCallbacks(this);
        this.mOverScroller.abortAnimation();
    }
}
