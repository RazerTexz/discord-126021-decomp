package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class Transition$AnimationInfo {
    public String mName;
    public Transition mTransition;
    public TransitionValues mValues;
    public View mView;
    public WindowIdImpl mWindowId;

    public Transition$AnimationInfo(View view, String str, Transition transition, WindowIdImpl windowIdImpl, TransitionValues transitionValues) {
        this.mView = view;
        this.mName = str;
        this.mValues = transitionValues;
        this.mWindowId = windowIdImpl;
        this.mTransition = transition;
    }
}
