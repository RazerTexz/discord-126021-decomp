package com.discord.api.thread;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ThreadMembersUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ThreadMembersUpdate {
    private final List<AugmentedThreadMember> addedMembers;
    private final long guildId;
    private final long id;
    private final int memberCount;
    private final List<Long> memberIdsPreview;
    private final List<Long> removedMemberIds;

    public final List<AugmentedThreadMember> a() {
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

    public final List<Long> d() {
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
        return this.id == threadMembersUpdate.id && this.guildId == threadMembersUpdate.guildId && this.memberCount == threadMembersUpdate.memberCount && m.areEqual(this.removedMemberIds, threadMembersUpdate.removedMemberIds) && m.areEqual(this.memberIdsPreview, threadMembersUpdate.memberIdsPreview) && m.areEqual(this.addedMembers, threadMembersUpdate.addedMembers);
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
        StringBuilder sbU = a.U("ThreadMembersUpdate(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", memberCount=");
        sbU.append(this.memberCount);
        sbU.append(", removedMemberIds=");
        sbU.append(this.removedMemberIds);
        sbU.append(", memberIdsPreview=");
        sbU.append(this.memberIdsPreview);
        sbU.append(", addedMembers=");
        return a.L(sbU, this.addedMembers, ")");
    }
}
