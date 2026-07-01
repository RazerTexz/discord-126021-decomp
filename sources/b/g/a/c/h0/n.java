package b.g.a.c.h0;

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

/* JADX INFO: compiled from: TypeFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class n implements Serializable {
    public static final k A;
    public static final k B;
    public static final k C;
    public static final k D;
    public static final b.g.a.c.j[] j = new b.g.a.c.j[0];
    public static final n k = new n();
    public static final m l = m.l;
    public static final Class<?> m = String.class;
    public static final Class<?> n = Object.class;
    public static final Class<?> o = Comparable.class;
    public static final Class<?> p = Class.class;
    public static final Class<?> q = Enum.class;
    public static final Class<?> r = b.g.a.c.l.class;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Class<?> f722s;
    private static final long serialVersionUID = 1;
    public static final Class<?> t;
    public static final Class<?> u;
    public static final k v;
    public static final k w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final k f723x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final k f724y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final k f725z;
    public final b.g.a.c.i0.j<Object, b.g.a.c.j> _typeCache = new b.g.a.c.i0.h(16, 200);
    public final p _parser = new p(this);
    public final o[] _modifiers = null;
    public final ClassLoader _classLoader = null;

    static {
        Class<?> cls = Boolean.TYPE;
        f722s = cls;
        Class<?> cls2 = Integer.TYPE;
        t = cls2;
        Class<?> cls3 = Long.TYPE;
        u = cls3;
        v = new k(cls);
        w = new k(cls2);
        f723x = new k(cls3);
        f724y = new k(String.class);
        f725z = new k(Object.class);
        A = new k(Comparable.class);
        B = new k(Enum.class);
        C = new k(Class.class);
        D = new k(b.g.a.c.l.class);
    }

    public static b.g.a.c.j k() {
        Objects.requireNonNull(k);
        return f725z;
    }

    public b.g.a.c.j a(Class<?> cls) {
        if (cls.isPrimitive()) {
            if (cls == f722s) {
                return v;
            }
            if (cls == t) {
                return w;
            }
            if (cls == u) {
                return f723x;
            }
            return null;
        }
        if (cls == m) {
            return f724y;
        }
        if (cls == n) {
            return f725z;
        }
        if (cls == r) {
            return D;
        }
        return null;
    }

    public b.g.a.c.j b(c cVar, Type type, m mVar) {
        b.g.a.c.j jVarB;
        Type[] bounds;
        m mVarD;
        if (type instanceof Class) {
            jVarB = c(cVar, (Class) type, l);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Class<?> cls = (Class) parameterizedType.getRawType();
            if (cls == q) {
                jVarB = B;
            } else if (cls == o) {
                jVarB = A;
            } else if (cls == p) {
                jVarB = C;
            } else {
                Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                int length = actualTypeArguments == null ? 0 : actualTypeArguments.length;
                if (length == 0) {
                    mVarD = l;
                } else {
                    b.g.a.c.j[] jVarArr = new b.g.a.c.j[length];
                    for (int i = 0; i < length; i++) {
                        jVarArr[i] = b(cVar, actualTypeArguments[i], mVar);
                    }
                    mVarD = m.d(cls, jVarArr);
                }
                jVarB = c(cVar, cls, mVarD);
            }
        } else {
            if (type instanceof b.g.a.c.j) {
                return (b.g.a.c.j) type;
            }
            if (type instanceof GenericArrayType) {
                jVarB = a.L(b(cVar, ((GenericArrayType) type).getGenericComponentType(), mVar), mVar);
            } else if (type instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type;
                String name = typeVariable.getName();
                if (mVar == null) {
                    throw new IllegalArgumentException(b.d.b.a.a.y("Null `bindings` passed (type variable \"", name, "\")"));
                }
                b.g.a.c.j jVarE = mVar.e(name);
                if (jVarE != null) {
                    jVarB = jVarE;
                } else if (mVar.h(name)) {
                    jVarB = f725z;
                } else {
                    m mVarL = mVar.l(name);
                    synchronized (typeVariable) {
                        bounds = typeVariable.getBounds();
                    }
                    jVarB = b(cVar, bounds[0], mVarL);
                }
            } else {
                if (!(type instanceof WildcardType)) {
                    StringBuilder sbU = b.d.b.a.a.U("Unrecognized Type: ");
                    sbU.append(type == null ? "[null]" : type.toString());
                    throw new IllegalArgumentException(sbU.toString());
                }
                jVarB = b(cVar, ((WildcardType) type).getUpperBounds()[0], mVar);
            }
        }
        if (this._modifiers != null) {
            jVarB.j();
            o[] oVarArr = this._modifiers;
            if (oVarArr.length > 0) {
                o oVar = oVarArr[0];
                throw null;
            }
        }
        return jVarB;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:102:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ba A[LOOP:1: B:101:0x01ae->B:105:0x01ba, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:126:0x01bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x01b8 A[SYNTHETIC] */
    public b.g.a.c.j c(c cVar, Class<?> cls, m mVar) {
        c cVar2;
        c cVar3;
        b.g.a.c.j jVarB;
        b.g.a.c.j[] jVarArrE;
        b.g.a.c.j iVar;
        b.g.a.c.j jVar;
        b.g.a.c.j jVar2;
        int length;
        int i;
        b.g.a.c.j jVarC;
        k kVar;
        b.g.a.c.j jVar3;
        b.g.a.c.j jVar4;
        b.g.a.c.j jVarA = a(cls);
        if (jVarA != null) {
            return jVarA;
        }
        Object objA = (mVar == null || mVar.i()) ? cls : mVar.a(cls);
        b.g.a.c.j jVarC2 = this._typeCache.get(objA);
        if (jVarC2 != null) {
            return jVarC2;
        }
        if (cVar == null) {
            cVar3 = new c(cls);
        } else {
            if (cVar.f719b != cls) {
                cVar2 = cVar.a;
                while (true) {
                    if (cVar2 == null) {
                        cVar2 = null;
                        break;
                    }
                    if (cVar2.f719b == cls) {
                        break;
                    }
                    cVar2 = cVar2.a;
                }
            } else {
                cVar2 = cVar;
            }
            if (cVar2 != null) {
                j jVar5 = new j(cls, l);
                if (cVar2.c == null) {
                    cVar2.c = new ArrayList<>();
                }
                cVar2.c.add(jVar5);
                return jVar5;
            }
            cVar3 = new c(cVar, cls);
        }
        if (cls.isArray()) {
            iVar = a.L(b(cVar3, cls.getComponentType(), mVar), mVar);
            objA = objA;
        } else {
            if (cls.isInterface()) {
                jVarArrE = e(cVar3, cls, mVar);
                jVarB = null;
            } else {
                Annotation[] annotationArr = b.g.a.c.i0.d.a;
                Type genericSuperclass = cls.getGenericSuperclass();
                jVarB = genericSuperclass == null ? null : b(cVar3, genericSuperclass, mVar);
                jVarArrE = e(cVar3, cls, mVar);
            }
            b.g.a.c.j[] jVarArr = jVarArrE;
            b.g.a.c.j jVar6 = jVarB;
            if (cls == Properties.class) {
                k kVar2 = f724y;
                jVarC2 = g.Q(cls, mVar, jVar6, jVarArr, kVar2, kVar2);
            } else if (jVar6 != null) {
                jVarC2 = jVar6.C(cls, mVar, jVar6, jVarArr);
            }
            if (jVarC2 == null) {
                m mVar2 = mVar == null ? l : mVar;
                if (cls == Map.class) {
                    if (cls == Properties.class) {
                        kVar = f724y;
                    } else {
                        List<b.g.a.c.j> listG = mVar2.g();
                        int size = listG.size();
                        if (size == 0) {
                            kVar = f725z;
                        } else {
                            if (size != 2) {
                                Object[] objArr = new Object[4];
                                objArr[0] = b.g.a.c.i0.d.u(cls);
                                objArr[1] = Integer.valueOf(size);
                                objArr[2] = size == 1 ? "" : "s";
                                objArr[3] = mVar2;
                                throw new IllegalArgumentException(String.format("Strange Map type %s with %d type parameter%s (%s), can not resolve", objArr));
                            }
                            b.g.a.c.j jVar7 = listG.get(0);
                            jVar3 = listG.get(1);
                            jVar4 = jVar7;
                        }
                        iVar = g.Q(cls, mVar2, jVar6, jVarArr, jVar4, jVar3);
                    }
                    jVar4 = kVar;
                    jVar3 = jVar4;
                    iVar = g.Q(cls, mVar2, jVar6, jVarArr, jVar4, jVar3);
                } else {
                    if (cls == Collection.class) {
                        List<b.g.a.c.j> listG2 = mVar2.g();
                        if (listG2.isEmpty()) {
                            jVar2 = f725z;
                        } else {
                            if (listG2.size() != 1) {
                                throw new IllegalArgumentException(b.d.b.a.a.o(cls, b.d.b.a.a.U("Strange Collection type "), ": cannot determine type parameters"));
                            }
                            jVar2 = listG2.get(0);
                        }
                        iVar = new e(cls, mVar2, jVar6, jVarArr, jVar2, null, null, false);
                    } else if (cls == AtomicReference.class) {
                        List<b.g.a.c.j> listG3 = mVar2.g();
                        if (listG3.isEmpty()) {
                            jVar = f725z;
                        } else {
                            if (listG3.size() != 1) {
                                throw new IllegalArgumentException(b.d.b.a.a.o(cls, b.d.b.a.a.U("Strange Reference type "), ": cannot determine type parameters"));
                            }
                            jVar = listG3.get(0);
                        }
                        iVar = new i(cls, mVar2, jVar6, jVarArr, jVar, null, null, null, false);
                    } else {
                        iVar = null;
                    }
                    if (iVar == null) {
                        length = jVarArr.length;
                        i = 0;
                        while (true) {
                            if (i >= length) {
                                iVar = null;
                                break;
                            }
                            jVarC = jVarArr[i].C(cls, mVar, jVar6, jVarArr);
                            if (jVarC != null) {
                                iVar = jVarC;
                                break;
                            }
                            i++;
                        }
                        if (iVar == null) {
                            iVar = d(cls, mVar, jVar6, jVarArr);
                        }
                    }
                }
                if (iVar == null) {
                    length = jVarArr.length;
                    i = 0;
                    while (true) {
                        if (i >= length) {
                            iVar = null;
                            break;
                        }
                        jVarC = jVarArr[i].C(cls, mVar, jVar6, jVarArr);
                        if (jVarC != null) {
                            iVar = jVarC;
                            break;
                        }
                        i++;
                    }
                    if (iVar == null) {
                        iVar = d(cls, mVar, jVar6, jVarArr);
                    }
                }
            } else {
                objA = objA;
                iVar = jVarC2;
            }
        }
        ArrayList<j> arrayList = cVar3.c;
        if (arrayList != null) {
            for (j jVar8 : arrayList) {
                if (jVar8._referencedType != null) {
                    StringBuilder sbU = b.d.b.a.a.U("Trying to re-set self reference; old value = ");
                    sbU.append(jVar8._referencedType);
                    sbU.append(", new = ");
                    sbU.append(iVar);
                    throw new IllegalStateException(sbU.toString());
                }
                jVar8._referencedType = iVar;
            }
        }
        if (!iVar.s()) {
            this._typeCache.putIfAbsent(objA, iVar);
        }
        return iVar;
    }

    public b.g.a.c.j d(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new k(cls, mVar, jVar, jVarArr, null, null, false);
    }

    public b.g.a.c.j[] e(c cVar, Class<?> cls, m mVar) {
        Annotation[] annotationArr = b.g.a.c.i0.d.a;
        Type[] genericInterfaces = cls.getGenericInterfaces();
        if (genericInterfaces == null || genericInterfaces.length == 0) {
            return j;
        }
        int length = genericInterfaces.length;
        b.g.a.c.j[] jVarArr = new b.g.a.c.j[length];
        for (int i = 0; i < length; i++) {
            jVarArr[i] = b(cVar, genericInterfaces[i], mVar);
        }
        return jVarArr;
    }

    public final boolean f(b.g.a.c.j jVar, b.g.a.c.j jVar2) {
        if (jVar2 instanceof h) {
            ((h) jVar2)._actualType = jVar;
            return true;
        }
        if (jVar._class != jVar2._class) {
            return false;
        }
        List<b.g.a.c.j> listG = jVar.j().g();
        List<b.g.a.c.j> listG2 = jVar2.j().g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (!f(listG.get(i), listG2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public b.g.a.c.j g(b.g.a.c.j jVar, Class<?> cls) {
        Class<?> cls2 = jVar._class;
        if (cls2 == cls) {
            return jVar;
        }
        b.g.a.c.j jVarI = jVar.i(cls);
        if (jVarI != null) {
            return jVarI;
        }
        if (cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format("Internal error: class %s not included as super-type for %s", cls.getName(), jVar));
        }
        throw new IllegalArgumentException(String.format("Class %s not a super-type of %s", cls.getName(), jVar));
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
    public b.g.a.c.j h(b.g.a.c.j jVar, Class<?> cls, boolean z2) throws IllegalArgumentException {
        int length;
        h[] hVarArr;
        int i;
        b.g.a.c.j jVarI;
        List<b.g.a.c.j> listG;
        List<b.g.a.c.j> listG2;
        int size;
        int size2;
        int i2;
        String str;
        b.g.a.c.j[] jVarArr;
        int i3;
        b.g.a.c.j jVarC;
        b.g.a.c.j jVarK;
        b.g.a.c.j jVar2;
        b.g.a.c.j jVarK2;
        boolean z3;
        Class<?> cls2;
        Class<?> cls3;
        boolean z4;
        Class<?> cls4 = jVar._class;
        if (cls4 == cls) {
            return jVar;
        }
        if (cls4 == Object.class) {
            jVarC = c(null, cls, l);
        } else {
            if (!cls4.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(String.format("Class %s not subtype of %s", b.g.a.c.i0.d.u(cls), b.g.a.c.i0.d.n(jVar)));
            }
            if (jVar.v()) {
                if (jVar.z()) {
                    if (cls == HashMap.class || cls == LinkedHashMap.class || cls == EnumMap.class || cls == TreeMap.class) {
                        jVarC = c(null, cls, m.c(cls, jVar.o(), jVar.k()));
                    } else if (jVar.j().i()) {
                        jVarC = c(null, cls, l);
                    } else {
                        hVarArr = new h[length];
                        for (i = 0; i < length; i++) {
                            hVarArr[i] = new h(i);
                        }
                        jVarI = c(null, cls, m.d(cls, hVarArr)).i(jVar._class);
                        if (jVarI != null) {
                            throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", jVar._class.getName(), cls.getName()));
                        }
                        listG = jVar.j().g();
                        listG2 = jVarI.j().g();
                        size = listG2.size();
                        size2 = listG.size();
                        i2 = 0;
                        while (true) {
                            if (i2 < size2) {
                                str = null;
                                break;
                            }
                            jVar2 = listG.get(i2);
                            if (i2 < size) {
                                jVarK2 = listG2.get(i2);
                            } else {
                                jVarK2 = k();
                            }
                            if (f(jVar2, jVarK2)) {
                                if (jVar2._class == Object.class) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    if (i2 != 0) {
                                        if (!jVar2._class.isInterface()) {
                                            cls2 = jVarK2._class;
                                            cls3 = jVar2._class;
                                            if (cls3 != cls2) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                            }
                                        }
                                        str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                        break;
                                    }
                                    if (!jVar2._class.isInterface()) {
                                        cls2 = jVarK2._class;
                                        cls3 = jVar2._class;
                                        if (cls3 != cls2) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        if (z4) {
                                        }
                                    }
                                    str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                    break;
                                }
                                continue;
                            }
                            i2++;
                        }
                        if (str == null) {
                        }
                        jVarArr = new b.g.a.c.j[length];
                        for (i3 = 0; i3 < length; i3++) {
                            jVarK = hVarArr[i3]._actualType;
                            if (jVarK == null) {
                                jVarK = k();
                            }
                            jVarArr[i3] = jVarK;
                        }
                        jVarC = c(null, cls, m.d(cls, jVarArr));
                    }
                } else if (jVar.u()) {
                    if (cls == ArrayList.class || cls == LinkedList.class || cls == HashSet.class || cls == TreeSet.class) {
                        jVarC = c(null, cls, m.b(cls, jVar.k()));
                    } else {
                        if (cls4 == EnumSet.class) {
                            return jVar;
                        }
                        if (jVar.j().i()) {
                            jVarC = c(null, cls, l);
                        } else {
                            hVarArr = new h[length];
                            while (i < length) {
                                hVarArr[i] = new h(i);
                            }
                            jVarI = c(null, cls, m.d(cls, hVarArr)).i(jVar._class);
                            if (jVarI != null) {
                                throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", jVar._class.getName(), cls.getName()));
                            }
                            listG = jVar.j().g();
                            listG2 = jVarI.j().g();
                            size = listG2.size();
                            size2 = listG.size();
                            i2 = 0;
                            while (true) {
                                if (i2 < size2) {
                                    str = null;
                                    break;
                                }
                                jVar2 = listG.get(i2);
                                if (i2 < size) {
                                    jVarK2 = listG2.get(i2);
                                } else {
                                    jVarK2 = k();
                                }
                                if (f(jVar2, jVarK2)) {
                                    if (jVar2._class == Object.class) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (z3) {
                                        if (i2 != 0) {
                                            if (!jVar2._class.isInterface()) {
                                                cls2 = jVarK2._class;
                                                cls3 = jVar2._class;
                                                if (cls3 != cls2) {
                                                    z4 = true;
                                                } else {
                                                    z4 = true;
                                                }
                                                if (z4) {
                                                }
                                            }
                                            str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                            break;
                                        }
                                        if (!jVar2._class.isInterface()) {
                                            cls2 = jVarK2._class;
                                            cls3 = jVar2._class;
                                            if (cls3 != cls2) {
                                                z4 = true;
                                            } else {
                                                z4 = true;
                                            }
                                            if (z4) {
                                            }
                                        }
                                        str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                        break;
                                    }
                                    continue;
                                }
                                i2++;
                            }
                            if (str == null) {
                            }
                            jVarArr = new b.g.a.c.j[length];
                            while (i3 < length) {
                                jVarK = hVarArr[i3]._actualType;
                                if (jVarK == null) {
                                    jVarK = k();
                                }
                                jVarArr[i3] = jVarK;
                            }
                            jVarC = c(null, cls, m.d(cls, jVarArr));
                        }
                    }
                } else if (jVar.j().i()) {
                    jVarC = c(null, cls, l);
                } else {
                    hVarArr = new h[length];
                    while (i < length) {
                        hVarArr[i] = new h(i);
                    }
                    jVarI = c(null, cls, m.d(cls, hVarArr)).i(jVar._class);
                    if (jVarI != null) {
                        throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", jVar._class.getName(), cls.getName()));
                    }
                    listG = jVar.j().g();
                    listG2 = jVarI.j().g();
                    size = listG2.size();
                    size2 = listG.size();
                    i2 = 0;
                    while (true) {
                        if (i2 < size2) {
                            str = null;
                            break;
                        }
                        jVar2 = listG.get(i2);
                        if (i2 < size) {
                            jVarK2 = listG2.get(i2);
                        } else {
                            jVarK2 = k();
                        }
                        if (f(jVar2, jVarK2)) {
                            if (jVar2._class == Object.class) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                if (i2 != 0) {
                                    if (!jVar2._class.isInterface()) {
                                        cls2 = jVarK2._class;
                                        cls3 = jVar2._class;
                                        if (cls3 != cls2) {
                                            z4 = true;
                                        } else {
                                            z4 = true;
                                        }
                                        if (z4) {
                                        }
                                    }
                                    str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                    break;
                                }
                                if (!jVar2._class.isInterface()) {
                                    cls2 = jVarK2._class;
                                    cls3 = jVar2._class;
                                    if (cls3 != cls2) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                break;
                            }
                            continue;
                        }
                        i2++;
                    }
                    if (str == null) {
                    }
                    jVarArr = new b.g.a.c.j[length];
                    while (i3 < length) {
                        jVarK = hVarArr[i3]._actualType;
                        if (jVarK == null) {
                            jVarK = k();
                        }
                        jVarArr[i3] = jVarK;
                    }
                    jVarC = c(null, cls, m.d(cls, jVarArr));
                }
            } else if (jVar.j().i() && (length = cls.getTypeParameters().length) != 0) {
                hVarArr = new h[length];
                while (i < length) {
                    hVarArr[i] = new h(i);
                }
                jVarI = c(null, cls, m.d(cls, hVarArr)).i(jVar._class);
                if (jVarI != null) {
                    throw new IllegalArgumentException(String.format("Internal error: unable to locate supertype (%s) from resolved subtype %s", jVar._class.getName(), cls.getName()));
                }
                listG = jVar.j().g();
                listG2 = jVarI.j().g();
                size = listG2.size();
                size2 = listG.size();
                i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        str = null;
                        break;
                    }
                    jVar2 = listG.get(i2);
                    if (i2 < size) {
                        jVarK2 = listG2.get(i2);
                    } else {
                        jVarK2 = k();
                    }
                    if (f(jVar2, jVarK2)) {
                        if (jVar2._class == Object.class) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            continue;
                        } else {
                            if (i2 != 0 || !jVar.z()) {
                                if (!jVar2._class.isInterface()) {
                                    cls2 = jVarK2._class;
                                    cls3 = jVar2._class;
                                    if (cls3 != cls2 || cls3.isAssignableFrom(cls2)) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                break;
                            }
                            if (!(jVarK2._class == Object.class)) {
                                if (!jVar2._class.isInterface()) {
                                    cls2 = jVarK2._class;
                                    cls3 = jVar2._class;
                                    if (cls3 != cls2) {
                                        z4 = true;
                                    } else {
                                        z4 = true;
                                    }
                                    if (z4) {
                                    }
                                }
                                str = String.format("Type parameter #%d/%d differs; can not specialize %s with %s", Integer.valueOf(i2 + 1), Integer.valueOf(size2), jVar2.e(), jVarK2.e());
                                break;
                            }
                            continue;
                        }
                    }
                    i2++;
                }
                if (str == null && !z2) {
                    StringBuilder sbU = b.d.b.a.a.U("Failed to specialize base type ");
                    sbU.append(jVar.e());
                    sbU.append(" as ");
                    sbU.append(cls.getName());
                    sbU.append(", problem: ");
                    sbU.append(str);
                    throw new IllegalArgumentException(sbU.toString());
                }
                jVarArr = new b.g.a.c.j[length];
                while (i3 < length) {
                    jVarK = hVarArr[i3]._actualType;
                    if (jVarK == null) {
                        jVarK = k();
                    }
                    jVarArr[i3] = jVarK;
                }
                jVarC = c(null, cls, m.d(cls, jVarArr));
            } else {
                jVarC = c(null, cls, l);
            }
        }
        return jVarC.F(jVar);
    }

    public b.g.a.c.j[] i(b.g.a.c.j jVar, Class<?> cls) {
        b.g.a.c.j jVarI = jVar.i(cls);
        return jVarI == null ? j : jVarI.j().k();
    }

    @Deprecated
    public b.g.a.c.j j(Class<?> cls) {
        b.g.a.c.j jVarA;
        m mVar = l;
        return (!mVar.i() || (jVarA = a(cls)) == null) ? d(cls, mVar, null, null) : jVarA;
    }
}
