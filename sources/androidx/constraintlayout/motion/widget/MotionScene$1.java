package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene$1 implements Interpolator {
    public final /* synthetic */ MotionScene this$0;
    public final /* synthetic */ Easing val$easing;

    public MotionScene$1(MotionScene motionScene, Easing easing) {
        this.this$0 = motionScene;
        this.val$easing = easing;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return (float) this.val$easing.get(f);
    }
}
