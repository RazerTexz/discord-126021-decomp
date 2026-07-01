package androidx.core.widget;

import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class AutoScrollHelper$ScrollAnimationRunnable implements Runnable {
    public final /* synthetic */ AutoScrollHelper this$0;

    public AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper autoScrollHelper) {
        this.this$0 = autoScrollHelper;
    }

    @Override // java.lang.Runnable
    public void run() {
        AutoScrollHelper autoScrollHelper = this.this$0;
        if (autoScrollHelper.mAnimating) {
            if (autoScrollHelper.mNeedsReset) {
                autoScrollHelper.mNeedsReset = false;
                autoScrollHelper.mScroller.start();
            }
            AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.this$0.mScroller;
            if (autoScrollHelper$ClampedScroller.isFinished() || !this.this$0.shouldAnimate()) {
                this.this$0.mAnimating = false;
                return;
            }
            AutoScrollHelper autoScrollHelper2 = this.this$0;
            if (autoScrollHelper2.mNeedsCancel) {
                autoScrollHelper2.mNeedsCancel = false;
                autoScrollHelper2.cancelTargetTouch();
            }
            autoScrollHelper$ClampedScroller.computeScrollDelta();
            this.this$0.scrollTargetBy(autoScrollHelper$ClampedScroller.getDeltaX(), autoScrollHelper$ClampedScroller.getDeltaY());
            ViewCompat.postOnAnimation(this.this$0.mTarget, this);
        }
    }
}
