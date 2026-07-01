package com.discord.utilities.voice;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Unlimited;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.Collection;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: VoiceChannelJoinabilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceChannelJoinabilityUtils$observeJoinability$1$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends VoiceState>, Long, Guild, GuildVerificationLevel, Long, StageInstance, VoiceChannelJoinability> {
    public final /* synthetic */ Channel $channel;

    public VoiceChannelJoinabilityUtils$observeJoinability$1$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ VoiceChannelJoinability call(Map<Long, ? extends VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
        return call2((Map<Long, VoiceState>) map, l, guild, guildVerificationLevel, l2, stageInstance);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final VoiceChannelJoinability call2(Map<Long, VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
        Channel channel = this.$channel;
        Collection<VoiceState> collectionValues = map.values();
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers$Unlimited.INSTANCE;
        }
        m.checkNotNullExpressionValue(guildVerificationLevel, "verificationLevelTriggered");
        return voiceChannelJoinabilityUtils.computeJoinability(channel, collectionValues, l, maxVideoChannelUsers, guildVerificationLevel, l2, stageInstance);
    }
}
