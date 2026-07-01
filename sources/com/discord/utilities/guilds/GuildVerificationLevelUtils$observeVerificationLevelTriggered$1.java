package com.discord.utilities.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func6;

/* JADX INFO: compiled from: GuildVerificationLevelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildVerificationLevelUtils$observeVerificationLevelTriggered$1<T1, T2, T3, T4, T5, T6, R> implements Func6<Long, Guild, GuildVerificationLevel, Map<Long, ? extends GuildMember>, MeUser, Map<Long, ? extends GuildRole>, GuildVerificationLevel> {
    public final /* synthetic */ Clock $clock;

    public GuildVerificationLevelUtils$observeVerificationLevelTriggered$1(Clock clock) {
        this.$clock = clock;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ GuildVerificationLevel call(Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Map<Long, ? extends GuildMember> map, MeUser meUser, Map<Long, ? extends GuildRole> map2) {
        return call2(l, guild, guildVerificationLevel, (Map<Long, GuildMember>) map, meUser, (Map<Long, GuildRole>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildVerificationLevel call2(Long l, Guild guild, GuildVerificationLevel guildVerificationLevel, Map<Long, GuildMember> map, MeUser meUser, Map<Long, GuildRole> map2) {
        GuildVerificationLevelUtils guildVerificationLevelUtils = GuildVerificationLevelUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "me");
        m.checkNotNullExpressionValue(map, "members");
        GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
        m.checkNotNullExpressionValue(guildVerificationLevel, "verificationLevel");
        m.checkNotNullExpressionValue(l, "joinedAt");
        return GuildVerificationLevelUtils.access$computeVerificationLevelTriggered(guildVerificationLevelUtils, meUser, guild, guildMember, guildVerificationLevel, l.longValue(), this.$clock, map2);
    }
}
