package com.discord.views.calls;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView;
import b.i.a.f.e.o.f;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.animations.AnimationCoroutineUtilsKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import d0.g;
import d0.i;
import d0.l;
import d0.w.h.c;
import d0.z.d.m;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import s.a.f0;
import s.a.u;

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
    public final u animationSupervisor;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Job animationJob;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Lazy innerView;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Lazy outerView;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public boolean isPulsing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerPulseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
        this.rampUpInterpolator = pathInterpolator;
        this.fadeOutInterpolator = pathInterpolator;
        this.animationSupervisor = f.d(null, 1);
        i iVar = i.NONE;
        this.innerView = g.lazy(iVar, new SpeakerPulseView$a(0, this));
        this.outerView = g.lazy(iVar, new SpeakerPulseView$a(1, this));
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
        m.checkNotNullExpressionValue(childAt, "actualChild");
        ViewGroup$LayoutParams layoutParams = childAt.getLayoutParams();
        if (layoutParams != null) {
            numValueOf = Integer.valueOf(layoutParams.width + ((int) (2 * paddingLeft * i2)));
        } else {
            numValueOf = null;
        }
        imageView.setAlpha(0.0f);
        imageView.setImageResource(2131231191);
        int iCoerceAtLeast = d0.d0.f.coerceAtLeast(speakerPulseView.getChildCount() - 1, 0);
        FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(numValueOf != null ? numValueOf.intValue() : -1, numValueOf != null ? numValueOf.intValue() : -1);
        frameLayout$LayoutParams.gravity = 17;
        speakerPulseView.addView(imageView, iCoerceAtLeast, frameLayout$LayoutParams);
        return imageView;
    }

    public static final /* synthetic */ ImageView b(SpeakerPulseView speakerPulseView) {
        return speakerPulseView.getInnerView();
    }

    public static final /* synthetic */ ImageView c(SpeakerPulseView speakerPulseView) {
        return speakerPulseView.getOuterView();
    }

    private final ImageView getInnerView() {
        return (ImageView) this.innerView.getValue();
    }

    private final ImageView getOuterView() {
        return (ImageView) this.outerView.getValue();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final /* synthetic */ Object d(View view, long j, long j2, Continuation<? super Unit> continuation) {
        SpeakerPulseView$b speakerPulseView$b;
        SpeakerPulseView speakerPulseView;
        if (continuation instanceof SpeakerPulseView$b) {
            speakerPulseView$b = (SpeakerPulseView$b) continuation;
            int i = speakerPulseView$b.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                speakerPulseView$b.label = i - Integer.MIN_VALUE;
            } else {
                speakerPulseView$b = new SpeakerPulseView$b(this, continuation);
            }
        } else {
            speakerPulseView$b = new SpeakerPulseView$b(this, continuation);
        }
        Object obj = speakerPulseView$b.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = speakerPulseView$b.label;
        if (i2 != 0) {
            if (i2 == 1) {
                j2 = speakerPulseView$b.J$0;
                view = (View) speakerPulseView$b.L$1;
                speakerPulseView = (SpeakerPulseView) speakerPulseView$b.L$0;
                l.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            return Unit.a;
        }
        l.throwOnFailure(obj);
        ViewPropertyAnimator viewPropertyAnimatorAlpha = view.animate().setInterpolator(this.rampUpInterpolator).setStartDelay(j).setDuration(500L).alpha(0.16f);
        m.checkNotNullExpressionValue(viewPropertyAnimatorAlpha, "animate()\n        .setIn…    .alpha(PULSE_OPACITY)");
        speakerPulseView$b.L$0 = this;
        speakerPulseView$b.L$1 = view;
        speakerPulseView$b.J$0 = j2;
        speakerPulseView$b.label = 1;
        if (AnimationCoroutineUtilsKt.await(viewPropertyAnimatorAlpha, speakerPulseView$b) == coroutine_suspended) {
            return coroutine_suspended;
        }
        speakerPulseView = this;
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = view.animate().setInterpolator(speakerPulseView.fadeOutInterpolator).setStartDelay(j2).setDuration(1000L).alpha(0.0f);
        m.checkNotNullExpressionValue(viewPropertyAnimatorAlpha2, "animate()\n        .setIn…ON_MS)\n        .alpha(0f)");
        speakerPulseView$b.L$0 = null;
        speakerPulseView$b.L$1 = null;
        speakerPulseView$b.label = 2;
        if (AnimationCoroutineUtilsKt.await(viewPropertyAnimatorAlpha2, speakerPulseView$b) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final /* synthetic */ Object e(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        SpeakerPulseView$c speakerPulseView$c;
        SpeakerPulseView speakerPulseView;
        CoroutineScope coroutineScope2;
        SpeakerPulseView speakerPulseView2;
        if (continuation instanceof SpeakerPulseView$c) {
            speakerPulseView$c = (SpeakerPulseView$c) continuation;
            int i = speakerPulseView$c.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                speakerPulseView$c.label = i - Integer.MIN_VALUE;
                speakerPulseView = this;
            } else {
                speakerPulseView = this;
                speakerPulseView$c = new SpeakerPulseView$c(speakerPulseView, continuation);
            }
        } else {
            speakerPulseView = this;
            speakerPulseView$c = new SpeakerPulseView$c(speakerPulseView, continuation);
        }
        Object obj = speakerPulseView$c.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = speakerPulseView$c.label;
        if (i2 == 0) {
            l.throwOnFailure(obj);
            coroutineScope2 = coroutineScope;
            speakerPulseView2 = speakerPulseView;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            coroutineScope2 = (CoroutineScope) speakerPulseView$c.L$1;
            SpeakerPulseView speakerPulseView3 = (SpeakerPulseView) speakerPulseView$c.L$0;
            l.throwOnFailure(obj);
            speakerPulseView2 = speakerPulseView3;
        }
        while (f.y0(coroutineScope2)) {
            CoroutineScope coroutineScope3 = coroutineScope2;
            f0[] f0VarArr = {f.i(coroutineScope3, null, null, new SpeakerPulseView$d(speakerPulseView2, null), 3, null), f.i(coroutineScope3, null, null, new SpeakerPulseView$e(speakerPulseView2, null), 3, null)};
            speakerPulseView$c.L$0 = speakerPulseView2;
            speakerPulseView$c.L$1 = coroutineScope2;
            speakerPulseView$c.label = 1;
            if (f.l(f0VarArr, speakerPulseView$c) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.a;
    }

    public final void f() {
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this);
        if (coroutineScope == null || AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        this.hasEverAnimated = true;
        Job job = this.animationJob;
        if (job != null) {
            f.t(job, null, 1, null);
        }
        this.animationJob = f.H0(coroutineScope, null, null, new SpeakerPulseView$f(this, null), 3, null);
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
