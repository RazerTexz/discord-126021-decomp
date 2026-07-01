package b.i.a.f.h.l;

import android.util.Log;
import b.d.b.a.outline;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p2 extends l2<Boolean> {
    public p2(q2 q2Var, String str, Boolean bool) {
        super(q2Var, str, bool, true, null);
    }

    @Override // b.i.a.f.h.l.l2
    public final /* synthetic */ Boolean a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (u1.c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (u1.d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String strC = c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", outline.l(strValueOf.length() + outline.b(strC, 28), "Invalid boolean value for ", strC, ": ", strValueOf));
        return null;
    }
}
