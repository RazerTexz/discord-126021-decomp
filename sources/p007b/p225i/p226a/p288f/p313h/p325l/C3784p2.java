package p007b.p225i.p226a.p288f.p313h.p325l;

import android.util.Log;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.l.p2 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3784p2 extends AbstractC3732l2<Boolean> {
    public C3784p2(C3797q2 c3797q2, String str, Boolean bool) {
        super(c3797q2, str, bool, true, null);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3732l2
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Boolean mo5047a(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (C3848u1.f10335c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (C3848u1.f10336d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String strM5049c = m5049c();
        String strValueOf = String.valueOf(obj);
        Log.e("PhenotypeFlag", C1643a.m861l(strValueOf.length() + C1643a.m841b(strM5049c, 28), "Invalid boolean value for ", strM5049c, ": ", strValueOf));
        return null;
    }
}
