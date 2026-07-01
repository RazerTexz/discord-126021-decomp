package com.discord.utilities.voice;

import android.content.Intent;
import com.discord.app.AppLog;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$onStartCommand$2 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ Intent $intent;
    public final /* synthetic */ int $startId;
    public final /* synthetic */ DiscordOverlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$onStartCommand$2(DiscordOverlayService discordOverlayService, int i, Intent intent) {
        super(1);
        this.this$0 = discordOverlayService;
        this.$startId = i;
        this.$intent = intent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        if (!StoreStream.Companion.getUserSettings().getIsMobileOverlayEnabled()) {
            this.this$0.stopForeground(true);
            this.this$0.stopSelf(this.$startId);
            return;
        }
        try {
            DiscordOverlayService.access$handleStart$s1927314545(this.this$0, this.$intent);
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "OverlayService", "Overlay failed to handle a request.", e, null, 8, null);
            DiscordOverlayService$Companion.tryStartOverlayService$default(DiscordOverlayService.Companion, this.this$0, "com.discord.actions.OVERLAY_CLOSE", false, 4, null);
        }
    }
}
