package b.f.j.l;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import java.util.LinkedList;
import java.util.Objects;

/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class p implements d {
    public final q<Bitmap> a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f597b;
    public int c;
    public final z d;
    public int e;

    public p(int i, int i2, z zVar, b.f.d.g.c cVar) {
        this.f597b = i;
        this.c = i2;
        this.d = zVar;
    }

    @Override // b.f.d.g.e
    public Bitmap get(int i) {
        Bitmap bitmapA;
        Bitmap bitmapC;
        synchronized (this) {
            try {
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
                    bitmapA = Bitmap.createBitmap(1, i, Bitmap$Config.ALPHA_8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bitmapA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.f.d.g.e, b.f.d.h.f
    public void release(Object obj) {
        boolean zAdd;
        Bitmap bitmap = (Bitmap) obj;
        int iB = this.a.b(bitmap);
        if (iB <= this.c) {
            this.d.g(iB);
            e eVar = (e) this.a;
            Objects.requireNonNull(eVar);
            if (eVar.d(bitmap)) {
                synchronized (eVar) {
                    zAdd = eVar.a.add((T) bitmap);
                }
                if (zAdd) {
                    g<T> gVar = eVar.f598b;
                    int iB2 = eVar.b(bitmap);
                    synchronized (gVar) {
                        g$b g_b = (g$b) gVar.a.get(iB2);
                        if (g_b == null) {
                            g$b g_b2 = new g$b(null, iB2, new LinkedList(), null, null);
                            gVar.a.put(iB2, (g$b<T>) g_b2);
                            g_b = g_b2;
                        }
                        g_b.c.addLast((I) bitmap);
                        gVar.a((g$b<T>) g_b);
                    }
                }
            }
            synchronized (this) {
                this.e += iB;
            }
        }
    }
}
