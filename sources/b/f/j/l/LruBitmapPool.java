package b.f.j.l;

import android.graphics.Bitmap;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.j.l.BucketMap;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.p, reason: use source file name */
/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class LruBitmapPool implements BitmapPool {
    public final LruBucketsPoolBackend<Bitmap> a = new BitmapPoolBackend();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f597b;
    public int c;
    public final PoolStatsTracker d;
    public int e;

    public LruBitmapPool(int i, int i2, PoolStatsTracker poolStatsTracker, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        this.f597b = i;
        this.c = i2;
        this.d = poolStatsTracker;
    }

    @Override // b.f.d.g.Pool2
    public Bitmap get(int i) {
        Bitmap bitmapA;
        Bitmap bitmapC;
        synchronized (this) {
            int i2 = this.e;
            int i3 = this.f597b;
            if (i2 > i3) {
                synchronized (this) {
                    while (this.e > i3 && (bitmapC = this.a.c()) != null) {
                        int iB = this.a.b(bitmapC);
                        this.e -= iB;
                        this.d.e(iB);
                    }
                }
            }
            bitmapA = this.a.a(i);
            if (bitmapA != null) {
                int iB2 = this.a.b(bitmapA);
                this.e -= iB2;
                this.d.b(iB2);
            } else {
                this.d.a(i);
                bitmapA = Bitmap.createBitmap(1, i, Bitmap.Config.ALPHA_8);
            }
        }
        return bitmapA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.f.d.g.Pool2, b.f.d.h.ResourceReleaser
    public void release(Object obj) {
        boolean zAdd;
        Bitmap bitmap = (Bitmap) obj;
        int iB = this.a.b(bitmap);
        if (iB <= this.c) {
            this.d.g(iB);
            BitmapPoolBackend bitmapPoolBackend = (BitmapPoolBackend) this.a;
            Objects.requireNonNull(bitmapPoolBackend);
            if (bitmapPoolBackend.d(bitmap)) {
                synchronized (bitmapPoolBackend) {
                    zAdd = bitmapPoolBackend.a.add((T) bitmap);
                }
                if (zAdd) {
                    BucketMap<T> bucketMap = bitmapPoolBackend.f598b;
                    int iB2 = bitmapPoolBackend.b(bitmap);
                    synchronized (bucketMap) {
                        BucketMap.b bVar = (BucketMap.b) bucketMap.a.get(iB2);
                        if (bVar == null) {
                            BucketMap.b bVar2 = new BucketMap.b(null, iB2, new LinkedList(), null, null);
                            bucketMap.a.put(iB2, (BucketMap.b<T>) bVar2);
                            bVar = bVar2;
                        }
                        bVar.c.addLast((I) bitmap);
                        bucketMap.a((BucketMap.b<T>) bVar);
                    }
                }
            }
            synchronized (this) {
                this.e += iB;
            }
        }
    }
}
