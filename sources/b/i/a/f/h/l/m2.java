package b.i.a.f.h.l;

import android.util.Log;
import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class m2 extends l2<Long> {
    public m2(q2 q2Var, String str, Long l) {
        super(q2Var, str, l, true, null);
    }

    @Override // b.i.a.f.h.l.l2
    public final Long a(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String strC = c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", outline.l(strValueOf.length() + outline.b(strC, 25), "Invalid long value for ", strC, ": ", strValueOf));
        return null;
    }
}
