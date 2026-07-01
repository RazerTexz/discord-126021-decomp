package com.discord.utilities.guilds;

import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import d0.z.d.m;
import j0.l.a.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: GuildVerificationLevelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildVerificationLevelUtils {
    public static final GuildVerificationLevelUtils INSTANCE = new GuildVerificationLevelUtils();

    private GuildVerificationLevelUtils() {
    }

    public static final /* synthetic */ GuildVerificationLevel access$computeVerificationLevelTriggered(GuildVerificationLevelUtils guildVerificationLevelUtils, MeUser meUser, Guild guild, GuildMember guildMember, GuildVerificationLevel guildVerificationLevel, long j, Clock clock, Map map) {
        return guildVerificationLevelUtils.computeVerificationLevelTriggered(meUser, guild, guildMember, guildVerificationLevel, j, clock, map);
    }

    private final GuildVerificationLevel computeVerificationLevelTriggered(MeUser me2, Guild guild, GuildMember member, GuildVerificationLevel verificationLevel, long joinedAt, Clock clock, Map<Long, GuildRole> guildRoles) {
        List<Long> roles;
        GuildRole guildRole;
        boolean z2 = false;
        boolean z3 = guild != null && guild.isOwner(me2.getId());
        if (member != null && (roles = member.getRoles()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : roles) {
                if (!((guildRoles == null || (guildRole = guildRoles.get(Long.valueOf(((Number) obj).longValue()))) == null) ? true : guildRole.getManaged())) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                z2 = true;
            }
        }
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean hasPhone = userUtils.getHasPhone(me2);
        boolean zIsStaff = userUtils.isStaff(me2);
        if (z3 || z2 || hasPhone || zIsStaff) {
            return GuildVerificationLevel.NONE;
        }
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.HIGHEST;
        if (verificationLevel == guildVerificationLevel) {
            return guildVerificationLevel;
        }
        GuildVerificationLevel guildVerificationLevel2 = GuildVerificationLevel.HIGH;
        if (verificationLevel == guildVerificationLevel2 && !GuildMemberUtilsKt.isGuildMemberOldEnough(joinedAt)) {
            return guildVerificationLevel2;
        }
        GuildVerificationLevel guildVerificationLevel3 = GuildVerificationLevel.MEDIUM;
        if (verificationLevel == guildVerificationLevel3 && !userUtils.isAccountOldEnough(me2, clock)) {
            return guildVerificationLevel3;
        }
        GuildVerificationLevel guildVerificationLevel4 = GuildVerificationLevel.LOW;
        return (verificationLevel != guildVerificationLevel4 || me2.isVerified()) ? GuildVerificationLevel.NONE : guildVerificationLevel4;
    }

    public static /* synthetic */ GuildVerificationLevel getVerificationLevelTriggered$default(GuildVerificationLevelUtils guildVerificationLevelUtils, long j, StoreGuilds storeGuilds, StoreUser storeUser, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 8) != 0) {
            clock = ClockFactory.get();
        }
        return guildVerificationLevelUtils.getVerificationLevelTriggered(j, storeGuilds2, storeUser2, clock);
    }

    public static /* synthetic */ Observable observeVerificationLevelTriggered$default(GuildVerificationLevelUtils guildVerificationLevelUtils, long j, StoreGuilds storeGuilds, StoreUser storeUser, Clock clock, int i, Object obj) {
        if ((i & 2) != 0) {
            storeGuilds = StoreStream.Companion.getGuilds();
        }
        StoreGuilds storeGuilds2 = storeGuilds;
        if ((i & 4) != 0) {
            storeUser = StoreStream.Companion.getUsers();
        }
        StoreUser storeUser2 = storeUser;
        if ((i & 8) != 0) {
            clock = ClockFactory.get();
        }
        return guildVerificationLevelUtils.observeVerificationLevelTriggered(j, storeGuilds2, storeUser2, clock);
    }

    public final GuildVerificationLevel getVerificationLevelTriggered(long guildId, StoreGuilds guildStore, StoreUser userStore, Clock clock) {
        GuildVerificationLevel verificationLevel;
        m.checkNotNullParameter(guildStore, "guildStore");
        m.checkNotNullParameter(userStore, "userStore");
        m.checkNotNullParameter(clock, "clock");
        Guild guild = guildStore.getGuild(guildId);
        Map<Long, GuildMember> map = guildStore.getMembers().get(Long.valueOf(guildId));
        MeUser meSnapshot = userStore.getMeSnapshot();
        Map<Long, GuildRole> map2 = guildStore.getRoles().get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(meSnapshot.getId())) : null;
        if (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) {
            verificationLevel = GuildVerificationLevel.NONE;
        }
        return computeVerificationLevelTriggered(meSnapshot, guild, guildMember, verificationLevel, GuildMemberUtilsKt.getJoinedAtOrNow(guildStore.getGuildsJoinedAt().get(Long.valueOf(guildId))), clock, map2);
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevelTriggered(long guildId, StoreGuilds guildStore, StoreUser userStore, Clock clock) {
        m.checkNotNullParameter(guildStore, "guildStore");
        m.checkNotNullParameter(userStore, "userStore");
        m.checkNotNullParameter(clock, "clock");
        Observable<Long> observableObserveJoinedAt = guildStore.observeJoinedAt(guildId);
        Observable<Guild> observableObserveGuild = guildStore.observeGuild(guildId);
        Observable<GuildVerificationLevel> observableObserveVerificationLevel = guildStore.observeVerificationLevel(guildId);
        Observable<Map<Long, GuildMember>> observableObserveComputed = guildStore.observeComputed(guildId);
        Observable<GuildVerificationLevel> observableR = Observable.f(observableObserveJoinedAt, observableObserveGuild, observableObserveVerificationLevel, Observable.h0(new r(observableObserveComputed.j, new LeadingEdgeThrottle(1500L, TimeUnit.MILLISECONDS))), userStore.observeMe(true), guildStore.observeRoles(guildId), new GuildVerificationLevelUtils$observeVerificationLevelTriggered$1(clock)).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n        .comb…  .distinctUntilChanged()");
        return observableR;
    }
}
