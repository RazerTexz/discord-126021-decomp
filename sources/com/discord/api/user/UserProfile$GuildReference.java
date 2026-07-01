package com.discord.api.user;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: UserProfile.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserProfile$GuildReference {
    private final long id;
    private final String nick;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserProfile$GuildReference)) {
            return false;
        }
        UserProfile$GuildReference userProfile$GuildReference = (UserProfile$GuildReference) other;
        return this.id == userProfile$GuildReference.id && m.areEqual(this.nick, userProfile$GuildReference.nick);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.nick;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildReference(id=");
        sbU.append(this.id);
        sbU.append(", nick=");
        return a.J(sbU, this.nick, ")");
    }
}
