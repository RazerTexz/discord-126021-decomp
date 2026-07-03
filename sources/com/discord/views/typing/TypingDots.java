package com.discord.views.typing;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import p007b.p008a.p025i.C1053t1;
import p007b.p008a.p062y.p071r0.C1380a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TypingDots.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDots extends ConstraintLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19342j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C1053t1 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final int dotsAnimationTimeMs;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final long dotsAnimationStaggerTimeMs;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public boolean isRunning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDots(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.typing_dots_view, this);
        int i = C5419R.id.view_typing_dots_1;
        TypingDot typingDot = (TypingDot) findViewById(C5419R.id.view_typing_dots_1);
        if (typingDot != null) {
            i = C5419R.id.view_typing_dots_2;
            TypingDot typingDot2 = (TypingDot) findViewById(C5419R.id.view_typing_dots_2);
            if (typingDot2 != null) {
                i = C5419R.id.view_typing_dots_3;
                TypingDot typingDot3 = (TypingDot) findViewById(C5419R.id.view_typing_dots_3);
                if (typingDot3 != null) {
                    C1053t1 c1053t1 = new C1053t1(this, typingDot, typingDot2, typingDot3);
                    C12238m.checkNotNullExpressionValue(c1053t1, "TypingDotsViewBinding.in…ater.from(context), this)");
                    this.binding = c1053t1;
                    int integer = getResources().getInteger(C5419R.integer.animation_time_standard);
                    this.dotsAnimationTimeMs = integer;
                    this.dotsAnimationStaggerTimeMs = (long) (((double) integer) / 1.5d);
                    typingDot3.setOnScaleDownCompleteListener(new C1380a(this));
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m8618b(TypingDots typingDots, boolean z2, int i) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        typingDots.m8619a(z2);
    }

    /* JADX INFO: renamed from: a */
    public final void m8619a(boolean isReplay) {
        if (this.isRunning && !isReplay) {
            return;
        }
        long j = isReplay ? this.dotsAnimationStaggerTimeMs : 0L;
        this.binding.f1240b.m8617a(j);
        this.binding.f1241c.m8617a(this.dotsAnimationStaggerTimeMs + j);
        TypingDot typingDot = this.binding.f1242d;
        long j2 = this.dotsAnimationStaggerTimeMs;
        typingDot.m8617a(j + j2 + j2);
        this.isRunning = true;
    }

    /* JADX INFO: renamed from: c */
    public final void m8620c() {
        C1053t1 c1053t1 = this.binding;
        for (TypingDot typingDot : C12147n.listOf((Object[]) new TypingDot[]{c1053t1.f1240b, c1053t1.f1241c, c1053t1.f1242d})) {
            typingDot.scaleAndFadeUpAnimation.cancel();
            typingDot.scaleAndFadeDownAnimation.cancel();
        }
        this.isRunning = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m8620c();
    }
}
