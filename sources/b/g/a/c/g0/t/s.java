package b.g.a.c.g0.t;

import b.g.a.a.p$a;
import b.g.a.c.i0.n$a;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnwrappingBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public class s extends b.g.a.c.g0.c implements Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.i0.n _nameTransformer;

    public s(s sVar, b.g.a.c.i0.n nVar, b.g.a.b.p.j jVar) {
        super(sVar, jVar);
        this._nameTransformer = nVar;
    }

    @Override // b.g.a.c.g0.c
    public b.g.a.c.n<Object> c(l lVar, Class<?> cls, x xVar) throws JsonMappingException {
        b.g.a.c.j jVar = this._nonTrivialBaseType;
        b.g.a.c.n<Object> nVarT = jVar != null ? xVar.t(xVar.k(jVar, cls), this) : xVar.u(cls, this);
        b.g.a.c.i0.n n_a = this._nameTransformer;
        if (nVarT.e() && (nVarT instanceof t)) {
            n_a = new n$a(n_a, ((t) nVarT)._nameTransformer);
        }
        b.g.a.c.n<Object> nVarH = nVarT.h(n_a);
        this.n = this.n.b(cls, nVarH);
        return nVarH;
    }

    @Override // b.g.a.c.g0.c
    public void f(b.g.a.c.n<Object> nVar) {
        if (nVar != null) {
            b.g.a.c.i0.n n_a = this._nameTransformer;
            if (nVar.e() && (nVar instanceof t)) {
                n_a = new n$a(n_a, ((t) nVar)._nameTransformer);
            }
            nVar = nVar.h(n_a);
        }
        super.f(nVar);
    }

    @Override // b.g.a.c.g0.c
    public b.g.a.c.g0.c g(b.g.a.c.i0.n nVar) {
        return new s(this, new n$a(nVar, this._nameTransformer), new b.g.a.b.p.j(nVar.a(this._name._value)));
    }

    @Override // b.g.a.c.g0.c
    public void i(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Method method = this.l;
        Object objInvoke = method == null ? this.m.get(obj) : method.invoke(obj, null);
        if (objInvoke == null) {
            return;
        }
        b.g.a.c.n<Object> nVarC = this._serializer;
        if (nVarC == null) {
            Class<?> cls = objInvoke.getClass();
            l lVar = this.n;
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
        if (!nVarC.e()) {
            dVar.x(this._name);
        }
        b.g.a.c.e0.g gVar = this._typeSerializer;
        if (gVar == null) {
            nVarC.f(objInvoke, dVar, xVar);
        } else {
            nVarC.g(objInvoke, dVar, xVar, gVar);
        }
    }

    public s(b.g.a.c.g0.c cVar, b.g.a.c.i0.n nVar) {
        super(cVar, cVar._name);
        this._nameTransformer = nVar;
    }
}
