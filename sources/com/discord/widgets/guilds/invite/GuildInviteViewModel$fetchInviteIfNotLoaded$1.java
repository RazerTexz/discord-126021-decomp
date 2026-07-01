package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.app.AppLog;
import com.discord.utilities.logging.Logger;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildInviteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteViewModel$fetchInviteIfNotLoaded$1 extends o implements Function0<Unit> {
    public final /* synthetic */ GuildInviteViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteViewModel$fetchInviteIfNotLoaded$1(GuildInviteViewModel guildInviteViewModel) {
        super(0);
        this.this$0 = guildInviteViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        AppLog appLog = AppLog.g;
        StringBuilder sbU = a.U("Failed to resolve invite[");
        sbU.append(this.this$0.getInviteCode().getInviteCode());
        sbU.append("] from ");
        sbU.append(this.this$0.getInviteCode().getSource());
        Logger.d$default(appLog, sbU.toString(), null, 2, null);
    }
}
