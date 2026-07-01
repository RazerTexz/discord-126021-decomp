package androidx.core.animation;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.Animator$AnimatorPauseListener;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt {
    public static final Animator$AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2, Function1<? super Animator, Unit> function3, Function1<? super Animator, Unit> function4) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function2, "onStart");
        m.checkNotNullParameter(function3, "onCancel");
        m.checkNotNullParameter(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator$AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = AnimatorKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function3 = AnimatorKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function4 = AnimatorKt$addListener$4.INSTANCE;
        }
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function2, "onStart");
        m.checkNotNullParameter(function3, "onCancel");
        m.checkNotNullParameter(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator$AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onResume");
        m.checkNotNullParameter(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator$AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnimatorKt$addPauseListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = AnimatorKt$addPauseListener$2.INSTANCE;
        }
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onResume");
        m.checkNotNullParameter(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator$AnimatorListener doOnCancel(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Animator$AnimatorListener doOnEnd(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator$AnimatorPauseListener doOnPause(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnPause$$inlined$addPauseListener$default$1 animatorKt$doOnPause$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$default$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$default$1;
    }

    public static final Animator$AnimatorListener doOnRepeat(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator$AnimatorPauseListener doOnResume(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnResume$$inlined$addPauseListener$default$1 animatorKt$doOnResume$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$default$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$default$1;
    }

    public static final Animator$AnimatorListener doOnStart(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
