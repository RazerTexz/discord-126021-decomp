package androidx.core.transition;

import android.transition.Transition;
import android.transition.Transition$TransitionListener;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition$TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function2, Function1<? super Transition, Unit> function3, Function1<? super Transition, Unit> function4, Function1<? super Transition, Unit> function5) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function2, "onStart");
        m.checkNotNullParameter(function3, "onCancel");
        m.checkNotNullParameter(function4, "onResume");
        m.checkNotNullParameter(function5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function4, function5, function3, function2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition$TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = TransitionKt$addListener$2.INSTANCE;
        }
        Function1 function6 = function2;
        if ((i & 4) != 0) {
            function3 = TransitionKt$addListener$3.INSTANCE;
        }
        Function1 function7 = function3;
        if ((i & 8) != 0) {
            function4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            function5 = TransitionKt$addListener$5.INSTANCE;
        }
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function6, "onStart");
        m.checkNotNullParameter(function7, "onCancel");
        m.checkNotNullParameter(function4, "onResume");
        m.checkNotNullParameter(function5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function4, function5, function7, function6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition$TransitionListener doOnCancel(Transition transition, Function1<? super Transition, Unit> function1) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "action");
        TransitionKt$doOnCancel$$inlined$addListener$default$1 transitionKt$doOnCancel$$inlined$addListener$default$1 = new TransitionKt$doOnCancel$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnCancel$$inlined$addListener$default$1);
        return transitionKt$doOnCancel$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Transition$TransitionListener doOnEnd(Transition transition, Function1<? super Transition, Unit> function1) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "action");
        TransitionKt$doOnEnd$$inlined$addListener$default$1 transitionKt$doOnEnd$$inlined$addListener$default$1 = new TransitionKt$doOnEnd$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnEnd$$inlined$addListener$default$1);
        return transitionKt$doOnEnd$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Transition$TransitionListener doOnPause(Transition transition, Function1<? super Transition, Unit> function1) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "action");
        TransitionKt$doOnPause$$inlined$addListener$default$1 transitionKt$doOnPause$$inlined$addListener$default$1 = new TransitionKt$doOnPause$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnPause$$inlined$addListener$default$1);
        return transitionKt$doOnPause$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Transition$TransitionListener doOnResume(Transition transition, Function1<? super Transition, Unit> function1) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "action");
        TransitionKt$doOnResume$$inlined$addListener$default$1 transitionKt$doOnResume$$inlined$addListener$default$1 = new TransitionKt$doOnResume$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnResume$$inlined$addListener$default$1);
        return transitionKt$doOnResume$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Transition$TransitionListener doOnStart(Transition transition, Function1<? super Transition, Unit> function1) {
        m.checkNotNullParameter(transition, "<this>");
        m.checkNotNullParameter(function1, "action");
        TransitionKt$doOnStart$$inlined$addListener$default$1 transitionKt$doOnStart$$inlined$addListener$default$1 = new TransitionKt$doOnStart$$inlined$addListener$default$1(function1);
        transition.addListener(transitionKt$doOnStart$$inlined$addListener$default$1);
        return transitionKt$doOnStart$$inlined$addListener$default$1;
    }
}
