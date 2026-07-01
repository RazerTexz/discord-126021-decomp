package com.discord.stores;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$handleGuildMemberCommunicationEnabled$1 extends o implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreGuilds this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$handleGuildMemberCommunicationEnabled$1(StoreGuilds storeGuilds, long j, long j2) {
        super(0);
        this.this$0 = storeGuilds;
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreGuilds.access$handleGuildMemberCommunicationEnabledInternal(this.this$0, this.$guildId, this.$userId);
    }
}
