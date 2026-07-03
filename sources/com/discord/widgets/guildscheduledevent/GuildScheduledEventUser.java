package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

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
            C12238m.checkNotNullParameter(apiGuildScheduledEventUser, "apiGuildScheduledEventUser");
            com.discord.api.user.User userM7969c = apiGuildScheduledEventUser.getUser();
            com.discord.api.guildmember.GuildMember guildMemberM7967a = apiGuildScheduledEventUser.m7967a(guildId);
            if (userM7969c == null || guildMemberM7967a == null) {
                return null;
            }
            return new GuildScheduledEventUser(new CoreUser(userM7969c), GuildMember.INSTANCE.from(guildMemberM7967a, guildId, (8 & 4) != 0 ? null : null, (8 & 8) != 0 ? null : null), apiGuildScheduledEventUser.getGuildScheduledEventId());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GuildScheduledEventUser(User user, GuildMember guildMember, long j) {
        C12238m.checkNotNullParameter(user, "user");
        C12238m.checkNotNullParameter(guildMember, "guildMember");
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
        C12238m.checkNotNullParameter(user, "user");
        C12238m.checkNotNullParameter(guildMember, "guildMember");
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
        return C12238m.areEqual(this.user, guildScheduledEventUser.user) && C12238m.areEqual(this.guildMember, guildScheduledEventUser.guildMember) && this.guildScheduledEventId == guildScheduledEventUser.guildScheduledEventId;
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
        return C0002b.m3a(this.guildScheduledEventId) + ((iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("GuildScheduledEventUser(user=");
        sbM833U.append(this.user);
        sbM833U.append(", guildMember=");
        sbM833U.append(this.guildMember);
        sbM833U.append(", guildScheduledEventId=");
        return C1643a.m815C(sbM833U, this.guildScheduledEventId, ")");
    }
}
