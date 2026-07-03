package p007b.p225i.p226a.p288f.p313h.p323j;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.a.f.h.j.m0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3529m0 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public static C3529m0 f9761l;

    public C3529m0(C3515g c3515g) {
        super(c3515g);
    }

    /* JADX INFO: renamed from: R */
    public static String m4464R(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (!(obj instanceof Long)) {
            if (obj instanceof Boolean) {
                return String.valueOf(obj);
            }
            return obj instanceof Throwable ? obj.getClass().getCanonicalName() : "-";
        }
        Long l = (Long) obj;
        if (Math.abs(l.longValue()) < 100) {
            return String.valueOf(obj);
        }
        String str = String.valueOf(obj).charAt(0) != '-' ? "" : "-";
        String strValueOf = String.valueOf(Math.abs(l.longValue()));
        StringBuilder sbM833U = C1643a.m833U(str);
        sbM833U.append(Math.round(Math.pow(10.0d, strValueOf.length() - 1)));
        sbM833U.append("...");
        sbM833U.append(str);
        sbM833U.append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d));
        return sbM833U.toString();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        synchronized (C3529m0.class) {
            f9761l = this;
        }
    }

    /* JADX INFO: renamed from: O */
    public final void m4465O(C3523j0 c3523j0, String str) {
        m4439x(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), c3523j0.toString());
    }
}
