package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.discord.C5419R;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.animations.AnimationCoroutineUtilsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12083g;
import p507d0.C12113l;
import p507d0.EnumC12110i;
import p507d0.p512d0.C11226f;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.InterfaceC13109f0;
import p659s.p660a.InterfaceC13153u;

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
    public final InterfaceC13153u animationSupervisor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Job animationJob;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Lazy innerView;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Lazy outerView;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean isPulsing;

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class C7101a extends AbstractC12240o implements Function0<ImageView> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f19218j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f19219k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7101a(int i, Object obj) {
            super(0);
            this.f19218j = i;
            this.f19219k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final ImageView invoke() {
            int i = this.f19218j;
            if (i == 0) {
                return SpeakerPulseView.m8574a((SpeakerPulseView) this.f19219k, 0);
            }
            if (i == 1) {
                return SpeakerPulseView.m8574a((SpeakerPulseView) this.f19219k, 1);
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$b */
    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView", m10085f = "SpeakerPulseView.kt", m10086l = {Opcodes.LOR, Opcodes.I2D}, m10087m = "animatePulse")
    public static final class C7102b extends AbstractC12187d {
        public long J$0;
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public C7102b(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.m8577d(null, 0L, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$c */
    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView", m10085f = "SpeakerPulseView.kt", m10086l = {117}, m10087m = "performPulseAnimation")
    public static final class C7103c extends AbstractC12187d {
        public Object L$0;
        public Object L$1;
        public int label;
        public /* synthetic */ Object result;

        public C7103c(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpeakerPulseView.this.m8578e(null, this);
        }
    }

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$d */
    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$inner$1", m10085f = "SpeakerPulseView.kt", m10086l = {106}, m10087m = "invokeSuspend")
    public static final class C7104d extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C7104d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new C7104d(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            C12238m.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new C7104d(continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView innerView = speakerPulseView.getInnerView();
                this.label = 1;
                if (speakerPulseView.m8577d(innerView, 200L, 500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$e */
    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView$performPulseAnimation$outer$1", m10085f = "SpeakerPulseView.kt", m10086l = {113}, m10087m = "invokeSuspend")
    public static final class C7105e extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C7105e(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new C7105e(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            C12238m.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new C7105e(continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                ImageView outerView = speakerPulseView.getOuterView();
                this.label = 1;
                if (speakerPulseView.m8577d(outerView, 700L, 0L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$f */
    /* JADX INFO: compiled from: SpeakerPulseView.kt */
    @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1", m10085f = "SpeakerPulseView.kt", m10086l = {87}, m10087m = "invokeSuspend")
    public static final class C7106f extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        /* JADX INFO: renamed from: com.discord.views.calls.SpeakerPulseView$f$a */
        /* JADX INFO: compiled from: SpeakerPulseView.kt */
        @InterfaceC12188e(m10084c = "com.discord.views.calls.SpeakerPulseView$startAnimating$1$1", m10085f = "SpeakerPulseView.kt", m10086l = {88}, m10087m = "invokeSuspend")
        public static final class a extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            public int label;

            public a(Continuation continuation) {
                super(2, continuation);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C12238m.checkNotNullParameter(continuation, "completion");
                a aVar = C7106f.this.new a(continuation);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                Continuation<? super Unit> continuation2 = continuation;
                C12238m.checkNotNullParameter(continuation2, "completion");
                a aVar = C7106f.this.new a(continuation2);
                aVar.L$0 = coroutineScope;
                return aVar.invokeSuspend(Unit.f27425a);
            }

            @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    C12113l.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                    SpeakerPulseView speakerPulseView = SpeakerPulseView.this;
                    this.label = 1;
                    if (speakerPulseView.m8578e(coroutineScope, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C12113l.throwOnFailure(obj);
                }
                return Unit.f27425a;
            }
        }

        public C7106f(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return SpeakerPulseView.this.new C7106f(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            C12238m.checkNotNullParameter(continuation2, "completion");
            return SpeakerPulseView.this.new C7106f(continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                InterfaceC13153u interfaceC13153u = SpeakerPulseView.this.animationSupervisor;
                a aVar = new a(null);
                this.label = 1;
                if (C3404f.m4197C1(interfaceC13153u, aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
        this.rampUpInterpolator = pathInterpolator;
        this.fadeOutInterpolator = pathInterpolator;
        this.animationSupervisor = C3404f.m4279d(null, 1);
        EnumC12110i enumC12110i = EnumC12110i.NONE;
        this.innerView = C12083g.lazy(enumC12110i, new C7101a(0, this));
        this.outerView = C12083g.lazy(enumC12110i, new C7101a(1, this));
        setClipChildren(false);
        setClipToOutline(false);
        setClipToPadding(false);
    }

    /* JADX INFO: renamed from: a */
    public static final ImageView m8574a(SpeakerPulseView speakerPulseView, int i) {
        Integer numValueOf;
        Objects.requireNonNull(speakerPulseView);
        ImageView imageView = new ImageView(speakerPulseView.getContext());
        View childAt = speakerPulseView.getChildAt(speakerPulseView.getChildCount() - 1);
        float paddingLeft = speakerPulseView.getPaddingLeft() / 2.0f;
        int i2 = i + 1;
        C12238m.checkNotNullExpressionValue(childAt, "actualChild");
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (layoutParams != null) {
            numValueOf = Integer.valueOf(layoutParams.width + ((int) (2 * paddingLeft * i2)));
        } else {
            numValueOf = null;
        }
        imageView.setAlpha(0.0f);
        imageView.setImageResource(C5419R.drawable.drawable_circle_white);
        int iCoerceAtLeast = C11226f.coerceAtLeast(speakerPulseView.getChildCount() - 1, 0);
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
    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object m8577d(View view, long j, long j2, Continuation<? super Unit> continuation) {
        C7102b c7102b;
        SpeakerPulseView speakerPulseView;
        if (continuation instanceof C7102b) {
            c7102b = (C7102b) continuation;
            int i = c7102b.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c7102b.label = i - Integer.MIN_VALUE;
            } else {
                c7102b = new C7102b(continuation);
            }
        } else {
            c7102b = new C7102b(continuation);
        }
        Object obj = c7102b.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c7102b.label;
        if (i2 != 0) {
            if (i2 == 1) {
                j2 = c7102b.J$0;
                view = (View) c7102b.L$1;
                speakerPulseView = (SpeakerPulseView) c7102b.L$0;
                C12113l.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            return Unit.f27425a;
        }
        C12113l.throwOnFailure(obj);
        ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().setInterpolator(this.rampUpInterpolator).setStartDelay(j).setDuration(500L).alpha(0.16f);
        C12238m.checkNotNullExpressionValue(viewPropertyAnimatorAlpha, "animate()\n        .setIn…    .alpha(PULSE_OPACITY)");
        c7102b.L$0 = this;
        c7102b.L$1 = view;
        c7102b.J$0 = j2;
        c7102b.label = 1;
        if (AnimationCoroutineUtilsKt.await(viewPropertyAnimatorAlpha, c7102b) == coroutine_suspended) {
            return coroutine_suspended;
        }
        speakerPulseView = this;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = view.animate().setInterpolator(speakerPulseView.fadeOutInterpolator).setStartDelay(j2).setDuration(1000L).alpha(0.0f);
        C12238m.checkNotNullExpressionValue(viewPropertyAnimatorAlpha2, "animate()\n        .setIn…ON_MS)\n        .alpha(0f)");
        c7102b.L$0 = null;
        c7102b.L$1 = null;
        c7102b.label = 2;
        if (AnimationCoroutineUtilsKt.await(viewPropertyAnimatorAlpha2, c7102b) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.f27425a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object m8578e(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        C7103c c7103c;
        SpeakerPulseView speakerPulseView;
        CoroutineScope coroutineScope2;
        SpeakerPulseView speakerPulseView2;
        if (continuation instanceof C7103c) {
            c7103c = (C7103c) continuation;
            int i = c7103c.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c7103c.label = i - Integer.MIN_VALUE;
                speakerPulseView = this;
            } else {
                speakerPulseView = this;
                c7103c = speakerPulseView.new C7103c(continuation);
            }
        } else {
            speakerPulseView = this;
            c7103c = speakerPulseView.new C7103c(continuation);
        }
        Object obj = c7103c.result;
        Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
        int i2 = c7103c.label;
        if (i2 == 0) {
            C12113l.throwOnFailure(obj);
            coroutineScope2 = coroutineScope;
            speakerPulseView2 = speakerPulseView;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) c7103c.L$1;
            SpeakerPulseView speakerPulseView3 = (SpeakerPulseView) c7103c.L$0;
            C12113l.throwOnFailure(obj);
            speakerPulseView2 = speakerPulseView3;
        }
        while (C3404f.m4364y0(coroutineScope2)) {
            CoroutineScope coroutineScope3 = coroutineScope2;
            InterfaceC13109f0[] interfaceC13109f0Arr = {C3404f.m4299i(coroutineScope3, null, null, speakerPulseView2.new C7104d(null), 3, null), C3404f.m4299i(coroutineScope3, null, null, speakerPulseView2.new C7105e(null), 3, null)};
            c7103c.L$0 = speakerPulseView2;
            c7103c.L$1 = coroutineScope2;
            c7103c.label = 1;
            if (C3404f.m4311l(interfaceC13109f0Arr, c7103c) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: f */
    public final void m8579f() {
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this);
        if (coroutineScope == null || AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        this.hasEverAnimated = true;
        Job job = this.animationJob;
        if (job != null) {
            C3404f.m4343t(job, null, 1, null);
        }
        this.animationJob = C3404f.m4211H0(coroutineScope, null, null, new C7106f(null), 3, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isPulsing) {
            m8579f();
        }
    }

    public final void setPulsing(boolean z2) {
        if (this.isPulsing != z2) {
            this.isPulsing = z2;
            if (z2) {
                m8579f();
                return;
            }
            Iterator<Job> it = this.animationSupervisor.mo10912e().iterator();
            while (it.hasNext()) {
                it.next().mo10911b(null);
            }
            if (this.hasEverAnimated) {
                getInnerView().animate().setDuration(500L).alpha(0.0f);
                getOuterView().animate().setDuration(500L).alpha(0.0f);
            }
        }
    }
}
