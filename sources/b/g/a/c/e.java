package b.g.a.c;

import b.g.a.a.i0;
import b.g.a.c.c0.a0;
import b.g.a.c.i0.e$a;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: compiled from: DatabindContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public final String a(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    public j b(Type type) {
        if (type == null) {
            return null;
        }
        return d().b(null, type, b.g.a.c.h0.n.l);
    }

    public b.g.a.c.i0.e<Object, Object> c(b.g.a.c.c0.b bVar, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof b.g.a.c.i0.e) {
            return (b.g.a.c.i0.e) obj;
        }
        if (!(obj instanceof Class)) {
            StringBuilder sbU = b.d.b.a.a.U("AnnotationIntrospector returned Converter definition of type ");
            sbU.append(obj.getClass().getName());
            sbU.append("; expected type Converter or Class<Converter> instead");
            throw new IllegalStateException(sbU.toString());
        }
        Class cls = (Class) obj;
        if (cls == e$a.class || b.g.a.c.i0.d.p(cls)) {
            return null;
        }
        if (!b.g.a.c.i0.e.class.isAssignableFrom(cls)) {
            throw new IllegalStateException(b.d.b.a.a.o(cls, b.d.b.a.a.U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
        }
        v vVar = ((x) this)._config;
        Objects.requireNonNull(vVar._base);
        return (b.g.a.c.i0.e) b.g.a.c.i0.d.g(cls, vVar.b());
    }

    public abstract b.g.a.c.h0.n d();

    public i0<?> e(b.g.a.c.c0.b bVar, a0 a0Var) throws JsonMappingException {
        Class<? extends i0<?>> cls = a0Var.c;
        v vVar = ((x) this)._config;
        Objects.requireNonNull(vVar._base);
        return ((i0) b.g.a.c.i0.d.g(cls, vVar.b())).b(a0Var.e);
    }

    public abstract <T> T f(j jVar, String str) throws JsonMappingException;

    public <T> T g(Class<?> cls, String str) throws JsonMappingException {
        return (T) f(b(cls), str);
    }
}
