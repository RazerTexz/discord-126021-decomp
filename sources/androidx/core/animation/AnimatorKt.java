package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt {

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$1 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02061 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02061 INSTANCE = new C02061();

        public C02061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$2 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02072 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02072 INSTANCE = new C02072();

        public C02072() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$3 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02083 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02083 INSTANCE = new C02083();

        public C02083() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addListener$4 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02094 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02094 INSTANCE = new C02094();

        public C02094() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02101 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02101 INSTANCE = new C02101();

        public C02101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2 */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class C02112 extends AbstractC12240o implements Function1<Animator, Unit> {
        public static final C02112 INSTANCE = new C02112();

        public C02112() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            C12238m.checkNotNullParameter(animator, "it");
        }
    }

    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2, Function1<? super Animator, Unit> function3, Function1<? super Animator, Unit> function4) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "onEnd");
        C12238m.checkNotNullParameter(function2, "onStart");
        C12238m.checkNotNullParameter(function3, "onCancel");
        C12238m.checkNotNullParameter(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function2, Function1 function3, Function1 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = C02061.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = C02072.INSTANCE;
        }
        if ((i & 4) != 0) {
            function3 = C02083.INSTANCE;
        }
        if ((i & 8) != 0) {
            function4 = C02094.INSTANCE;
        }
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "onEnd");
        C12238m.checkNotNullParameter(function2, "onStart");
        C12238m.checkNotNullParameter(function3, "onCancel");
        C12238m.checkNotNullParameter(function4, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function4, function1, function3, function2);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function2) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "onResume");
        C12238m.checkNotNullParameter(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = C02101.INSTANCE;
        }
        if ((i & 2) != 0) {
            function2 = C02112.INSTANCE;
        }
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "onResume");
        C12238m.checkNotNullParameter(function2, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function2, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, final Function1<? super Animator, Unit> function1) {
        C12238m.checkNotNullParameter(animator, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C12238m.checkNotNullParameter(animator2, "animator");
                function1.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
