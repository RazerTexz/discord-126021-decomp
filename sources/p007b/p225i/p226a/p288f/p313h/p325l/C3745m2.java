package p007b.p225i.p226a.p288f.p313h.p325l;

import android.util.Log;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.m2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3745m2 extends AbstractC3732l2<Long> {
    public C3745m2(C3797q2 c3797q2, String str, Long l) {
        super(c3797q2, str, l, true, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3732l2
    /* JADX INFO: renamed from: a */
    public final Long mo5047a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strM5049c = m5049c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C1643a.m861l(strValueOf.length() + C1643a.m841b(strM5049c, 25), "Invalid long value for ", strM5049c, ": ", strValueOf));
        return null;
    }
}
