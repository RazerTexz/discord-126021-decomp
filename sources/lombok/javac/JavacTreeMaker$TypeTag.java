package lombok.javac;

import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacTreeMaker$TypeTag.SCL.lombok */
public class JavacTreeMaker$TypeTag extends JavacTreeMaker$SchroedingerType {
    private static final ConcurrentMap<String, Object> TYPE_TAG_CACHE = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, Field> FIELD_CACHE = new ConcurrentHashMap();
    private static final Method TYPE_TYPETAG_METHOD;

    @Override // lombok.javac.JavacTreeMaker$SchroedingerType
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // lombok.javac.JavacTreeMaker$SchroedingerType
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    static {
        Method m = null;
        try {
            m = Permit.getMethod(Type.class, "getTag", new Class[0]);
        } catch (NoSuchMethodException unused) {
        }
        TYPE_TYPETAG_METHOD = m;
    }

    private JavacTreeMaker$TypeTag(Object value) {
        super(value, null);
    }

    public static JavacTreeMaker$TypeTag typeTag(JCTree o) {
        try {
            return new JavacTreeMaker$TypeTag(getFieldCached(FIELD_CACHE, o, "typetag"));
        } catch (NoSuchFieldException e) {
            throw Javac.sneakyThrow(e);
        }
    }

    public static JavacTreeMaker$TypeTag typeTag(Type t) {
        if (t == null) {
            return Javac.CTC_VOID;
        }
        try {
            return new JavacTreeMaker$TypeTag(getFieldCached(FIELD_CACHE, t, "tag"));
        } catch (NoSuchFieldException unused) {
            if (TYPE_TYPETAG_METHOD == null) {
                throw new IllegalStateException("Type " + t.getClass() + " has neither 'tag' nor getTag()");
            }
            try {
                return new JavacTreeMaker$TypeTag(TYPE_TYPETAG_METHOD.invoke(t, new Object[0]));
            } catch (IllegalAccessException ex) {
                throw Javac.sneakyThrow(ex);
            } catch (InvocationTargetException ex2) {
                throw Javac.sneakyThrow(ex2.getCause());
            }
        }
    }

    public static JavacTreeMaker$TypeTag typeTag(String identifier) {
        return new JavacTreeMaker$TypeTag(getFieldCached(TYPE_TAG_CACHE, Javac.getJavaCompilerVersion() < 8 ? "com.sun.tools.javac.code.TypeTags" : "com.sun.tools.javac.code.TypeTag", identifier));
    }
}
