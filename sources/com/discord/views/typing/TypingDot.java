package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.discord.R$anim;
import d0.z.d.m;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$anim.anim_typing_dots_scale_up);
        m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…nim_typing_dots_scale_up)");
        this.scaleAndFadeUpAnimation = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R$anim.anim_typing_dots_scale_down);
        m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…m_typing_dots_scale_down)");
        this.scaleAndFadeDownAnimation = animationLoadAnimation2;
    }

    public final void a(long delay) {
        this.scaleAndFadeUpAnimation.setStartOffset(delay);
        this.scaleAndFadeUpAnimation.setAnimationListener(new TypingDot$b(new TypingDot$a(0, this)));
        this.scaleAndFadeDownAnimation.setAnimationListener(new TypingDot$b(new TypingDot$a(1, this)));
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
