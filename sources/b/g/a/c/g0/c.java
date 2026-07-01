package b.g.a.c.g0;

import b.g.a.a.p$a;
import b.g.a.c.g0.t.l$b;
import b.g.a.c.g0.t.l$d;
import b.g.a.c.t;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX INFO: compiled from: BeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class c extends n implements Serializable {
    public static final /* synthetic */ int j = 0;
    private static final long serialVersionUID = 1;
    public final b.g.a.c.j _cfgSerializationType;
    public final b.g.a.c.j _declaredType;
    public final Class<?>[] _includeInViews;
    public final b.g.a.c.c0.i _member;
    public final b.g.a.b.p.j _name;
    public b.g.a.c.j _nonTrivialBaseType;
    public b.g.a.c.n<Object> _nullSerializer;
    public b.g.a.c.n<Object> _serializer;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public b.g.a.c.e0.g _typeSerializer;
    public final t _wrapperName;
    public final transient b.g.a.c.i0.a k;
    public transient Method l;
    public transient Field m;
    public transient b.g.a.c.g0.t.l n;
    public transient HashMap<Object, Object> o;

    public c(b.g.a.c.c0.s sVar, b.g.a.c.c0.i iVar, b.g.a.c.i0.a aVar, b.g.a.c.j jVar, b.g.a.c.n<?> nVar, b.g.a.c.e0.g gVar, b.g.a.c.j jVar2, boolean z2, Object obj, Class<?>[] clsArr) {
        super(sVar);
        this._member = iVar;
        this.k = aVar;
        this._name = new b.g.a.b.p.j(sVar.p());
        this._wrapperName = sVar.t();
        this._declaredType = jVar;
        this._serializer = nVar;
        this.n = nVar == null ? l$b.f706b : null;
        this._typeSerializer = gVar;
        this._cfgSerializationType = jVar2;
        if (iVar instanceof b.g.a.c.c0.g) {
            this.l = null;
            this.m = (Field) iVar.i();
        } else if (iVar instanceof b.g.a.c.c0.j) {
            this.l = (Method) iVar.i();
            this.m = null;
        } else {
            this.l = null;
            this.m = null;
        }
        this._suppressNulls = z2;
        this._suppressableValue = obj;
        this._nullSerializer = null;
        this._includeInViews = clsArr;
    }

    public b.g.a.c.n<Object> c(b.g.a.c.g0.t.l lVar, Class<?> cls, x xVar) throws JsonMappingException {
        l$d l_d;
        b.g.a.c.j jVar = this._nonTrivialBaseType;
        if (jVar != null) {
            b.g.a.c.j jVarK = xVar.k(jVar, cls);
            b.g.a.c.n<Object> nVarQ = xVar.q(jVarK, this);
            l_d = new l$d(nVarQ, lVar.b(jVarK._class, nVarQ));
        } else {
            b.g.a.c.n<Object> nVarR = xVar.r(cls, this);
            l_d = new l$d(nVarR, lVar.b(cls, nVarR));
        }
        b.g.a.c.g0.t.l lVar2 = l_d.f708b;
        if (lVar != lVar2) {
            this.n = lVar2;
        }
        return l_d.a;
    }

    public boolean d(b.g.a.b.d dVar, x xVar, b.g.a.c.n nVar) throws IOException {
        if (nVar.i()) {
            return false;
        }
        if (xVar.D(w.FAIL_ON_SELF_REFERENCES)) {
            if (!(nVar instanceof b.g.a.c.g0.u.d)) {
                return false;
            }
            xVar.f(this._declaredType, "Direct self-reference leading to cycle");
            throw null;
        }
        if (!xVar.D(w.WRITE_SELF_REFERENCES_AS_NULL)) {
            return false;
        }
        if (this._nullSerializer == null) {
            return true;
        }
        if (!dVar.c().b()) {
            dVar.x(this._name);
        }
        this._nullSerializer.f(null, dVar, xVar);
        return true;
    }

    public void e(b.g.a.c.n<Object> nVar) {
        b.g.a.c.n<Object> nVar2 = this._nullSerializer;
        if (nVar2 != null && nVar2 != nVar) {
            throw new IllegalStateException(String.format("Cannot override _nullSerializer: had a %s, trying to set to %s", b.g.a.c.i0.d.e(this._nullSerializer), b.g.a.c.i0.d.e(nVar)));
        }
        this._nullSerializer = nVar;
    }

    public void f(b.g.a.c.n<Object> nVar) {
        b.g.a.c.n<Object> nVar2 = this._serializer;
        if (nVar2 != null && nVar2 != nVar) {
            throw new IllegalStateException(String.format("Cannot override _serializer: had a %s, trying to set to %s", b.g.a.c.i0.d.e(this._serializer), b.g.a.c.i0.d.e(nVar)));
        }
        this._serializer = nVar;
    }

    public c g(b.g.a.c.i0.n nVar) {
        String strA = nVar.a(this._name._value);
        return strA.equals(this._name._value) ? this : new c(this, t.a(strA));
    }

    @Override // b.g.a.c.d
    public b.g.a.c.c0.i getMember() {
        return this._member;
    }

    @Override // b.g.a.c.d
    public b.g.a.c.j getType() {
        return this._declaredType;
    }

    public void h(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            b.g.a.c.n<Object> nVar = this._nullSerializer;
            if (nVar != null) {
                nVar.f(null, dVar, xVar);
                return;
            } else {
                dVar.A();
                return;
            }
        }
        b.g.a.c.n<Object> nVarC = this._serializer;
        if (nVarC == null) {
            Class<?> cls = objInvoke.getClass();
            b.g.a.c.g0.t.l lVar = this.n;
            b.g.a.c.n<Object> nVarC2 = lVar.c(cls);
            nVarC = nVarC2 == null ? c(lVar, cls, xVar) : nVarC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (p$a.NON_EMPTY == obj2) {
                if (nVarC.d(xVar, objInvoke)) {
                    b.g.a.c.n<Object> nVar2 = this._nullSerializer;
                    if (nVar2 != null) {
                        nVar2.f(null, dVar, xVar);
                        return;
                    } else {
                        dVar.A();
                        return;
                    }
                }
            } else if (obj2.equals(objInvoke)) {
                b.g.a.c.n<Object> nVar3 = this._nullSerializer;
                if (nVar3 != null) {
                    nVar3.f(null, dVar, xVar);
                    return;
                } else {
                    dVar.A();
                    return;
                }
            }
        }
        if (objInvoke == obj && d(dVar, xVar, nVarC)) {
            return;
        }
        b.g.a.c.e0.g gVar = this._typeSerializer;
        if (gVar == null) {
            nVarC.f(objInvoke, dVar, xVar);
        } else {
            nVarC.g(objInvoke, dVar, xVar, gVar);
        }
    }

    public void i(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            if (this._nullSerializer != null) {
                dVar.x(this._name);
                this._nullSerializer.f(null, dVar, xVar);
                return;
            }
            return;
        }
        b.g.a.c.n<Object> nVarC = this._serializer;
        if (nVarC == null) {
            Class<?> cls = objInvoke.getClass();
            b.g.a.c.g0.t.l lVar = this.n;
            b.g.a.c.n<Object> nVarC2 = lVar.c(cls);
            nVarC = nVarC2 == null ? c(lVar, cls, xVar) : nVarC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (p$a.NON_EMPTY == obj2) {
                if (nVarC.d(xVar, objInvoke)) {
                    return;
                }
            } else if (obj2.equals(objInvoke)) {
                return;
            }
        }
        if (objInvoke == obj && d(dVar, xVar, nVarC)) {
            return;
        }
        dVar.x(this._name);
        b.g.a.c.e0.g gVar = this._typeSerializer;
        if (gVar == null) {
            nVarC.f(objInvoke, dVar, xVar);
        } else {
            nVarC.g(objInvoke, dVar, xVar, gVar);
        }
    }

    public Object readResolve() {
        b.g.a.c.c0.i iVar = this._member;
        if (iVar instanceof b.g.a.c.c0.g) {
            this.l = null;
            this.m = (Field) iVar.i();
        } else if (iVar instanceof b.g.a.c.c0.j) {
            this.l = (Method) iVar.i();
            this.m = null;
        }
        if (this._serializer == null) {
            this.n = l$b.f706b;
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(this._name._value);
        sb.append("' (");
        if (this.l != null) {
            sb.append("via method ");
            sb.append(this.l.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.l.getName());
        } else if (this.m != null) {
            sb.append("field \"");
            sb.append(this.m.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this.m.getName());
        } else {
            sb.append("virtual");
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            StringBuilder sbU = b.d.b.a.a.U(", static serializer of type ");
            sbU.append(this._serializer.getClass().getName());
            sb.append(sbU.toString());
        }
        sb.append(')');
        return sb.toString();
    }

    public c() {
        super(b.g.a.c.s.l);
        this._member = null;
        this.k = null;
        this._name = null;
        this._wrapperName = null;
        this._includeInViews = null;
        this._declaredType = null;
        this._serializer = null;
        this.n = null;
        this._typeSerializer = null;
        this._cfgSerializationType = null;
        this.l = null;
        this.m = null;
        this._suppressNulls = false;
        this._suppressableValue = null;
        this._nullSerializer = null;
    }

    public c(c cVar, t tVar) {
        super(cVar);
        this._name = new b.g.a.b.p.j(tVar._simpleName);
        this._wrapperName = cVar._wrapperName;
        this.k = cVar.k;
        this._declaredType = cVar._declaredType;
        this._member = cVar._member;
        this.l = cVar.l;
        this.m = cVar.m;
        this._serializer = cVar._serializer;
        this._nullSerializer = cVar._nullSerializer;
        if (cVar.o != null) {
            this.o = new HashMap<>(cVar.o);
        }
        this._cfgSerializationType = cVar._cfgSerializationType;
        this.n = cVar.n;
        this._suppressNulls = cVar._suppressNulls;
        this._suppressableValue = cVar._suppressableValue;
        this._includeInViews = cVar._includeInViews;
        this._typeSerializer = cVar._typeSerializer;
        this._nonTrivialBaseType = cVar._nonTrivialBaseType;
    }

    public c(c cVar, b.g.a.b.p.j jVar) {
        super(cVar);
        this._name = jVar;
        this._wrapperName = cVar._wrapperName;
        this._member = cVar._member;
        this.k = cVar.k;
        this._declaredType = cVar._declaredType;
        this.l = cVar.l;
        this.m = cVar.m;
        this._serializer = cVar._serializer;
        this._nullSerializer = cVar._nullSerializer;
        if (cVar.o != null) {
            this.o = new HashMap<>(cVar.o);
        }
        this._cfgSerializationType = cVar._cfgSerializationType;
        this.n = cVar.n;
        this._suppressNulls = cVar._suppressNulls;
        this._suppressableValue = cVar._suppressableValue;
        this._includeInViews = cVar._includeInViews;
        this._typeSerializer = cVar._typeSerializer;
        this._nonTrivialBaseType = cVar._nonTrivialBaseType;
    }
}
