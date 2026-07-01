package b.g.a.c.g0.u;

import b.g.a.a.p$a;
import b.g.a.a.p$b;
import b.g.a.c.g0.t.l$b;
import b.g.a.c.i0.n$a;
import b.g.a.c.y.e$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: ReferenceTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f0<T> extends q0<T> implements b.g.a.c.g0.i {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.d _property;
    public final b.g.a.c.j _referredType;
    public final boolean _suppressNulls;
    public final Object _suppressableValue;
    public final b.g.a.c.i0.n _unwrapper;
    public final b.g.a.c.n<Object> _valueSerializer;
    public final b.g.a.c.e0.g _valueTypeSerializer;
    public transient b.g.a.c.g0.t.l k;

    public f0(b.g.a.c.h0.i iVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar) {
        super(iVar);
        this._referredType = iVar._referencedType;
        this._property = null;
        this._valueTypeSerializer = gVar;
        this._valueSerializer = nVar;
        this._unwrapper = null;
        this._suppressableValue = null;
        this._suppressNulls = false;
        this.k = l$b.f706b;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x0033  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:78:0x00de  */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarY;
        p$b p_bB;
        p$a p_a;
        boolean zC;
        Object objC;
        Object objT0 = p$a.NON_EMPTY;
        b.g.a.c.e0.g gVarA = this._valueTypeSerializer;
        if (gVarA != null) {
            gVarA = gVarA.a(dVar);
        }
        if (dVar != null) {
            b.g.a.c.c0.i member = dVar.getMember();
            b.g.a.c.b bVarV = xVar.v();
            if (member == null || (objC = bVarV.c(member)) == null) {
                nVarY = null;
            } else {
                nVarY = xVar.H(member, objC);
            }
        } else {
            nVarY = null;
        }
        boolean zB = false;
        if (nVarY == null) {
            nVarY = this._valueSerializer;
            if (nVarY == null) {
                b.g.a.c.j jVar = this._referredType;
                if (jVar.y()) {
                    zC = false;
                } else if (jVar.x() || jVar._asStatic) {
                    zC = true;
                } else {
                    b.g.a.c.b bVarV2 = xVar.v();
                    if (bVarV2 != null && dVar != null && dVar.getMember() != null) {
                        e$b e_bK = bVarV2.K(dVar.getMember());
                        if (e_bK == e$b.STATIC) {
                            zC = true;
                        } else if (e_bK == e$b.DYNAMIC) {
                            zC = false;
                        }
                    }
                    zC = xVar.C(b.g.a.c.p.USE_STATIC_TYPING);
                }
                if (zC) {
                    nVarY = xVar.q(this._referredType, dVar);
                }
            } else {
                nVarY = xVar.y(nVarY, dVar);
            }
        }
        f0<T> f0VarU = (this._property == dVar && this._valueTypeSerializer == gVarA && this._valueSerializer == nVarY) ? this : u(dVar, gVarA, nVarY, this._unwrapper);
        if (dVar == null || (p_bB = dVar.b(xVar._config, this._handledType)) == null || (p_a = p_bB._contentInclusion) == p$a.USE_DEFAULTS) {
            return f0VarU;
        }
        int iOrdinal = p_a.ordinal();
        if (iOrdinal == 1) {
            objT0 = null;
            zB = true;
        } else {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal == 4) {
                        objT0 = b.c.a.a0.d.t0(this._referredType);
                        if (objT0 != null && objT0.getClass().isArray()) {
                            objT0 = b.c.a.a0.d.q0(objT0);
                        }
                    } else if (iOrdinal != 5) {
                        objT0 = null;
                    } else {
                        objT0 = xVar.A(null, p_bB._contentFilter);
                        if (objT0 != null) {
                            zB = xVar.B(objT0);
                        }
                    }
                }
            } else if (!this._referredType.b()) {
                objT0 = null;
            }
            zB = true;
        }
        return (this._suppressableValue == objT0 && this._suppressNulls == zB) ? f0VarU : f0VarU.t(objT0, zB);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, T t) {
        if (!s(t)) {
            return true;
        }
        Object objQ = q(t);
        if (objQ == null) {
            return this._suppressNulls;
        }
        if (this._suppressableValue == null) {
            return false;
        }
        b.g.a.c.n<Object> nVarP = this._valueSerializer;
        if (nVarP == null) {
            try {
                nVarP = p(xVar, objQ.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        Object obj = this._suppressableValue;
        return obj == p$a.NON_EMPTY ? nVarP.d(xVar, objQ) : obj.equals(objQ);
    }

    @Override // b.g.a.c.n
    public boolean e() {
        return this._unwrapper != null;
    }

    @Override // b.g.a.c.n
    public void f(T t, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Object objR = r(t);
        if (objR == null) {
            if (this._unwrapper == null) {
                xVar.l(dVar);
                return;
            }
            return;
        }
        b.g.a.c.n<Object> nVarP = this._valueSerializer;
        if (nVarP == null) {
            nVarP = p(xVar, objR.getClass());
        }
        b.g.a.c.e0.g gVar = this._valueTypeSerializer;
        if (gVar != null) {
            nVarP.g(objR, dVar, xVar, gVar);
        } else {
            nVarP.f(objR, dVar, xVar);
        }
    }

    @Override // b.g.a.c.n
    public void g(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Object objR = r(t);
        if (objR == null) {
            if (this._unwrapper == null) {
                xVar.l(dVar);
            }
        } else {
            b.g.a.c.n<Object> nVarP = this._valueSerializer;
            if (nVarP == null) {
                nVarP = p(xVar, objR.getClass());
            }
            nVarP.g(objR, dVar, xVar, gVar);
        }
    }

    @Override // b.g.a.c.n
    public b.g.a.c.n<T> h(b.g.a.c.i0.n nVar) {
        b.g.a.c.n<?> nVarH = this._valueSerializer;
        if (nVarH != null && (nVarH = nVarH.h(nVar)) == this._valueSerializer) {
            return this;
        }
        b.g.a.c.i0.n nVar2 = this._unwrapper;
        if (nVar2 != null) {
            nVar = new n$a(nVar, nVar2);
        }
        return (this._valueSerializer == nVarH && nVar2 == nVar) ? this : u(this._property, this._valueTypeSerializer, nVarH, nVar);
    }

    public final b.g.a.c.n<Object> p(b.g.a.c.x xVar, Class<?> cls) throws JsonMappingException {
        b.g.a.c.n<Object> nVarC = this.k.c(cls);
        if (nVarC != null) {
            return nVarC;
        }
        b.g.a.c.n<Object> nVarQ = this._referredType.r() ? xVar.q(xVar.k(this._referredType, cls), this._property) : xVar.r(cls, this._property);
        b.g.a.c.i0.n nVar = this._unwrapper;
        if (nVar != null) {
            nVarQ = nVarQ.h(nVar);
        }
        b.g.a.c.n<Object> nVar2 = nVarQ;
        this.k = this.k.b(cls, nVar2);
        return nVar2;
    }

    public abstract Object q(T t);

    public abstract Object r(T t);

    public abstract boolean s(T t);

    public abstract f0<T> t(Object obj, boolean z2);

    public abstract f0<T> u(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, b.g.a.c.i0.n nVar2);

    public f0(f0<?> f0Var, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, b.g.a.c.i0.n nVar2, Object obj, boolean z2) {
        super(f0Var);
        this._referredType = f0Var._referredType;
        this.k = l$b.f706b;
        this._property = dVar;
        this._valueTypeSerializer = gVar;
        this._valueSerializer = nVar;
        this._unwrapper = nVar2;
        this._suppressableValue = obj;
        this._suppressNulls = z2;
    }
}
