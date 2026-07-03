package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandData {
    private final List<ApplicationCommandAttachment> attachments;
    private final String guildId;
    private final String id;
    private final String name;
    private final List<ApplicationCommandValue> options;
    private final String version;

    public ApplicationCommandData(String str, String str2, String str3, String str4, List<ApplicationCommandValue> list, List<ApplicationCommandAttachment> list2) {
        C12238m.checkNotNullParameter(str3, ModelAuditLogEntry.CHANGE_KEY_ID);
        C12238m.checkNotNullParameter(str4, ModelAuditLogEntry.CHANGE_KEY_NAME);
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

    /* JADX INFO: renamed from: b */
    public final List<ApplicationCommandValue> m7725b() {
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
        return C12238m.areEqual(this.version, applicationCommandData.version) && C12238m.areEqual(this.guildId, applicationCommandData.guildId) && C12238m.areEqual(this.id, applicationCommandData.id) && C12238m.areEqual(this.name, applicationCommandData.name) && C12238m.areEqual(this.options, applicationCommandData.options) && C12238m.areEqual(this.attachments, applicationCommandData.attachments);
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
        List<ApplicationCommandValue> list = this.options;
        int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        List<ApplicationCommandAttachment> list2 = this.attachments;
        return iHashCode5 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandData(version=");
        sbM833U.append(this.version);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", options=");
        sbM833U.append(this.options);
        sbM833U.append(", attachments=");
        return C1643a.m824L(sbM833U, this.attachments, ")");
    }
}
