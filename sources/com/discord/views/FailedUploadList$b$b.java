package com.discord.views;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: FailedUploadList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadList$b$b extends FailedUploadList$b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2829b;

    public FailedUploadList$b$b(int i, long j) {
        super(null);
        this.a = i;
        this.f2829b = j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FailedUploadList$b$b)) {
            return false;
        }
        FailedUploadList$b$b failedUploadList$b$b = (FailedUploadList$b$b) obj;
        return this.a == failedUploadList$b$b.a && this.f2829b == failedUploadList$b$b.f2829b;
    }

    public int hashCode() {
        return b.a(this.f2829b) + (this.a * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ManyFailedUploads(uploadCount=");
        sbU.append(this.a);
        sbU.append(", sizeBytes=");
        return a.C(sbU, this.f2829b, ")");
    }
}
