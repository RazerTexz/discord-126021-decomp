package com.discord.overlay;

import com.discord.overlay.views.OverlayBubbleWrap;

/* JADX INFO: compiled from: OverlayService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayService$a implements Runnable {
    public final /* synthetic */ OverlayService j;
    public final /* synthetic */ OverlayBubbleWrap k;

    public OverlayService$a(OverlayService overlayService, OverlayBubbleWrap overlayBubbleWrap) {
        this.j = overlayService;
        this.k = overlayBubbleWrap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.getOverlayManager().b(this.k);
    }
}
