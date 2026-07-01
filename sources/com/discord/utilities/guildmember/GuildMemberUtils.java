package com.discord.utilities.guildmember;

import com.discord.models.member.GuildMember;
import com.discord.utilities.time.ClockFactory;

/* JADX INFO: renamed from: com.discord.utilities.guildmember.GuildMemberUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: GuildMemberUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberUtils {
    private static final long AGE_THRESHOLD = 600000;

    public static final long getJoinedAtOrNow(Long l) {
        return l != null ? l.longValue() : ClockFactory.get().currentTimeMillis();
    }

    public static final boolean isGuildMemberOldEnough(long j) {
        return ClockFactory.get().currentTimeMillis() - j > 600000;
    }

    public static final boolean isLurker(GuildMember guildMember) {
        return guildMember == null || guildMember.getPending() || guildMember.getJoinedAt() == null;
    }
}
