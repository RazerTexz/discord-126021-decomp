package b.c.a.a0;

import android.graphics.Color;
import b.c.a.a0.i0.c$b;
import java.io.IOException;

/* JADX INFO: compiled from: ColorParser.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements h0<Integer> {
    public static final f a = new f();

    @Override // b.c.a.a0.h0
    public Integer a(b.c.a.a0.i0.c cVar, float f) throws IOException {
        boolean z2 = cVar.u() == c$b.BEGIN_ARRAY;
        if (z2) {
            cVar.a();
        }
        double dN = cVar.n();
        double dN2 = cVar.n();
        double dN3 = cVar.n();
        double dN4 = cVar.n();
        if (z2) {
            cVar.c();
        }
        if (dN <= 1.0d && dN2 <= 1.0d && dN3 <= 1.0d) {
            dN *= 255.0d;
            dN2 *= 255.0d;
            dN3 *= 255.0d;
            if (dN4 <= 1.0d) {
                dN4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dN4, (int) dN, (int) dN2, (int) dN3));
    }
}
