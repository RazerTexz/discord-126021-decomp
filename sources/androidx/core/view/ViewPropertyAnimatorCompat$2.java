package androidx.core.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompat$2 implements ValueAnimator$AnimatorUpdateListener {
    public final /* synthetic */ ViewPropertyAnimatorCompat this$0;
    public final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
    public final /* synthetic */ View val$view;

    public ViewPropertyAnimatorCompat$2(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener, View view) {
        this.this$0 = viewPropertyAnimatorCompat;
        this.val$listener = viewPropertyAnimatorUpdateListener;
        this.val$view = view;
    }

    @Override // android.animation.ValueAnimator$AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.val$listener.onAnimationUpdate(this.val$view);
    }
}
