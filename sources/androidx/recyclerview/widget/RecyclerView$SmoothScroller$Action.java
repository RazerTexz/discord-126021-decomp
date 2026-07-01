package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView$SmoothScroller$Action {
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    private boolean mChanged;
    private int mConsecutiveUpdates;
    private int mDuration;
    private int mDx;
    private int mDy;
    private Interpolator mInterpolator;
    private int mJumpToPosition;

    public RecyclerView$SmoothScroller$Action(@Px int i, @Px int i2) {
        this(i, i2, Integer.MIN_VALUE, null);
    }

    private void validate() {
        if (this.mInterpolator != null && this.mDuration < 1) {
            throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.mDuration < 1) {
            throw new IllegalStateException("Scroll duration must be a positive number");
        }
    }

    public int getDuration() {
        return this.mDuration;
    }

    @Px
    public int getDx() {
        return this.mDx;
    }

    @Px
    public int getDy() {
        return this.mDy;
    }

    @Nullable
    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public boolean hasJumpTarget() {
        return this.mJumpToPosition >= 0;
    }

    public void jumpTo(int i) {
        this.mJumpToPosition = i;
    }

    public void runIfNecessary(RecyclerView recyclerView) {
        int i = this.mJumpToPosition;
        if (i >= 0) {
            this.mJumpToPosition = -1;
            recyclerView.jumpToPositionForSmoothScroller(i);
            this.mChanged = false;
        } else {
            if (!this.mChanged) {
                this.mConsecutiveUpdates = 0;
                return;
            }
            validate();
            recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
            int i2 = this.mConsecutiveUpdates + 1;
            this.mConsecutiveUpdates = i2;
            if (i2 > 10) {
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            }
            this.mChanged = false;
        }
    }

    public void setDuration(int i) {
        this.mChanged = true;
        this.mDuration = i;
    }

    public void setDx(@Px int i) {
        this.mChanged = true;
        this.mDx = i;
    }

    public void setDy(@Px int i) {
        this.mChanged = true;
        this.mDy = i;
    }

    public void setInterpolator(@Nullable Interpolator interpolator) {
        this.mChanged = true;
        this.mInterpolator = interpolator;
    }

    public void update(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
        this.mDx = i;
        this.mDy = i2;
        this.mDuration = i3;
        this.mInterpolator = interpolator;
        this.mChanged = true;
    }

    public RecyclerView$SmoothScroller$Action(@Px int i, @Px int i2, int i3) {
        this(i, i2, i3, null);
    }

    public RecyclerView$SmoothScroller$Action(@Px int i, @Px int i2, int i3, @Nullable Interpolator interpolator) {
        this.mJumpToPosition = -1;
        this.mChanged = false;
        this.mConsecutiveUpdates = 0;
        this.mDx = i;
        this.mDy = i2;
        this.mDuration = i3;
        this.mInterpolator = interpolator;
    }
}
