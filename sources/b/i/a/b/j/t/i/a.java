package b.i.a.b.j.t.i;

/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f795b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    public a(long j, int i, int i2, long j2, int i3, a$a a_a) {
        this.f795b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    @Override // b.i.a.b.j.t.i.d
    public int a() {
        return this.d;
    }

    @Override // b.i.a.b.j.t.i.d
    public long b() {
        return this.e;
    }

    @Override // b.i.a.b.j.t.i.d
    public int c() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.i.d
    public int d() {
        return this.f;
    }

    @Override // b.i.a.b.j.t.i.d
    public long e() {
        return this.f795b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f795b == dVar.e() && this.c == dVar.c() && this.d == dVar.a() && this.e == dVar.b() && this.f == dVar.d();
    }

    public int hashCode() {
        long j = this.f795b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return this.f ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("EventStoreConfig{maxStorageSizeInBytes=");
        sbU.append(this.f795b);
        sbU.append(", loadBatchSize=");
        sbU.append(this.c);
        sbU.append(", criticalSectionEnterTimeoutMs=");
        sbU.append(this.d);
        sbU.append(", eventCleanUpAge=");
        sbU.append(this.e);
        sbU.append(", maxBlobByteSizePerRow=");
        return b.d.b.a.a.B(sbU, this.f, "}");
    }
}
