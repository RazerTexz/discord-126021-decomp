package b.m.a.g.d;

/* JADX INFO: compiled from: SntpClient.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1907b;
    public final long c;
    public final b.m.a.b d;

    public e$b(long j, long j2, long j3, b.m.a.b bVar) {
        this.a = j;
        this.f1907b = j2;
        this.c = j3;
        this.d = bVar;
    }

    public long a() {
        return this.a + this.c + (this.d.b() - this.f1907b);
    }
}
