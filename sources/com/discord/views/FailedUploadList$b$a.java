package com.discord.views;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: FailedUploadList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FailedUploadList$b$a extends FailedUploadList$b {
    public final List<FailedUploadList$a> a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FailedUploadList$b$a(List<FailedUploadList$a> list) {
        super(null);
        m.checkNotNullParameter(list, "uploads");
        this.a = list;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof FailedUploadList$b$a) && m.areEqual(this.a, ((FailedUploadList$b$a) obj).a);
        }
        return true;
    }

    public int hashCode() {
        List<FailedUploadList$a> list = this.a;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("FewFailedUploads(uploads="), this.a, ")");
    }
}
