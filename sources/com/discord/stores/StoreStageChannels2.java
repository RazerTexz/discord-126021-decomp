package com.discord.stores;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.api.voice.state.StageRequestToSpeakState;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageRoles;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.discord.stores.StageChannelRoleContext, reason: use source file name */
/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreStageChannels2 {
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRolesMap;
    private final Map<Long, VoiceState> voiceStates;

    public StoreStageChannels2(Guild guild, Channel channel, Map<Long, GuildRole> map, Map<Long, VoiceState> map2) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(map, "guildRolesMap");
        Intrinsics3.checkNotNullParameter(map2, "voiceStates");
        this.guild = guild;
        this.channel = channel;
        this.guildRolesMap = map;
        this.voiceStates = map2;
    }

    private final boolean can(long permission, long userId, GuildMember member) {
        long id2 = this.guild.getId();
        long ownerId = this.guild.getOwnerId();
        Map<Long, GuildRole> map = this.guildRolesMap;
        List<PermissionOverwrite> listV = this.channel.v();
        if (listV == null) {
            listV = Collections2.emptyList();
        }
        return PermissionUtils.can(permission, Long.valueOf(PermissionUtils.computeNonThreadPermissions(userId, id2, ownerId, member, map, listV)));
    }

    private final boolean isSpeaker(long userId, GuildMember member) {
        if (this.voiceStates.get(Long.valueOf(userId)) != null) {
            return getRequestToSpeakState(userId) == StageRequestToSpeakState.ON_STAGE;
        }
        return can(Permission.SPEAK, userId, member);
    }

    public final StageRequestToSpeakState getRequestToSpeakState(long userId) {
        return AnimatableValueParser.y0(this.voiceStates.get(Long.valueOf(userId)));
    }

    /* JADX INFO: renamed from: getRole-K-6mKVE, reason: not valid java name */
    public final int m7getRoleK6mKVE(long userId, GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        return StageRoles.INSTANCE.m38invokeH48EO60(isSpeaker(userId, member), isModerator(userId, member), getRequestToSpeakState(userId) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK);
    }

    public final boolean isModerator(long userId, GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        return can(20971536L, userId, member);
    }
}
