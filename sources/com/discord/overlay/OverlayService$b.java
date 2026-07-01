package com.discord.overlay;

import b.a.n.f;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;

/* JADX INFO: compiled from: OverlayService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayService$b implements f {
    public final /* synthetic */ OverlayService j;

    public OverlayService$b(OverlayService overlayService) {
        this.j = overlayService;
    }

    @Override // b.a.n.f
    public void a(OverlayBubbleWrap overlayBubbleWrap) {
    }

    @Override // b.a.n.f
    public void b(OverlayBubbleWrap overlayBubbleWrap) {
        m.checkNotNullParameter(overlayBubbleWrap, "bubble");
        this.j.getOverlayManager().d(overlayBubbleWrap);
    }
}
