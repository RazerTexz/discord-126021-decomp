package b.g.a.c.g0.u;

import b.g.a.a.i$c;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonMappingException$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: BeanSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends q0<Object> implements b.g.a.c.g0.i, b.g.a.c.g0.o {
    public static final b.g.a.c.g0.c[] k;
    public final b.g.a.c.g0.a _anyGetterWriter;
    public final b.g.a.c.j _beanType;
    public final b.g.a.c.g0.c[] _filteredProps;
    public final b.g.a.c.g0.t.j _objectIdWriter;
    public final Object _propertyFilterId;
    public final b.g.a.c.g0.c[] _props;
    public final i$c _serializationShape;
    public final b.g.a.c.c0.i _typeId;

    static {
        new b.g.a.c.t("#object-ref");
        k = new b.g.a.c.g0.c[0];
    }

    public d(b.g.a.c.j jVar, b.g.a.c.g0.e eVar, b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2) {
        super(jVar);
        this._beanType = jVar;
        this._props = cVarArr;
        this._filteredProps = cVarArr2;
        if (eVar == null) {
            this._typeId = null;
            this._anyGetterWriter = null;
            this._propertyFilterId = null;
            this._objectIdWriter = null;
            this._serializationShape = null;
            return;
        }
        this._typeId = eVar.h;
        this._anyGetterWriter = eVar.f;
        this._propertyFilterId = eVar.g;
        this._objectIdWriter = eVar.i;
        this._serializationShape = eVar.f701b.a(null).e();
    }

    public static final b.g.a.c.g0.c[] t(b.g.a.c.g0.c[] cVarArr, b.g.a.c.i0.n nVar) {
        if (cVarArr == null || cVarArr.length == 0 || nVar == null || nVar == b.g.a.c.i0.n.j) {
            return cVarArr;
        }
        int length = cVarArr.length;
        b.g.a.c.g0.c[] cVarArr2 = new b.g.a.c.g0.c[length];
        for (int i = 0; i < length; i++) {
            b.g.a.c.g0.c cVar = cVarArr[i];
            if (cVar != null) {
                cVarArr2[i] = cVar.g(nVar);
            }
        }
        return cVarArr2;
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0171  */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        i$c i_cE;
        Object objG;
        Set<String> set;
        Set<String> setD;
        int i;
        d dVarW;
        Object obj;
        b.g.a.c.c0.a0 a0VarS;
        b.g.a.c.b bVarV = xVar.v();
        b.g.a.c.g0.c[] cVarArr = null;
        b.g.a.c.c0.i member = (dVar == null || bVarV == null) ? null : dVar.getMember();
        b.g.a.c.v vVar = xVar._config;
        i$d i_dL = l(xVar, dVar, this._handledType);
        char c = 0;
        if (i_dL == null || !i_dL.i()) {
            i_cE = null;
        } else {
            i_cE = i_dL.e();
            if (i_cE != i$c.ANY && i_cE != this._serializationShape) {
                if (this._beanType.w()) {
                    int iOrdinal = i_cE.ordinal();
                    if (iOrdinal == 5 || iOrdinal == 7 || iOrdinal == 8) {
                        vVar.n(this._beanType);
                        Class<?> cls = this._beanType._class;
                        return xVar.y(new m(b.g.a.c.i0.f.a(xVar._config, cls), m.p(cls, i_dL, true, null)), dVar);
                    }
                } else if (i_cE == i$c.NATURAL && ((!this._beanType.z() || !Map.class.isAssignableFrom(this._handledType)) && Map$Entry.class.isAssignableFrom(this._handledType))) {
                    b.g.a.c.j jVarI = this._beanType.i(Map$Entry.class);
                    return xVar.y(new b.g.a.c.g0.t.i(this._beanType, jVarI.h(0), jVarI.h(1), false, null, dVar), dVar);
                }
            }
        }
        b.g.a.c.g0.t.j jVarA = this._objectIdWriter;
        if (member != null) {
            setD = bVarV.x(vVar, member).d();
            set = bVarV.A(vVar, member)._included;
            b.g.a.c.c0.a0 a0VarR = bVarV.r(member);
            if (a0VarR != null) {
                b.g.a.c.c0.a0 a0VarS2 = bVarV.s(member, a0VarR);
                Class<? extends b.g.a.a.i0<?>> cls2 = a0VarS2.c;
                b.g.a.c.j jVar = xVar.d().i(xVar.b(cls2), b.g.a.a.i0.class)[0];
                if (cls2 == b.g.a.a.l0.class) {
                    String str = a0VarS2.f681b._simpleName;
                    int length = this._props.length;
                    i = 0;
                    while (true) {
                        if (i == length) {
                            b.g.a.c.j jVar2 = this._beanType;
                            Object[] objArr = new Object[2];
                            objArr[c] = b.g.a.c.i0.d.u(this._handledType);
                            objArr[1] = str == null ? "[null]" : b.g.a.c.i0.d.c(str);
                            xVar.f(jVar2, String.format("Invalid Object Id definition for %s: cannot find property with name %s", objArr));
                            throw null;
                        }
                        b.g.a.c.g0.c cVar = this._props[i];
                        if (str.equals(cVar._name._value)) {
                            jVarA = b.g.a.c.g0.t.j.a(cVar._declaredType, null, new b.g.a.c.g0.t.k(a0VarS2, cVar), a0VarS2.f);
                            break;
                        }
                        i++;
                        c = 0;
                    }
                } else {
                    jVarA = b.g.a.c.g0.t.j.a(jVar, a0VarS2.f681b, xVar.e(member, a0VarS2), a0VarS2.f);
                }
                objG = bVarV.g(member);
                if (objG != null || ((obj = this._propertyFilterId) != null && objG.equals(obj))) {
                    objG = null;
                }
            } else if (jVarA != null && (a0VarS = bVarV.s(member, null)) != null) {
                jVarA = this._objectIdWriter;
                boolean z2 = a0VarS.f;
                if (z2 != jVarA.e) {
                    jVarA = new b.g.a.c.g0.t.j(jVarA.a, jVarA.f704b, jVarA.c, jVarA.d, z2);
                }
            }
            i = 0;
            objG = bVarV.g(member);
            if (objG != null) {
                objG = null;
            } else {
                objG = null;
            }
        } else {
            objG = null;
            set = null;
            setD = null;
            i = 0;
        }
        if (i > 0) {
            b.g.a.c.g0.c[] cVarArr2 = this._props;
            b.g.a.c.g0.c[] cVarArr3 = (b.g.a.c.g0.c[]) Arrays.copyOf(cVarArr2, cVarArr2.length);
            b.g.a.c.g0.c cVar2 = cVarArr3[i];
            System.arraycopy(cVarArr3, 0, cVarArr3, 1, i);
            cVarArr3[0] = cVar2;
            b.g.a.c.g0.c[] cVarArr4 = this._filteredProps;
            if (cVarArr4 != null) {
                cVarArr = (b.g.a.c.g0.c[]) Arrays.copyOf(cVarArr4, cVarArr4.length);
                b.g.a.c.g0.c cVar3 = cVarArr[i];
                System.arraycopy(cVarArr, 0, cVarArr, 1, i);
                cVarArr[0] = cVar3;
            }
            dVarW = y(cVarArr3, cVarArr);
        } else {
            dVarW = this;
        }
        if (jVarA != null) {
            b.g.a.c.g0.t.j jVar3 = new b.g.a.c.g0.t.j(jVarA.a, jVarA.f704b, jVarA.c, xVar.t(jVarA.a, dVar), jVarA.e);
            if (jVar3 != this._objectIdWriter) {
                dVarW = dVarW.x(jVar3);
            }
        }
        if ((setD != null && !setD.isEmpty()) || set != null) {
            dVarW = dVarW.v(setD, set);
        }
        if (objG != null) {
            dVarW = dVarW.w(objG);
        }
        if (i_cE == null) {
            i_cE = this._serializationShape;
        }
        return i_cE == i$c.ARRAY ? dVarW.s() : dVarW;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    @Override // b.g.a.c.g0.o
    public void b(b.g.a.c.x xVar) throws JsonMappingException {
        b.g.a.c.g0.c cVar;
        b.g.a.c.e0.g gVar;
        b.g.a.c.c0.b bVar;
        Object objH;
        b.g.a.c.n<Object> nVar;
        b.g.a.c.g0.c cVar2;
        b.g.a.c.g0.c[] cVarArr = this._filteredProps;
        int length = cVarArr == null ? 0 : cVarArr.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            b.g.a.c.g0.c cVar3 = this._props[i];
            if (!cVar3._suppressNulls) {
                if (!(cVar3._nullSerializer != null) && (nVar = xVar._nullValueSerializer) != null) {
                    cVar3.e(nVar);
                    if (i < length && (cVar2 = this._filteredProps[i]) != null) {
                        cVar2.e(nVar);
                    }
                }
            }
            if (!(cVar3._serializer != null)) {
                b.g.a.c.b bVarV = xVar.v();
                b.g.a.c.n<Object> nVarT = null;
                if (bVarV != null && (bVar = cVar3._member) != null && (objH = bVarV.H(bVar)) != null) {
                    b.g.a.c.i0.e<Object, Object> eVarC = xVar.c(cVar3._member, objH);
                    b.g.a.c.j jVarA = eVarC.a(xVar.d());
                    nVarT = new j0(eVarC, jVarA, jVarA.y() ? null : xVar.t(jVarA, cVar3));
                }
                if (nVarT == null) {
                    b.g.a.c.j jVar = cVar3._cfgSerializationType;
                    if (jVar == null) {
                        jVar = cVar3._declaredType;
                        if (!jVar.x()) {
                            if (jVar.v() || jVar.g() > 0) {
                                cVar3._nonTrivialBaseType = jVar;
                            }
                        }
                    }
                    nVarT = xVar.t(jVar, cVar3);
                    if (jVar.v() && (gVar = (b.g.a.c.e0.g) jVar.k()._typeHandler) != null && (nVarT instanceof b.g.a.c.g0.h)) {
                        b.g.a.c.g0.h hVar = (b.g.a.c.g0.h) nVarT;
                        Objects.requireNonNull(hVar);
                        nVarT = hVar.p(gVar);
                    }
                    if (i < length) {
                        cVar3.f(nVarT);
                    } else {
                        cVar3.f(nVarT);
                    }
                } else if (i < length || (cVar = this._filteredProps[i]) == null) {
                    cVar3.f(nVarT);
                } else {
                    cVar.f(nVarT);
                }
            }
        }
        b.g.a.c.g0.a aVar = this._anyGetterWriter;
        if (aVar != null) {
            b.g.a.c.n<?> nVar2 = aVar.c;
            if (nVar2 instanceof b.g.a.c.g0.i) {
                b.g.a.c.n<?> nVarY = xVar.y(nVar2, aVar.a);
                aVar.c = nVarY;
                if (nVarY instanceof t) {
                    aVar.d = (t) nVarY;
                }
            }
        }
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        if (this._objectIdWriter != null) {
            dVar.e(obj);
            p(obj, dVar, xVar, gVar);
            return;
        }
        dVar.e(obj);
        b.g.a.b.s.b bVarR = r(gVar, obj, b.g.a.b.h.START_OBJECT);
        gVar.e(dVar, bVarR);
        Object obj2 = this._propertyFilterId;
        if (obj2 == null) {
            u(obj, dVar, xVar);
            gVar.f(dVar, bVarR);
        } else {
            if (this._filteredProps != null) {
                Class<?> cls = xVar._serializationView;
            }
            m(xVar, obj2, obj);
            throw null;
        }
    }

    @Override // b.g.a.c.n
    public boolean i() {
        return this._objectIdWriter != null;
    }

    public final void p(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        b.g.a.c.g0.t.j jVar = this._objectIdWriter;
        b.g.a.c.g0.t.u uVarP = xVar.p(obj, jVar.c);
        if (uVarP.a(dVar, xVar, jVar)) {
            return;
        }
        if (uVarP.f713b == null) {
            uVarP.f713b = uVarP.a.c(obj);
        }
        Object obj2 = uVarP.f713b;
        if (jVar.e) {
            jVar.d.f(obj2, dVar, xVar);
            return;
        }
        b.g.a.c.g0.t.j jVar2 = this._objectIdWriter;
        b.g.a.b.s.b bVarR = r(gVar, obj, b.g.a.b.h.START_OBJECT);
        gVar.e(dVar, bVarR);
        uVarP.c = true;
        Objects.requireNonNull(dVar);
        b.g.a.b.k kVar = jVar2.f704b;
        if (kVar != null) {
            dVar.x(kVar);
            jVar2.d.f(uVarP.f713b, dVar, xVar);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m(xVar, obj3, obj);
            throw null;
        }
        u(obj, dVar, xVar);
        gVar.f(dVar, bVarR);
    }

    public final void q(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, boolean z2) throws IOException {
        b.g.a.c.g0.t.j jVar = this._objectIdWriter;
        b.g.a.c.g0.t.u uVarP = xVar.p(obj, jVar.c);
        if (uVarP.a(dVar, xVar, jVar)) {
            return;
        }
        if (uVarP.f713b == null) {
            uVarP.f713b = uVarP.a.c(obj);
        }
        Object obj2 = uVarP.f713b;
        if (jVar.e) {
            jVar.d.f(obj2, dVar, xVar);
            return;
        }
        if (z2) {
            dVar.d0(obj);
        }
        uVarP.c = true;
        b.g.a.b.k kVar = jVar.f704b;
        if (kVar != null) {
            dVar.x(kVar);
            jVar.d.f(uVarP.f713b, dVar, xVar);
        }
        Object obj3 = this._propertyFilterId;
        if (obj3 != null) {
            m(xVar, obj3, obj);
            throw null;
        }
        u(obj, dVar, xVar);
        if (z2) {
            dVar.u();
        }
    }

    public final b.g.a.b.s.b r(b.g.a.c.e0.g gVar, Object obj, b.g.a.b.h hVar) {
        b.g.a.c.c0.i iVar = this._typeId;
        if (iVar == null) {
            return gVar.d(obj, hVar);
        }
        Object objJ = iVar.j(obj);
        if (objJ == null) {
            objJ = "";
        }
        b.g.a.b.s.b bVarD = gVar.d(obj, hVar);
        bVarD.c = objJ;
        return bVarD;
    }

    public abstract d s();

    public void u(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        b.g.a.c.g0.c[] cVarArr = this._filteredProps;
        if (cVarArr == null || xVar._serializationView == null) {
            cVarArr = this._props;
        }
        int i = 0;
        try {
            int length = cVarArr.length;
            while (i < length) {
                b.g.a.c.g0.c cVar = cVarArr[i];
                if (cVar != null) {
                    cVar.i(obj, dVar, xVar);
                }
                i++;
            }
            b.g.a.c.g0.a aVar = this._anyGetterWriter;
            if (aVar != null) {
                aVar.a(obj, dVar, xVar);
            }
        } catch (Exception e) {
            o(xVar, e, obj, i != cVarArr.length ? cVarArr[i]._name._value : "[anySetter]");
            throw null;
        } catch (StackOverflowError e2) {
            JsonMappingException jsonMappingException = new JsonMappingException(dVar, "Infinite recursion (StackOverflowError)", e2);
            jsonMappingException.e(new JsonMappingException$a(obj, i != cVarArr.length ? cVarArr[i]._name._value : "[anySetter]"));
            throw jsonMappingException;
        }
    }

    public abstract d v(Set<String> set, Set<String> set2);

    public abstract d w(Object obj);

    public abstract d x(b.g.a.c.g0.t.j jVar);

    public abstract d y(b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2);

    public d(d dVar, b.g.a.c.g0.c[] cVarArr, b.g.a.c.g0.c[] cVarArr2) {
        super(dVar._handledType);
        this._beanType = dVar._beanType;
        this._props = cVarArr;
        this._filteredProps = cVarArr2;
        this._typeId = dVar._typeId;
        this._anyGetterWriter = dVar._anyGetterWriter;
        this._objectIdWriter = dVar._objectIdWriter;
        this._propertyFilterId = dVar._propertyFilterId;
        this._serializationShape = dVar._serializationShape;
    }

    public d(d dVar, b.g.a.c.g0.t.j jVar, Object obj) {
        super(dVar._handledType);
        this._beanType = dVar._beanType;
        this._props = dVar._props;
        this._filteredProps = dVar._filteredProps;
        this._typeId = dVar._typeId;
        this._anyGetterWriter = dVar._anyGetterWriter;
        this._objectIdWriter = jVar;
        this._propertyFilterId = obj;
        this._serializationShape = dVar._serializationShape;
    }

    public d(d dVar, Set<String> set, Set<String> set2) {
        super(dVar._handledType);
        this._beanType = dVar._beanType;
        b.g.a.c.g0.c[] cVarArr = dVar._props;
        b.g.a.c.g0.c[] cVarArr2 = dVar._filteredProps;
        int length = cVarArr.length;
        ArrayList arrayList = new ArrayList(length);
        ArrayList arrayList2 = cVarArr2 == null ? null : new ArrayList(length);
        for (int i = 0; i < length; i++) {
            b.g.a.c.g0.c cVar = cVarArr[i];
            if (!b.c.a.a0.d.b2(cVar._name._value, set, set2)) {
                arrayList.add(cVar);
                if (cVarArr2 != null) {
                    arrayList2.add(cVarArr2[i]);
                }
            }
        }
        this._props = (b.g.a.c.g0.c[]) arrayList.toArray(new b.g.a.c.g0.c[arrayList.size()]);
        this._filteredProps = arrayList2 != null ? (b.g.a.c.g0.c[]) arrayList2.toArray(new b.g.a.c.g0.c[arrayList2.size()]) : null;
        this._typeId = dVar._typeId;
        this._anyGetterWriter = dVar._anyGetterWriter;
        this._objectIdWriter = dVar._objectIdWriter;
        this._propertyFilterId = dVar._propertyFilterId;
        this._serializationShape = dVar._serializationShape;
    }
}
