package com.discord.models.domain;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: ModelChannelFollowerStats.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModelChannelFollowerStats$Companion {
    private ModelChannelFollowerStats$Companion() {
    }

    public final ModelChannelFollowerStats fromResponse(ModelChannelFollowerStatsDto dto) {
        return dto == null ? new ModelChannelFollowerStats(0L, null, null, null, null, null, null, Opcodes.LAND, null) : new ModelChannelFollowerStats(0L, dto.getChannelsFollowing(), dto.getGuildMembers(), dto.getGuildsFollowing(), dto.getUsersSeenEver(), dto.getSubscribersGainedSinceLastPost(), dto.getSubscribersLostSinceLastPost(), 1, null);
    }

    public /* synthetic */ ModelChannelFollowerStats$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
