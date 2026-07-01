package b.g.a.c.b0;

import b.d.b.a.outline;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.JsonSerializer;
import b.g.a.c.SerializationConfig;
import b.g.a.c.g0.Serializers;
import b.g.a.c.g0.u.DateSerializer2;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Node;

/* JADX INFO: renamed from: b.g.a.c.b0.f, reason: use source file name */
/* JADX INFO: compiled from: OptionalHandlerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class OptionalHandlerFactory implements Serializable {
    public static final Class<?> j = Node.class;
    public static final Java7Handlers k;
    public static final OptionalHandlerFactory l;
    private static final long serialVersionUID = 1;
    private final Map<String, String> _sqlDeserializers;
    private final Map<String, Object> _sqlSerializers;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Java7Handlers java7Handlers = null;
        try {
            java7Handlers = Java7Handlers.a;
        } catch (Throwable unused) {
        }
        k = java7Handlers;
        l = new OptionalHandlerFactory();
    }

    public OptionalHandlerFactory() {
        HashMap map = new HashMap();
        this._sqlDeserializers = map;
        map.put("java.sql.Date", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer");
        map.put("java.sql.Timestamp", "com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer");
        HashMap map2 = new HashMap();
        this._sqlSerializers = map2;
        map2.put("java.sql.Timestamp", DateSerializer2.k);
        map2.put("java.sql.Date", "com.fasterxml.jackson.databind.ser.std.SqlDateSerializer");
        map2.put("java.sql.Time", "com.fasterxml.jackson.databind.ser.std.SqlTimeSerializer");
        map2.put("java.sql.Blob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
        map2.put("javax.sql.rowset.serial.SerialBlob", "com.fasterxml.jackson.databind.ext.SqlBlobSerializer");
    }

    public JsonSerializer<?> a(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JsonSerializer<?> jsonSerializerA;
        Class<?> superclass = javaType._class;
        Class<?> cls = j;
        boolean z2 = true;
        if (cls != null && cls.isAssignableFrom(superclass)) {
            return (JsonSerializer) c("com.fasterxml.jackson.databind.ext.DOMSerializer", javaType);
        }
        Java7Handlers java7Handlers = k;
        if (java7Handlers != null && (jsonSerializerA = java7Handlers.a(superclass)) != null) {
            return jsonSerializerA;
        }
        String name = superclass.getName();
        Object obj = this._sqlSerializers.get(name);
        if (obj != null) {
            return obj instanceof JsonSerializer ? (JsonSerializer) obj : (JsonSerializer) c((String) obj, javaType);
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
        Object objC = c("com.fasterxml.jackson.databind.ext.CoreXMLSerializers", javaType);
        if (objC == null) {
            return null;
        }
        return ((Serializers) objC).b(serializationConfig, javaType, beanDescription);
    }

    public final Object b(Class<?> cls, JavaType javaType) {
        try {
            return ClassUtil.g(cls, false);
        } catch (Throwable th) {
            StringBuilder sbU = outline.U("Failed to create instance of `");
            sbU.append(cls.getName());
            sbU.append("` for handling values of type ");
            sbU.append(ClassUtil.n(javaType));
            sbU.append(", problem: (");
            sbU.append(th.getClass().getName());
            sbU.append(") ");
            sbU.append(th.getMessage());
            throw new IllegalStateException(sbU.toString());
        }
    }

    public final Object c(String str, JavaType javaType) {
        try {
            return b(Class.forName(str), javaType);
        } catch (Throwable th) {
            StringBuilder sbY = outline.Y("Failed to find class `", str, "` for handling values of type ");
            sbY.append(ClassUtil.n(javaType));
            sbY.append(", problem: (");
            sbY.append(th.getClass().getName());
            sbY.append(") ");
            sbY.append(th.getMessage());
            throw new IllegalStateException(sbY.toString());
        }
    }
}
