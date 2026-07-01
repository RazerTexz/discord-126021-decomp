package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    public final b a(List<?> list, d0.e0.p.d.m0.b.i iVar) {
        List list2 = d0.t.u.toList(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            g<?> gVarCreateConstantValue = createConstantValue(it.next());
            if (gVarCreateConstantValue != null) {
                arrayList.add(gVarCreateConstantValue);
            }
        }
        return new b(arrayList, new h$b(iVar));
    }

    public final b createArrayValue(List<? extends g<?>> list, c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(list, "value");
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        return new b(list, new h$a(c0Var));
    }

    public final g<?> createConstantValue(Object obj) {
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new v(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new s(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new w((String) obj);
        }
        if (obj instanceof byte[]) {
            return a(d0.t.k.toList((byte[]) obj), d0.e0.p.d.m0.b.i.BYTE);
        }
        if (obj instanceof short[]) {
            return a(d0.t.k.toList((short[]) obj), d0.e0.p.d.m0.b.i.SHORT);
        }
        if (obj instanceof int[]) {
            return a(d0.t.k.toList((int[]) obj), d0.e0.p.d.m0.b.i.INT);
        }
        if (obj instanceof long[]) {
            return a(d0.t.k.toList((long[]) obj), d0.e0.p.d.m0.b.i.LONG);
        }
        if (obj instanceof char[]) {
            return a(d0.t.k.toList((char[]) obj), d0.e0.p.d.m0.b.i.CHAR);
        }
        if (obj instanceof float[]) {
            return a(d0.t.k.toList((float[]) obj), d0.e0.p.d.m0.b.i.FLOAT);
        }
        if (obj instanceof double[]) {
            return a(d0.t.k.toList((double[]) obj), d0.e0.p.d.m0.b.i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return a(d0.t.k.toList((boolean[]) obj), d0.e0.p.d.m0.b.i.BOOLEAN);
        }
        if (obj == null) {
            return new t();
        }
        return null;
    }
}
