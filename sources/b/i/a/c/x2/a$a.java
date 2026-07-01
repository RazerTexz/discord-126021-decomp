package b.i.a.c.x2;

/* JADX INFO: compiled from: BinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public class a$a implements t {
    public final a$d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1160b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    public a$a(a$d a_d, long j, long j2, long j3, long j4, long j5, long j6) {
        this.a = a_d;
        this.f1160b = j;
        this.c = j2;
        this.d = j3;
        this.e = j4;
        this.f = j5;
        this.g = j6;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        return new t$a(new u(j, a$c.a(this.a.a(j), this.c, this.d, this.e, this.f, this.g)));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.f1160b;
    }
}
