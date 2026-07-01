package b.c.a.a0;

import b.c.a.a0.i0.c$b;
import java.io.IOException;

/* JADX INFO: compiled from: ScaleXYParser.java */
/* JADX INFO: loaded from: classes.dex */
public class a0 implements h0<b.c.a.c0.d> {
    public static final a0 a = new a0();

    @Override // b.c.a.a0.h0
    public b.c.a.c0.d a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        boolean z2 = cVar.u() == c$b.BEGIN_ARRAY;
        if (z2) {
            cVar.a();
        }
        float fN = (float) cVar.n();
        float fN2 = (float) cVar.n();
        while (cVar.e()) {
            cVar.C();
        }
        if (z2) {
            cVar.c();
        }
        return new b.c.a.c0.d((fN / 100.0f) * f, (fN2 / 100.0f) * f);
    }
}
