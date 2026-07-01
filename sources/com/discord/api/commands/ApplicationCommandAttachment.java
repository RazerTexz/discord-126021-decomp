package com.discord.api.commands;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandAttachment {
    private final String filename;
    private final String id;

    public ApplicationCommandAttachment(String str, String str2) {
        m.checkNotNullParameter(str, "filename");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
        this.filename = str;
        this.id = str2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandAttachment)) {
            return false;
        }
        ApplicationCommandAttachment applicationCommandAttachment = (ApplicationCommandAttachment) other;
        return m.areEqual(this.filename, applicationCommandAttachment.filename) && m.areEqual(this.id, applicationCommandAttachment.id);
    }

    public int hashCode() {
        String str = this.filename;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ApplicationCommandAttachment(filename=");
        sbU.append(this.filename);
        sbU.append(", id=");
        return a.J(sbU, this.id, ")");
    }
}
