package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransitionKt {

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$1 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02571 extends AbstractC12240o implements Function1<Transition, Unit> {
        public static final C02571 INSTANCE = new C02571();

        public C02571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            C12238m.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$2 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02582 extends AbstractC12240o implements Function1<Transition, Unit> {
        public static final C02582 INSTANCE = new C02582();

        public C02582() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            C12238m.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$3 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02593 extends AbstractC12240o implements Function1<Transition, Unit> {
        public static final C02593 INSTANCE = new C02593();

        public C02593() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            C12238m.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$4 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02604 extends AbstractC12240o implements Function1<Transition, Unit> {
        public static final C02604 INSTANCE = new C02604();

        public C02604() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            C12238m.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$5 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02615 extends AbstractC12240o implements Function1<Transition, Unit> {
        public static final C02615 INSTANCE = new C02615();

        public C02615() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            C12238m.checkNotNullParameter(transition, "it");
        }
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function2, Function1<? super Transition, Unit> function3, Function1<? super Transition, Unit> function4, Function1<? super Transition, Unit> function5) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "onEnd");
        C12238m.checkNotNullParameter(function2, "onStart");
        C12238m.checkNotNullParameter(function3, "onCancel");
        C12238m.checkNotNullParameter(function4, "onResume");
        C12238m.checkNotNullParameter(function5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function4, function5, function3, function2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = C02571.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = C02582.INSTANCE;
        }
        Function1 function6 = function2;
        if ((i & 4) != 0) {
            function3 = C02593.INSTANCE;
        }
        Function1 function7 = function3;
        if ((i & 8) != 0) {
            function4 = C02604.INSTANCE;
        }
        if ((i & 16) != 0) {
            function5 = C02615.INSTANCE;
        }
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "onEnd");
        C12238m.checkNotNullParameter(function6, "onStart");
        C12238m.checkNotNullParameter(function7, "onCancel");
        C12238m.checkNotNullParameter(function4, "onResume");
        C12238m.checkNotNullParameter(function5, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(function1, function4, function5, function7, function6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, final Function1<? super Transition, Unit> function1) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
                function1.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, final Function1<? super Transition, Unit> function1) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
                function1.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, final Function1<? super Transition, Unit> function1) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
                function1.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, final Function1<? super Transition, Unit> function1) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
                function1.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, final Function1<? super Transition, Unit> function1) {
        C12238m.checkNotNullParameter(transition, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C12238m.checkNotNullParameter(transition2, "transition");
                function1.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
