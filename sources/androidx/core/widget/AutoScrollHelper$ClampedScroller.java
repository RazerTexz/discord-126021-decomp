package androidx.core.widget;

import android.view.animation.AnimationUtils;

/* JADX INFO: loaded from: classes.dex */
public class AutoScrollHelper$ClampedScroller {
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;
    private long mStartTime = Long.MIN_VALUE;
    private long mStopTime = -1;
    private long mDeltaTime = 0;
    private int mDeltaX = 0;
    private int mDeltaY = 0;

    private float getValueAt(long j) {
        long j2 = this.mStartTime;
        if (j < j2) {
            return 0.0f;
        }
        long j3 = this.mStopTime;
        if (j3 < 0 || j < j3) {
            return AutoScrollHelper.constrain((j - j2) / this.mRampUpDuration, 0.0f, 1.0f) * 0.5f;
        }
        float f = this.mStopValue;
        return (AutoScrollHelper.constrain((j - j3) / this.mEffectiveRampDown, 0.0f, 1.0f) * f) + (1.0f - f);
    }

    private float interpolateValue(float f) {
        return (f * 4.0f) + ((-4.0f) * f * f);
    }

    public void computeScrollDelta() {
        if (this.mDeltaTime == 0) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float fInterpolateValue = interpolateValue(getValueAt(jCurrentAnimationTimeMillis));
        long j = jCurrentAnimationTimeMillis - this.mDeltaTime;
        this.mDeltaTime = jCurrentAnimationTimeMillis;
        float f = j * fInterpolateValue;
        this.mDeltaX = (int) (this.mTargetVelocityX * f);
        this.mDeltaY = (int) (f * this.mTargetVelocityY);
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }

    public int getHorizontalDirection() {
        float f = this.mTargetVelocityX;
        return (int) (f / Math.abs(f));
    }

    public int getVerticalDirection() {
        float f = this.mTargetVelocityY;
        return (int) (f / Math.abs(f));
    }

    public boolean isFinished() {
        return this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown);
    }

    public void requestStop() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (jCurrentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
        this.mStopValue = getValueAt(jCurrentAnimationTimeMillis);
        this.mStopTime = jCurrentAnimationTimeMillis;
    }

    public void setRampDownDuration(int i) {
        this.mRampDownDuration = i;
    }

    public void setRampUpDuration(int i) {
        this.mRampUpDuration = i;
    }

    public void setTargetVelocity(float f, float f2) {
        this.mTargetVelocityX = f;
        this.mTargetVelocityY = f2;
    }

    public void start() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mStartTime = jCurrentAnimationTimeMillis;
        this.mStopTime = -1L;
        this.mDeltaTime = jCurrentAnimationTimeMillis;
        this.mStopValue = 0.5f;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
    }
}
