package b.i.a.c.y2;

/* JADX INFO: renamed from: b.i.a.c.y2.q, reason: use source file name */
/* JADX INFO: compiled from: C2Mp3TimestampTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2Mp3TimestampTracker {
    public long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f1312b;
    public boolean c;

    public final long a(long j) {
        return Math.max(0L, ((this.f1312b - 529) * 1000000) / j) + this.a;
    }
}
