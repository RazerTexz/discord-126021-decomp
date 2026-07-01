package com.discord.utilities.voice;

import android.view.View;
import b.a.y.w;
import com.discord.app.AppLog;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$onCreate$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ DiscordOverlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$onCreate$2(DiscordOverlayService discordOverlayService) {
        super(1);
        this.this$0 = discordOverlayService;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        Logger.v$default(AppLog.g, "OverlayService", "removeView: " + view, null, 4, null);
        if (view instanceof w) {
            StoreStream.Companion.getAnalytics().onOverlayVoiceEvent(false);
        }
        if (DiscordOverlayService.access$getOverlayManager$p(this.this$0).activeBubbles.isEmpty()) {
            DiscordOverlayService$Companion.tryStartOverlayService$default(DiscordOverlayService.Companion, this.this$0, "com.discord.actions.OVERLAY_CLOSE", false, 4, null);
        }
    }
}
