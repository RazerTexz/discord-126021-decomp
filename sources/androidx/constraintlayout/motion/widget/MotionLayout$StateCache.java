package androidx.constraintlayout.motion.widget;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$StateCache {
    public final /* synthetic */ MotionLayout this$0;
    public float mProgress = Float.NaN;
    public float mVelocity = Float.NaN;
    public int startState = -1;
    public int endState = -1;
    public final String KeyProgress = "motion.progress";
    public final String KeyVelocity = "motion.velocity";
    public final String KeyStartState = "motion.StartState";
    public final String KeyEndState = "motion.EndState";

    public MotionLayout$StateCache(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
    }

    public void apply() {
        int i = this.startState;
        if (i != -1 || this.endState != -1) {
            if (i == -1) {
                this.this$0.transitionToState(this.endState);
            } else {
                int i2 = this.endState;
                if (i2 == -1) {
                    this.this$0.setState(i, -1, -1);
                } else {
                    this.this$0.setTransition(i, i2);
                }
            }
            this.this$0.setState(MotionLayout$TransitionState.SETUP);
        }
        if (Float.isNaN(this.mVelocity)) {
            if (Float.isNaN(this.mProgress)) {
                return;
            }
            this.this$0.setProgress(this.mProgress);
        } else {
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
        }
    }

    public Bundle getTransitionState() {
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", this.mProgress);
        bundle.putFloat("motion.velocity", this.mVelocity);
        bundle.putInt("motion.StartState", this.startState);
        bundle.putInt("motion.EndState", this.endState);
        return bundle;
    }

    public void recordState() {
        this.endState = MotionLayout.access$000(this.this$0);
        this.startState = MotionLayout.access$100(this.this$0);
        this.mVelocity = this.this$0.getVelocity();
        this.mProgress = this.this$0.getProgress();
    }

    public void setEndState(int i) {
        this.endState = i;
    }

    public void setProgress(float f) {
        this.mProgress = f;
    }

    public void setStartState(int i) {
        this.startState = i;
    }

    public void setTransitionState(Bundle bundle) {
        this.mProgress = bundle.getFloat("motion.progress");
        this.mVelocity = bundle.getFloat("motion.velocity");
        this.startState = bundle.getInt("motion.StartState");
        this.endState = bundle.getInt("motion.EndState");
    }

    public void setVelocity(float f) {
        this.mVelocity = f;
    }
}
