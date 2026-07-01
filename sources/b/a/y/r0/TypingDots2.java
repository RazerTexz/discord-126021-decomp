package b.a.y.r0;

import com.discord.views.typing.TypingDots;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.y.r0.a, reason: use source file name */
/* JADX INFO: compiled from: TypingDots.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TypingDots2 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ TypingDots this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypingDots2(TypingDots typingDots) {
        super(0);
        this.this$0 = typingDots;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (this.this$0.isAttachedToWindow()) {
            this.this$0.a(true);
        }
        return Unit.a;
    }
}
