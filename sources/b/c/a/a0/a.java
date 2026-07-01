package b.c.a.a0;

import android.graphics.PointF;
import b.c.a.a0.i0.c$a;
import b.c.a.a0.i0.c$b;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatablePathValueParser.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static c$a a = c$a.a("k", "x", "y");

    public static b.c.a.y.k.e a(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (cVar.u() == c$b.BEGIN_ARRAY) {
            cVar.a();
            while (cVar.e()) {
                arrayList.add(new b.c.a.w.c.h(dVar, q.a(cVar, dVar, b.c.a.b0.g.c(), v.a, cVar.u() == c$b.BEGIN_OBJECT)));
            }
            cVar.c();
            r.b(arrayList);
        } else {
            arrayList.add(new b.c.a.c0.a(p.b(cVar, b.c.a.b0.g.c())));
        }
        return new b.c.a.y.k.e(arrayList);
    }

    public static b.c.a.y.k.m<PointF, PointF> b(b.c.a.a0.i0.c cVar, b.c.a.d dVar) throws IOException {
        c$b c_b = c$b.STRING;
        cVar.b();
        b.c.a.y.k.e eVarA = null;
        b.c.a.y.k.b bVarQ1 = null;
        b.c.a.y.k.b bVarQ2 = null;
        boolean z2 = false;
        while (cVar.u() != c$b.END_OBJECT) {
            int iY = cVar.y(a);
            if (iY == 0) {
                eVarA = a(cVar, dVar);
            } else if (iY != 1) {
                if (iY != 2) {
                    cVar.A();
                    cVar.C();
                } else if (cVar.u() == c_b) {
                    cVar.C();
                    z2 = true;
                } else {
                    bVarQ2 = d.q1(cVar, dVar);
                }
            } else if (cVar.u() == c_b) {
                cVar.C();
                z2 = true;
            } else {
                bVarQ1 = d.q1(cVar, dVar);
            }
        }
        cVar.d();
        if (z2) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVarA != null ? eVarA : new b.c.a.y.k.i(bVarQ1, bVarQ2);
    }
}
