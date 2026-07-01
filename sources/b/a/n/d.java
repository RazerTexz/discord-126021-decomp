package b.a.n;

import android.view.View;
import android.view.View$OnClickListener;
import android.view.WindowManager;
import com.discord.overlay.OverlayManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d implements View$OnClickListener {
    public final /* synthetic */ OverlayManager j;
    public final /* synthetic */ Function1 k;
    public final /* synthetic */ OverlayBubbleWrap l;
    public final /* synthetic */ Object m;

    public d(OverlayManager overlayManager, Function1 function1, OverlayBubbleWrap overlayBubbleWrap, Object obj) {
        this.j = overlayManager;
        this.k = function1;
        this.l = overlayBubbleWrap;
        this.m = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        OverlayBubbleWrap overlayBubbleWrap = (OverlayBubbleWrap) this.k.invoke(this.l);
        overlayBubbleWrap.addOnAttachStateChangeListener(new d$a(this));
        this.j.a(overlayBubbleWrap);
        this.l.setBubbleTouchable(false);
        this.j.windowManager.removeViewImmediate(this.l);
        WindowManager windowManager = this.j.windowManager;
        OverlayBubbleWrap overlayBubbleWrap2 = this.l;
        windowManager.addView(overlayBubbleWrap2, overlayBubbleWrap2.getWindowLayoutParams());
    }
}
