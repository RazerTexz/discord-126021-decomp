package com.discord.api.commands;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationCommandData.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandAttachment {
    private final String filename;
    private final String id;

    public ApplicationCommandAttachment(String str, String str2) {
        C12238m.checkNotNullParameter(str, "filename");
        C12238m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_ID);
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
        return C12238m.areEqual(this.filename, applicationCommandAttachment.filename) && C12238m.areEqual(this.id, applicationCommandAttachment.id);
    }

    public int hashCode() {
        String str = this.filename;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.id;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ApplicationCommandAttachment(filename=");
        sbM833U.append(this.filename);
        sbM833U.append(", id=");
        return C1643a.m822J(sbM833U, this.id, ")");
    }
}
