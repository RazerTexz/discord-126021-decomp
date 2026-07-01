package com.discord.models.guild;

import b.d.b.a.outline;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserGuildMember.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserGuildMember {
    private final GuildMember guildMember;
    private final String nickname;
    private final User user;

    public UserGuildMember(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        this.nickname = guildMember != null ? guildMember.getNick() : null;
    }

    public static /* synthetic */ UserGuildMember copy$default(UserGuildMember userGuildMember, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            user = userGuildMember.user;
        }
        if ((i & 2) != 0) {
            guildMember = userGuildMember.guildMember;
        }
        return userGuildMember.copy(user, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final UserGuildMember copy(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new UserGuildMember(user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserGuildMember)) {
            return false;
        }
        UserGuildMember userGuildMember = (UserGuildMember) other;
        return Intrinsics3.areEqual(this.user, userGuildMember.user) && Intrinsics3.areEqual(this.guildMember, userGuildMember.guildMember);
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final String getNickOrUserName() {
        return GuildMember.INSTANCE.getNickOrUsername(this.guildMember, this.user);
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserGuildMember(user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ UserGuildMember(User user, GuildMember guildMember, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember);
    }
}
