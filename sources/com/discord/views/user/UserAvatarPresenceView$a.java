package com.discord.views.user;

import b.d.b.a.a;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView$a {
    public final User a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Presence f2846b;
    public final StreamContext c;
    public final boolean d;
    public final GuildMember e;

    public UserAvatarPresenceView$a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember, int i) {
        int i2 = i & 16;
        m.checkNotNullParameter(user, "user");
        this.a = user;
        this.f2846b = presence;
        this.c = streamContext;
        this.d = z2;
        this.e = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAvatarPresenceView$a)) {
            return false;
        }
        UserAvatarPresenceView$a userAvatarPresenceView$a = (UserAvatarPresenceView$a) obj;
        return m.areEqual(this.a, userAvatarPresenceView$a.a) && m.areEqual(this.f2846b, userAvatarPresenceView$a.f2846b) && m.areEqual(this.c, userAvatarPresenceView$a.c) && this.d == userAvatarPresenceView$a.d && m.areEqual(this.e, userAvatarPresenceView$a.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        User user = this.a;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        Presence presence = this.f2846b;
        int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
        StreamContext streamContext = this.c;
        int iHashCode3 = (iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
        boolean z2 = this.d;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        GuildMember guildMember = this.e;
        return i + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(user=");
        sbU.append(this.a);
        sbU.append(", presence=");
        sbU.append(this.f2846b);
        sbU.append(", streamContext=");
        sbU.append(this.c);
        sbU.append(", showPresence=");
        sbU.append(this.d);
        sbU.append(", guildMember=");
        sbU.append(this.e);
        sbU.append(")");
        return sbU.toString();
    }

    public UserAvatarPresenceView$a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        this.a = user;
        this.f2846b = presence;
        this.c = streamContext;
        this.d = z2;
        this.e = guildMember;
    }
}
