package com.discord.utilities.debug;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: HistoricalProcessExitReason.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class HistoricalProcessExitReason$Reason {
    private final String description;
    private final String reason;

    public HistoricalProcessExitReason$Reason(String str, String str2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.reason = str;
        this.description = str2;
    }

    public static /* synthetic */ HistoricalProcessExitReason$Reason copy$default(HistoricalProcessExitReason$Reason historicalProcessExitReason$Reason, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = historicalProcessExitReason$Reason.reason;
        }
        if ((i & 2) != 0) {
            str2 = historicalProcessExitReason$Reason.description;
        }
        return historicalProcessExitReason$Reason.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final HistoricalProcessExitReason$Reason copy(String reason, String description) {
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new HistoricalProcessExitReason$Reason(reason, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoricalProcessExitReason$Reason)) {
            return false;
        }
        HistoricalProcessExitReason$Reason historicalProcessExitReason$Reason = (HistoricalProcessExitReason$Reason) other;
        return m.areEqual(this.reason, historicalProcessExitReason$Reason.reason) && m.areEqual(this.description, historicalProcessExitReason$Reason.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getReason() {
        return this.reason;
    }

    public int hashCode() {
        String str = this.reason;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Reason(reason=");
        sbU.append(this.reason);
        sbU.append(", description=");
        return a.J(sbU, this.description, ")");
    }
}
