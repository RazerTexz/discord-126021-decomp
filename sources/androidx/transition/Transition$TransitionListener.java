package androidx.transition;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface Transition$TransitionListener {
    void onTransitionCancel(@NonNull Transition transition);

    void onTransitionEnd(@NonNull Transition transition);

    void onTransitionPause(@NonNull Transition transition);

    void onTransitionResume(@NonNull Transition transition);

    void onTransitionStart(@NonNull Transition transition);
}
