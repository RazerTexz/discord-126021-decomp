package b.c.a.a0;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import b.c.a.a0.i0.c$a;
import b.c.a.a0.i0.c$b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: JsonUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public static final c$a a = c$a.a("x", "y");

    @ColorInt
    public static int a(b.c.a.a0.i0.c cVar) throws IOException {
        cVar.a();
        int iN = (int) (cVar.n() * 255.0d);
        int iN2 = (int) (cVar.n() * 255.0d);
        int iN3 = (int) (cVar.n() * 255.0d);
        while (cVar.e()) {
            cVar.C();
        }
        cVar.c();
        return Color.argb(255, iN, iN2, iN3);
    }

    public static PointF b(b.c.a.a0.i0.c cVar, float f) throws IOException {
        int iOrdinal = cVar.u().ordinal();
        if (iOrdinal == 0) {
            cVar.a();
            float fN = (float) cVar.n();
            float fN2 = (float) cVar.n();
            while (cVar.u() != c$b.END_ARRAY) {
                cVar.C();
            }
            cVar.c();
            return new PointF(fN * f, fN2 * f);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                StringBuilder sbU = b.d.b.a.a.U("Unknown point starts with ");
                sbU.append(cVar.u());
                throw new IllegalArgumentException(sbU.toString());
            }
            float fN3 = (float) cVar.n();
            float fN4 = (float) cVar.n();
            while (cVar.e()) {
                cVar.C();
            }
            return new PointF(fN3 * f, fN4 * f);
        }
        cVar.b();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (cVar.e()) {
            int iY = cVar.y(a);
            if (iY == 0) {
                fD = d(cVar);
            } else if (iY != 1) {
                cVar.A();
                cVar.C();
            } else {
                fD2 = d(cVar);
            }
        }
        cVar.d();
        return new PointF(fD * f, fD2 * f);
    }

    public static List<PointF> c(b.c.a.a0.i0.c cVar, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        cVar.a();
        while (cVar.u() == c$b.BEGIN_ARRAY) {
            cVar.a();
            arrayList.add(b(cVar, f));
            cVar.c();
        }
        cVar.c();
        return arrayList;
    }

    public static float d(b.c.a.a0.i0.c cVar) throws IOException {
        c$b c_bU = cVar.u();
        int iOrdinal = c_bU.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) cVar.n();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + c_bU);
        }
        cVar.a();
        float fN = (float) cVar.n();
        while (cVar.e()) {
            cVar.C();
        }
        cVar.c();
        return fN;
    }
}
