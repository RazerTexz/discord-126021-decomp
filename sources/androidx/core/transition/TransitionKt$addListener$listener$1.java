package androidx.core.transition;

import android.transition.Transition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    public final /* synthetic */ Function1<Transition, Unit> $onCancel;
    public final /* synthetic */ Function1<Transition, Unit> $onEnd;
    public final /* synthetic */ Function1<Transition, Unit> $onPause;
    public final /* synthetic */ Function1<Transition, Unit> $onResume;
    public final /* synthetic */ Function1<Transition, Unit> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function2, Function1<? super Transition, Unit> function3, Function1<? super Transition, Unit> function4, Function1<? super Transition, Unit> function5) {
        this.$onEnd = function1;
        this.$onResume = function2;
        this.$onPause = function3;
        this.$onCancel = function4;
        this.$onStart = function5;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        C12238m.checkNotNullParameter(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        C12238m.checkNotNullParameter(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        C12238m.checkNotNullParameter(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        C12238m.checkNotNullParameter(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        C12238m.checkNotNullParameter(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
