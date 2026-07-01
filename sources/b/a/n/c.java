package b.a.n;

import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ OverlayBubbleWrap $bubble;
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        super(1);
        this.this$0 = overlayManager;
        this.$bubble = overlayBubbleWrap;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        if (bool.booleanValue()) {
            b.a.n.h.a aVar = this.this$0.trashWrap;
            if (aVar != null) {
                aVar.l.start();
            }
        } else {
            b.a.n.h.a aVar2 = this.this$0.trashWrap;
            if (aVar2 != null) {
                aVar2.m.start();
            }
            this.this$0.b(this.$bubble);
        }
        return Unit.a;
    }
}
