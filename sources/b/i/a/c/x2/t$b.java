package b.i.a.c.x2;

/* JADX INFO: compiled from: SeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class t$b implements t {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t$a f1297b;

    public t$b(long j, long j2) {
        this.a = j;
        this.f1297b = new t$a(j2 == 0 ? u.a : new u(0L, j2));
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return false;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        return this.f1297b;
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.a;
    }
}
