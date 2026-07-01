package com.discord.stores;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildProfiles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildProfiles$observeGuildProfile$2 extends o implements Function0<StoreGuildProfiles$GuildProfileData> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildProfiles this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildProfiles$observeGuildProfile$2(StoreGuildProfiles storeGuildProfiles, long j) {
        super(0);
        this.this$0 = storeGuildProfiles;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StoreGuildProfiles$GuildProfileData invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StoreGuildProfiles$GuildProfileData invoke() {
        return (StoreGuildProfiles$GuildProfileData) StoreGuildProfiles.access$getGuildProfilesStateSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
    }
}
