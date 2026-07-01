package com.discord.utilities.voice;

import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Limited;
import com.discord.api.guild.GuildMaxVideoChannelUsers$Unlimited;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.h0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: VoiceChannelJoinabilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceChannelJoinabilityUtils {
    public static final VoiceChannelJoinabilityUtils INSTANCE = new VoiceChannelJoinabilityUtils();

    private VoiceChannelJoinabilityUtils() {
    }

    public static /* synthetic */ Observable observeJoinability$default(VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreVoiceStates storeVoiceStates, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreStageInstances storeStageInstances, int i, Object obj) {
        return voiceChannelJoinabilityUtils.observeJoinability(j, (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 16) != 0 ? StoreStream.Companion.getVoiceStates() : storeVoiceStates, (i & 32) != 0 ? StoreStream.Companion.getVoiceChannelSelected() : storeVoiceChannelSelected, (i & 64) != 0 ? StoreStream.Companion.getStageInstances() : storeStageInstances);
    }

    public final VoiceChannelJoinability computeJoinability(Channel channel, Collection<VoiceState> channelVoiceStates, Long channelPermissions, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, GuildVerificationLevel verificationLevelTriggered, Long selectedVoiceChannelId, StageInstance stageInstance) {
        boolean z2;
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(channelVoiceStates, "channelVoiceStates");
        m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
        if (ChannelUtils.B(channel)) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        long id2 = channel.getId();
        if (selectedVoiceChannelId != null && id2 == selectedVoiceChannelId.longValue()) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        if (!PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return VoiceChannelJoinability.PERMISSIONS_MISSING;
        }
        if ((verificationLevelTriggered != GuildVerificationLevel.NONE) && (stageInstance == null || !d.W0(stageInstance))) {
            return VoiceChannelJoinability.PERMISSIONS_MISSING;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : channelVoiceStates) {
            Long channelId = ((VoiceState) obj).getChannelId();
            if (channelId != null && channelId.longValue() == channel.getId()) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        if (arrayList.isEmpty()) {
            z2 = false;
            break;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (((VoiceState) it.next()).getSelfVideo()) {
                z2 = true;
                break;
            }
        }
        boolean zCan = PermissionUtils.can(Permission.MOVE_MEMBERS, channelPermissions);
        if (size >= (channel.getUserLimit() != 0 ? channel.getUserLimit() : Integer.MAX_VALUE) && !zCan) {
            return VoiceChannelJoinability.CHANNEL_FULL;
        }
        boolean zCan2 = PermissionUtils.can(8L, channelPermissions);
        if (!(z2 && (guildMaxVideoChannelUsers instanceof GuildMaxVideoChannelUsers$Limited) && size >= ((GuildMaxVideoChannelUsers$Limited) guildMaxVideoChannelUsers).getLimit()) || zCan2) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        return (((GuildMaxVideoChannelUsers$Limited) guildMaxVideoChannelUsers).getLimit() == size && zCan) ? VoiceChannelJoinability.CAN_JOIN : VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY;
    }

    public final VoiceChannelJoinability getJoinability(long channelId) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Channel channel = storeStream$Companion.getChannels().getChannel(channelId);
        if (channel == null) {
            return VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
        }
        Map mapEmptyMap = (Map) a.c(channel, storeStream$Companion.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        Collection collectionValues = mapEmptyMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Long channelId2 = ((VoiceState) obj).getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                arrayList.add(obj);
            }
        }
        StoreStream$Companion storeStream$Companion2 = StoreStream.Companion;
        Long l = storeStream$Companion2.getPermissions().getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = storeStream$Companion2.getGuilds().getGuild(channel.getGuildId());
        GuildVerificationLevel verificationLevelTriggered$default = GuildVerificationLevelUtils.getVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null);
        long selectedVoiceChannelId = storeStream$Companion2.getVoiceChannelSelected().getSelectedVoiceChannelId();
        StageInstance stageInstanceForChannel = storeStream$Companion2.getStageInstances().getStageInstanceForChannel(channelId);
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers$Unlimited.INSTANCE;
        }
        return computeJoinability(channel, arrayList, l, maxVideoChannelUsers, verificationLevelTriggered$default, Long.valueOf(selectedVoiceChannelId), stageInstanceForChannel);
    }

    public final Observable<VoiceChannelJoinability> observeJoinability(long channelId, StoreChannels channelsStore, StoreGuilds guildsStore, StorePermissions permissionsStore, StoreVoiceStates voiceStatesStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreStageInstances stageInstancesStore) {
        m.checkNotNullParameter(channelsStore, "channelsStore");
        m.checkNotNullParameter(guildsStore, "guildsStore");
        m.checkNotNullParameter(permissionsStore, "permissionsStore");
        m.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        m.checkNotNullParameter(stageInstancesStore, "stageInstancesStore");
        Observable observableY = channelsStore.observeChannel(channelId).Y(new VoiceChannelJoinabilityUtils$observeJoinability$1(voiceStatesStore, channelId, permissionsStore, guildsStore, voiceChannelSelectedStore, stageInstancesStore));
        m.checkNotNullExpressionValue(observableY, "channelsStore\n        .o…  }\n          }\n        }");
        return observableY;
    }
}
