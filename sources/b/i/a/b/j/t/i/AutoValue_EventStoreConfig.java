package b.i.a.b.j.t.i;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.a, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_EventStoreConfig extends EventStoreConfig {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f795b;
    public final int c;
    public final int d;
    public final long e;
    public final int f;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3, a aVar) {
        this.f795b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    @Override // b.i.a.b.j.t.i.EventStoreConfig
    public int a() {
        return this.d;
    }

    @Override // b.i.a.b.j.t.i.EventStoreConfig
    public long b() {
        return this.e;
    }

    @Override // b.i.a.b.j.t.i.EventStoreConfig
    public int c() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.i.EventStoreConfig
    public int d() {
        return this.f;
    }

    @Override // b.i.a.b.j.t.i.EventStoreConfig
    public long e() {
        return this.f795b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventStoreConfig)) {
            return false;
        }
        EventStoreConfig eventStoreConfig = (EventStoreConfig) obj;
        return this.f795b == eventStoreConfig.e() && this.c == eventStoreConfig.c() && this.d == eventStoreConfig.a() && this.e == eventStoreConfig.b() && this.f == eventStoreConfig.d();
    }

    public int hashCode() {
        long j = this.f795b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return this.f ^ ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = outline.U("EventStoreConfig{maxStorageSizeInBytes=");
        sbU.append(this.f795b);
        sbU.append(", loadBatchSize=");
        sbU.append(this.c);
        sbU.append(", criticalSectionEnterTimeoutMs=");
        sbU.append(this.d);
        sbU.append(", eventCleanUpAge=");
        sbU.append(this.e);
        sbU.append(", maxBlobByteSizePerRow=");
        return outline.B(sbU, this.f, "}");
    }
}
