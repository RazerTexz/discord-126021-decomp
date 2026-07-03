package p007b.p008a.p062y.p071r0;

import com.discord.views.typing.TypingDots;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.y.r0.a */
/* JADX INFO: compiled from: TypingDots.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1380a extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ TypingDots this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1380a(TypingDots typingDots) {
        super(0);
        this.this$0 = typingDots;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (this.this$0.isAttachedToWindow()) {
            this.this$0.m8619a(true);
        }
        return Unit.f27425a;
    }
}
