package b.g.a.c.b0;

import b.g.a.c.g0.r;
import b.g.a.c.g0.u.k;
import b.g.a.c.j;
import b.g.a.c.n;
import b.g.a.c.v;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: OptionalHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Serializable {
    public static final Class<?> j = Node.class;
    public static final a k;
    public static final f l;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        a aVar = null;
        try {
            aVar = a.a;
        } catch (Throwable unused) {
        }
        k = aVar;
        l = new f();
    }

    public f() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put("java.sql.Timestamp", k.k);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public n<?> a(v vVar, j jVar, b.g.a.c.c cVar) {
        n<?> nVarA;
        Class<?> superclass = jVar._class;
        Class<?> cls = j;
        boolean z2 = true;
        if (cls != null && cls.isAssignableFrom(superclass)) {
            return (n) c("com.fasterxml.jackson.databind.ext.DOMSerializer", jVar);
        }
        a aVar = k;
        if (aVar != null && (nVarA = aVar.a(superclass)) != null) {
            return nVarA;
        }
        String name = superclass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            return obj instanceof n ? (n) obj : (n) c((String) obj, jVar);
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
        Object objC = c("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", jVar);
        if (objC == null) {
            return null;
        }
        return ((r) objC).b(vVar, jVar, cVar);
    }

    public final Object b(Class<?> cls, j jVar) {
        try {
            return b.g.a.c.i0.d.g(cls, false);
        } catch (Throwable th) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to create instance of `");
            sbU.append(cls.getName());
            sbU.append("` for handling values of type ");
            sbU.append(b.g.a.c.i0.d.n(jVar));
            sbU.append(", problem: (");
            sbU.append(th.getClass().getName());
            sbU.append(") ");
            sbU.append(th.getMessage());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public final Object c(String str, j jVar) {
        try {
            return b(Class.forName(str), jVar);
        } catch (Throwable th) {
            StringBuilder sbY = b.d.b.a.a.Y("Failed to find class `", str, "` for handling values of type ");
            sbY.append(b.g.a.c.i0.d.n(jVar));
            sbY.append(", problem: (");
            sbY.append(th.getClass().getName());
            sbY.append(") ");
            sbY.append(th.getMessage());
            throw new IllegalStateException(sbY.toString());
        }
    }
}
