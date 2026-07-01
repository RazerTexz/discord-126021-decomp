package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TranslationAnimationCreator$TransitionPositionListener extends AnimatorListenerAdapter implements Transition$TransitionListener {
    private final View mMovingView;
    private float mPausedX;
    private float mPausedY;
    private final int mStartX;
    private final int mStartY;
    private final float mTerminalX;
    private final float mTerminalY;
    private int[] mTransitionPosition;
    private final View mViewInHierarchy;

    public TranslationAnimationCreator$TransitionPositionListener(View view, View view2, int i, int i2, float f, float f2) {
        this.mMovingView = view;
        this.mViewInHierarchy = view2;
        this.mStartX = i - Math.round(view.getTranslationX());
        this.mStartY = i2 - Math.round(view.getTranslationY());
        this.mTerminalX = f;
        this.mTerminalY = f2;
        int i3 = R$id.transition_position;
        int[] iArr = (int[]) view2.getTag(i3);
        this.mTransitionPosition = iArr;
        if (iArr != null) {
            view2.setTag(i3, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.mTransitionPosition == null) {
            this.mTransitionPosition = new int[2];
        }
        this.mTransitionPosition[0] = Math.round(this.mMovingView.getTranslationX() + this.mStartX);
        this.mTransitionPosition[1] = Math.round(this.mMovingView.getTranslationY() + this.mStartY);
        this.mViewInHierarchy.setTag(R$id.transition_position, this.mTransitionPosition);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        this.mPausedX = this.mMovingView.getTranslationX();
        this.mPausedY = this.mMovingView.getTranslationY();
        this.mMovingView.setTranslationX(this.mTerminalX);
        this.mMovingView.setTranslationY(this.mTerminalY);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        this.mMovingView.setTranslationX(this.mPausedX);
        this.mMovingView.setTranslationY(this.mPausedY);
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionCancel(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionEnd(@NonNull Transition transition) {
        this.mMovingView.setTranslationX(this.mTerminalX);
        this.mMovingView.setTranslationY(this.mTerminalY);
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionPause(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionResume(@NonNull Transition transition) {
    }

    @Override // androidx.transition.Transition$TransitionListener
    public void onTransitionStart(@NonNull Transition transition) {
    }
}
