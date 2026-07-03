package p007b.p195g.p196a.p205c.p209b0;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.C2372v;
import p007b.p195g.p196a.p205c.p215g0.InterfaceC2249r;
import p007b.p195g.p196a.p205c.p215g0.p217u.C2292k;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.b0.f */
/* JADX INFO: compiled from: OptionalHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2171f implements Serializable {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f4623j = Node.class;

    /* JADX INFO: renamed from: k */
    public static final AbstractC2166a f4624k;

    /* JADX INFO: renamed from: l */
    public static final C2171f f4625l;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        AbstractC2166a abstractC2166a = null;
        try {
            abstractC2166a = AbstractC2166a.f4620a;
        } catch (Throwable unused) {
        }
        f4624k = abstractC2166a;
        f4625l = new C2171f();
    }

    public C2171f() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put("java.sql.Timestamp", C2292k.f4856k);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2364n<?> m1809a(C2372v c2372v, AbstractC2360j abstractC2360j, AbstractC2172c abstractC2172c) {
        AbstractC2364n<?> abstractC2364nMo1803a;
        Class<?> superclass = abstractC2360j._class;
        Class<?> cls = f4623j;
        boolean z2 = true;
        if (cls != null && cls.isAssignableFrom(superclass)) {
            return (AbstractC2364n) m1811c("com.fasterxml.jackson.databind.ext.DOMSerializer", abstractC2360j);
        }
        AbstractC2166a abstractC2166a = f4624k;
        if (abstractC2166a != null && (abstractC2364nMo1803a = abstractC2166a.mo1803a(superclass)) != null) {
            return abstractC2364nMo1803a;
        }
        String name = superclass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            return obj instanceof AbstractC2364n ? (AbstractC2364n) obj : (AbstractC2364n) m1811c((String) obj, abstractC2360j);
        }
        if (!name.startsWith("javax.xml.")) {
            do {
                superclass = superclass.getSuperclass();
                if (superclass == null || superclass == Object.class) {
                    z2 = false;
                    break;
                }
            } while (!superclass.getName().startsWith("javax.xml."));
            if (!z2) {
                return null;
            }
        }
        Object objM1811c = m1811c("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", abstractC2360j);
        if (objM1811c == null) {
            return null;
        }
        return ((InterfaceC2249r) objM1811c).m2011b(c2372v, abstractC2360j, abstractC2172c);
    }

    /* JADX INFO: renamed from: b */
    public final Object m1810b(Class<?> cls, AbstractC2360j abstractC2360j) {
        try {
            return C2342d.m2175g(cls, false);
        } catch (Throwable th) {
            StringBuilder sbM833U = C1643a.m833U("Failed to create instance of `");
            sbM833U.append(cls.getName());
            sbM833U.append("` for handling values of type ");
            sbM833U.append(C2342d.m2182n(abstractC2360j));
            sbM833U.append(", problem: (");
            sbM833U.append(th.getClass().getName());
            sbM833U.append(") ");
            sbM833U.append(th.getMessage());
            throw new IllegalStateException(sbM833U.toString());
        }
    }

    /* JADX INFO: renamed from: c */
    public final Object m1811c(String str, AbstractC2360j abstractC2360j) {
        try {
            return m1810b(Class.forName(str), abstractC2360j);
        } catch (Throwable th) {
            StringBuilder sbM837Y = C1643a.m837Y("Failed to find class `", str, "` for handling values of type ");
            sbM837Y.append(C2342d.m2182n(abstractC2360j));
            sbM837Y.append(", problem: (");
            sbM837Y.append(th.getClass().getName());
            sbM837Y.append(") ");
            sbM837Y.append(th.getMessage());
            throw new IllegalStateException(sbM837Y.toString());
        }
    }
}
