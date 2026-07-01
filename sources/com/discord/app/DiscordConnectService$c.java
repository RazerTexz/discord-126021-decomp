package com.discord.app;

import b.d.b.a.a;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService$c extends o implements Function0<Unit> {
    public final /* synthetic */ int $startId;
    public final /* synthetic */ DiscordConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordConnectService$c(DiscordConnectService discordConnectService, int i) {
        super(0);
        this.this$0 = discordConnectService;
        this.$startId = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        DiscordConnectService$a discordConnectService$a = DiscordConnectService.j;
        StringBuilder sbU = a.U("Success[");
        sbU.append(this.$startId);
        sbU.append(']');
        DiscordConnectService$a.a(discordConnectService$a, sbU.toString());
        DiscordConnectService discordConnectService = this.this$0;
        int i = this.$startId;
        discordConnectService.stopForeground(true);
        discordConnectService.stopSelf(i);
        return Unit.a;
    }
}
