package androidx.constraintlayout.motion.widget;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public interface MotionLayout$MotionTracker {
    void addMovement(MotionEvent motionEvent);

    void clear();

    void computeCurrentVelocity(int i);

    void computeCurrentVelocity(int i, float f);

    float getXVelocity();

    float getXVelocity(int i);

    float getYVelocity();

    float getYVelocity(int i);

    void recycle();
}
