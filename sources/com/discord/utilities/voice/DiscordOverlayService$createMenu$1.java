package com.discord.utilities.voice;

import com.discord.overlay.views.OverlayDialog;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$createMenu$1 extends o implements Function1<OverlayDialog, Unit> {
    public final /* synthetic */ DiscordOverlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$createMenu$1(DiscordOverlayService discordOverlayService) {
        super(1);
        this.this$0 = discordOverlayService;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OverlayDialog overlayDialog) {
        invoke2(overlayDialog);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OverlayDialog overlayDialog) {
        m.checkNotNullParameter(overlayDialog, "it");
        DiscordOverlayService.access$getOverlayManager$p(this.this$0).d(overlayDialog);
    }
}
