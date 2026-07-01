package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator$AnimatorListener {
    public final /* synthetic */ Function1<Animator, Unit> $onCancel;
    public final /* synthetic */ Function1<Animator, Unit> $onEnd;
    public final /* synthetic */ Function1<Animator, Unit> $onRepeat;
    public final /* synthetic */ Function1<Animator, Unit> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2, Function1<? super Animator, Unit> function3, Function1<? super Animator, Unit> function4) {
        this.$onRepeat = function1;
        this.$onEnd = function2;
        this.$onCancel = function3;
        this.$onStart = function4;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
