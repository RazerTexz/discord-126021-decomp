package b.i.a.b.i.e;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.i.a.b.i.e.h, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_LogResponse extends LogResponse {
    public final long a;

    public AutoValue_LogResponse(long j) {
        this.a = j;
    }

    @Override // b.i.a.b.i.e.LogResponse
    public long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.a == ((LogResponse) obj).b();
    }

    public int hashCode() {
        long j = this.a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return outline.C(outline.U("LogResponse{nextRequestWaitMillis="), this.a, "}");
    }
}
