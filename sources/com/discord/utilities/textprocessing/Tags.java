package com.discord.utilities.textprocessing;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Tags {
    private final Set<Long> channels;
    private final boolean isEmpty;
    private final Set<Long> roles;
    private final Set<Long> users;

    public Tags(Set<Long> set, Set<Long> set2, Set<Long> set3) {
        m.checkNotNullParameter(set, "users");
        m.checkNotNullParameter(set2, "channels");
        m.checkNotNullParameter(set3, "roles");
        this.users = set;
        this.channels = set2;
        this.roles = set3;
        this.isEmpty = set.isEmpty() && set3.isEmpty() && set2.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Tags copy$default(Tags tags, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = tags.users;
        }
        if ((i & 2) != 0) {
            set2 = tags.channels;
        }
        if ((i & 4) != 0) {
            set3 = tags.roles;
        }
        return tags.copy(set, set2, set3);
    }

    public final Set<Long> component1() {
        return this.users;
    }

    public final Set<Long> component2() {
        return this.channels;
    }

    public final Set<Long> component3() {
        return this.roles;
    }

    public final Tags copy(Set<Long> users, Set<Long> channels, Set<Long> roles) {
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(roles, "roles");
        return new Tags(users, channels, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tags)) {
            return false;
        }
        Tags tags = (Tags) other;
        return m.areEqual(this.users, tags.users) && m.areEqual(this.channels, tags.channels) && m.areEqual(this.roles, tags.roles);
    }

    public final Set<Long> getChannels() {
        return this.channels;
    }

    public final Set<Long> getRoles() {
        return this.roles;
    }

    public final Set<Long> getUsers() {
        return this.users;
    }

    public int hashCode() {
        Set<Long> set = this.users;
        int iHashCode = (set != null ? set.hashCode() : 0) * 31;
        Set<Long> set2 = this.channels;
        int iHashCode2 = (iHashCode + (set2 != null ? set2.hashCode() : 0)) * 31;
        Set<Long> set3 = this.roles;
        return iHashCode2 + (set3 != null ? set3.hashCode() : 0);
    }

    /* JADX INFO: renamed from: isEmpty, reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        StringBuilder sbU = a.U("Tags(users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        return a.N(sbU, this.roles, ")");
    }
}
