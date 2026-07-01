package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.discord.R;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: TypingDot.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDot extends View {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Animation scaleAndFadeUpAnimation;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Animation scaleAndFadeDownAnimation;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onScaleDownCompleteListener;

    /* JADX INFO: compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.j = i;
            this.k = obj;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.j;
            if (i == 0) {
                TypingDot typingDot = (TypingDot) this.k;
                typingDot.startAnimation(typingDot.scaleAndFadeDownAnimation);
                return Unit.a;
            }
            if (i != 1) {
                throw null;
            }
            Function0<Unit> onScaleDownCompleteListener = ((TypingDot) this.k).getOnScaleDownCompleteListener();
            if (onScaleDownCompleteListener != null) {
                onScaleDownCompleteListener.invoke();
            }
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: TypingDot.kt */
    public static class b implements Animation.AnimationListener {
        public final Function0<Unit> j;

        public b(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "onComplete");
            this.j = function0;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.j.invoke();
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
        Intrinsics3.checkNotNullParameter(context, "context");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_typing_dots_scale_up);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…nim_typing_dots_scale_up)");
        this.scaleAndFadeUpAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R.anim.anim_typing_dots_scale_down);
        Intrinsics3.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…m_typing_dots_scale_down)");
        this.scaleAndFadeDownAnimation = animationLoadAnimation2;
    }

    public final void a(long delay) {
        this.scaleAndFadeUpAnimation.setStartOffset(delay);
        this.scaleAndFadeUpAnimation.setAnimationListener(new b(new a(0, this)));
        this.scaleAndFadeDownAnimation.setAnimationListener(new b(new a(1, this)));
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
