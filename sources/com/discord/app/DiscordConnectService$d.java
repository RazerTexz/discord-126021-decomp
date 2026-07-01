package com.discord.app;

import b.d.b.a.a;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordConnectService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DiscordConnectService$d extends o implements Function1<Error, Unit> {
    public final /* synthetic */ int $startId;
    public final /* synthetic */ DiscordConnectService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordConnectService$d(DiscordConnectService discordConnectService, int i) {
        super(1);
        this.this$0 = discordConnectService;
        this.$startId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Error error) {
        Error error2 = error;
        m.checkNotNullParameter(error2, "it");
        error2.setShouldLog(false);
        DiscordConnectService$a discordConnectService$a = DiscordConnectService.j;
        StringBuilder sbU = a.U("Request timeout[");
        sbU.append(this.$startId);
        sbU.append("]: ");
        sbU.append(error2);
        DiscordConnectService$a.a(discordConnectService$a, sbU.toString());
        DiscordConnectService discordConnectService = this.this$0;
        int i = this.$startId;
        discordConnectService.stopForeground(true);
        discordConnectService.stopSelf(i);
        return Unit.a;
    }
}
