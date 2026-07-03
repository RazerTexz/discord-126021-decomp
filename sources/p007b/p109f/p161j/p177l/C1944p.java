package p007b.p109f.p161j.p177l;

import android.graphics.Bitmap;
import java.util.LinkedList;
import java.util.Objects;
import p007b.p109f.p115d.p122g.InterfaceC1696c;
import p007b.p109f.p161j.p177l.C1935g;

/* JADX INFO: renamed from: b.f.j.l.p */
/* JADX INFO: compiled from: LruBitmapPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1944p implements InterfaceC1932d {

    /* JADX INFO: renamed from: a */
    public final AbstractC1945q<Bitmap> f3945a = new C1933e();

    /* JADX INFO: renamed from: b */
    public final int f3946b;

    /* JADX INFO: renamed from: c */
    public int f3947c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC1954z f3948d;

    /* JADX INFO: renamed from: e */
    public int f3949e;

    public C1944p(int i, int i2, InterfaceC1954z interfaceC1954z, InterfaceC1696c interfaceC1696c) {
        this.f3946b = i;
        this.f3947c = i2;
        this.f3948d = interfaceC1954z;
    }

    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e
    public Bitmap get(int i) {
        Bitmap bitmapMo1373a;
        Bitmap bitmapM1392c;
        synchronized (this) {
            try {
                int i2 = this.f3949e;
                int i3 = this.f3946b;
                if (i2 > i3) {
                    synchronized (this) {
                        while (this.f3949e > i3 && (bitmapM1392c = this.f3945a.m1392c()) != null) {
                            int iMo1374b = this.f3945a.mo1374b(bitmapM1392c);
                            this.f3949e -= iMo1374b;
                            this.f3948d.mo1403e(iMo1374b);
                        }
                    }
                }
                bitmapMo1373a = this.f3945a.mo1373a(i);
                if (bitmapMo1373a != null) {
                    int iMo1374b2 = this.f3945a.mo1374b(bitmapMo1373a);
                    this.f3949e -= iMo1374b2;
                    this.f3948d.mo1400b(iMo1374b2);
                } else {
                    this.f3948d.mo1399a(i);
                    bitmapMo1373a = Bitmap.createBitmap(1, i, Bitmap.Config.ALPHA_8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bitmapMo1373a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p007b.p109f.p115d.p122g.InterfaceC1698e, p007b.p109f.p115d.p123h.InterfaceC1709f
    public void release(Object obj) {
        boolean zAdd;
        Bitmap bitmap = (Bitmap) obj;
        int iMo1374b = this.f3945a.mo1374b(bitmap);
        if (iMo1374b <= this.f3947c) {
            this.f3948d.mo1405g(iMo1374b);
            C1933e c1933e = (C1933e) this.f3945a;
            Objects.requireNonNull(c1933e);
            if (c1933e.m1375d(bitmap)) {
                synchronized (c1933e) {
                    zAdd = c1933e.f3950a.add((T) bitmap);
                }
                if (zAdd) {
                    C1935g<T> c1935g = c1933e.f3951b;
                    int iMo1374b2 = c1933e.mo1374b(bitmap);
                    synchronized (c1935g) {
                        C1935g.b bVar = (C1935g.b) c1935g.f3931a.get(iMo1374b2);
                        if (bVar == null) {
                            C1935g.b bVar2 = new C1935g.b(null, iMo1374b2, new LinkedList(), null, null);
                            c1935g.f3931a.put(iMo1374b2, (C1935g.b<T>) bVar2);
                            bVar = bVar2;
                        }
                        bVar.f3936c.addLast((I) bitmap);
                        c1935g.m1380a((C1935g.b<T>) bVar);
                    }
                }
            }
            synchronized (this) {
                this.f3949e += iMo1374b;
            }
        }
    }
}
