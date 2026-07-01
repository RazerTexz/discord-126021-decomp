package androidx.dynamicanimation.animation;

import android.view.Choreographer$FrameCallback;

/* JADX INFO: loaded from: classes.dex */
public class AnimationHandler$FrameCallbackProvider16$1 implements Choreographer$FrameCallback {
    public final /* synthetic */ AnimationHandler$FrameCallbackProvider16 this$0;

    public AnimationHandler$FrameCallbackProvider16$1(AnimationHandler$FrameCallbackProvider16 animationHandler$FrameCallbackProvider16) {
        this.this$0 = animationHandler$FrameCallbackProvider16;
    }

    @Override // android.view.Choreographer$FrameCallback
    public void doFrame(long j) {
        this.this$0.mDispatcher.dispatchAnimationFrame();
    }
}
