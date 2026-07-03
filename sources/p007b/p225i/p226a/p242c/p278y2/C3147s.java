package p007b.p225i.p226a.p242c.p278y2;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: b.i.a.c.y2.s */
/* JADX INFO: compiled from: IntArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3147s {

    /* JADX INFO: renamed from: a */
    public int f9102a = 0;

    /* JADX INFO: renamed from: b */
    public int f9103b = -1;

    /* JADX INFO: renamed from: c */
    public int f9104c = 0;

    /* JADX INFO: renamed from: d */
    public int[] f9105d;

    /* JADX INFO: renamed from: e */
    public int f9106e;

    public C3147s() {
        int[] iArr = new int[16];
        this.f9105d = iArr;
        this.f9106e = iArr.length - 1;
    }

    /* JADX INFO: renamed from: a */
    public void m3860a(int i) {
        int i2 = this.f9104c;
        int[] iArr = this.f9105d;
        if (i2 == iArr.length) {
            int length = iArr.length << 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i3 = this.f9102a;
            int i4 = length2 - i3;
            System.arraycopy(iArr, i3, iArr2, 0, i4);
            System.arraycopy(this.f9105d, 0, iArr2, i4, i3);
            this.f9102a = 0;
            this.f9103b = this.f9104c - 1;
            this.f9105d = iArr2;
            this.f9106e = length - 1;
        }
        int i5 = (this.f9103b + 1) & this.f9106e;
        this.f9103b = i5;
        this.f9105d[i5] = i;
        this.f9104c++;
    }

    /* JADX INFO: renamed from: b */
    public int m3861b() {
        int i = this.f9104c;
        if (i == 0) {
            throw new NoSuchElementException();
        }
        int[] iArr = this.f9105d;
        int i2 = this.f9102a;
        int i3 = iArr[i2];
        this.f9102a = (i2 + 1) & this.f9106e;
        this.f9104c = i - 1;
        return i3;
    }
}
