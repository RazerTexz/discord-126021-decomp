package p007b.p008a.p036n;

import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.n.b */
/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1167b extends AbstractC12240o implements Function1<OverlayBubbleWrap, Boolean> {
    public final /* synthetic */ OverlayManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1167b(OverlayManager overlayManager) {
        super(1);
        this.this$0 = overlayManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(OverlayBubbleWrap overlayBubbleWrap) {
        boolean z2;
        OverlayBubbleWrap overlayBubbleWrap2 = overlayBubbleWrap;
        C12238m.checkNotNullParameter(overlayBubbleWrap2, "bubbleWrap");
        try {
            this.this$0.windowManager.removeViewImmediate(overlayBubbleWrap2);
            this.this$0.onOverlayBubbleRemoved.invoke(overlayBubbleWrap2);
            z2 = true;
        } catch (IllegalArgumentException unused) {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
