package com.discord.widgets.guildscheduledevent;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GuildScheduledEventUser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventUser {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildMember guildMember;
    private final long guildScheduledEventId;
    private final User user;

    /* JADX INFO: compiled from: GuildScheduledEventUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final GuildScheduledEventUser from(ApiGuildScheduledEventUser apiGuildScheduledEventUser, long guildId) {
            Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUser, "apiGuildScheduledEventUser");
            com.discord.api.user.User userC = apiGuildScheduledEventUser.getUser();
            com.discord.api.guildmember.GuildMember guildMemberA = apiGuildScheduledEventUser.a(guildId);
            if (userC == null || guildMemberA == null) {
                return null;
            }
            return new GuildScheduledEventUser(new CoreUser(userC), GuildMember.INSTANCE.from(guildMemberA, guildId, (8 & 4) != 0 ? null : null, (8 & 8) != 0 ? null : null), apiGuildScheduledEventUser.getGuildScheduledEventId());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventUser(User user, GuildMember guildMember, long j) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        this.user = user;
        this.guildMember = guildMember;
        this.guildScheduledEventId = j;
    }

    public static /* synthetic */ GuildScheduledEventUser copy$default(GuildScheduledEventUser guildScheduledEventUser, User user, GuildMember guildMember, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            user = guildScheduledEventUser.user;
        }
        if ((i & 2) != 0) {
            guildMember = guildScheduledEventUser.guildMember;
        }
        if ((i & 4) != 0) {
            j = guildScheduledEventUser.guildScheduledEventId;
        }
        return guildScheduledEventUser.copy(user, guildMember, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final GuildScheduledEventUser copy(User user, GuildMember guildMember, long guildScheduledEventId) {
        Intrinsics3.checkNotNullParameter(user, "user");
        Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
        return new GuildScheduledEventUser(user, guildMember, guildScheduledEventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventUser)) {
            return false;
        }
        GuildScheduledEventUser guildScheduledEventUser = (GuildScheduledEventUser) other;
        return Intrinsics3.areEqual(this.user, guildScheduledEventUser.user) && Intrinsics3.areEqual(this.guildMember, guildScheduledEventUser.guildMember) && this.guildScheduledEventId == guildScheduledEventUser.guildScheduledEventId;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final long getGuildScheduledEventId() {
        return this.guildScheduledEventId;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return b.a(this.guildScheduledEventId) + ((iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventUser(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(", guildScheduledEventId=");
        return outline.C(sbU, this.guildScheduledEventId, ")");
    }
}
