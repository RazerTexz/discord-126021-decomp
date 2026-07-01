package com.discord.views.typing;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: kotlin-style lambda group */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDot$a extends o implements Function0<Unit> {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDot$a(int i, Object obj) {
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
