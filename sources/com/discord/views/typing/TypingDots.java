package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.t1;
import b.a.y.r0.a;
import com.discord.R$id;
import com.discord.R$integer;
import com.discord.R$layout;
import d0.t.n;
import d0.z.d.m;

/* JADX INFO: compiled from: TypingDots.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDots extends ConstraintLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final t1 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int dotsAnimationTimeMs;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final long dotsAnimationStaggerTimeMs;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean isRunning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDots(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.typing_dots_view, this);
        int i = R$id.view_typing_dots_1;
        TypingDot typingDot = (TypingDot) findViewById(R$id.view_typing_dots_1);
        if (typingDot != null) {
            i = R$id.view_typing_dots_2;
            TypingDot typingDot2 = (TypingDot) findViewById(R$id.view_typing_dots_2);
            if (typingDot2 != null) {
                i = R$id.view_typing_dots_3;
                TypingDot typingDot3 = (TypingDot) findViewById(R$id.view_typing_dots_3);
                if (typingDot3 != null) {
                    t1 t1Var = new t1(this, typingDot, typingDot2, typingDot3);
                    m.checkNotNullExpressionValue(t1Var, "TypingDotsViewBinding.in…ater.from(context), this)");
                    this.binding = t1Var;
                    int integer = getResources().getInteger(R$integer.animation_time_standard);
                    this.dotsAnimationTimeMs = integer;
                    this.dotsAnimationStaggerTimeMs = (long) (((double) integer) / 1.5d);
                    typingDot3.setOnScaleDownCompleteListener(new a(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public static /* synthetic */ void b(TypingDots typingDots, boolean z2, int i) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        typingDots.a(z2);
    }

    public final void a(boolean isReplay) {
        if (this.isRunning && !isReplay) {
            return;
        }
        long j2 = isReplay ? this.dotsAnimationStaggerTimeMs : 0L;
        this.binding.f202b.a(j2);
        this.binding.c.a(this.dotsAnimationStaggerTimeMs + j2);
        TypingDot typingDot = this.binding.d;
        long j3 = this.dotsAnimationStaggerTimeMs;
        typingDot.a(j2 + j3 + j3);
        this.isRunning = true;
    }

    public final void c() {
        t1 t1Var = this.binding;
        for (TypingDot typingDot : n.listOf((Object[]) new TypingDot[]{t1Var.f202b, t1Var.c, t1Var.d})) {
            typingDot.scaleAndFadeUpAnimation.cancel();
            typingDot.scaleAndFadeDownAnimation.cancel();
        }
        this.isRunning = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
