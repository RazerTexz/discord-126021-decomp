package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import android.view.Choreographer$FrameCallback;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public class AnimationHandler$FrameCallbackProvider16 extends AnimationHandler$AnimationFrameCallbackProvider {
    private final Choreographer mChoreographer;
    private final Choreographer$FrameCallback mChoreographerCallback;

    public AnimationHandler$FrameCallbackProvider16(AnimationHandler$AnimationCallbackDispatcher animationHandler$AnimationCallbackDispatcher) {
        super(animationHandler$AnimationCallbackDispatcher);
        this.mChoreographer = Choreographer.getInstance();
        this.mChoreographerCallback = new AnimationHandler$FrameCallbackProvider16$1(this);
    }

    @Override // androidx.dynamicanimation.animation.AnimationHandler$AnimationFrameCallbackProvider
    public void postFrameCallback() {
        this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
    }
}
