package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;
import android.view.VelocityTracker;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$MyTracker implements MotionLayout$MotionTracker {

    /* JADX INFO: renamed from: me, reason: collision with root package name */
    private static MotionLayout$MyTracker f27me = new MotionLayout$MyTracker();
    public VelocityTracker tracker;

    private MotionLayout$MyTracker() {
    }

    public static MotionLayout$MyTracker obtain() {
        f27me.tracker = VelocityTracker.obtain();
        return f27me;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public void addMovement(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public void clear() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public void computeCurrentVelocity(int i) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(i);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public float getXVelocity() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getXVelocity();
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public float getYVelocity() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getYVelocity();
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public void recycle() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.tracker = null;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public void computeCurrentVelocity(int i, float f) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(i, f);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public float getXVelocity(int i) {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            return velocityTracker.getXVelocity(i);
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
    public float getYVelocity(int i) {
        if (this.tracker != null) {
            return getYVelocity(i);
        }
        return 0.0f;
    }
}
