package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable$2 implements Animator$AnimatorListener {
    public final /* synthetic */ CircularProgressDrawable this$0;
    public final /* synthetic */ CircularProgressDrawable$Ring val$ring;

    public CircularProgressDrawable$2(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable$Ring circularProgressDrawable$Ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = circularProgressDrawable$Ring;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.this$0.applyTransformation(1.0f, this.val$ring, true);
        this.val$ring.storeOriginals();
        this.val$ring.goToNextColor();
        CircularProgressDrawable circularProgressDrawable = this.this$0;
        if (!circularProgressDrawable.mFinishing) {
            circularProgressDrawable.mRotationCount += 1.0f;
            return;
        }
        circularProgressDrawable.mFinishing = false;
        animator.cancel();
        animator.setDuration(1332L);
        animator.start();
        this.val$ring.setShowArrow(false);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.this$0.mRotationCount = 0.0f;
    }
}
