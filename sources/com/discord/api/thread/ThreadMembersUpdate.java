package com.discord.api.thread;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ThreadMembersUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadMembersUpdate {
    private final List<AugmentedThreadMember> addedMembers;
    private final long guildId;
    private final long id;
    private final int memberCount;
    private final List<Long> memberIdsPreview;
    private final List<Long> removedMemberIds;

    /* JADX INFO: renamed from: a */
    public final List<AugmentedThreadMember> m8275a() {
        return this.addedMembers;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: d */
    public final List<Long> m8278d() {
        return this.removedMemberIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMembersUpdate)) {
            return false;
        }
        ThreadMembersUpdate threadMembersUpdate = (ThreadMembersUpdate) other;
        return this.id == threadMembersUpdate.id && this.guildId == threadMembersUpdate.guildId && this.memberCount == threadMembersUpdate.memberCount && C12238m.areEqual(this.removedMemberIds, threadMembersUpdate.removedMemberIds) && C12238m.areEqual(this.memberIdsPreview, threadMembersUpdate.memberIdsPreview) && C12238m.areEqual(this.addedMembers, threadMembersUpdate.addedMembers);
    }

    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.memberCount) * 31;
        List<Long> list = this.removedMemberIds;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Long> list2 = this.memberIdsPreview;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<AugmentedThreadMember> list3 = this.addedMembers;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ThreadMembersUpdate(id=");
        sbM833U.append(this.id);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", memberCount=");
        sbM833U.append(this.memberCount);
        sbM833U.append(", removedMemberIds=");
        sbM833U.append(this.removedMemberIds);
        sbM833U.append(", memberIdsPreview=");
        sbM833U.append(this.memberIdsPreview);
        sbM833U.append(", addedMembers=");
        return C1643a.m824L(sbM833U, this.addedMembers, ")");
    }
}
