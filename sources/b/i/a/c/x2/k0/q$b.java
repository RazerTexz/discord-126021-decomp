package b.i.a.c.x2.k0;

/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$b {
    public final b.i.a.c.x2.w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1271b;
    public boolean c;
    public boolean d;
    public int e;
    public int f;
    public long g;
    public long h;

    public q$b(b.i.a.c.x2.w wVar) {
        this.a = wVar;
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.c) {
            int i3 = this.f;
            int i4 = (i + 1) - i3;
            if (i4 >= i2) {
                this.f = (i2 - i) + i3;
            } else {
                this.d = ((bArr[i4] & 192) >> 6) == 0;
                this.c = false;
            }
        }
    }
}
