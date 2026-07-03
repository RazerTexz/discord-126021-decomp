package p007b.p225i.p226a.p288f.p313h.p325l;

import android.util.Log;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.o2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3771o2 extends AbstractC3732l2<Double> {
    public C3771o2(C3797q2 c3797q2, String str, Double d) {
        super(c3797q2, str, d, true, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3732l2
    /* JADX INFO: renamed from: a */
    public final Double mo5047a(Object obj) {
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
        String strM5049c = m5049c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C1643a.m861l(strValueOf.length() + C1643a.m841b(strM5049c, 27), "Invalid double value for ", strM5049c, ": ", strValueOf));
        return null;
    }
}
