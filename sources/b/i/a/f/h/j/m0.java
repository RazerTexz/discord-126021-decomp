package b.i.a.f.h.j;

import b.d.b.a.outline;

/* JADX INFO: loaded from: classes3.dex */
public class m0 extends e {
    public static m0 l;

    public m0(g gVar) {
        super(gVar);
    }

    public static String R(Object obj) {
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
        Long l2 = (Long) obj;
        if (Math.abs(l2.longValue()) < 100) {
            return String.valueOf(obj);
        }
        String str = String.valueOf(obj).charAt(0) != '-' ? "" : "-";
        String strValueOf = String.valueOf(Math.abs(l2.longValue()));
        StringBuilder sbU = outline.U(str);
        sbU.append(Math.round(Math.pow(10.0d, strValueOf.length() - 1)));
        sbU.append("...");
        sbU.append(str);
        sbU.append(Math.round(Math.pow(10.0d, strValueOf.length()) - 1.0d));
        return sbU.toString();
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        synchronized (m0.class) {
            l = this;
        }
    }

    public final void O(j0 j0Var, String str) {
        x(str.length() != 0 ? "Discarding hit. ".concat(str) : new String("Discarding hit. "), j0Var.toString());
    }
}
