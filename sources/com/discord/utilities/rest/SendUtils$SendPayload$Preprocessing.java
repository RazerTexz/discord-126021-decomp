package com.discord.utilities.rest;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: SendUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SendUtils$SendPayload$Preprocessing extends SendUtils$SendPayload {
    private final String mimeType;
    private final String name;
    private final int numFiles;

    public SendUtils$SendPayload$Preprocessing(int i, String str, String str2) {
        super(null);
        this.numFiles = i;
        this.name = str;
        this.mimeType = str2;
    }

    public static /* synthetic */ SendUtils$SendPayload$Preprocessing copy$default(SendUtils$SendPayload$Preprocessing sendUtils$SendPayload$Preprocessing, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = sendUtils$SendPayload$Preprocessing.numFiles;
        }
        if ((i2 & 2) != 0) {
            str = sendUtils$SendPayload$Preprocessing.name;
        }
        if ((i2 & 4) != 0) {
            str2 = sendUtils$SendPayload$Preprocessing.mimeType;
        }
        return sendUtils$SendPayload$Preprocessing.copy(i, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getNumFiles() {
        return this.numFiles;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final SendUtils$SendPayload$Preprocessing copy(int numFiles, String name, String mimeType) {
        return new SendUtils$SendPayload$Preprocessing(numFiles, name, mimeType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendUtils$SendPayload$Preprocessing)) {
            return false;
        }
        SendUtils$SendPayload$Preprocessing sendUtils$SendPayload$Preprocessing = (SendUtils$SendPayload$Preprocessing) other;
        return this.numFiles == sendUtils$SendPayload$Preprocessing.numFiles && m.areEqual(this.name, sendUtils$SendPayload$Preprocessing.name) && m.areEqual(this.mimeType, sendUtils$SendPayload$Preprocessing.mimeType);
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumFiles() {
        return this.numFiles;
    }

    public int hashCode() {
        int i = this.numFiles * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mimeType;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Preprocessing(numFiles=");
        sbU.append(this.numFiles);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", mimeType=");
        return a.J(sbU, this.mimeType, ")");
    }
}
