package b.g.a.c.g0;

import b.g.a.a.p$b;
import b.g.a.c.g0.u.a0;
import b.g.a.c.g0.u.b0;
import b.g.a.c.g0.u.c0;
import b.g.a.c.g0.u.g0;
import b.g.a.c.g0.u.j0;
import b.g.a.c.g0.u.k0;
import b.g.a.c.g0.u.l0;
import b.g.a.c.g0.u.m0;
import b.g.a.c.g0.u.o0;
import b.g.a.c.g0.u.o0$a;
import b.g.a.c.g0.u.o0$b;
import b.g.a.c.g0.u.o0$c;
import b.g.a.c.g0.u.r0;
import b.g.a.c.g0.u.t0;
import b.g.a.c.g0.u.u;
import b.g.a.c.g0.u.v;
import b.g.a.c.g0.u.v0;
import b.g.a.c.g0.u.w0;
import b.g.a.c.g0.u.x;
import b.g.a.c.g0.u.y;
import b.g.a.c.g0.u.z;
import b.g.a.c.y.e$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: BasicSerializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends q implements Serializable {
    public static final HashMap<String, b.g.a.c.n<?>> j;
    public static final HashMap<String, Class<? extends b.g.a.c.n<?>>> k;
    public final b.g.a.c.z.o _factoryConfig;

    static {
        HashMap<String, Class<? extends b.g.a.c.n<?>>> map = new HashMap<>();
        HashMap<String, b.g.a.c.n<?>> map2 = new HashMap<>();
        map2.put(String.class.getName(), new r0());
        t0 t0Var = t0.k;
        map2.put(StringBuffer.class.getName(), t0Var);
        map2.put(StringBuilder.class.getName(), t0Var);
        map2.put(Character.class.getName(), t0Var);
        map2.put(Character.TYPE.getName(), t0Var);
        map2.put(Integer.class.getName(), new a0(Integer.class));
        Class cls = Integer.TYPE;
        map2.put(cls.getName(), new a0(cls));
        map2.put(Long.class.getName(), new b0(Long.class));
        Class cls2 = Long.TYPE;
        map2.put(cls2.getName(), new b0(cls2));
        String name = Byte.class.getName();
        z zVar = z.k;
        map2.put(name, zVar);
        map2.put(Byte.TYPE.getName(), zVar);
        String name2 = Short.class.getName();
        c0 c0Var = c0.k;
        map2.put(name2, c0Var);
        map2.put(Short.TYPE.getName(), c0Var);
        map2.put(Double.class.getName(), new x(Double.class));
        map2.put(Double.TYPE.getName(), new x(Double.TYPE));
        String name3 = Float.class.getName();
        y yVar = y.k;
        map2.put(name3, yVar);
        map2.put(Float.TYPE.getName(), yVar);
        map2.put(Boolean.TYPE.getName(), new b.g.a.c.g0.u.e(true));
        map2.put(Boolean.class.getName(), new b.g.a.c.g0.u.e(false));
        map2.put(BigInteger.class.getName(), new v(BigInteger.class));
        map2.put(BigDecimal.class.getName(), new v(BigDecimal.class));
        map2.put(Calendar.class.getName(), b.g.a.c.g0.u.h.k);
        map2.put(Date.class.getName(), b.g.a.c.g0.u.k.k);
        HashMap map3 = new HashMap();
        map3.put(URL.class, new t0(URL.class));
        map3.put(URI.class, new t0(URI.class));
        map3.put(Currency.class, new t0(Currency.class));
        map3.put(UUID.class, new w0());
        map3.put(Pattern.class, new t0(Pattern.class));
        map3.put(Locale.class, new t0(Locale.class));
        map3.put(AtomicBoolean.class, k0.class);
        map3.put(AtomicInteger.class, l0.class);
        map3.put(AtomicLong.class, m0.class);
        map3.put(File.class, b.g.a.c.g0.u.o.class);
        map3.put(Class.class, b.g.a.c.g0.u.i.class);
        u uVar = u.k;
        map3.put(Void.class, uVar);
        map3.put(Void.TYPE, uVar);
        for (Map$Entry map$Entry : map3.entrySet()) {
            Object value = map$Entry.getValue();
            if (value instanceof b.g.a.c.n) {
                map2.put(((Class) map$Entry.getKey()).getName(), (b.g.a.c.n) value);
            } else {
                map.put(((Class) map$Entry.getKey()).getName(), (Class) value);
            }
        }
        map.put(b.g.a.c.i0.s.class.getName(), v0.class);
        j = map2;
        k = map;
    }

    public b(b.g.a.c.z.o oVar) {
        this._factoryConfig = oVar == null ? new b.g.a.c.z.o() : oVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x015a  */
    /* JADX WARN: Code duplicated, block: B:116:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x01a8 A[PHI: r3
      0x01a8: PHI (r3v6 b.g.a.c.n<java.lang.Object>) = (r3v5 b.g.a.c.n<java.lang.Object>), (r3v9 b.g.a.c.n<java.lang.Object>) binds: [B:20:0x0046, B:86:0x0121] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // b.g.a.c.g0.q
    public b.g.a.c.n<Object> a(b.g.a.c.x xVar, b.g.a.c.j jVar, b.g.a.c.n<Object> nVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarB;
        b.g.a.c.c0.i iVarB;
        o0$a o0_a;
        b.g.a.c.v vVar = xVar._config;
        b.g.a.c.c cVarU = vVar.u(jVar);
        r[] rVarArr = this._factoryConfig._additionalKeySerializers;
        if (rVarArr.length > 0) {
            b.g.a.c.i0.b bVar = new b.g.a.c.i0.b(rVarArr);
            nVarB = null;
            while (bVar.hasNext() && (nVarB = ((r) bVar.next()).b(vVar, jVar, cVarU)) == null) {
            }
        } else {
            nVarB = null;
        }
        if (nVarB == null) {
            b.g.a.c.c0.q qVar = (b.g.a.c.c0.q) cVarU;
            b.g.a.c.c0.c cVar = qVar.f;
            Object objL = xVar.v().l(cVar);
            b.g.a.c.n<Object> nVarH = objL != null ? xVar.H(cVar, objL) : null;
            if (nVarH != null) {
                nVar = nVarH;
            } else if (nVar == null) {
                Class cls = jVar._class;
                b.g.a.c.n<Object> nVar2 = o0.a;
                if (cls == null || cls == Object.class) {
                    nVarH = new o0$b();
                } else if (cls == String.class) {
                    nVarH = o0.a;
                } else {
                    if (cls.isPrimitive()) {
                        Annotation[] annotationArr = b.g.a.c.i0.d.a;
                        if (cls == Integer.TYPE) {
                            cls = Integer.class;
                        } else if (cls == Long.TYPE) {
                            cls = Long.class;
                        } else if (cls == Boolean.TYPE) {
                            cls = Boolean.class;
                        } else if (cls == Double.TYPE) {
                            cls = Double.class;
                        } else if (cls == Float.TYPE) {
                            cls = Float.class;
                        } else if (cls == Byte.TYPE) {
                            cls = Byte.class;
                        } else if (cls == Short.TYPE) {
                            cls = Short.class;
                        } else {
                            if (cls != Character.TYPE) {
                                throw new IllegalArgumentException(b.d.b.a.a.o(cls, b.d.b.a.a.U("Class "), " is not a primitive type"));
                            }
                            cls = Character.class;
                        }
                    }
                    if (cls == Integer.class) {
                        o0_a = new o0$a(5, cls);
                    } else if (cls == Long.class) {
                        o0_a = new o0$a(6, cls);
                    } else if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
                        o0_a = new o0$a(8, cls);
                    } else if (cls == Class.class) {
                        o0_a = new o0$a(3, cls);
                    } else if (Date.class.isAssignableFrom(cls)) {
                        o0_a = new o0$a(1, cls);
                    } else if (Calendar.class.isAssignableFrom(cls)) {
                        o0_a = new o0$a(2, cls);
                    } else if (cls == UUID.class) {
                        o0_a = new o0$a(8, cls);
                    } else if (cls == byte[].class) {
                        o0_a = new o0$a(7, cls);
                    } else {
                        nVarH = null;
                    }
                    nVarH = o0_a;
                }
                if (nVarH == null) {
                    b.g.a.c.c0.b0 b0Var = qVar.c;
                    if (b0Var != null) {
                        if (!b0Var.i) {
                            b0Var.h();
                        }
                        LinkedList<b.g.a.c.c0.i> linkedList = b0Var.q;
                        if (linkedList == null) {
                            iVarB = null;
                        } else {
                            if (linkedList.size() > 1) {
                                b0Var.i("Multiple 'as-key' properties defined (%s vs %s)", b0Var.q.get(0), b0Var.q.get(1));
                                throw null;
                            }
                            iVarB = b0Var.q.get(0);
                        }
                    } else {
                        iVarB = null;
                    }
                    if (iVarB == null) {
                        iVarB = cVarU.b();
                    }
                    if (iVarB != null) {
                        b.g.a.c.n<Object> nVarA = a(xVar, iVarB.e(), nVar);
                        if (vVar.b()) {
                            b.g.a.c.i0.d.d(iVarB.i(), vVar.q(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        nVar = new b.g.a.c.g0.u.s(iVarB, null, nVarA);
                    } else {
                        Class<?> cls2 = jVar._class;
                        if (cls2 == null) {
                            nVar = new o0$a(8, cls2);
                        } else if (cls2 == Enum.class) {
                            nVar = new o0$b();
                        } else if (b.g.a.c.i0.d.q(cls2)) {
                            nVar = new o0$c(cls2, b.g.a.c.i0.f.a(vVar, cls2));
                        } else {
                            nVar = new o0$a(8, cls2);
                        }
                    }
                } else {
                    nVar = nVarH;
                }
            }
        } else {
            nVar = nVarB;
        }
        if (this._factoryConfig.a()) {
            b.g.a.c.i0.b bVar2 = (b.g.a.c.i0.b) this._factoryConfig.b();
            while (bVar2.hasNext()) {
                Objects.requireNonNull((g) bVar2.next());
            }
        }
        return nVar;
    }

    @Override // b.g.a.c.g0.q
    public b.g.a.c.e0.g c(b.g.a.c.v vVar, b.g.a.c.j jVar) {
        ArrayList arrayList;
        b.g.a.c.c0.c cVar = ((b.g.a.c.c0.q) vVar.o(jVar._class)).f;
        b.g.a.c.e0.f<?> fVarP = vVar.e().P(vVar, cVar, jVar);
        if (fVarP == null) {
            fVarP = vVar._base._typeResolverBuilder;
            arrayList = null;
        } else {
            b.g.a.c.e0.h.i iVar = (b.g.a.c.e0.h.i) vVar._subtypeResolver;
            Objects.requireNonNull(iVar);
            b.g.a.c.b bVarE = vVar.e();
            HashMap<b.g.a.c.e0.b, b.g.a.c.e0.b> map = new HashMap<>();
            LinkedHashSet<b.g.a.c.e0.b> linkedHashSet = iVar._registeredSubtypes;
            if (linkedHashSet != null) {
                Class<?> cls = cVar.l;
                for (b.g.a.c.e0.b bVar : linkedHashSet) {
                    if (cls.isAssignableFrom(bVar._class)) {
                        iVar.b(b.g.a.c.c0.d.h(vVar, bVar._class), bVar, vVar, bVarE, map);
                    }
                }
            }
            iVar.b(cVar, new b.g.a.c.e0.b(cVar.l, null), vVar, bVarE, map);
            arrayList = new ArrayList(map.values());
        }
        if (fVarP == null) {
            return null;
        }
        return fVarP.e(vVar, jVar, arrayList);
    }

    public p$b d(b.g.a.c.x xVar, b.g.a.c.c cVar, b.g.a.c.j jVar, Class<?> cls) throws JsonMappingException {
        b.g.a.c.v vVar = xVar._config;
        p$b p_bC = cVar.c(vVar._configOverrides._defaultInclusion);
        vVar._configOverrides.a(cls);
        vVar.k(jVar._class, null);
        return p_bC;
    }

    public final b.g.a.c.n<?> e(b.g.a.c.x xVar, b.g.a.c.j jVar, b.g.a.c.c cVar) throws JsonMappingException {
        if (b.g.a.c.m.class.isAssignableFrom(jVar._class)) {
            return g0.k;
        }
        b.g.a.c.c0.i iVarB = cVar.b();
        if (iVarB == null) {
            return null;
        }
        if (xVar._config.b()) {
            b.g.a.c.i0.d.d(iVarB.i(), xVar.C(b.g.a.c.p.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        b.g.a.c.j jVarE = iVarB.e();
        b.g.a.c.n<Object> nVarF = f(xVar, iVarB);
        if (nVarF == null) {
            nVarF = (b.g.a.c.n) jVarE._valueHandler;
        }
        b.g.a.c.e0.g gVarC = (b.g.a.c.e0.g) jVarE._typeHandler;
        if (gVarC == null) {
            gVarC = c(xVar._config, jVarE);
        }
        return new b.g.a.c.g0.u.s(iVarB, gVarC, nVarF);
    }

    public b.g.a.c.n<Object> f(b.g.a.c.x xVar, b.g.a.c.c0.b bVar) throws JsonMappingException {
        Object objL = xVar.v().L(bVar);
        if (objL == null) {
            return null;
        }
        b.g.a.c.n<Object> nVarH = xVar.H(bVar, objL);
        Object objH = xVar.v().H(bVar);
        b.g.a.c.i0.e<Object, Object> eVarC = objH != null ? xVar.c(bVar, objH) : null;
        return eVarC == null ? nVarH : new j0(eVarC, eVarC.a(xVar.d()), nVarH);
    }

    public boolean g(b.g.a.c.v vVar, b.g.a.c.c cVar, b.g.a.c.e0.g gVar) {
        e$b e_bK = vVar.e().K(((b.g.a.c.c0.q) cVar).f);
        if (e_bK == null || e_bK == e$b.DEFAULT_TYPING) {
            return vVar.q(b.g.a.c.p.USE_STATIC_TYPING);
        }
        return e_bK == e$b.STATIC;
    }
}
