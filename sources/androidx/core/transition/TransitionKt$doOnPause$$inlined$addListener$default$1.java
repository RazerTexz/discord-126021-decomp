package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition$TransitionListener;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt$doOnPause$$inlined$addListener$default$1 implements Transition$TransitionListener {
    public final /* synthetic */ Function1 $onPause;

    public TransitionKt$doOnPause$$inlined$addListener$default$1(Function1 function1) {
        this.$onPause = function1;
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionCancel(Transition transition) {
        m.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionEnd(Transition transition) {
        m.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionPause(Transition transition) {
        m.checkNotNullParameter(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionResume(Transition transition) {
        m.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition$TransitionListener
    public void onTransitionStart(Transition transition) {
        m.checkNotNullParameter(transition, "transition");
    }
}
