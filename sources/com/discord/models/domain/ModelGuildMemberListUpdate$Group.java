package com.discord.models.domain;

import androidx.browser.customtabs.CustomTabsCallback;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ModelGuildMemberListUpdate.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGuildMemberListUpdate$Group {
    private final int count;
    private final String id;
    private final ModelGuildMemberListUpdate$Group$Type type;

    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    public ModelGuildMemberListUpdate$Group(String str, int i) {
        ModelGuildMemberListUpdate$Group$Type modelGuildMemberListUpdate$Group$Type;
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.id = str;
        this.count = i;
        int iHashCode = str.hashCode();
        if (iHashCode != -1548612125) {
            if (iHashCode == -1012222381 && str.equals(CustomTabsCallback.ONLINE_EXTRAS_KEY)) {
                modelGuildMemberListUpdate$Group$Type = ModelGuildMemberListUpdate$Group$Type.ONLINE;
            } else {
                modelGuildMemberListUpdate$Group$Type = ModelGuildMemberListUpdate$Group$Type.ROLE;
            }
        } else if (str.equals("offline")) {
            modelGuildMemberListUpdate$Group$Type = ModelGuildMemberListUpdate$Group$Type.OFFLINE;
        } else {
            modelGuildMemberListUpdate$Group$Type = ModelGuildMemberListUpdate$Group$Type.ROLE;
        }
        this.type = modelGuildMemberListUpdate$Group$Type;
    }

    public static /* synthetic */ ModelGuildMemberListUpdate$Group copy$default(ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = modelGuildMemberListUpdate$Group.id;
        }
        if ((i2 & 2) != 0) {
            i = modelGuildMemberListUpdate$Group.count;
        }
        return modelGuildMemberListUpdate$Group.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final ModelGuildMemberListUpdate$Group copy(String id2, int count) {
        m.checkNotNullParameter(id2, ModelAuditLogEntry.CHANGE_KEY_ID);
        return new ModelGuildMemberListUpdate$Group(id2, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGuildMemberListUpdate$Group)) {
            return false;
        }
        ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group = (ModelGuildMemberListUpdate$Group) other;
        return m.areEqual(this.id, modelGuildMemberListUpdate$Group.id) && this.count == modelGuildMemberListUpdate$Group.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getId() {
        return this.id;
    }

    public final ModelGuildMemberListUpdate$Group$Type getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.id;
        return ((str != null ? str.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbU = a.U("Group(id=");
        sbU.append(this.id);
        sbU.append(", count=");
        return a.B(sbU, this.count, ")");
    }
}
