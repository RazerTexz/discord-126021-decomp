package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class Fade$FadeAnimatorListener extends AnimatorListenerAdapter {
    private boolean mLayerTypeChanged = false;
    private final View mView;

    public Fade$FadeAnimatorListener(View view) {
        this.mView = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ViewUtils.setTransitionAlpha(this.mView, 1.0f);
        if (this.mLayerTypeChanged) {
            this.mView.setLayerType(0, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (ViewCompat.hasOverlappingRendering(this.mView) && this.mView.getLayerType() == 0) {
            this.mLayerTypeChanged = true;
            this.mView.setLayerType(2, null);
        }
    }
}
