package com.discord.utilities.textprocessing;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Set;

/* JADX INFO: renamed from: com.discord.utilities.textprocessing.Tags, reason: use source file name */
/* JADX INFO: compiled from: TagsBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class TagsBuilder2 {
    private final Set<Long> channels;
    private final boolean isEmpty;
    private final Set<Long> roles;
    private final Set<Long> users;

    public TagsBuilder2(Set<Long> set, Set<Long> set2, Set<Long> set3) {
        Intrinsics3.checkNotNullParameter(set, "users");
        Intrinsics3.checkNotNullParameter(set2, "channels");
        Intrinsics3.checkNotNullParameter(set3, "roles");
        this.users = set;
        this.channels = set2;
        this.roles = set3;
        this.isEmpty = set.isEmpty() && set3.isEmpty() && set2.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagsBuilder2 copy$default(TagsBuilder2 tagsBuilder2, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = tagsBuilder2.users;
        }
        if ((i & 2) != 0) {
            set2 = tagsBuilder2.channels;
        }
        if ((i & 4) != 0) {
            set3 = tagsBuilder2.roles;
        }
        return tagsBuilder2.copy(set, set2, set3);
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

    public final TagsBuilder2 copy(Set<Long> users, Set<Long> channels, Set<Long> roles) {
        Intrinsics3.checkNotNullParameter(users, "users");
        Intrinsics3.checkNotNullParameter(channels, "channels");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        return new TagsBuilder2(users, channels, roles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagsBuilder2)) {
            return false;
        }
        TagsBuilder2 tagsBuilder2 = (TagsBuilder2) other;
        return Intrinsics3.areEqual(this.users, tagsBuilder2.users) && Intrinsics3.areEqual(this.channels, tagsBuilder2.channels) && Intrinsics3.areEqual(this.roles, tagsBuilder2.roles);
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
        StringBuilder sbU = outline.U("Tags(users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", roles=");
        return outline.N(sbU, this.roles, ")");
    }
}
