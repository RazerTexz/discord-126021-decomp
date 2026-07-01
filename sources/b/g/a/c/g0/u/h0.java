package b.g.a.c.g0.u;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: compiled from: StaticListSerializerBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h0<T extends Collection<?>> extends q0<T> implements b.g.a.c.g0.i {
    public final Boolean _unwrapSingle;

    public h0(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001a  */
    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarH;
        Object objC;
        if (dVar != null) {
            b.g.a.c.b bVarV = xVar.v();
            b.g.a.c.c0.i member = dVar.getMember();
            if (member == null || (objC = bVarV.c(member)) == null) {
                nVarH = null;
            } else {
                nVarH = xVar.H(member, objC);
            }
        } else {
            nVarH = null;
        }
        i$d i_dL = l(xVar, dVar, this._handledType);
        Boolean boolB = i_dL != null ? i_dL.b(i$a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
        b.g.a.c.n<?> nVarK = k(xVar, dVar, nVarH);
        if (nVarK == null) {
            nVarK = xVar.n(String.class, dVar);
        }
        if (b.g.a.c.i0.d.s(nVarK)) {
            return Objects.equals(boolB, this._unwrapSingle) ? this : p(dVar, boolB);
        }
        return new j(xVar.b(String.class), true, null, nVarK);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        Collection collection = (Collection) obj;
        return collection == null || collection.size() == 0;
    }

    @Override // b.g.a.c.n
    public /* bridge */ /* synthetic */ void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        q((Collection) obj, dVar, xVar, gVar);
    }

    public abstract b.g.a.c.n<?> p(b.g.a.c.d dVar, Boolean bool);

    public abstract void q(T t, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException;

    public h0(h0<?> h0Var, Boolean bool) {
        super(h0Var);
        this._unwrapSingle = bool;
    }
}
