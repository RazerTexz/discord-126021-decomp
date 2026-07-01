package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
    public boolean mAnimEndCalled;
    public ViewPropertyAnimatorCompat mVpa;

    public ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.mVpa = viewPropertyAnimatorCompat;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationCancel(view);
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    @SuppressLint({"WrongConstant"})
    public void onAnimationEnd(View view) {
        int i = this.mVpa.mOldLayerType;
        if (i > -1) {
            view.setLayerType(i, null);
            this.mVpa.mOldLayerType = -1;
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
        Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
        if (runnable != null) {
            viewPropertyAnimatorCompat.mEndAction = null;
            runnable.run();
        }
        Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationEnd(view);
        }
        this.mAnimEndCalled = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        this.mAnimEndCalled = false;
        if (this.mVpa.mOldLayerType > -1) {
            view.setLayerType(2, null);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
        Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
        if (runnable != null) {
            viewPropertyAnimatorCompat.mStartAction = null;
            runnable.run();
        }
        Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
        ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
        if (viewPropertyAnimatorListener != null) {
            viewPropertyAnimatorListener.onAnimationStart(view);
        }
    }
}
