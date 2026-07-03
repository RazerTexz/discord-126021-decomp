package com.discord.stores;

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
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StoreStageChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelRoleContext {
    private final Channel channel;
    private final Guild guild;
    private final Map<Long, GuildRole> guildRolesMap;
    private final Map<Long, VoiceState> voiceStates;

    public StageChannelRoleContext(Guild guild, Channel channel, Map<Long, GuildRole> map, Map<Long, VoiceState> map2) {
        C12238m.checkNotNullParameter(guild, "guild");
        C12238m.checkNotNullParameter(channel, "channel");
        C12238m.checkNotNullParameter(map, "guildRolesMap");
        C12238m.checkNotNullParameter(map2, "voiceStates");
        this.guild = guild;
        this.channel = channel;
        this.guildRolesMap = map;
        this.voiceStates = map2;
    }

    private final boolean can(long permission, long userId, GuildMember member) {
        long id2 = this.guild.getId();
        long ownerId = this.guild.getOwnerId();
        Map<Long, GuildRole> map = this.guildRolesMap;
        List<PermissionOverwrite> listM7655v = this.channel.m7655v();
        if (listM7655v == null) {
            listM7655v = C12147n.emptyList();
        }
        return PermissionUtils.can(permission, Long.valueOf(PermissionUtils.computeNonThreadPermissions(userId, id2, ownerId, member, map, listM7655v)));
    }

    private final boolean isSpeaker(long userId, GuildMember member) {
        if (this.voiceStates.get(Long.valueOf(userId)) != null) {
            return getRequestToSpeakState(userId) == StageRequestToSpeakState.ON_STAGE;
        }
        return can(Permission.SPEAK, userId, member);
    }

    public final StageRequestToSpeakState getRequestToSpeakState(long userId) {
        return C1460d.m592y0(this.voiceStates.get(Long.valueOf(userId)));
    }

    /* JADX INFO: renamed from: getRole-K-6mKVE, reason: not valid java name */
    public final int m11384getRoleK6mKVE(long userId, GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        return StageRoles.INSTANCE.m11415invokeH48EO60(isSpeaker(userId, member), isModerator(userId, member), getRequestToSpeakState(userId) == StageRequestToSpeakState.REQUESTED_TO_SPEAK_AND_AWAITING_USER_ACK);
    }

    public final boolean isModerator(long userId, GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        return can(20971536L, userId, member);
    }
}
