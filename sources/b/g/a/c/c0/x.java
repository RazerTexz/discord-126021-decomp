package b.g.a.c.c0;

import b.g.a.a.a0$a;
import b.g.a.a.h0;
import b.g.a.a.i$a;
import b.g.a.a.i$b;
import b.g.a.a.i$c;
import b.g.a.a.i$d;
import b.g.a.a.k0;
import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.a.q$a;
import b.g.a.a.u$a;
import b.g.a.c.b$a;
import b.g.a.c.n$a;
import b.g.a.c.y.b$b;
import b.g.a.c.y.e$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: JacksonAnnotationIntrospector.java */
/* JADX INFO: loaded from: classes3.dex */
public class x extends b.g.a.c.b implements Serializable {
    public static final Class<? extends Annotation>[] j = {b.g.a.c.y.e.class, b.g.a.a.g0.class, b.g.a.a.i.class, b.g.a.a.c0.class, b.g.a.a.x.class, b.g.a.a.e0.class, b.g.a.a.f.class, b.g.a.a.s.class};
    public static final Class<? extends Annotation>[] k = {b.g.a.c.y.c.class, b.g.a.a.g0.class, b.g.a.a.i.class, b.g.a.a.c0.class, b.g.a.a.e0.class, b.g.a.a.f.class, b.g.a.a.s.class, b.g.a.a.t.class};
    public static final b.g.a.c.b0.c l;
    private static final long serialVersionUID = 1;
    public transient b.g.a.c.i0.h<Class<?>, Boolean> m = new b.g.a.c.i0.h<>(48, 48);
    public boolean _cfgConstructorPropertiesImpliesCreator = true;

    static {
        b.g.a.c.b0.c cVar;
        try {
            cVar = b.g.a.c.b0.c.a;
        } catch (Throwable unused) {
            cVar = null;
        }
        l = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.HashSet] */
    @Override // b.g.a.c.b
    public q$a A(b.g.a.c.z.l<?> lVar, b bVar) {
        ?? EmptySet;
        b.g.a.a.q qVar = (b.g.a.a.q) bVar.b(b.g.a.a.q.class);
        if (qVar == null) {
            return q$a.j;
        }
        String[] strArrValue = qVar.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return new q$a(EmptySet);
    }

    @Override // b.g.a.c.b
    public Integer B(b bVar) {
        int iIndex;
        b.g.a.a.u uVar = (b.g.a.a.u) bVar.b(b.g.a.a.u.class);
        if (uVar == null || (iIndex = uVar.index()) == -1) {
            return null;
        }
        return Integer.valueOf(iIndex);
    }

    @Override // b.g.a.c.b
    public b.g.a.c.e0.f<?> C(b.g.a.c.z.l<?> lVar, i iVar, b.g.a.c.j jVar) {
        if (jVar.v() || jVar.b()) {
            return null;
        }
        return h0(lVar, iVar, jVar);
    }

    @Override // b.g.a.c.b
    public b$a D(i iVar) {
        b.g.a.a.s sVar = (b.g.a.a.s) iVar.b(b.g.a.a.s.class);
        if (sVar != null) {
            return new b$a(1, sVar.value());
        }
        b.g.a.a.f fVar = (b.g.a.a.f) iVar.b(b.g.a.a.f.class);
        if (fVar != null) {
            return new b$a(2, fVar.value());
        }
        return null;
    }

    @Override // b.g.a.c.b
    public b.g.a.c.t E(b.g.a.c.z.l<?> lVar, g gVar, b.g.a.c.t tVar) {
        return null;
    }

    @Override // b.g.a.c.b
    public b.g.a.c.t F(c cVar) {
        b.g.a.a.y yVar = (b.g.a.a.y) cVar.b(b.g.a.a.y.class);
        if (yVar == null) {
            return null;
        }
        String strNamespace = yVar.namespace();
        return b.g.a.c.t.b(yVar.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
    }

    @Override // b.g.a.c.b
    public Object G(i iVar) {
        Class<?> clsG0;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) iVar.b(b.g.a.c.y.e.class);
        if (eVar == null || (clsG0 = g0(eVar.contentConverter())) == null || clsG0 == b.g.a.c.i0.e$a.class) {
            return null;
        }
        return clsG0;
    }

