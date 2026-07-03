package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.discord.C5419R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TypingDot.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDot extends View {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Animation scaleAndFadeUpAnimation;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Animation scaleAndFadeDownAnimation;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onScaleDownCompleteListener;

    /* JADX INFO: renamed from: com.discord.views.typing.TypingDot$a */
    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class C7129a extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f19339j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f19340k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7129a(int i, Object obj) {
            super(0);
            this.f19339j = i;
            this.f19340k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.f19339j;
            if (i == 0) {
                TypingDot typingDot = (TypingDot) this.f19340k;
                typingDot.startAnimation(typingDot.scaleAndFadeDownAnimation);
                return Unit.f27425a;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> onScaleDownCompleteListener = ((TypingDot) this.f19340k).getOnScaleDownCompleteListener();
            if (onScaleDownCompleteListener != null) {
                onScaleDownCompleteListener.invoke();
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.typing.TypingDot$b */
    /* JADX INFO: compiled from: TypingDot.kt */
    public static class AnimationAnimationListenerC7130b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: j */
        public final Function0<Unit> f19341j;

        public AnimationAnimationListenerC7130b(Function0<Unit> function0) {
            C12238m.checkNotNullParameter(function0, "onComplete");
            this.f19341j = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f19341j.invoke();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, C5419R.anim.anim_typing_dots_scale_up);
        C12238m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…nim_typing_dots_scale_up)");
        this.scaleAndFadeUpAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, C5419R.anim.anim_typing_dots_scale_down);
        C12238m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…m_typing_dots_scale_down)");
        this.scaleAndFadeDownAnimation = animationLoadAnimation2;
    }

    /* JADX INFO: renamed from: a */
    public final void m8617a(long delay) {
        this.scaleAndFadeUpAnimation.setStartOffset(delay);
        this.scaleAndFadeUpAnimation.setAnimationListener(new AnimationAnimationListenerC7130b(new C7129a(0, this)));
        this.scaleAndFadeDownAnimation.setAnimationListener(new AnimationAnimationListenerC7130b(new C7129a(1, this)));
        startAnimation(this.scaleAndFadeUpAnimation);
    }

    public final Function0<Unit> getOnScaleDownCompleteListener() {
        return this.onScaleDownCompleteListener;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.scaleAndFadeUpAnimation.cancel();
        this.scaleAndFadeDownAnimation.cancel();
    }

    public final void setOnScaleDownCompleteListener(Function0<Unit> function0) {
        this.onScaleDownCompleteListener = function0;
    }
}
