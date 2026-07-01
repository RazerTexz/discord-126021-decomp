package com.discord.models.domain;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate {
    public static final ModelGuildMemberListUpdate$Companion Companion = new ModelGuildMemberListUpdate$Companion(null);
    public static final String EVERYONE_ID = "everyone";
    private final List<ModelGuildMemberListUpdate$Group> groups;
    private final long guildId;
    private final String id;
    private final List<ModelGuildMemberListUpdate$Operation> operations;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelGuildMemberListUpdate(long j, String str, List<? extends ModelGuildMemberListUpdate$Operation> list, List<ModelGuildMemberListUpdate$Group> list2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(list, "operations");
        m.checkNotNullParameter(list2, "groups");
        this.guildId = j;
        this.id = str;
        this.operations = list;
        this.groups = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelGuildMemberListUpdate copy$default(ModelGuildMemberListUpdate modelGuildMemberListUpdate, long j, String str, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = modelGuildMemberListUpdate.guildId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = modelGuildMemberListUpdate.id;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = modelGuildMemberListUpdate.operations;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = modelGuildMemberListUpdate.groups;
        }
        return modelGuildMemberListUpdate.copy(j2, str2, list3, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ModelGuildMemberListUpdate$Operation> component3() {
        return this.operations;
    }

    public final List<ModelGuildMemberListUpdate$Group> component4() {
        return this.groups;
    }

    public final ModelGuildMemberListUpdate copy(long guildId, String id2, List<? extends ModelGuildMemberListUpdate$Operation> operations, List<ModelGuildMemberListUpdate$Group> groups) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        m.checkNotNullParameter(operations, "operations");
        m.checkNotNullParameter(groups, "groups");
        return new ModelGuildMemberListUpdate(guildId, id2, operations, groups);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate)) {
            return false;
        }
        ModelGuildMemberListUpdate modelGuildMemberListUpdate = (ModelGuildMemberListUpdate) other;
        return this.guildId == modelGuildMemberListUpdate.guildId && m.areEqual(this.id, modelGuildMemberListUpdate.id) && m.areEqual(this.operations, modelGuildMemberListUpdate.operations) && m.areEqual(this.groups, modelGuildMemberListUpdate.groups);
    }

    public final List<ModelGuildMemberListUpdate$Group> getGroups() {
        return this.groups;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getId() {
        return this.id;
    }

    public final List<ModelGuildMemberListUpdate$Operation> getOperations() {
        return this.operations;
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.id;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<ModelGuildMemberListUpdate$Operation> list = this.operations;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<ModelGuildMemberListUpdate$Group> list2 = this.groups;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelGuildMemberListUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", operations=");
        sbU.append(this.operations);
        sbU.append(", groups=");
        return a.L(sbU, this.groups, ")");
    }
}
