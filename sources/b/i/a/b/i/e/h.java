package b.i.a.b.i.e;

/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends n {
    public final long a;

    public h(long j) {
        this.a = j;
    }

    @Override // b.i.a.b.i.e.n
    public long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.a == ((n) obj).b();
    }

    public int hashCode() {
        long j = this.a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return b.d.b.a.a.C(b.d.b.a.a.U("LogResponse{nextRequestWaitMillis="), this.a, "}");
    }
}
