package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.user.User;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.user.CoreUser;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUser$Companion {
    private GuildScheduledEventUser$Companion() {
    }

    public final GuildScheduledEventUser from(ApiGuildScheduledEventUser apiGuildScheduledEventUser, long guildId) {
        m.checkNotNullParameter(apiGuildScheduledEventUser, "apiGuildScheduledEventUser");
        User userC = apiGuildScheduledEventUser.getUser();
        GuildMember guildMemberA = apiGuildScheduledEventUser.a(guildId);
        if (userC == null || guildMemberA == null) {
            return null;
        }
        return new GuildScheduledEventUser(new CoreUser(userC), GuildMember$Companion.from$default(com.discord.models.member.GuildMember.Companion, guildMemberA, guildId, null, null, 12, null), apiGuildScheduledEventUser.getGuildScheduledEventId());
    }

    public /* synthetic */ GuildScheduledEventUser$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