    @Override // b.g.a.c.b
    public Object H(b bVar) {
        Class<?> clsG0;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar == null || (clsG0 = g0(eVar.converter())) == null || clsG0 == b.g.a.c.i0.e$a.class) {
            return null;
        }
        return clsG0;
    }

    @Override // b.g.a.c.b
    public String[] I(c cVar) {
        b.g.a.a.w wVar = (b.g.a.a.w) cVar.b(b.g.a.a.w.class);
        if (wVar == null) {
            return null;
        }
        return wVar.value();
    }

    @Override // b.g.a.c.b
    public Boolean J(b bVar) {
        b.g.a.a.w wVar = (b.g.a.a.w) bVar.b(b.g.a.a.w.class);
        if (wVar == null || !wVar.alphabetic()) {
            return null;
        }
        return Boolean.TRUE;
    }

    @Override // b.g.a.c.b
    public e$b K(b bVar) {
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar == null) {
            return null;
        }
        return eVar.typing();
    }

    @Override // b.g.a.c.b
    public Object L(b bVar) {
        Class<? extends b.g.a.c.n> clsUsing;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar != null && (clsUsing = eVar.using()) != n$a.class) {
            return clsUsing;
        }
        b.g.a.a.x xVar = (b.g.a.a.x) bVar.b(b.g.a.a.x.class);
        if (xVar == null || !xVar.value()) {
            return null;
        }
        return new b.g.a.c.g0.u.e0(bVar.d());
    }

    @Override // b.g.a.c.b
    public b.g.a.a.z$a M(b bVar) {
        b.g.a.a.z zVar = (b.g.a.a.z) bVar.b(b.g.a.a.z.class);
        if (zVar == null) {
            return b.g.a.a.z$a.j;
        }
        h0 h0VarNulls = zVar.nulls();
        h0 h0VarContentNulls = zVar.contentNulls();
        h0 h0Var = h0.DEFAULT;
        if (h0VarNulls == null) {
            h0VarNulls = h0Var;
        }
        if (h0VarContentNulls == null) {
            h0VarContentNulls = h0Var;
        }
        return h0VarNulls == h0Var && h0VarContentNulls == h0Var ? b.g.a.a.z$a.j : new b.g.a.a.z$a(h0VarNulls, h0VarContentNulls);
    }

    @Override // b.g.a.c.b
    public List<b.g.a.c.e0.b> N(b bVar) {
        b.g.a.a.a0 a0Var = (b.g.a.a.a0) bVar.b(b.g.a.a.a0.class);
        if (a0Var == null) {
            return null;
        }
        a0$a[] a0_aArrValue = a0Var.value();
        ArrayList arrayList = new ArrayList(a0_aArrValue.length);
        for (a0$a a0_a : a0_aArrValue) {
            arrayList.add(new b.g.a.c.e0.b(a0_a.value(), a0_a.name()));
            for (String str : a0_a.names()) {
                arrayList.add(new b.g.a.c.e0.b(a0_a.value(), str));
            }
        }
        return arrayList;
    }

    @Override // b.g.a.c.b
    public String O(c cVar) {
        b.g.a.a.d0 d0Var = (b.g.a.a.d0) cVar.b(b.g.a.a.d0.class);
        if (d0Var == null) {
            return null;
        }
        return d0Var.value();
    }

    @Override // b.g.a.c.b
    public b.g.a.c.e0.f<?> P(b.g.a.c.z.l<?> lVar, c cVar, b.g.a.c.j jVar) {
        return h0(lVar, cVar, jVar);
    }

    @Override // b.g.a.c.b
    public b.g.a.c.i0.n Q(i iVar) {
        b.g.a.a.e0 e0Var = (b.g.a.a.e0) iVar.b(b.g.a.a.e0.class);
        if (e0Var == null || !e0Var.enabled()) {
            return null;
        }
        String strPrefix = e0Var.prefix();
        String strSuffix = e0Var.suffix();
        boolean z2 = false;
        boolean z3 = (strPrefix == null || strPrefix.isEmpty()) ? false : true;
        if (strSuffix != null && !strSuffix.isEmpty()) {
            z2 = true;
        }
        if (z3) {
            return z2 ? new b.g.a.c.i0.k(strPrefix, strSuffix) : new b.g.a.c.i0.l(strPrefix);
        }
        return z2 ? new b.g.a.c.i0.m(strSuffix) : b.g.a.c.i0.n.j;
    }

    @Override // b.g.a.c.b
    public Class<?>[] R(b bVar) {
        b.g.a.a.g0 g0Var = (b.g.a.a.g0) bVar.b(b.g.a.a.g0.class);
        if (g0Var == null) {
            return null;
        }
        return g0Var.value();
    }

    @Override // b.g.a.c.b
    public Boolean S(b bVar) {
        b.g.a.a.c cVar = (b.g.a.a.c) bVar.b(b.g.a.a.c.class);
        if (cVar == null) {
            return null;
        }
        return Boolean.valueOf(cVar.enabled());
    }

    @Override // b.g.a.c.b
    @Deprecated
    public boolean T(j jVar) {
        return jVar.k(b.g.a.a.c.class);
    }

    @Override // b.g.a.c.b
    public Boolean U(b bVar) {
        b.g.a.a.d dVar = (b.g.a.a.d) bVar.b(b.g.a.a.d.class);
        if (dVar == null) {
            return null;
        }
        return Boolean.valueOf(dVar.enabled());
    }

    @Override // b.g.a.c.b
    public Boolean V(b.g.a.c.z.l<?> lVar, b bVar) {
        b.g.a.a.r rVar = (b.g.a.a.r) bVar.b(b.g.a.a.r.class);
        if (rVar == null) {
            return null;
        }
        return Boolean.valueOf(rVar.value());
    }

    @Override // b.g.a.c.b
    public Boolean W(b bVar) {
        b.g.a.a.f0 f0Var = (b.g.a.a.f0) bVar.b(b.g.a.a.f0.class);
        if (f0Var == null) {
            return null;
        }
        return Boolean.valueOf(f0Var.value());
    }

    @Override // b.g.a.c.b
    @Deprecated
    public boolean X(j jVar) {
        b.g.a.a.f0 f0Var = (b.g.a.a.f0) jVar.b(b.g.a.a.f0.class);
        return f0Var != null && f0Var.value();
    }

    @Override // b.g.a.c.b
    @Deprecated
    public boolean Y(b bVar) {
        b.g.a.c.b0.c cVar;
        Boolean boolC;
        b.g.a.a.g gVar = (b.g.a.a.g) bVar.b(b.g.a.a.g.class);
        if (gVar != null) {
            return gVar.mode() != b.g.a.a.g$a.DISABLED;
        }
        if (!this._cfgConstructorPropertiesImpliesCreator || !(bVar instanceof e) || (cVar = l) == null || (boolC = cVar.c(bVar)) == null) {
            return false;
        }
        return boolC.booleanValue();
    }

    @Override // b.g.a.c.b
    public boolean Z(i iVar) {
        Boolean boolB;
        b.g.a.a.m mVar = (b.g.a.a.m) iVar.b(b.g.a.a.m.class);
        if (mVar != null) {
            return mVar.value();
        }
        b.g.a.c.b0.c cVar = l;
        if (cVar == null || (boolB = cVar.b(iVar)) == null) {
            return false;
        }
        return boolB.booleanValue();
    }

    @Override // b.g.a.c.b
    public void a(b.g.a.c.z.l<?> lVar, c cVar, List<b.g.a.c.g0.c> list) {
        b.g.a.c.y.b bVar = (b.g.a.c.y.b) cVar.t.a(b.g.a.c.y.b.class);
        if (bVar == null) {
            return;
        }
        boolean zPrepend = bVar.prepend();
        b.g.a.c.y.b$a[] b_aArrAttrs = bVar.attrs();
        int length = b_aArrAttrs.length;
        b.g.a.c.h0.c cVar2 = null;
        b.g.a.c.j jVarB = null;
        int i = 0;
        while (i < length) {
            if (jVarB == null) {
                jVarB = lVar._base._typeFactory.b(cVar2, Object.class, b.g.a.c.h0.n.l);
            }
            b.g.a.c.y.b$a b_a = b_aArrAttrs[i];
            b.g.a.c.s sVar = b_a.required() ? b.g.a.c.s.j : b.g.a.c.s.k;
            String strValue = b_a.value();
            b.g.a.c.t tVarJ0 = j0(b_a.propName(), b_a.propNamespace());
            if (!tVarJ0.c()) {
                tVarJ0 = b.g.a.c.t.a(strValue);
            }
            b.g.a.c.g0.t.a aVar = new b.g.a.c.g0.t.a(strValue, b.g.a.c.i0.q.w(lVar, new f0(cVar, cVar.l, strValue, jVarB), tVarJ0, sVar, b_a.include()), cVar.t, jVarB);
            if (zPrepend) {
                list.add(i, aVar);
            } else {
                list.add(aVar);
            }
            i++;
            cVar2 = null;
        }
        b$b[] b_bArrProps = bVar.props();
        int length2 = b_bArrProps.length;
        for (int i2 = 0; i2 < length2; i2++) {
            b$b b_b = b_bArrProps[i2];
            b.g.a.c.s sVar2 = b_b.required() ? b.g.a.c.s.j : b.g.a.c.s.k;
            b.g.a.c.t tVarJ1 = j0(b_b.name(), b_b.namespace());
            b.g.a.c.j jVarD = lVar.d(b_b.type());
            b.g.a.c.i0.q qVarW = b.g.a.c.i0.q.w(lVar, new f0(cVar, cVar.l, tVarJ1._simpleName, jVarD), tVarJ1, sVar2, b_b.include());
            Class<? extends b.g.a.c.g0.s> clsValue = b_b.value();
            Objects.requireNonNull(lVar._base);
            b.g.a.c.g0.s sVarK = ((b.g.a.c.g0.s) b.g.a.c.i0.d.g(clsValue, lVar.b())).k(lVar, cVar, qVarW, jVarD);
            if (zPrepend) {
                list.add(i2, sVarK);
            } else {
                list.add(sVarK);
            }
        }
    }

    @Override // b.g.a.c.b
    public Boolean a0(i iVar) {
        b.g.a.a.u uVar = (b.g.a.a.u) iVar.b(b.g.a.a.u.class);
        if (uVar != null) {
            return Boolean.valueOf(uVar.required());
        }
        return null;
    }

    @Override // b.g.a.c.b
    public g0<?> b(c cVar, g0<?> g0Var) {
        b.g.a.a.e eVar = (b.g.a.a.e) cVar.b(b.g.a.a.e.class);
        if (eVar == null) {
            return g0Var;
        }
        g0$a g0_a = (g0$a) g0Var;
        Objects.requireNonNull(g0_a);
        return g0_a.b(g0_a.a(g0_a._getterMinLevel, eVar.getterVisibility()), g0_a.a(g0_a._isGetterMinLevel, eVar.isGetterVisibility()), g0_a.a(g0_a._setterMinLevel, eVar.setterVisibility()), g0_a.a(g0_a._creatorMinLevel, eVar.creatorVisibility()), g0_a.a(g0_a._fieldMinLevel, eVar.fieldVisibility()));
    }

    @Override // b.g.a.c.b
    public boolean b0(Annotation annotation) {
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        Boolean boolValueOf = this.m.get(clsAnnotationType);
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(clsAnnotationType.getAnnotation(b.g.a.a.a.class) != null);
            this.m.putIfAbsent(clsAnnotationType, boolValueOf);
        }
        return boolValueOf.booleanValue();
    }

    @Override // b.g.a.c.b
    public Object c(b bVar) {
        Class<? extends b.g.a.c.n> clsContentUsing;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar == null || (clsContentUsing = eVar.contentUsing()) == n$a.class) {
            return null;
        }
        return clsContentUsing;
    }

    @Override // b.g.a.c.b
    public Boolean c0(c cVar) {
        b.g.a.a.o oVar = (b.g.a.a.o) cVar.b(b.g.a.a.o.class);
        if (oVar == null) {
            return null;
        }
        return Boolean.valueOf(oVar.value());
    }

    @Override // b.g.a.c.b
    public b.g.a.a.g$a d(b.g.a.c.z.l<?> lVar, b bVar) {
        b.g.a.c.b0.c cVar;
        Boolean boolC;
        b.g.a.a.g gVar = (b.g.a.a.g) bVar.b(b.g.a.a.g.class);
        if (gVar != null) {
            return gVar.mode();
        }
        if (this._cfgConstructorPropertiesImpliesCreator && lVar.q(b.g.a.c.p.INFER_CREATOR_FROM_CONSTRUCTOR_PROPERTIES) && (bVar instanceof e) && (cVar = l) != null && (boolC = cVar.c(bVar)) != null && boolC.booleanValue()) {
            return b.g.a.a.g$a.PROPERTIES;
        }
        return null;
    }

    @Override // b.g.a.c.b
    public Boolean d0(i iVar) {
        return Boolean.valueOf(iVar.k(b.g.a.a.b0.class));
    }

    @Override // b.g.a.c.b
    @Deprecated
    public b.g.a.a.g$a e(b bVar) {
        b.g.a.a.g gVar = (b.g.a.a.g) bVar.b(b.g.a.a.g.class);
        if (gVar == null) {
            return null;
        }
        return gVar.mode();
    }

    @Override // b.g.a.c.b
    public b.g.a.c.j e0(b.g.a.c.z.l<?> lVar, b bVar, b.g.a.c.j jVar) throws JsonMappingException {
        b.g.a.c.j jVarG;
        b.g.a.c.j jVarG2;
        b.g.a.c.h0.n nVar = lVar._base._typeFactory;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        Class<?> clsG0 = eVar == null ? null : g0(eVar.as());
        if (clsG0 != null) {
            Class<?> cls = jVar._class;
            if (cls == clsG0) {
                jVar = jVar.G();
            } else {
                try {
                    if (clsG0.isAssignableFrom(cls)) {
                        jVar = nVar.g(jVar, clsG0);
                    } else if (cls.isAssignableFrom(clsG0)) {
                        jVar = nVar.h(jVar, clsG0, false);
                    } else {
                        if (!i0(cls, clsG0)) {
                            throw new JsonMappingException(null, String.format("Cannot refine serialization type %s into %s; types not related", jVar, clsG0.getName()));
                        }
                        jVar = jVar.G();
                    }
                } catch (IllegalArgumentException e) {
                    throw new JsonMappingException(null, String.format("Failed to widen type %s with annotation (value %s), from '%s': %s", jVar, clsG0.getName(), bVar.c(), e.getMessage()), e);
                }
            }
        }
        if (jVar.z()) {
            b.g.a.c.j jVarO = jVar.o();
            Class<?> clsG1 = eVar == null ? null : g0(eVar.keyAs());
            if (clsG1 != null) {
                Class<?> cls2 = jVarO._class;
                if (cls2 == clsG1) {
                    jVarG2 = jVarO.G();
                } else {
                    try {
                        if (clsG1.isAssignableFrom(cls2)) {
                            jVarG2 = nVar.g(jVarO, clsG1);
                        } else if (cls2.isAssignableFrom(clsG1)) {
                            jVarG2 = nVar.h(jVarO, clsG1, false);
                        } else {
                            if (!i0(cls2, clsG1)) {
                                throw new JsonMappingException(null, String.format("Cannot refine serialization key type %s into %s; types not related", jVarO, clsG1.getName()));
                            }
                            jVarG2 = jVarO.G();
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new JsonMappingException(null, String.format("Failed to widen key type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, clsG1.getName(), bVar.c(), e2.getMessage()), e2);
                    }
                }
                jVar = ((b.g.a.c.h0.f) jVar).M(jVarG2);
            }
        }
        b.g.a.c.j jVarK = jVar.k();
        if (jVarK == null) {
            return jVar;
        }
        Class<?> clsG2 = eVar == null ? null : g0(eVar.contentAs());
        if (clsG2 == null) {
            return jVar;
        }
        Class<?> cls3 = jVarK._class;
        if (cls3 == clsG2) {
            jVarG = jVarK.G();
        } else {
            try {
                if (clsG2.isAssignableFrom(cls3)) {
                    jVarG = nVar.g(jVarK, clsG2);
                } else if (cls3.isAssignableFrom(clsG2)) {
                    jVarG = nVar.h(jVarK, clsG2, false);
                } else {
                    if (!i0(cls3, clsG2)) {
                        throw new JsonMappingException(null, String.format("Cannot refine serialization content type %s into %s; types not related", jVarK, clsG2.getName()));
                    }
                    jVarG = jVarK.G();
                }
            } catch (IllegalArgumentException e3) {
                throw new JsonMappingException(null, String.format("Internal error: failed to refine value type of %s with concrete-type annotation (value %s), from '%s': %s", jVar, clsG2.getName(), bVar.c(), e3.getMessage()), e3);
            }
        }
        return jVar.D(jVarG);
    }

    @Override // b.g.a.c.b
    public String[] f(Class<?> cls, Enum<?>[] enumArr, String[] strArr) {
        b.g.a.a.u uVar;
        HashMap map = null;
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && (uVar = (b.g.a.a.u) field.getAnnotation(b.g.a.a.u.class)) != null) {
                String strValue = uVar.value();
                if (!strValue.isEmpty()) {
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(field.getName(), strValue);
                }
            }
        }
        if (map != null) {
            int length = enumArr.length;
            for (int i = 0; i < length; i++) {
                String str = (String) map.get(enumArr[i].name());
                if (str != null) {
                    strArr[i] = str;
                }
            }
        }
        return strArr;
    }

    @Override // b.g.a.c.b
    public j f0(b.g.a.c.z.l<?> lVar, j jVar, j jVar2) {
        Class<?> clsP = jVar.p(0);
        Class<?> clsP2 = jVar2.p(0);
        if (clsP.isPrimitive()) {
            if (!clsP2.isPrimitive()) {
                return jVar;
            }
        } else if (clsP2.isPrimitive()) {
            return jVar2;
        }
        if (clsP == String.class) {
            if (clsP2 != String.class) {
                return jVar;
            }
            return null;
        }
        if (clsP2 == String.class) {
            return jVar2;
        }
        return null;
    }

    @Override // b.g.a.c.b
    public Object g(b bVar) {
        b.g.a.a.h hVar = (b.g.a.a.h) bVar.b(b.g.a.a.h.class);
        if (hVar == null) {
            return null;
        }
        String strValue = hVar.value();
        if (strValue.isEmpty()) {
            return null;
        }
        return strValue;
    }

    public Class<?> g0(Class<?> cls) {
        if (cls == null || b.g.a.c.i0.d.p(cls)) {
            return null;
        }
        return cls;
    }

    @Override // b.g.a.c.b
    public i$d h(b bVar) {
        b.g.a.a.i iVar = (b.g.a.a.i) bVar.b(b.g.a.a.i.class);
        if (iVar == null) {
            return null;
        }
        String strPattern = iVar.pattern();
        i$c i_cShape = iVar.shape();
        String strLocale = iVar.locale();
        String strTimezone = iVar.timezone();
        i$a[] i_aArrWith = iVar.with();
        i$a[] i_aArrWithout = iVar.without();
        int iOrdinal = 0;
        for (i$a i_a : i_aArrWith) {
            iOrdinal |= 1 << i_a.ordinal();
        }
        int iOrdinal2 = 0;
        for (i$a i_a2 : i_aArrWithout) {
            iOrdinal2 |= 1 << i_a2.ordinal();
        }
        return new i$d(strPattern, i_cShape, strLocale, strTimezone, new i$b(iOrdinal, iOrdinal2), iVar.lenient().f());
    }

    public b.g.a.c.e0.f<?> h0(b.g.a.c.z.l<?> lVar, b bVar, b.g.a.c.j jVar) {
        b.g.a.c.e0.f jVar2;
        b.g.a.a.c0 c0Var = (b.g.a.a.c0) bVar.b(b.g.a.a.c0.class);
        b.g.a.c.y.g gVar = (b.g.a.c.y.g) bVar.b(b.g.a.c.y.g.class);
        b.g.a.c.e0.e eVar = null;
        if (gVar != null) {
            if (c0Var == null) {
                return null;
            }
            Class<? extends b.g.a.c.e0.f<?>> clsValue = gVar.value();
            Objects.requireNonNull(lVar._base);
            jVar2 = (b.g.a.c.e0.f) b.g.a.c.i0.d.g(clsValue, lVar.b());
        } else {
            if (c0Var == null) {
                return null;
            }
            b.g.a.a.c0$b c0_bUse = c0Var.use();
            b.g.a.a.c0$b c0_b = b.g.a.a.c0$b.NONE;
            if (c0_bUse == c0_b) {
                b.g.a.c.e0.h.j jVar3 = new b.g.a.c.e0.h.j();
                jVar3.g(c0_b, null);
                return jVar3;
            }
            jVar2 = new b.g.a.c.e0.h.j();
        }
        b.g.a.c.y.f fVar = (b.g.a.c.y.f) bVar.b(b.g.a.c.y.f.class);
        if (fVar != null) {
            Class<? extends b.g.a.c.e0.e> clsValue2 = fVar.value();
            Objects.requireNonNull(lVar._base);
            eVar = (b.g.a.c.e0.e) b.g.a.c.i0.d.g(clsValue2, lVar.b());
        }
        if (eVar != null) {
            eVar.b(jVar);
        }
        b.g.a.c.e0.f fVarB = jVar2.b(c0Var.use(), eVar);
        b.g.a.a.c0$a c0_aInclude = c0Var.include();
        if (c0_aInclude == b.g.a.a.c0$a.EXTERNAL_PROPERTY && (bVar instanceof c)) {
            c0_aInclude = b.g.a.a.c0$a.PROPERTY;
        }
        b.g.a.c.e0.f fVarC = fVarB.f(c0_aInclude).c(c0Var.property());
        Class<?> clsDefaultImpl = c0Var.defaultImpl();
        if (clsDefaultImpl != b.g.a.a.c0$c.class && !clsDefaultImpl.isAnnotation()) {
            fVarC = fVarC.d(clsDefaultImpl);
        }
        return fVarC.a(c0Var.visible());
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    @Override // b.g.a.c.b
    public String i(i iVar) {
        b.g.a.c.t tVarA;
        b.g.a.c.b0.c cVar;
        if (iVar instanceof m) {
            m mVar = (m) iVar;
            if (mVar._owner == null || (cVar = l) == null || (tVarA = cVar.a(mVar)) == null) {
                tVarA = null;
            }
        } else {
            tVarA = null;
        }
        if (tVarA == null) {
            return null;
        }
        return tVarA._simpleName;
    }

    public final boolean i0(Class<?> cls, Class<?> cls2) {
        if (cls.isPrimitive()) {
            return cls == b.g.a.c.i0.d.v(cls2);
        }
        return cls2.isPrimitive() && cls2 == b.g.a.c.i0.d.v(cls);
    }

    @Override // b.g.a.c.b
    public b.g.a.a.b$a j(i iVar) {
        String name;
        b.g.a.a.b bVar = (b.g.a.a.b) iVar.b(b.g.a.a.b.class);
        if (bVar == null) {
            return null;
        }
        b.g.a.a.b$a b_aA = b.g.a.a.b$a.a(bVar.value(), bVar.useInput().f());
        if (b_aA._id != null) {
            return b_aA;
        }
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            name = jVar.o() == 0 ? iVar.d().getName() : jVar.p(0).getName();
        } else {
            name = iVar.d().getName();
        }
        return name.equals(b_aA._id) ? b_aA : new b.g.a.a.b$a(name, b_aA._useInput);
    }

    public b.g.a.c.t j0(String str, String str2) {
        if (str.isEmpty()) {
            return b.g.a.c.t.j;
        }
        return (str2 == null || str2.isEmpty()) ? b.g.a.c.t.a(str) : b.g.a.c.t.b(str, str2);
    }

    @Override // b.g.a.c.b
    @Deprecated
    public Object k(i iVar) {
        b.g.a.a.b$a b_aJ = j(iVar);
        if (b_aJ == null) {
            return null;
        }
        return b_aJ._id;
    }

    @Override // b.g.a.c.b
    public Object l(b bVar) {
        Class<? extends b.g.a.c.n> clsKeyUsing;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar == null || (clsKeyUsing = eVar.keyUsing()) == n$a.class) {
            return null;
        }
        return clsKeyUsing;
    }

    @Override // b.g.a.c.b
    public Boolean m(b bVar) {
        b.g.a.a.t tVar = (b.g.a.a.t) bVar.b(b.g.a.a.t.class);
        if (tVar == null) {
            return null;
        }
        return tVar.value().f();
    }

    @Override // b.g.a.c.b
    public b.g.a.c.t n(b bVar) {
        boolean z2;
        b.g.a.a.z zVar = (b.g.a.a.z) bVar.b(b.g.a.a.z.class);
        if (zVar != null) {
            String strValue = zVar.value();
            if (!strValue.isEmpty()) {
                return b.g.a.c.t.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        b.g.a.a.u uVar = (b.g.a.a.u) bVar.b(b.g.a.a.u.class);
        if (uVar != null) {
            String strNamespace = uVar.namespace();
            return b.g.a.c.t.b(uVar.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = k;
            p pVar = ((i) bVar).k;
            if (!(pVar != null ? pVar.b(clsArr) : false)) {
                return null;
            }
        }
        return b.g.a.c.t.j;
    }

    @Override // b.g.a.c.b
    public b.g.a.c.t o(b bVar) {
        boolean z2;
        b.g.a.a.j jVar = (b.g.a.a.j) bVar.b(b.g.a.a.j.class);
        if (jVar != null) {
            String strValue = jVar.value();
            if (!strValue.isEmpty()) {
                return b.g.a.c.t.a(strValue);
            }
            z2 = true;
        } else {
            z2 = false;
        }
        b.g.a.a.u uVar = (b.g.a.a.u) bVar.b(b.g.a.a.u.class);
        if (uVar != null) {
            String strNamespace = uVar.namespace();
            return b.g.a.c.t.b(uVar.value(), (strNamespace == null || !strNamespace.isEmpty()) ? strNamespace : null);
        }
        if (!z2) {
            Class<? extends Annotation>[] clsArr = j;
            p pVar = ((i) bVar).k;
            if (!(pVar != null ? pVar.b(clsArr) : false)) {
                return null;
            }
        }
        return b.g.a.c.t.j;
    }

    @Override // b.g.a.c.b
    public Object p(c cVar) {
        b.g.a.c.y.d dVar = (b.g.a.c.y.d) cVar.b(b.g.a.c.y.d.class);
        if (dVar == null) {
            return null;
        }
        return dVar.value();
    }

    @Override // b.g.a.c.b
    public Object q(b bVar) {
        Class<? extends b.g.a.c.n> clsNullsUsing;
        b.g.a.c.y.e eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class);
        if (eVar == null || (clsNullsUsing = eVar.nullsUsing()) == n$a.class) {
            return null;
        }
        return clsNullsUsing;
    }

    @Override // b.g.a.c.b
    public a0 r(b bVar) {
        b.g.a.a.k kVar = (b.g.a.a.k) bVar.b(b.g.a.a.k.class);
        if (kVar == null || kVar.generator() == k0.class) {
            return null;
        }
        return new a0(b.g.a.c.t.a(kVar.property()), kVar.scope(), kVar.generator(), false, kVar.resolver());
    }

    public Object readResolve() {
        if (this.m == null) {
            this.m = new b.g.a.c.i0.h<>(48, 48);
        }
        return this;
    }

    @Override // b.g.a.c.b
    public a0 s(b bVar, a0 a0Var) {
        b.g.a.a.l lVar = (b.g.a.a.l) bVar.b(b.g.a.a.l.class);
        if (lVar == null) {
            return a0Var;
        }
        if (a0Var == null) {
            a0Var = a0.a;
        }
        boolean zAlwaysAsId = lVar.alwaysAsId();
        return a0Var.f == zAlwaysAsId ? a0Var : new a0(a0Var.f681b, a0Var.e, a0Var.c, zAlwaysAsId, a0Var.d);
    }

    @Override // b.g.a.c.b
    public u$a t(b bVar) {
        b.g.a.a.u uVar = (b.g.a.a.u) bVar.b(b.g.a.a.u.class);
        if (uVar != null) {
            return uVar.access();
        }
        return null;
    }

    @Override // b.g.a.c.b
    public b.g.a.c.e0.f<?> u(b.g.a.c.z.l<?> lVar, i iVar, b.g.a.c.j jVar) {
        if (jVar.k() != null) {
            return h0(lVar, iVar, jVar);
        }
        throw new IllegalArgumentException("Must call method with a container or reference type (got " + jVar + ")");
    }

    @Override // b.g.a.c.b
    public String v(b bVar) {
        b.g.a.a.u uVar = (b.g.a.a.u) bVar.b(b.g.a.a.u.class);
        if (uVar == null) {
            return null;
        }
        String strDefaultValue = uVar.defaultValue();
        if (strDefaultValue.isEmpty()) {
            return null;
        }
        return strDefaultValue;
    }

    @Override // b.g.a.c.b
    public String w(b bVar) {
        b.g.a.a.v vVar = (b.g.a.a.v) bVar.b(b.g.a.a.v.class);
        if (vVar == null) {
            return null;
        }
        return vVar.value();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // b.g.a.c.b
    public b.g.a.a.n$a x(b.g.a.c.z.l<?> lVar, b bVar) {
        ?? EmptySet;
        b.g.a.a.n nVar = (b.g.a.a.n) bVar.b(b.g.a.a.n.class);
        if (nVar == null) {
            return b.g.a.a.n$a.j;
        }
        b.g.a.a.n$a n_a = b.g.a.a.n$a.j;
        String[] strArrValue = nVar.value();
        if (strArrValue == null || strArrValue.length == 0) {
            EmptySet = Collections.emptySet();
        } else {
            EmptySet = new HashSet(strArrValue.length);
            for (String str : strArrValue) {
                EmptySet.add(str);
            }
        }
        return b.g.a.a.n$a.c(EmptySet, nVar.ignoreUnknown(), nVar.allowGetters(), nVar.allowSetters(), false);
    }

    @Override // b.g.a.c.b
    @Deprecated
    public b.g.a.a.n$a y(b bVar) {
        return x(null, bVar);
    }

    @Override // b.g.a.c.b
    public p$b z(b bVar) {
        p$b p_b;
        b.g.a.c.y.e eVar;
        p$b p_bB;
        p$a p_a = p$a.USE_DEFAULTS;
        b.g.a.a.p pVar = (b.g.a.a.p) bVar.b(b.g.a.a.p.class);
        if (pVar == null) {
            p$b p_b2 = p$b.j;
            p_b = p$b.j;
        } else {
            p$b p_b3 = p$b.j;
            p$a p_aValue = pVar.value();
            p$a p_aContent = pVar.content();
            if (p_aValue == p_a && p_aContent == p_a) {
                p_b = p$b.j;
            } else {
                Class<?> clsValueFilter = pVar.valueFilter();
                if (clsValueFilter == Void.class) {
                    clsValueFilter = null;
                }
                Class<?> clsContentFilter = pVar.contentFilter();
                p_b = new p$b(p_aValue, p_aContent, clsValueFilter, clsContentFilter != Void.class ? clsContentFilter : null);
            }
        }
        if (p_b._valueInclusion != p_a || (eVar = (b.g.a.c.y.e) bVar.b(b.g.a.c.y.e.class)) == null) {
            return p_b;
        }
        int iOrdinal = eVar.include().ordinal();
        if (iOrdinal == 0) {
            p_bB = p_b.b(p$a.ALWAYS);
        } else if (iOrdinal == 1) {
            p_bB = p_b.b(p$a.NON_NULL);
        } else if (iOrdinal == 2) {
            p_bB = p_b.b(p$a.NON_DEFAULT);
        } else {
            if (iOrdinal != 3) {
                return p_b;
            }
            p_bB = p_b.b(p$a.NON_EMPTY);
        }
        return p_bB;
    }
}
