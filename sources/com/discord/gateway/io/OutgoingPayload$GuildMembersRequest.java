package com.discord.gateway.io;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Outgoing.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class OutgoingPayload$GuildMembersRequest extends OutgoingPayload {
    private final List<Long> guildId;
    private final Integer limit;
    private final boolean presences;
    private final String query;
    private final List<Long> userIds;

    public /* synthetic */ OutgoingPayload$GuildMembersRequest(List list, String str, List list2, Integer num, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? true : z2);
    }

    private final List<Long> component1() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final String getQuery() {
        return this.query;
    }

    private final List<Long> component3() {
        return this.userIds;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final Integer getLimit() {
        return this.limit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OutgoingPayload$GuildMembersRequest copy$default(OutgoingPayload$GuildMembersRequest outgoingPayload$GuildMembersRequest, List list, String str, List list2, Integer num, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = outgoingPayload$GuildMembersRequest.guildId;
        }
        if ((i & 2) != 0) {
            str = outgoingPayload$GuildMembersRequest.query;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list2 = outgoingPayload$GuildMembersRequest.userIds;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            num = outgoingPayload$GuildMembersRequest.limit;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            z2 = outgoingPayload$GuildMembersRequest.presences;
        }
        return outgoingPayload$GuildMembersRequest.copy(list, str2, list3, num2, z2);
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getPresences() {
        return this.presences;
    }

    public final OutgoingPayload$GuildMembersRequest copy(List<Long> guildId, String query, List<Long> userIds, Integer limit, boolean presences) {
        m.checkNotNullParameter(guildId, "guildId");
        return new OutgoingPayload$GuildMembersRequest(guildId, query, userIds, limit, presences);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutgoingPayload$GuildMembersRequest)) {
            return false;
        }
        OutgoingPayload$GuildMembersRequest outgoingPayload$GuildMembersRequest = (OutgoingPayload$GuildMembersRequest) other;
        return m.areEqual(this.guildId, outgoingPayload$GuildMembersRequest.guildId) && m.areEqual(this.query, outgoingPayload$GuildMembersRequest.query) && m.areEqual(this.userIds, outgoingPayload$GuildMembersRequest.userIds) && m.areEqual(this.limit, outgoingPayload$GuildMembersRequest.limit) && this.presences == outgoingPayload$GuildMembersRequest.presences;
    }

    public final boolean getPresences() {
        return this.presences;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        List<Long> list = this.guildId;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.query;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list2 = this.userIds;
        int iHashCode3 = (iHashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Integer num = this.limit;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.presences;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode4 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildMembersRequest(guildId=");
        sbU.append(this.guildId);
        sbU.append(", query=");
        sbU.append(this.query);
        sbU.append(", userIds=");
        sbU.append(this.userIds);
        sbU.append(", limit=");
        sbU.append(this.limit);
        sbU.append(", presences=");
        return a.O(sbU, this.presences, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutgoingPayload$GuildMembersRequest(List<Long> list, String str, List<Long> list2, Integer num, boolean z2) {
        super(null);
        m.checkNotNullParameter(list, "guildId");
        this.guildId = list;
        this.query = str;
        this.userIds = list2;
        this.limit = num;
        this.presences = z2;
    }
}
