package p007b.p195g.p196a.p205c.p218h0;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.AbstractC2362l;
import p007b.p195g.p196a.p205c.p219i0.C2342d;
import p007b.p195g.p196a.p205c.p219i0.C2346h;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2348j;

/* JADX INFO: renamed from: b.g.a.c.h0.n */
/* JADX INFO: compiled from: TypeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2335n implements Serializable {

    /* JADX INFO: renamed from: A */
    public static final C2332k f4920A;

    /* JADX INFO: renamed from: B */
    public static final C2332k f4921B;

    /* JADX INFO: renamed from: C */
    public static final C2332k f4922C;

    /* JADX INFO: renamed from: D */
    public static final C2332k f4923D;

    /* JADX INFO: renamed from: j */
    public static final AbstractC2360j[] f4924j = new AbstractC2360j[0];

    /* JADX INFO: renamed from: k */
    public static final C2335n f4925k = new C2335n();

    /* JADX INFO: renamed from: l */
    public static final C2334m f4926l = C2334m.f4908l;

    /* JADX INFO: renamed from: m */
    public static final Class<?> f4927m = String.class;

    /* JADX INFO: renamed from: n */
    public static final Class<?> f4928n = Object.class;

    /* JADX INFO: renamed from: o */
    public static final Class<?> f4929o = Comparable.class;

    /* JADX INFO: renamed from: p */
    public static final Class<?> f4930p = Class.class;

    /* JADX INFO: renamed from: q */
    public static final Class<?> f4931q = Enum.class;

    /* JADX INFO: renamed from: r */
    public static final Class<?> f4932r = AbstractC2362l.class;

    /* JADX INFO: renamed from: s */
    public static final Class<?> f4933s;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: t */
    public static final Class<?> f4934t;

    /* JADX INFO: renamed from: u */
    public static final Class<?> f4935u;

    /* JADX INFO: renamed from: v */
    public static final C2332k f4936v;

    /* JADX INFO: renamed from: w */
    public static final C2332k f4937w;

    /* JADX INFO: renamed from: x */
    public static final C2332k f4938x;

    /* JADX INFO: renamed from: y */
    public static final C2332k f4939y;

    /* JADX INFO: renamed from: z */
    public static final C2332k f4940z;
    public final InterfaceC2348j<Object, AbstractC2360j> _typeCache = new C2346h(16, 200);
    public final C2337p _parser = new C2337p(this);
    public final AbstractC2336o[] _modifiers = null;
    public final ClassLoader _classLoader = null;

    static {
        Class<?> cls = Boolean.TYPE;
        f4933s = cls;
        Class<?> cls2 = Integer.TYPE;
        f4934t = cls2;
        Class<?> cls3 = Long.TYPE;
        f4935u = cls3;
        f4936v = new C2332k(cls);
        f4937w = new C2332k(cls2);
        f4938x = new C2332k(cls3);
        f4939y = new C2332k(String.class);
        f4940z = new C2332k(Object.class);
        f4920A = new C2332k(Comparable.class);
        f4921B = new C2332k(Enum.class);
        f4922C = new C2332k(Class.class);
        f4923D = new C2332k(AbstractC2362l.class);
    }

    /* JADX INFO: renamed from: k */
    public static AbstractC2360j m2158k() {
        Objects.requireNonNull(f4925k);
        return f4940z;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC2360j m2159a(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == f4933s) {
                return f4936v;
            }
            if (cls == f4934t) {
                return f4937w;
            }
            if (cls == f4935u) {
                return f4938x;
            }
            return null;
        }
        if (cls == f4927m) {
            return f4939y;
        }
        if (cls == f4928n) {
            return f4940z;
        }
        if (cls == f4932r) {
            return f4923D;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC2360j m2160b(C2324c c2324c, Type type, C2334m c2334m) {
        AbstractC2360j abstractC2360jM2160b;
        Type[] bounds;
        C2334m c2334mM2148d;
        if (type instanceof Class) {
            abstractC2360jM2160b = m2161c(c2324c, (Class) type, f4926l);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls = (Class) parameterizedType.getRawType();
            if (cls == f4931q) {
                abstractC2360jM2160b = f4921B;
            } else if (cls == f4929o) {
                abstractC2360jM2160b = f4920A;
            } else if (cls == f4930p) {
                abstractC2360jM2160b = f4922C;
            } else {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
                if (length == 0) {
                    c2334mM2148d = f4926l;
                } else {
                    AbstractC2360j[] abstractC2360jArr = new AbstractC2360j[length];
                    for (int i = 0; i < length; i++) {
                        abstractC2360jArr[i] = m2160b(c2324c, actualTypeArguments[i], c2334m);
                    }
                    c2334mM2148d = C2334m.m2148d(cls, abstractC2360jArr);
                }
                abstractC2360jM2160b = m2161c(c2324c, cls, c2334mM2148d);
            }
        } else {
            if (type instanceof AbstractC2360j) {
                return (AbstractC2360j) type;
            }
            if (type instanceof GenericArrayType) {
                abstractC2360jM2160b = C2322a.m2092L(m2160b(c2324c, ((GenericArrayType) type).getGenericComponentType(), c2334m), c2334m);
            } else if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                String name = typeVariable.getName();
                if (c2334m == null) {
                    throw new IllegalArgumentException(C1643a.m886y("Null `bindings` passed (type variable \"", name, "\")"));
                }
                AbstractC2360j abstractC2360jM2150e = c2334m.m2150e(name);
                if (abstractC2360jM2150e != null) {
                    abstractC2360jM2160b = abstractC2360jM2150e;
                } else if (c2334m.m2153h(name)) {
                    abstractC2360jM2160b = f4940z;
                } else {
                    C2334m c2334mM2157l = c2334m.m2157l(name);
                    synchronized (typeVariable) {
                        bounds = typeVariable.getBounds();
                    }
                    abstractC2360jM2160b = m2160b(c2324c, bounds[0], c2334mM2157l);
                }
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sbM833U = C1643a.m833U("Unrecognized Type: ");
                    sbM833U.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                abstractC2360jM2160b = m2160b(c2324c, ((WildcardType) type).getUpperBounds()[0], c2334m);
            }
        }
        if (this._modifiers != null) {
            abstractC2360jM2160b.mo2136j();
            AbstractC2336o[] abstractC2336oArr = this._modifiers;
            if (abstractC2336oArr.length > 0) {
                AbstractC2336o abstractC2336o = abstractC2336oArr[0];
                throw null;
            }
        }
        return abstractC2360jM2160b;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ba A[LOOP:1: B:101:0x01ae->B:105:0x01ba, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:126:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x01b8 A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    public AbstractC2360j m2161c(C2324c c2324c, Class<?> cls, C2334m c2334m) {
        C2324c c2324c2;
        C2324c c2324c3;
        AbstractC2360j abstractC2360jM2160b;
        AbstractC2360j[] abstractC2360jArrM2163e;
        AbstractC2360j c2330i;
        AbstractC2360j abstractC2360j;
        AbstractC2360j abstractC2360j2;
        int length;
        int i;
        AbstractC2360j abstractC2360jMo2093C;
        C2332k c2332k;
        AbstractC2360j abstractC2360j3;
        AbstractC2360j abstractC2360j4;
        AbstractC2360j abstractC2360jM2159a = m2159a(cls);
        if (abstractC2360jM2159a != null) {
            return abstractC2360jM2159a;
        }
        Object objM2149a = (c2334m == null || c2334m.m2154i()) ? cls : c2334m.m2149a(cls);
        AbstractC2360j abstractC2360jMo2093C2 = this._typeCache.get(objM2149a);
        if (abstractC2360jMo2093C2 != null) {
            return abstractC2360jMo2093C2;
        }
        if (c2324c == null) {
            c2324c3 = new C2324c(cls);
        } else {
            if (c2324c.f4903b != cls) {
                c2324c2 = c2324c.f4902a;
                while (true) {
                    if (c2324c2 == null) {
                        c2324c2 = null;
                        break;
                    }
                    if (c2324c2.f4903b == cls) {
                        break;
                    }
                    c2324c2 = c2324c2.f4902a;
                }
            } else {
                c2324c2 = c2324c;
            }
            if (c2324c2 != null) {
                C2331j c2331j = new C2331j(cls, f4926l);
                if (c2324c2.f4904c == null) {
                    c2324c2.f4904c = new ArrayList<>();
                }
                c2324c2.f4904c.add(c2331j);
                return c2331j;
            }
            c2324c3 = new C2324c(c2324c, cls);
        }
        if (cls.isArray()) {
            c2330i = C2322a.m2092L(m2160b(c2324c3, cls.getComponentType(), c2334m), c2334m);
            objM2149a = objM2149a;
        } else {
            if (cls.isInterface()) {
                abstractC2360jArrM2163e = m2163e(c2324c3, cls, c2334m);
                abstractC2360jM2160b = null;
            } else {
                Annotation[] annotationArr = C2342d.f4944a;
                Type genericSuperclass = cls.getGenericSuperclass();
                abstractC2360jM2160b = genericSuperclass == null ? null : m2160b(c2324c3, genericSuperclass, c2334m);
                abstractC2360jArrM2163e = m2163e(c2324c3, cls, c2334m);
            }
            AbstractC2360j[] abstractC2360jArr = abstractC2360jArrM2163e;
            AbstractC2360j abstractC2360j5 = abstractC2360jM2160b;
            if (cls == Properties.class) {
                C2332k c2332k2 = f4939y;
                abstractC2360jMo2093C2 = C2328g.m2123Q(cls, c2334m, abstractC2360j5, abstractC2360jArr, c2332k2, c2332k2);
            } else if (abstractC2360j5 != null) {
                abstractC2360jMo2093C2 = abstractC2360j5.mo2093C(cls, c2334m, abstractC2360j5, abstractC2360jArr);
            }
            if (abstractC2360jMo2093C2 == null) {
                C2334m c2334m2 = c2334m == null ? f4926l : c2334m;
                if (cls == Map.class) {
                    if (cls == Properties.class) {
                        c2332k = f4939y;
                    } else {
                        List<AbstractC2360j> listM2152g = c2334m2.m2152g();
                        int size = listM2152g.size();
                        if (size == 0) {
                            c2332k = f4940z;
                        } else {
                            if (size != 2) {
                                Object[] objArr = new Object[4];
                                objArr[0] = C2342d.m2189u(cls);
                                objArr[1] = Integer.valueOf(size);
                                objArr[2] = size == 1 ? "" : "s";
                                objArr[3] = c2334m2;
                                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
                            }
                            AbstractC2360j abstractC2360j6 = listM2152g.get(0);
                            abstractC2360j3 = listM2152g.get(1);
                            abstractC2360j4 = abstractC2360j6;
                        }
                        c2330i = C2328g.m2123Q(cls, c2334m2, abstractC2360j5, abstractC2360jArr, abstractC2360j4, abstractC2360j3);
                    }
                    abstractC2360j4 = c2332k;
                    abstractC2360j3 = abstractC2360j4;
                    c2330i = C2328g.m2123Q(cls, c2334m2, abstractC2360j5, abstractC2360jArr, abstractC2360j4, abstractC2360j3);
                } else {
                    if (cls == Collection.class) {
                        List<AbstractC2360j> listM2152g2 = c2334m2.m2152g();
                        if (listM2152g2.isEmpty()) {
                            abstractC2360j2 = f4940z;
                        } else {
                            if (listM2152g2.size() != 1) {
                                throw new IllegalArgumentException(C1643a.m867o(cls, C1643a.m833U("Strange Collection type "), ": cannot determine type parameters"));
                            }
                            abstractC2360j2 = listM2152g2.get(0);
                        }
                        c2330i = new C2326e(cls, c2334m2, abstractC2360j5, abstractC2360jArr, abstractC2360j2, null, null, false);
                    } else if (cls == AtomicReference.class) {
                        List<AbstractC2360j> listM2152g3 = c2334m2.m2152g();
                        if (listM2152g3.isEmpty()) {
                            abstractC2360j = f4940z;
                        } else {
                            if (listM2152g3.size() != 1) {
                                throw new IllegalArgumentException(C1643a.m867o(cls, C1643a.m833U("Strange Reference type "), ": cannot determine type parameters"));
                            }
                            abstractC2360j = listM2152g3.get(0);
                        }
                        c2330i = new C2330i(cls, c2334m2, abstractC2360j5, abstractC2360jArr, abstractC2360j, null, null, null, false);
                    } else {
                        c2330i = null;
                    }
                    if (c2330i == null) {
                        length = abstractC2360jArr.length;
                        i = 0;
                        while (true) {
                            if (i >= length) {
                                c2330i = null;
                                break;
                            }
                            abstractC2360jMo2093C = abstractC2360jArr[i].mo2093C(cls, c2334m, abstractC2360j5, abstractC2360jArr);
                            if (abstractC2360jMo2093C != null) {
                                c2330i = abstractC2360jMo2093C;
                                break;
                            }
                            i++;
                        }
                        if (c2330i == null) {
                            c2330i = m2162d(cls, c2334m, abstractC2360j5, abstractC2360jArr);
                        }
                    }
                }
                if (c2330i == null) {
                    length = abstractC2360jArr.length;
                    i = 0;
                    while (true) {
                        if (i >= length) {
                            c2330i = null;
                            break;
                        }
                        abstractC2360jMo2093C = abstractC2360jArr[i].mo2093C(cls, c2334m, abstractC2360j5, abstractC2360jArr);
                        if (abstractC2360jMo2093C != null) {
                            c2330i = abstractC2360jMo2093C;
                            break;
                        }
                        i++;
                    }
                    if (c2330i == null) {
                        c2330i = m2162d(cls, c2334m, abstractC2360j5, abstractC2360jArr);
                    }
                }
            } else {
                objM2149a = objM2149a;
                c2330i = abstractC2360jMo2093C2;
            }
        }
        ArrayList<C2331j> arrayList = c2324c3.f4904c;
        if (arrayList != null) {
            for (C2331j c2331j2 : arrayList) {
                if (c2331j2._referencedType != null) {
                    StringBuilder sbM833U = C1643a.m833U("Trying to re-set self reference; old value = ");
                    sbM833U.append(c2331j2._referencedType);
                    sbM833U.append(", new = ");
                    sbM833U.append(c2330i);
                    throw new IllegalStateException(sbM833U.toString());
                }
                c2331j2._referencedType = c2330i;
            }
        }
        if (!c2330i.mo2103s()) {
            this._typeCache.putIfAbsent(objM2149a, c2330i);
        }
        return c2330i;
    }

    /* JADX INFO: renamed from: d */
    public AbstractC2360j m2162d(Class<?> cls, C2334m c2334m, AbstractC2360j abstractC2360j, AbstractC2360j[] abstractC2360jArr) {
        return new C2332k(cls, c2334m, abstractC2360j, abstractC2360jArr, null, null, false);
    }

    /* JADX INFO: renamed from: e */
    public AbstractC2360j[] m2163e(C2324c c2324c, Class<?> cls, C2334m c2334m) {
        Annotation[] annotationArr = C2342d.f4944a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return f4924j;
        }
        int length = genericInterfaces.length;
        AbstractC2360j[] abstractC2360jArr = new AbstractC2360j[length];
        for (int i = 0; i < length; i++) {
            abstractC2360jArr[i] = m2160b(c2324c, genericInterfaces[i], c2334m);
        }
        return abstractC2360jArr;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m2164f(AbstractC2360j abstractC2360j, AbstractC2360j abstractC2360j2) {
        if (abstractC2360j2 instanceof C2329h) {
            ((C2329h) abstractC2360j2)._actualType = abstractC2360j;
            return true;
        }
        if (abstractC2360j._class != abstractC2360j2._class) {
            return false;
        }
        List<AbstractC2360j> listM2152g = abstractC2360j.mo2136j().m2152g();
        List<AbstractC2360j> listM2152g2 = abstractC2360j2.mo2136j().m2152g();
        int size = listM2152g.size();
        for (int i = 0; i < size; i++) {
            if (!m2164f(listM2152g.get(i), listM2152g2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    public AbstractC2360j m2165g(AbstractC2360j abstractC2360j, Class<?> cls) {
        Class<?> cls2 = abstractC2360j._class;
        if (cls2 == cls) {
            return abstractC2360j;
        }
        AbstractC2360j abstractC2360jMo2144i = abstractC2360j.mo2144i(cls);
        if (abstractC2360jMo2144i != null) {
            return abstractC2360jMo2144i;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), abstractC2360j));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), abstractC2360j));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x019e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x014b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:111:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0077  */
    /* JADX WARN: Code duplicated, block: B:40:0x0081 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:41:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x009d A[LOOP:0: B:45:0x009b->B:46:0x009d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00da  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    /* JADX WARN: Code duplicated, block: B:74:0x010f  */
    /* JADX WARN: Code duplicated, block: B:76:0x0115  */
    /* JADX WARN: Code duplicated, block: B:80:0x011e  */
    /* JADX WARN: Code duplicated, block: B:87:0x014e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:93:0x0181  */
    /* JADX WARN: Code duplicated, block: B:95:0x0187  */
    /* JADX INFO: renamed from: h */
    public AbstractC2360j m2166h(AbstractC2360j abstractC2360j, Class<?> cls, boolean z2) throws IllegalArgumentException {
        int length;
        C2329h[] c2329hArr;
        int i;
        AbstractC2360j abstractC2360jMo2144i;
        List<AbstractC2360j> listM2152g;
        List<AbstractC2360j> listM2152g2;
        int size;
        int size2;
        int i2;
        String str;
        AbstractC2360j[] abstractC2360jArr;
        int i3;
        AbstractC2360j abstractC2360jM2161c;
        AbstractC2360j abstractC2360jM2158k;
        AbstractC2360j abstractC2360j2;
        AbstractC2360j abstractC2360jM2158k2;
        boolean z3;
        Class<?> cls2;
        Class<?> cls3;
        boolean z4;
        Class<?> cls4 = abstractC2360j._class;
        if (cls4 == cls) {
            return abstractC2360j;
        }
        if (cls4 == Object.class) {
            abstractC2360jM2161c = m2161c(null, cls, f4926l);
        } else {
            if (!cls4.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format("Class %s not subtype of %s", C2342d.m2189u(cls), C2342d.m2182n(abstractC2360j)));
            }
            if (abstractC2360j.mo2104v()) {
                if (abstractC2360j.mo2122z()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        abstractC2360jM2161c = m2161c(null, cls, C2334m.m2147c(cls, abstractC2360j.mo2121o(), abstractC2360j.mo2099k()));
                    } else if (abstractC2360j.mo2136j().m2154i()) {
                        abstractC2360jM2161c = m2161c(null, cls, f4926l);
                    } else {
                        c2329hArr = new C2329h[length];
                        for (i = 0; i < length; i++) {
                            c2329hArr[i] = new C2329h(i);
                        }
                        abstractC2360jMo2144i = m2161c(null, cls, C2334m.m2148d(cls, c2329hArr)).mo2144i(abstractC2360j._class);
                        if (abstractC2360jMo2144i != null) {
                            throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", abstractC2360j._class.getName(), cls.getName()));
                        }
                        listM2152g = abstractC2360j.mo2136j().m2152g();
                        listM2152g2 = abstractC2360jMo2144i.mo2136j().m2152g();
                        size = listM2152g2.size();
                        size2 = listM2152g.size();
                        i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                str = null;
                                break;
                            }
                            abstractC2360j2 = listM2152g.get(i2);
                            if (i2 < size) {
                                abstractC2360jM2158k2 = listM2152g2.get(i2);
                            } else {
                                abstractC2360jM2158k2 = m2158k();
                            }
                            if (m2164f(abstractC2360j2, abstractC2360jM2158k2)) {
                                if (abstractC2360j2._class == Object.class) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    if (i2 != 0) {
                                        if (!abstractC2360j2._class.isInterface()) {
                                            cls2 = abstractC2360jM2158k2._class;
                                            cls3 = abstractC2360j2._class;
                                            if (cls3 != cls2) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                            }
                                        }
                                        str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                        break;
                                    }
                                    if (!abstractC2360j2._class.isInterface()) {
                                        cls2 = abstractC2360jM2158k2._class;
                                        cls3 = abstractC2360j2._class;
                                        if (cls3 != cls2) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        if (z4) {
                                        }
                                    }
                                    str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                    break;
                                }
                                continue;
                            }
                            i2++;
                        }
                        if (str == null) {
                        }
                        abstractC2360jArr = new AbstractC2360j[length];
                        for (i3 = 0; i3 < length; i3++) {
                            abstractC2360jM2158k = c2329hArr[i3]._actualType;
                            if (abstractC2360jM2158k == null) {
                                abstractC2360jM2158k = m2158k();
                            }
                            abstractC2360jArr[i3] = abstractC2360jM2158k;
                        }
                        abstractC2360jM2161c = m2161c(null, cls, C2334m.m2148d(cls, abstractC2360jArr));
                    }
                } else if (abstractC2360j.mo2111u()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        abstractC2360jM2161c = m2161c(null, cls, C2334m.m2146b(cls, abstractC2360j.mo2099k()));
                    } else {
                        if (cls4 == EnumSet.class) {
                            return abstractC2360j;
                        }
                        if (abstractC2360j.mo2136j().m2154i()) {
                            abstractC2360jM2161c = m2161c(null, cls, f4926l);
                        } else {
                            c2329hArr = new C2329h[length];
                            while (i < length) {
                                c2329hArr[i] = new C2329h(i);
                            }
                            abstractC2360jMo2144i = m2161c(null, cls, C2334m.m2148d(cls, c2329hArr)).mo2144i(abstractC2360j._class);
                            if (abstractC2360jMo2144i != null) {
                                throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", abstractC2360j._class.getName(), cls.getName()));
                            }
                            listM2152g = abstractC2360j.mo2136j().m2152g();
                            listM2152g2 = abstractC2360jMo2144i.mo2136j().m2152g();
                            size = listM2152g2.size();
                            size2 = listM2152g.size();
                            i2 = 0;
                            while (true) {
                                if (i2 < size2) {
                                    str = null;
                                    break;
                                }
                                abstractC2360j2 = listM2152g.get(i2);
                                if (i2 < size) {
                                    abstractC2360jM2158k2 = listM2152g2.get(i2);
                                } else {
                                    abstractC2360jM2158k2 = m2158k();
                                }
                                if (m2164f(abstractC2360j2, abstractC2360jM2158k2)) {
                                    if (abstractC2360j2._class == Object.class) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        if (i2 != 0) {
                                            if (!abstractC2360j2._class.isInterface()) {
                                                cls2 = abstractC2360jM2158k2._class;
                                                cls3 = abstractC2360j2._class;
                                                if (cls3 != cls2) {
                                                    z4 = true;
                                                } else {
                                                    z4 = true;
                                                }
                                                if (z4) {
                                                }
                                            }
                                            str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                            break;
                                        }
                                        if (!abstractC2360j2._class.isInterface()) {
                                            cls2 = abstractC2360jM2158k2._class;
                                            cls3 = abstractC2360j2._class;
                                            if (cls3 != cls2) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                            }
                                        }
                                        str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                        break;
                                    }
                                    continue;
                                }
                                i2++;
                            }
                            if (str == null) {
                            }
                            abstractC2360jArr = new AbstractC2360j[length];
                            while (i3 < length) {
                                abstractC2360jM2158k = c2329hArr[i3]._actualType;
                                if (abstractC2360jM2158k == null) {
                                    abstractC2360jM2158k = m2158k();
                                }
                                abstractC2360jArr[i3] = abstractC2360jM2158k;
                            }
                            abstractC2360jM2161c = m2161c(null, cls, C2334m.m2148d(cls, abstractC2360jArr));
                        }
                    }
                } else if (abstractC2360j.mo2136j().m2154i()) {
                    abstractC2360jM2161c = m2161c(null, cls, f4926l);
                } else {
                    c2329hArr = new C2329h[length];
                    while (i < length) {
                        c2329hArr[i] = new C2329h(i);
                    }
                    abstractC2360jMo2144i = m2161c(null, cls, C2334m.m2148d(cls, c2329hArr)).mo2144i(abstractC2360j._class);
                    if (abstractC2360jMo2144i != null) {
                        throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", abstractC2360j._class.getName(), cls.getName()));
                    }
                    listM2152g = abstractC2360j.mo2136j().m2152g();
                    listM2152g2 = abstractC2360jMo2144i.mo2136j().m2152g();
                    size = listM2152g2.size();
                    size2 = listM2152g.size();
                    i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            str = null;
                            break;
                        }
                        abstractC2360j2 = listM2152g.get(i2);
                        if (i2 < size) {
                            abstractC2360jM2158k2 = listM2152g2.get(i2);
                        } else {
                            abstractC2360jM2158k2 = m2158k();
                        }
                        if (m2164f(abstractC2360j2, abstractC2360jM2158k2)) {
                            if (abstractC2360j2._class == Object.class) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                if (i2 != 0) {
                                    if (!abstractC2360j2._class.isInterface()) {
                                        cls2 = abstractC2360jM2158k2._class;
                                        cls3 = abstractC2360j2._class;
                                        if (cls3 != cls2) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        if (z4) {
                                        }
                                    }
                                    str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                    break;
                                }
                                if (!abstractC2360j2._class.isInterface()) {
                                    cls2 = abstractC2360jM2158k2._class;
                                    cls3 = abstractC2360j2._class;
                                    if (cls3 != cls2) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                break;
                            }
                            continue;
                        }
                        i2++;
                    }
                    if (str == null) {
                    }
                    abstractC2360jArr = new AbstractC2360j[length];
                    while (i3 < length) {
                        abstractC2360jM2158k = c2329hArr[i3]._actualType;
                        if (abstractC2360jM2158k == null) {
                            abstractC2360jM2158k = m2158k();
                        }
                        abstractC2360jArr[i3] = abstractC2360jM2158k;
                    }
                    abstractC2360jM2161c = m2161c(null, cls, C2334m.m2148d(cls, abstractC2360jArr));
                }
            } else if (abstractC2360j.mo2136j().m2154i() && (length = cls.getTypeParameters().length) != 0) {
                c2329hArr = new C2329h[length];
                while (i < length) {
                    c2329hArr[i] = new C2329h(i);
                }
                abstractC2360jMo2144i = m2161c(null, cls, C2334m.m2148d(cls, c2329hArr)).mo2144i(abstractC2360j._class);
                if (abstractC2360jMo2144i != null) {
                    throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", abstractC2360j._class.getName(), cls.getName()));
                }
                listM2152g = abstractC2360j.mo2136j().m2152g();
                listM2152g2 = abstractC2360jMo2144i.mo2136j().m2152g();
                size = listM2152g2.size();
                size2 = listM2152g.size();
                i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        str = null;
                        break;
                    }
                    abstractC2360j2 = listM2152g.get(i2);
                    if (i2 < size) {
                        abstractC2360jM2158k2 = listM2152g2.get(i2);
                    } else {
                        abstractC2360jM2158k2 = m2158k();
                    }
                    if (m2164f(abstractC2360j2, abstractC2360jM2158k2)) {
                        if (abstractC2360j2._class == Object.class) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            continue;
                        } else {
                            if (i2 != 0 || !abstractC2360j.mo2122z()) {
                                if (!abstractC2360j2._class.isInterface()) {
                                    cls2 = abstractC2360jM2158k2._class;
                                    cls3 = abstractC2360j2._class;
                                    if (cls3 != cls2 || cls3.isAssignableFrom(cls2)) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                break;
                            }
                            if (!(abstractC2360jM2158k2._class == Object.class)) {
                                if (!abstractC2360j2._class.isInterface()) {
                                    cls2 = abstractC2360jM2158k2._class;
                                    cls3 = abstractC2360j2._class;
                                    if (cls3 != cls2) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), abstractC2360j2.mo1729e(), abstractC2360jM2158k2.mo1729e());
                                break;
                            }
                            continue;
                        }
                    }
                    i2++;
                }
                if (str == null && !z2) {
                    StringBuilder sbM833U = C1643a.m833U("Failed to specialize base type ");
                    sbM833U.append(abstractC2360j.mo1729e());
                    sbM833U.append(" as ");
                    sbM833U.append(cls.getName());
                    sbM833U.append(", problem: ");
                    sbM833U.append(str);
                    throw new IllegalArgumentException(sbM833U.toString());
                }
                abstractC2360jArr = new AbstractC2360j[length];
                while (i3 < length) {
                    abstractC2360jM2158k = c2329hArr[i3]._actualType;
                    if (abstractC2360jM2158k == null) {
                        abstractC2360jM2158k = m2158k();
                    }
                    abstractC2360jArr[i3] = abstractC2360jM2158k;
                }
                abstractC2360jM2161c = m2161c(null, cls, C2334m.m2148d(cls, abstractC2360jArr));
            } else {
                abstractC2360jM2161c = m2161c(null, cls, f4926l);
            }
        }
        return abstractC2360jM2161c.mo2105F(abstractC2360j);
    }

    /* JADX INFO: renamed from: i */
    public AbstractC2360j[] m2167i(AbstractC2360j abstractC2360j, Class<?> cls) {
        AbstractC2360j abstractC2360jMo2144i = abstractC2360j.mo2144i(cls);
        return abstractC2360jMo2144i == null ? f4924j : abstractC2360jMo2144i.mo2136j().m2156k();
    }

    @Deprecated
    /* JADX INFO: renamed from: j */
    public AbstractC2360j m2168j(Class<?> cls) {
        AbstractC2360j abstractC2360jM2159a;
        C2334m c2334m = f4926l;
        return (!c2334m.m2154i() || (abstractC2360jM2159a = m2159a(cls)) == null) ? m2162d(cls, c2334m, null, null) : abstractC2360jM2159a;
    }
}
