package f0.e0.j;

/* JADX INFO: compiled from: Huffman.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a {
    public final p$a[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3646b;
    public final int c;

    public p$a() {
        this.a = new p$a[256];
        this.f3646b = 0;
        this.c = 0;
    }

    public p$a(int i, int i2) {
        this.a = null;
        this.f3646b = i;
        int i3 = i2 & 7;
        this.c = i3 == 0 ? 8 : i3;
    }
}
