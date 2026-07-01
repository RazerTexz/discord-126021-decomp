package b.g.a.c.g0;

import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.c.x;
import java.io.Serializable;

/* JADX INFO: compiled from: VirtualBeanPropertyWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends c implements Serializable {
    private static final long serialVersionUID = 1;

    public s() {
    }

    @Override // b.g.a.c.g0.c
    public void h(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Object objJ = j(obj, dVar, xVar);
        if (objJ == null) {
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
            Class<?> cls = objJ.getClass();
            b.g.a.c.g0.t.l lVar = this.n;
            b.g.a.c.n<Object> nVarC2 = lVar.c(cls);
            nVarC = nVarC2 == null ? c(lVar, cls, xVar) : nVarC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (p$a.NON_EMPTY == obj2) {
                if (nVarC.d(xVar, objJ)) {
                    b.g.a.c.n<Object> nVar2 = this._nullSerializer;
                    if (nVar2 != null) {
                        nVar2.f(null, dVar, xVar);
                        return;
                    } else {
                        dVar.A();
                        return;
                    }
                }
            } else if (obj2.equals(objJ)) {
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
        if (objJ == obj && d(dVar, xVar, nVarC)) {
            return;
        }
        b.g.a.c.e0.g gVar = this._typeSerializer;
        if (gVar == null) {
            nVarC.f(objJ, dVar, xVar);
        } else {
            nVarC.g(objJ, dVar, xVar, gVar);
        }
    }

    @Override // b.g.a.c.g0.c
    public void i(Object obj, b.g.a.b.d dVar, x xVar) throws Exception {
        Object objJ = j(obj, dVar, xVar);
        if (objJ == null) {
            if (this._nullSerializer != null) {
                dVar.x(this._name);
                this._nullSerializer.f(null, dVar, xVar);
                return;
            }
            return;
        }
        b.g.a.c.n<Object> nVarC = this._serializer;
        if (nVarC == null) {
            Class<?> cls = objJ.getClass();
            b.g.a.c.g0.t.l lVar = this.n;
            b.g.a.c.n<Object> nVarC2 = lVar.c(cls);
            nVarC = nVarC2 == null ? c(lVar, cls, xVar) : nVarC2;
        }
        Object obj2 = this._suppressableValue;
        if (obj2 != null) {
            if (p$a.NON_EMPTY == obj2) {
                if (nVarC.d(xVar, objJ)) {
                    return;
                }
            } else if (obj2.equals(objJ)) {
                return;
            }
        }
        if (objJ == obj && d(dVar, xVar, nVarC)) {
            return;
        }
        dVar.x(this._name);
        b.g.a.c.e0.g gVar = this._typeSerializer;
        if (gVar == null) {
            nVarC.f(objJ, dVar, xVar);
        } else {
            nVarC.g(objJ, dVar, xVar, gVar);
        }
    }

    public abstract Object j(Object obj, b.g.a.b.d dVar, x xVar) throws Exception;

    public abstract s k(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.c cVar, b.g.a.c.c0.s sVar, b.g.a.c.j jVar);

    /* JADX WARN: Illegal instructions before constructor call */
    public s(b.g.a.c.c0.s sVar, b.g.a.c.i0.a aVar, b.g.a.c.j jVar, b.g.a.c.n<?> nVar, b.g.a.c.e0.g gVar, b.g.a.c.j jVar2, p$b p_b, Class<?>[] clsArr) {
        boolean z2;
        Object obj;
        p$a p_a = p$a.USE_DEFAULTS;
        p$a p_a2 = p$a.ALWAYS;
        b.g.a.c.c0.i iVarQ = sVar.q();
        boolean z3 = false;
        if (p_b == null) {
            z2 = false;
        } else {
            p$a p_a3 = p_b._valueInclusion;
            if (p_a3 != p_a2 && p_a3 != p_a) {
                z3 = true;
            }
            z2 = z3;
        }
        if (p_b == null) {
            obj = Boolean.FALSE;
        } else {
            p$a p_a4 = p_b._valueInclusion;
            obj = (p_a4 == p_a2 || p_a4 == p$a.NON_NULL || p_a4 == p_a) ? null : p$a.NON_EMPTY;
        }
        super(sVar, iVarQ, aVar, jVar, null, null, null, z2, obj, null);
    }
}
