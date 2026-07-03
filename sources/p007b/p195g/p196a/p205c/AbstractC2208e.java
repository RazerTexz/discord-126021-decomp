package p007b.p195g.p196a.p205c;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.lang.reflect.Type;
import java.util.Objects;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p197a.AbstractC2082i0;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2175b;
import p007b.p195g.p196a.p205c.p210c0.C2174a0;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;

/* JADX INFO: renamed from: b.g.a.c.e */
/* JADX INFO: compiled from: DatabindContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2208e {
    /* JADX INFO: renamed from: a */
    public final String m1937a(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC2360j m1938b(Type type) {
        if (type == null) {
            return null;
        }
        return mo1940d().m2160b(null, type, C2335n.f4926l);
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC2343e<Object, Object> m1939c(AbstractC2175b abstractC2175b, Object obj) throws JsonMappingException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof InterfaceC2343e) {
            return (InterfaceC2343e) obj;
        }
        if (!(obj instanceof Class)) {
            StringBuilder sbM833U = C1643a.m833U("AnnotationIntrospector returned Converter definition of type ");
            sbM833U.append(obj.getClass().getName());
            sbM833U.append("; expected type Converter or Class<Converter> instead");
            throw new IllegalStateException(sbM833U.toString());
        }
        Class cls = (Class) obj;
        if (cls == InterfaceC2343e.a.class || C2342d.m2184p(cls)) {
            return null;
        }
        if (!InterfaceC2343e.class.isAssignableFrom(cls)) {
            throw new IllegalStateException(C1643a.m867o(cls, C1643a.m833U("AnnotationIntrospector returned Class "), "; expected Class<Converter>"));
        }
        C2372v c2372v = ((AbstractC2374x) this)._config;
        Objects.requireNonNull(c2372v._base);
        return (InterfaceC2343e) C2342d.m2175g(cls, c2372v.m2265b());
    }

    /* JADX INFO: renamed from: d */
    public abstract C2335n mo1940d();

    /* JADX INFO: renamed from: e */
    public AbstractC2082i0<?> m1941e(AbstractC2175b abstractC2175b, C2174a0 c2174a0) throws JsonMappingException {
        Class<? extends AbstractC2082i0<?>> cls = c2174a0.f4629c;
        C2372v c2372v = ((AbstractC2374x) this)._config;
        Objects.requireNonNull(c2372v._base);
        return ((AbstractC2082i0) C2342d.m2175g(cls, c2372v.m2265b())).mo1609b(c2174a0.f4631e);
    }

    /* JADX INFO: renamed from: f */
    public abstract <T> T mo1942f(AbstractC2360j abstractC2360j, String str) throws JsonMappingException;

    /* JADX INFO: renamed from: g */
    public <T> T m1943g(Class<?> cls, String str) throws JsonMappingException {
        return (T) mo1942f(m1938b(cls), str);
    }
}
