package com.discord.utilities.lazy.requester;

import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildMemberRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberRequestManager$getGuildRequestState$1 extends o implements Function1<Long, Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildMemberRequestManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMemberRequestManager$getGuildRequestState$1(GuildMemberRequestManager guildMemberRequestManager, long j) {
        super(1);
        this.this$0 = guildMemberRequestManager;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        return ((Boolean) GuildMemberRequestManager.access$getGuildMemberExists$p(this.this$0).invoke(Long.valueOf(this.$guildId), Long.valueOf(j))).booleanValue();
    }
}
