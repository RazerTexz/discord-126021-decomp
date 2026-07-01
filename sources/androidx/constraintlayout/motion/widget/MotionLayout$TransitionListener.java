package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public interface MotionLayout$TransitionListener {
    void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

    void onTransitionCompleted(MotionLayout motionLayout, int i);

    void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

    void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z2, float f);
}
