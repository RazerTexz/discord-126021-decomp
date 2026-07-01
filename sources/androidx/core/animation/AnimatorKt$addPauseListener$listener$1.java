package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator$AnimatorPauseListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator$AnimatorPauseListener {
    public final /* synthetic */ Function1<Animator, Unit> $onPause;
    public final /* synthetic */ Function1<Animator, Unit> $onResume;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addPauseListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2) {
        this.$onPause = function1;
        this.$onResume = function2;
    }

    @Override // android.animation.Animator$AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator$AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
