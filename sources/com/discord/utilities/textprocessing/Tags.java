package com.discord.utilities.textprocessing;

import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Tags {
    private final Set<Long> channels;
    private final boolean isEmpty;
    private final Set<Long> roles;
    private final Set<Long> users;

    public Tags(Set<Long> set, Set<Long> set2, Set<Long> set3) {
        C12238m.checkNotNullParameter(set, "users");
        C12238m.checkNotNullParameter(set2, "channels");
        C12238m.checkNotNullParameter(set3, "roles");
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
        C12238m.checkNotNullParameter(users, "users");
        C12238m.checkNotNullParameter(channels, "channels");
        C12238m.checkNotNullParameter(roles, "roles");
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
        return C12238m.areEqual(this.users, tags.users) && C12238m.areEqual(this.channels, tags.channels) && C12238m.areEqual(this.roles, tags.roles);
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
        StringBuilder sbM833U = C1643a.m833U("Tags(users=");
        sbM833U.append(this.users);
        sbM833U.append(", channels=");
        sbM833U.append(this.channels);
        sbM833U.append(", roles=");
        return C1643a.m826N(sbM833U, this.roles, ")");
    }
}
