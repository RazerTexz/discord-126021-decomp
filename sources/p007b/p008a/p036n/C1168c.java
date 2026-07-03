package p007b.p008a.p036n;

import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p036n.p038h.C1173a;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.n.c */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1168c extends AbstractC12240o implements Function1<Boolean, Unit> {
    public final /* synthetic */ OverlayBubbleWrap $bubble;
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1168c(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        super(1);
        this.this$0 = overlayManager;
        this.$bubble = overlayBubbleWrap;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        if (bool.booleanValue()) {
            C1173a c1173a = this.this$0.trashWrap;
            if (c1173a != null) {
                c1173a.f1563l.start();
            }
        } else {
            C1173a c1173a2 = this.this$0.trashWrap;
            if (c1173a2 != null) {
                c1173a2.f1564m.start();
            }
            this.this$0.m8431b(this.$bubble);
        }
        return Unit.f27425a;
    }
}
