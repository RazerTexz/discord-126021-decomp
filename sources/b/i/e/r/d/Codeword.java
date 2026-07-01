package b.i.e.r.d;

/* JADX INFO: renamed from: b.i.e.r.d.d, reason: use source file name */
/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Codeword {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1878b;
    public final int c;
    public final int d;
    public int e = -1;

    public Codeword(int i, int i2, int i3, int i4) {
        this.a = i;
        this.f1878b = i2;
        this.c = i3;
        this.d = i4;
    }

    public boolean a() {
        int i = this.e;
        return i != -1 && this.c == (i % 3) * 3;
    }

    public void b() {
        this.e = (this.c / 3) + ((this.d / 30) * 3);
    }

    public String toString() {
        return this.e + "|" + this.d;
    }
}
