package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GuildCommunicationDisabledGuildsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1 extends o implements Function0<Boolean> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ GuildCommunicationDisabledGuildsFeatureFlag this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCommunicationDisabledGuildsFeatureFlag$observeCanGuildAccessCommunicationDisabled$1(GuildCommunicationDisabledGuildsFeatureFlag guildCommunicationDisabledGuildsFeatureFlag, long j) {
        super(0);
        this.this$0 = guildCommunicationDisabledGuildsFeatureFlag;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.canGuildAccessCommunicationDisabled(this.$guildId) && this.this$0.canUserAccessDisableCommunication();
    }
}
