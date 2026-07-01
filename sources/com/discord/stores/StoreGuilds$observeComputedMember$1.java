package com.discord.stores;

import com.discord.models.member.GuildMember;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeComputedMember$1 extends o implements Function0<GuildMember> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ StoreGuilds this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$observeComputedMember$1(StoreGuilds storeGuilds, long j, long j2) {
        super(0);
        this.this$0 = storeGuilds;
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildMember invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildMember invoke() {
        return this.this$0.getMember(this.$guildId, this.$userId);
    }
}
