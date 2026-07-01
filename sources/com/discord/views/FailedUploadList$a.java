package com.discord.views;

import a0.a.a.b;
import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: FailedUploadList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadList$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2828b;
    public final String c;

    public FailedUploadList$a(String str, long j, String str2) {
        m.checkNotNullParameter(str, "displayName");
        m.checkNotNullParameter(str2, "mimeType");
        this.a = str;
        this.f2828b = j;
        this.c = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FailedUploadList$a)) {
            return false;
        }
        FailedUploadList$a failedUploadList$a = (FailedUploadList$a) obj;
        return m.areEqual(this.a, failedUploadList$a.a) && this.f2828b == failedUploadList$a.f2828b && m.areEqual(this.c, failedUploadList$a.c);
    }

    public int hashCode() {
        String str = this.a;
        int iA = (b.a(this.f2828b) + ((str != null ? str.hashCode() : 0) * 31)) * 31;
        String str2 = this.c;
        return iA + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SingleFailedUpload(displayName=");
        sbU.append(this.a);
        sbU.append(", sizeBytes=");
        sbU.append(this.f2828b);
        sbU.append(", mimeType=");
        return a.J(sbU, this.c, ")");
    }
}
