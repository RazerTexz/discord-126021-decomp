package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator$AnimatorPauseListener;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$doOnResume$$inlined$addPauseListener$default$1 implements Animator$AnimatorPauseListener {
    public final /* synthetic */ Function1 $onResume;

    public AnimatorKt$doOnResume$$inlined$addPauseListener$default$1(Function1 function1) {
        this.$onResume = function1;
    }

    @Override // android.animation.Animator$AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
