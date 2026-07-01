package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandData {
    private final List<ApplicationCommandData2> attachments;
    private final String guildId;
    private final String id;
    private final String name;
    private final List<ApplicationCommandData3> options;
    private final String version;

    public ApplicationCommandData(String str, String str2, String str3, String str4, List<ApplicationCommandData3> list, List<ApplicationCommandData2> list2) {
        Intrinsics3.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
        Intrinsics3.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.version = str;
        this.guildId = str2;
        this.id = str3;
        this.name = str4;
        this.options = list;
        this.attachments = list2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandData3> b() {
        return this.options;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandData)) {
            return false;
        }
        ApplicationCommandData applicationCommandData = (ApplicationCommandData) other;
        return Intrinsics3.areEqual(this.version, applicationCommandData.version) && Intrinsics3.areEqual(this.guildId, applicationCommandData.guildId) && Intrinsics3.areEqual(this.id, applicationCommandData.id) && Intrinsics3.areEqual(this.name, applicationCommandData.name) && Intrinsics3.areEqual(this.options, applicationCommandData.options) && Intrinsics3.areEqual(this.attachments, applicationCommandData.attachments);
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.guildId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ApplicationCommandData3> list = this.options;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<ApplicationCommandData2> list2 = this.attachments;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandData(version=");
        sbU.append(this.version);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", attachments=");
        return outline.L(sbU, this.attachments, ")");
    }
}
