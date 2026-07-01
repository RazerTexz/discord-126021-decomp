package b.f.j.l;

import android.graphics.Bitmap;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.h.ResourceReleaser;
import b.f.k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.l.b, reason: use source file name */
/* JADX INFO: compiled from: BitmapCounter.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapCounter {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f592b;
    public final int c;
    public final int d;
    public final ResourceReleaser<Bitmap> e;

    /* JADX INFO: renamed from: b.f.j.l.b$a */
    /* JADX INFO: compiled from: BitmapCounter.java */
    public class a implements ResourceReleaser<Bitmap> {
        public a() {
        }

        @Override // b.f.d.h.ResourceReleaser
        public void release(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            try {
                BitmapCounter.this.a(bitmap2);
            } finally {
                bitmap2.recycle();
            }
        }
    }

    public BitmapCounter(int i, int i2) {
        AnimatableValueParser.i(Boolean.valueOf(i > 0));
        AnimatableValueParser.i(Boolean.valueOf(i2 > 0));
        this.c = i;
        this.d = i2;
        this.e = new a();
    }

    public synchronized void a(Bitmap bitmap) {
        int iD = BitmapUtil.d(bitmap);
        AnimatableValueParser.k(this.a > 0, "No bitmaps registered.");
        long j = iD;
        boolean z2 = j <= this.f592b;
        Object[] objArr = {Integer.valueOf(iD), Long.valueOf(this.f592b)};
        if (!z2) {
            throw new IllegalArgumentException(AnimatableValueParser.k0("Bitmap size bigger than the total registered size: %d, %d", objArr));
        }
        this.f592b -= j;
        this.a--;
    }

    public synchronized int b() {
        return this.d;
    }
}
