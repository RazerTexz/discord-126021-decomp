package b.i.a.f.h.l;

import android.util.Log;
import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class o2 extends l2<Double> {
    public o2(q2 q2Var, String str, Double d) {
        super(q2Var, str, d, true, null);
    }

    @Override // b.i.a.f.h.l.l2
    public final Double a(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strC = c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", outline.l(strValueOf.length() + outline.b(strC, 27), "Invalid double value for ", strC, ": ", strValueOf));
        return null;
    }
}
