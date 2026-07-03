package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p123h.InterfaceC1709f;
import p007b.p109f.p186k.C2038a;

/* JADX INFO: renamed from: b.f.j.l.b */
/* JADX INFO: compiled from: BitmapCounter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1930b {

    /* JADX INFO: renamed from: a */
    public int f3917a;

    /* JADX INFO: renamed from: b */
    public long f3918b;

    /* JADX INFO: renamed from: c */
    public final int f3919c;

    /* JADX INFO: renamed from: d */
    public final int f3920d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC1709f<Bitmap> f3921e;

    /* JADX INFO: renamed from: b.f.j.l.b$a */
    /* JADX INFO: compiled from: BitmapCounter.java */
    public class a implements InterfaceC1709f<Bitmap> {
        public a() {
        }

        @Override // p007b.p109f.p115d.p123h.InterfaceC1709f
        public void release(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                C1930b.this.m1371a(bitmap2);
            } finally {
                bitmap2.recycle();
            }
        }
    }

    public C1930b(int i, int i2) {
        C1460d.m527i(Boolean.valueOf(i > 0));
        C1460d.m527i(Boolean.valueOf(i2 > 0));
        this.f3919c = i;
        this.f3920d = i2;
        this.f3921e = new a();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m1371a(Bitmap bitmap) {
        int iM1541d = C2038a.m1541d(bitmap);
        C1460d.m535k(this.f3917a > 0, "No bitmaps registered.");
        long j = iM1541d;
        boolean z2 = j <= this.f3918b;
        Object[] objArr = {Integer.valueOf(iM1541d), Long.valueOf(this.f3918b)};
        if (!z2) {
            throw new IllegalArgumentException(C1460d.m536k0("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
        this.f3918b -= j;
        this.f3917a--;
    }

    /* JADX INFO: renamed from: b */
    public synchronized int m1372b() {
        return this.f3920d;
    }
}
