package b.a.n;

import b.a.n.h.OverlayTrashWrap;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.n.c, reason: use source file name */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayManager4 extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ OverlayBubbleWrap $bubble;
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayManager4(OverlayManager overlayManager, OverlayBubbleWrap overlayBubbleWrap) {
        super(1);
        this.this$0 = overlayManager;
        this.$bubble = overlayBubbleWrap;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        if (bool.booleanValue()) {
            OverlayTrashWrap overlayTrashWrap = this.this$0.trashWrap;
            if (overlayTrashWrap != null) {
                overlayTrashWrap.l.start();
            }
        } else {
            OverlayTrashWrap overlayTrashWrap2 = this.this$0.trashWrap;
            if (overlayTrashWrap2 != null) {
                overlayTrashWrap2.m.start();
            }
            this.this$0.b(this.$bubble);
        }
        return Unit.a;
    }
}
