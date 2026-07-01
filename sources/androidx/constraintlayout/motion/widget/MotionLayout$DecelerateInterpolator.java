package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public class MotionLayout$DecelerateInterpolator extends MotionInterpolator {
    public float maxA;
    public final /* synthetic */ MotionLayout this$0;
    public float initalV = 0.0f;
    public float currentP = 0.0f;

    public MotionLayout$DecelerateInterpolator(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
    }

    public void config(float f, float f2, float f3) {
        this.initalV = f;
        this.currentP = f2;
        this.maxA = f3;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float f2 = this.initalV;
        if (f2 > 0.0f) {
            float f3 = this.maxA;
            if (f2 / f3 < f) {
                f = f2 / f3;
            }
            this.this$0.mLastVelocity = f2 - (f3 * f);
            return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.currentP;
        }
        float f4 = this.maxA;
        if ((-f2) / f4 < f) {
            f = (-f2) / f4;
        }
        this.this$0.mLastVelocity = (f4 * f) + f2;
        return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.currentP;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public float getVelocity() {
        return this.this$0.mLastVelocity;
    }
}
