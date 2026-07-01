package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.c$a;
import b.c.a.a0.i0.c$b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ShapeDataParser.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 implements h0<b.c.a.y.l.k> {
    public static final b0 a = new b0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c$a f327b = c$a.a("c", "v", "i", "o");

    @Override // b.c.a.a0.h0
    public b.c.a.y.l.k a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        if (cVar.u() == c$b.BEGIN_ARRAY) {
            cVar.a();
        }
        cVar.b();
        List<PointF> listC = null;
        List<PointF> listC2 = null;
        List<PointF> listC3 = null;
        boolean zF = false;
        while (cVar.e()) {
            int iY = cVar.y(f327b);
            if (iY == 0) {
                zF = cVar.f();
            } else if (iY == 1) {
                listC = p.c(cVar, f);
            } else if (iY == 2) {
                listC2 = p.c(cVar, f);
            } else if (iY != 3) {
                cVar.A();
                cVar.C();
            } else {
                listC3 = p.c(cVar, f);
            }
        }
        cVar.d();
        if (cVar.u() == c$b.END_ARRAY) {
            cVar.c();
        }
        if (listC == null || listC2 == null || listC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listC.isEmpty()) {
            return new b.c.a.y.l.k(new PointF(), false, Collections.emptyList());
        }
        int size = listC.size();
        PointF pointF = listC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listC.get(i);
            int i2 = i - 1;
            arrayList.add(new b.c.a.y.a(b.c.a.b0.f.a(listC.get(i2), listC3.get(i2)), b.c.a.b0.f.a(pointF2, listC2.get(i)), pointF2));
        }
        if (zF) {
            PointF pointF3 = listC.get(0);
            int i3 = size - 1;
            arrayList.add(new b.c.a.y.a(b.c.a.b0.f.a(listC.get(i3), listC3.get(i3)), b.c.a.b0.f.a(pointF3, listC2.get(0)), pointF3));
        }
        return new b.c.a.y.l.k(pointF, zF, arrayList);
    }
}
