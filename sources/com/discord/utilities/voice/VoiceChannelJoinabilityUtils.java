package com.discord.utilities.voice;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildMaxVideoChannelUsers;
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
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.StoreVoiceStates;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func6;

/* JADX INFO: compiled from: VoiceChannelJoinabilityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceChannelJoinabilityUtils {
    public static final VoiceChannelJoinabilityUtils INSTANCE = new VoiceChannelJoinabilityUtils();

    private VoiceChannelJoinabilityUtils() {
    }

    public final VoiceChannelJoinability computeJoinability(Channel channel, Collection<VoiceState> channelVoiceStates, Long channelPermissions, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers, GuildVerificationLevel verificationLevelTriggered, Long selectedVoiceChannelId, StageInstance stageInstance) {
        boolean z2;
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(channelVoiceStates, "channelVoiceStates");
        C12238m.checkNotNullParameter(guildMaxVideoChannelUsers, "guildMaxVideoChannelUsers");
        C12238m.checkNotNullParameter(verificationLevelTriggered, "verificationLevelTriggered");
        if (ChannelUtils.m7667B(channel)) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        long id2 = channel.getId();
        if (selectedVoiceChannelId != null && id2 == selectedVoiceChannelId.longValue()) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        if (!PermissionUtils.can(Permission.CONNECT, channelPermissions)) {
            return VoiceChannelJoinability.PERMISSIONS_MISSING;
        }
        if ((verificationLevelTriggered != GuildVerificationLevel.NONE) && (stageInstance == null || !C1460d.m484W0(stageInstance))) {
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
        if (!(z2 && (guildMaxVideoChannelUsers instanceof GuildMaxVideoChannelUsers.Limited) && size >= ((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers).getLimit()) || zCan2) {
            return VoiceChannelJoinability.CAN_JOIN;
        }
        return (((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers).getLimit() == size && zCan) ? VoiceChannelJoinability.CAN_JOIN : VoiceChannelJoinability.GUILD_VIDEO_AT_CAPACITY;
    }

    public final VoiceChannelJoinability getJoinability(long channelId) {
        GuildMaxVideoChannelUsers maxVideoChannelUsers;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Channel channel = companion.getChannels().getChannel(channelId);
        if (channel == null) {
            return VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST;
        }
        Map mapEmptyMap = (Map) C1643a.m843c(channel, companion.getVoiceStates().get());
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        Collection collectionValues = mapEmptyMap.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Long channelId2 = ((VoiceState) obj).getChannelId();
            if (channelId2 != null && channelId2.longValue() == channelId) {
                arrayList.add(obj);
            }
        }
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        Long l = companion2.getPermissions().getPermissionsByChannel().get(Long.valueOf(channelId));
        Guild guild = companion2.getGuilds().getGuild(channel.getGuildId());
        GuildVerificationLevel verificationLevelTriggered$default = GuildVerificationLevelUtils.getVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null);
        long selectedVoiceChannelId = companion2.getVoiceChannelSelected().getSelectedVoiceChannelId();
        StageInstance stageInstanceForChannel = companion2.getStageInstances().getStageInstanceForChannel(channelId);
        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
            maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
        }
        return computeJoinability(channel, arrayList, l, maxVideoChannelUsers, verificationLevelTriggered$default, Long.valueOf(selectedVoiceChannelId), stageInstanceForChannel);
    }

    public final Observable<VoiceChannelJoinability> observeJoinability(final long channelId, StoreChannels channelsStore, final StoreGuilds guildsStore, final StorePermissions permissionsStore, final StoreVoiceStates voiceStatesStore, final StoreVoiceChannelSelected voiceChannelSelectedStore, final StoreStageInstances stageInstancesStore) {
        C12238m.checkNotNullParameter(channelsStore, "channelsStore");
        C12238m.checkNotNullParameter(guildsStore, "guildsStore");
        C12238m.checkNotNullParameter(permissionsStore, "permissionsStore");
        C12238m.checkNotNullParameter(voiceStatesStore, "voiceStatesStore");
        C12238m.checkNotNullParameter(voiceChannelSelectedStore, "voiceChannelSelectedStore");
        C12238m.checkNotNullParameter(stageInstancesStore, "stageInstancesStore");
        Observable observableM11099Y = channelsStore.observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends VoiceChannelJoinability>>() { // from class: com.discord.utilities.voice.VoiceChannelJoinabilityUtils.observeJoinability.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends VoiceChannelJoinability> call(final Channel channel) {
                return channel == null ? new C12721k(VoiceChannelJoinability.CHANNEL_DOES_NOT_EXIST) : Observable.m11071f(voiceStatesStore.observe(channel.getGuildId(), channelId), permissionsStore.observePermissionsForChannel(channelId), guildsStore.observeGuild(channel.getGuildId()), GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, channel.getGuildId(), null, null, null, 14, null), voiceChannelSelectedStore.observeSelectedVoiceChannelId(), stageInstancesStore.observeStageInstanceForChannel(channelId), new Func6<Map<Long, ? extends VoiceState>, Long, Guild, GuildVerificationLevel, Long, StageInstance, VoiceChannelJoinability>() { // from class: com.discord.utilities.voice.VoiceChannelJoinabilityUtils.observeJoinability.1.1
                    @Override // p658rx.functions.Func6
                    public /* bridge */ /* synthetic */ VoiceChannelJoinability call(Map<Long, ? extends VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
                        return call2((Map<Long, VoiceState>) map, l, guild, guildVerificationLevel, l2, stageInstance);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final VoiceChannelJoinability call2(Map<Long, VoiceState> map, Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Long l2, StageInstance stageInstance) {
                        GuildMaxVideoChannelUsers maxVideoChannelUsers;
                        VoiceChannelJoinabilityUtils voiceChannelJoinabilityUtils = VoiceChannelJoinabilityUtils.INSTANCE;
                        Channel channel2 = channel;
                        Collection<VoiceState> collectionValues = map.values();
                        if (guild == null || (maxVideoChannelUsers = guild.getMaxVideoChannelUsers()) == null) {
                            maxVideoChannelUsers = GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
                        }
                        C12238m.checkNotNullExpressionValue(guildVerificationLevel, "verificationLevelTriggered");
                        return voiceChannelJoinabilityUtils.computeJoinability(channel2, collectionValues, l, maxVideoChannelUsers, guildVerificationLevel, l2, stageInstance);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "channelsStore\n        .o…  }\n          }\n        }");
        return observableM11099Y;
    }
}
