package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.animations.AnimationCoroutineUtils;
import com.discord.utilities.views.ViewCoroutineScope;
import d0.Lazy5;
import d0.LazyJVM;
import d0.Result3;
import d0.d0._Ranges;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl3;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import s.a.CompletableJob;
import s.a.Deferred;

/* JADX INFO: compiled from: SpeakerPulseView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeakerPulseView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final PathInterpolator rampUpInterpolator;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final PathInterpolator fadeOutInterpolator;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean hasEverAnimated;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final CompletableJob animationSupervisor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Job animationJob;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Lazy innerView;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Lazy outerView;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean isPulsing;

    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<ImageView> {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.j = i;
            this.k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            int i = this.j;
            if (i == 0) {
                return SpeakerPulseView.a((SpeakerPulseView) this.k, 0);
            }
            if (i == 1) {
                return SpeakerPulseView.a((SpeakerPulseView) this.k, 1);
            }
            throw null;
        }
    }

    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {Opcodes.LOR, Opcodes.I2D}, m = "animatePulse")
    public static final class b extends ContinuationImpl3 {
        public long J$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public b(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.d(null, 0L, 0L, this);
        }
    }

    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView", f = "SpeakerPulseView.kt", l = {117}, m = "performPulseAnimation")
    public static final class c extends ContinuationImpl3 {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public c(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.e(null, this);
        }
    }

    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$inner$1", f = "SpeakerPulseView.kt", l = {106}, m = "invokeSuspend")
    public static final class d extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new d(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView innerView = speakerPulseView.getInnerView();
                this.label = 1;
                if (speakerPulseView.d(innerView, 200L, 500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$outer$1", f = "SpeakerPulseView.kt", l = {113}, m = "invokeSuspend")
    public static final class e extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new e(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView outerView = speakerPulseView.getOuterView();
                this.label = 1;
                if (speakerPulseView.d(outerView, 700L, 0L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1", f = "SpeakerPulseView.kt", l = {87}, m = "invokeSuspend")
    public static final class f extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* JADX INFO: compiled from: SpeakerPulseView.kt */
        @DebugMetadata(c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1$1", f = "SpeakerPulseView.kt", l = {88}, m = "invokeSuspend")
        public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            public int label;

            public a(Continuation continuation) {
                super(2, continuation);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Intrinsics3.checkNotNullParameter(continuation, "completion");
                a aVar = f.this.new a(continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                Intrinsics3.checkNotNullParameter(continuation2, "completion");
                a aVar = f.this.new a(continuation2);
                aVar.L$0 = coroutineScope;
                return aVar.invokeSuspend(Unit.a);
            }

            @Override // d0.w.i.a.ContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    Result3.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                    this.label = 1;
                    if (speakerPulseView.e(coroutineScope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    Result3.throwOnFailure(obj);
                }
                return Unit.a;
            }
        }

        public f(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new f(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                CompletableJob completableJob = SpeakerPulseView.this.animationSupervisor;
                a aVar = new a(null);
                this.label = 1;
                if (b.i.a.f.e.o.f.C1(completableJob, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
        this.rampUpInterpolator = pathInterpolator;
        this.fadeOutInterpolator = pathInterpolator;
        this.animationSupervisor = b.i.a.f.e.o.f.d(null, 1);
        Lazy5 lazy5 = Lazy5.NONE;
        this.innerView = LazyJVM.lazy(lazy5, new a(0, this));
        this.outerView = LazyJVM.lazy(lazy5, new a(1, this));
        setClipChildren(false);
        setClipToOutline(false);
        setClipToPadding(false);
    }

    public static final ImageView a(SpeakerPulseView speakerPulseView, int i) {
        Integer numValueOf;
        Objects.requireNonNull(speakerPulseView);
        ImageView imageView = new ImageView(speakerPulseView.getContext());
        View childAt = speakerPulseView.getChildAt(speakerPulseView.getChildCount() - 1);
        float paddingLeft = speakerPulseView.getPaddingLeft() / 2.0f;
        int i2 = i + 1;
        Intrinsics3.checkNotNullExpressionValue(childAt, "actualChild");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (layoutParams != null) {
            numValueOf = Integer.valueOf(layoutParams.width + ((int) (2 * paddingLeft * i2)));
        } else {
            numValueOf = null;
        }
        imageView.setAlpha(0.0f);
        imageView.setImageResource(R.drawable.drawable_circle_white);
        int iCoerceAtLeast = _Ranges.coerceAtLeast(speakerPulseView.getChildCount() - 1, 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(numValueOf != null ? numValueOf.intValue() : -1, numValueOf != null ? numValueOf.intValue() : -1);
        layoutParams2.gravity = 17;
        speakerPulseView.addView(imageView, iCoerceAtLeast, layoutParams2);
        return imageView;
    }

    private final ImageView getInnerView() {
        return (ImageView) this.innerView.getValue();
    }

    private final ImageView getOuterView() {
        return (ImageView) this.outerView.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object d(View view, long j, long j2, Continuation<? super Unit> continuation) {
        b bVar;
        SpeakerPulseView speakerPulseView;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.label = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object obj = bVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = bVar.label;
        if (i2 != 0) {
            if (i2 == 1) {
                j2 = bVar.J$0;
                view = (View) bVar.L$1;
                speakerPulseView = (SpeakerPulseView) bVar.L$0;
                Result3.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            return Unit.a;
        }
        Result3.throwOnFailure(obj);
        ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().setInterpolator(this.rampUpInterpolator).setStartDelay(j).setDuration(500L).alpha(0.16f);
        Intrinsics3.checkNotNullExpressionValue(viewPropertyAnimatorAlpha, "animate()\n        .setIn…    .alpha(PULSE_OPACITY)");
        bVar.L$0 = this;
        bVar.L$1 = view;
        bVar.J$0 = j2;
        bVar.label = 1;
        if (AnimationCoroutineUtils.await(viewPropertyAnimatorAlpha, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        speakerPulseView = this;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = view.animate().setInterpolator(speakerPulseView.fadeOutInterpolator).setStartDelay(j2).setDuration(1000L).alpha(0.0f);
        Intrinsics3.checkNotNullExpressionValue(viewPropertyAnimatorAlpha2, "animate()\n        .setIn…ON_MS)\n        .alpha(0f)");
        bVar.L$0 = null;
        bVar.L$1 = null;
        bVar.label = 2;
        if (AnimationCoroutineUtils.await(viewPropertyAnimatorAlpha2, bVar) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final /* synthetic */ Object e(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        c cVar;
        SpeakerPulseView speakerPulseView;
        CoroutineScope coroutineScope2;
        SpeakerPulseView speakerPulseView2;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.label = i - Integer.MIN_VALUE;
                speakerPulseView = this;
            } else {
                speakerPulseView = this;
                cVar = speakerPulseView.new c(continuation);
            }
        } else {
            speakerPulseView = this;
            cVar = speakerPulseView.new c(continuation);
        }
        Object obj = cVar.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = cVar.label;
        if (i2 == 0) {
            Result3.throwOnFailure(obj);
            coroutineScope2 = coroutineScope;
            speakerPulseView2 = speakerPulseView;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) cVar.L$1;
            SpeakerPulseView speakerPulseView3 = (SpeakerPulseView) cVar.L$0;
            Result3.throwOnFailure(obj);
            speakerPulseView2 = speakerPulseView3;
        }
        while (b.i.a.f.e.o.f.y0(coroutineScope2)) {
            CoroutineScope coroutineScope3 = coroutineScope2;
            Deferred[] deferredArr = {b.i.a.f.e.o.f.i(coroutineScope3, null, null, speakerPulseView2.new d(null), 3, null), b.i.a.f.e.o.f.i(coroutineScope3, null, null, speakerPulseView2.new e(null), 3, null)};
            cVar.L$0 = speakerPulseView2;
            cVar.L$1 = coroutineScope2;
            cVar.label = 1;
            if (b.i.a.f.e.o.f.l(deferredArr, cVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.a;
    }

    public final void f() {
        CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this);
        if (coroutineScope == null || AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        this.hasEverAnimated = true;
        Job job = this.animationJob;
        if (job != null) {
            b.i.a.f.e.o.f.t(job, null, 1, null);
        }
        this.animationJob = b.i.a.f.e.o.f.H0(coroutineScope, null, null, new f(null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPulsing) {
            f();
        }
    }

    public final void setPulsing(boolean z2) {
        if (this.isPulsing != z2) {
            this.isPulsing = z2;
            if (z2) {
                f();
                return;
            }
            Iterator<Job> it = this.animationSupervisor.e().iterator();
            while (it.hasNext()) {
                it.next().b(null);
            }
            if (this.hasEverAnimated) {
                getInnerView().animate().setDuration(500L).alpha(0.0f);
                getOuterView().animate().setDuration(500L).alpha(0.0f);
            }
        }
    }
}
