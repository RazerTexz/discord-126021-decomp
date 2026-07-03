package p007b.p195g.p196a.p205c.p212e0.p213h;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p212e0.AbstractC2211c;
import p007b.p195g.p196a.p205c.p218h0.C2326e;
import p007b.p195g.p196a.p205c.p218h0.C2328g;
import p007b.p195g.p196a.p205c.p218h0.C2334m;
import p007b.p195g.p196a.p205c.p218h0.C2335n;
import p007b.p195g.p196a.p205c.p219i0.C2342d;

/* JADX INFO: renamed from: b.g.a.c.e0.h.f */
/* JADX INFO: compiled from: ClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2221f extends AbstractC2226k {
    public C2221f(AbstractC2360j abstractC2360j, C2335n c2335n, AbstractC2211c abstractC2211c) {
        super(abstractC2360j, c2335n);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e
    /* JADX INFO: renamed from: a */
    public String mo1946a(Object obj) {
        return m1964d(obj, obj.getClass(), this.f4774a);
    }

    @Override // p007b.p195g.p196a.p205c.p212e0.InterfaceC2213e
    /* JADX INFO: renamed from: c */
    public String mo1948c(Object obj, Class<?> cls) {
        return m1964d(obj, cls, this.f4774a);
    }

    /* JADX INFO: renamed from: d */
    public String m1964d(Object obj, Class<?> cls, C2335n c2335n) {
        Class<?> declaringClass;
        AbstractC2360j abstractC2360jM2161c;
        AbstractC2360j abstractC2360jM2161c2;
        C2334m c2334m;
        Class<?> declaringClass2;
        C2334m c2334m2;
        Class<?> superclass = (!C2342d.m2185q(cls) || cls.isEnum()) ? cls : cls.getSuperclass();
        String name = superclass.getName();
        if (!name.startsWith("java.util.")) {
            return (name.indexOf(36) < 0 || C2342d.m2181m(superclass) == null || C2342d.m2181m(this.f4775b._class) != null) ? name : this.f4775b._class.getName();
        }
        if (obj instanceof EnumSet) {
            EnumSet enumSet = (EnumSet) obj;
            if (enumSet.isEmpty()) {
                Field field = C2342d.b.f4951a.f4952b;
                if (field == null) {
                    throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
                }
                try {
                    declaringClass2 = (Class) field.get(enumSet);
                } catch (Exception e) {
                    throw new IllegalArgumentException(e);
                }
            } else {
                declaringClass2 = ((Enum) enumSet.iterator().next()).getDeclaringClass();
            }
            AbstractC2360j abstractC2360jM2161c3 = c2335n.m2161c(null, declaringClass2, C2335n.f4926l);
            String[] strArr = C2334m.f4906j;
            TypeVariable[] typeParameters = EnumSet.class.getTypeParameters();
            int length = typeParameters == null ? 0 : typeParameters.length;
            if (length == 0) {
                c2334m2 = C2334m.f4908l;
            } else {
                if (length != 1) {
                    StringBuilder sbM833U = C1643a.m833U("Cannot create TypeBindings for class ");
                    sbM833U.append(EnumSet.class.getName());
                    sbM833U.append(" with 1 type parameter: class expects ");
                    sbM833U.append(length);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                c2334m2 = new C2334m(new String[]{typeParameters[0].getName()}, new AbstractC2360j[]{abstractC2360jM2161c3}, null);
            }
            C2326e c2326e = (C2326e) c2335n.m2161c(null, EnumSet.class, c2334m2);
            if (c2334m2.m2154i()) {
                AbstractC2360j abstractC2360jMo2099k = c2326e.mo2144i(Collection.class).mo2099k();
                if (!abstractC2360jMo2099k.equals(abstractC2360jM2161c3)) {
                    throw new IllegalArgumentException(String.format("Non-generic Collection class %s did not resolve to something with element type %s but %s ", C2342d.m2189u(EnumSet.class), abstractC2360jM2161c3, abstractC2360jMo2099k));
                }
            }
            return c2326e.mo2106K();
        }
        if (!(obj instanceof EnumMap)) {
            return name;
        }
        EnumMap enumMap = (EnumMap) obj;
        if (enumMap.isEmpty()) {
            Field field2 = C2342d.b.f4951a.f4953c;
            if (field2 == null) {
                throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
            }
            try {
                declaringClass = (Class) field2.get(enumMap);
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            declaringClass = ((Enum) enumMap.keySet().iterator().next()).getDeclaringClass();
        }
        Objects.requireNonNull(c2335n);
        if (EnumMap.class == Properties.class) {
            abstractC2360jM2161c = C2335n.f4939y;
            abstractC2360jM2161c2 = abstractC2360jM2161c;
        } else {
            C2334m c2334m3 = C2335n.f4926l;
            abstractC2360jM2161c = c2335n.m2161c(null, declaringClass, c2334m3);
            abstractC2360jM2161c2 = c2335n.m2161c(null, Object.class, c2334m3);
        }
        AbstractC2360j[] abstractC2360jArr = {abstractC2360jM2161c, abstractC2360jM2161c2};
        String[] strArr2 = C2334m.f4906j;
        TypeVariable[] typeParameters2 = EnumMap.class.getTypeParameters();
        if (typeParameters2 == null || typeParameters2.length == 0) {
            c2334m = C2334m.f4908l;
        } else {
            int length2 = typeParameters2.length;
            String[] strArr3 = new String[length2];
            for (int i = 0; i < length2; i++) {
                strArr3[i] = typeParameters2[i].getName();
            }
            if (length2 != 2) {
                StringBuilder sbM833U2 = C1643a.m833U("Cannot create TypeBindings for class ");
                sbM833U2.append(EnumMap.class.getName());
                sbM833U2.append(" with ");
                sbM833U2.append(2);
                sbM833U2.append(" type parameter");
                sbM833U2.append("s");
                sbM833U2.append(": class expects ");
                sbM833U2.append(length2);
                throw new IllegalArgumentException(sbM833U2.toString());
            }
            c2334m = new C2334m(strArr3, abstractC2360jArr, null);
        }
        C2328g c2328g = (C2328g) c2335n.m2161c(null, EnumMap.class, c2334m);
        if (c2334m.m2154i()) {
            AbstractC2360j abstractC2360jMo2144i = c2328g.mo2144i(Map.class);
            AbstractC2360j abstractC2360jMo2121o = abstractC2360jMo2144i.mo2121o();
            if (!abstractC2360jMo2121o.equals(abstractC2360jM2161c)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with key type %s but %s ", C2342d.m2189u(EnumMap.class), abstractC2360jM2161c, abstractC2360jMo2121o));
            }
            AbstractC2360j abstractC2360jMo2099k2 = abstractC2360jMo2144i.mo2099k();
            if (!abstractC2360jMo2099k2.equals(abstractC2360jM2161c2)) {
                throw new IllegalArgumentException(String.format("Non-generic Map class %s did not resolve to something with value type %s but %s ", C2342d.m2189u(EnumMap.class), abstractC2360jM2161c2, abstractC2360jMo2099k2));
            }
        }
        return c2328g.mo2106K();
    }
}
