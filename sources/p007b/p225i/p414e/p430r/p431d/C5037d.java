package p007b.p225i.p414e.p430r.p431d;

/* JADX INFO: renamed from: b.i.e.r.d.d */
/* JADX INFO: compiled from: Codeword.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5037d {

    /* JADX INFO: renamed from: a */
    public final int f13479a;

    /* JADX INFO: renamed from: b */
    public final int f13480b;

    /* JADX INFO: renamed from: c */
    public final int f13481c;

    /* JADX INFO: renamed from: d */
    public final int f13482d;

    /* JADX INFO: renamed from: e */
    public int f13483e = -1;

    public C5037d(int i, int i2, int i3, int i4) {
        this.f13479a = i;
        this.f13480b = i2;
        this.f13481c = i3;
        this.f13482d = i4;
    }

    /* JADX INFO: renamed from: a */
    public boolean m7050a() {
        int i = this.f13483e;
        return i != -1 && this.f13481c == (i % 3) * 3;
    }

    /* JADX INFO: renamed from: b */
    public void m7051b() {
        this.f13483e = (this.f13481c / 3) + ((this.f13482d / 30) * 3);
    }

    public String toString() {
        return this.f13483e + "|" + this.f13482d;
    }
}
