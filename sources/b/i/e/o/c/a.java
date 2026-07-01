package b.i.e.o.c;

import b.i.a.f.e.o.f;
import b.i.e.k;
import b.i.e.n.b;
import b.i.e.n.i;
import com.google.zxing.NotFoundException;
import java.util.Map;

/* JADX INFO: compiled from: Detector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.e.n.k.a f1850b;

    public a(b bVar) throws NotFoundException {
        this.a = bVar;
        this.f1850b = new b.i.e.n.k.a(bVar, 10, bVar.j / 2, bVar.k / 2);
    }

    public static int a(k kVar, k kVar2) {
        return f.Z0(f.Q(kVar.a, kVar.f1826b, kVar2.a, kVar2.f1826b));
    }

    public static void b(Map<k, Integer> map, k kVar) {
        Integer num = map.get(kVar);
        map.put(kVar, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public static b d(b bVar, k kVar, k kVar2, k kVar3, k kVar4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return b.i.e.n.f.a.a(bVar, i, i2, i.a(0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, kVar.a, kVar.f1826b, kVar4.a, kVar4.f1826b, kVar3.a, kVar3.f1826b, kVar2.a, kVar2.f1826b));
    }

    public final boolean c(k kVar) {
        float f = kVar.a;
        if (f < 0.0f) {
            return false;
        }
        b bVar = this.a;
        if (f >= bVar.j) {
            return false;
        }
        float f2 = kVar.f1826b;
        return f2 > 0.0f && f2 < ((float) bVar.k);
    }

    public final a$b e(k kVar, k kVar2) {
        a aVar = this;
        int i = (int) kVar.a;
        int i2 = (int) kVar.f1826b;
        int i3 = (int) kVar2.a;
        int i4 = (int) kVar2.f1826b;
        boolean z2 = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z2) {
            i2 = i;
            i = i2;
            i4 = i3;
            i3 = i4;
        }
        int iAbs = Math.abs(i3 - i);
        int iAbs2 = Math.abs(i4 - i2);
        int i5 = (-iAbs) / 2;
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i >= i3 ? -1 : 1;
        boolean zF = aVar.a.f(z2 ? i2 : i, z2 ? i : i2);
        int i8 = 0;
        while (i != i3) {
            boolean zF2 = aVar.a.f(z2 ? i2 : i, z2 ? i : i2);
            if (zF2 != zF) {
                i8++;
                zF = zF2;
            }
            i5 += iAbs2;
            if (i5 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i6;
                i5 -= iAbs;
            }
            i += i7;
            aVar = this;
        }
        return new a$b(kVar, kVar2, i8, null);
    }
}
