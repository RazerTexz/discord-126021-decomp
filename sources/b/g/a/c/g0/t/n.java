package b.g.a.c.g0.t;

import b.g.a.a.i$a;
import b.g.a.a.i$d;
import b.g.a.c.w;
import b.g.a.c.x;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: StringArraySerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class n extends b.g.a.c.g0.u.a<String[]> implements b.g.a.c.g0.i {
    public static final n k;
    public final b.g.a.c.n<Object> _elementSerializer;

    static {
        b.g.a.c.h0.n.k.j(String.class);
        k = new n();
    }

    public n() {
        super(String[].class);
        this._elementSerializer = null;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    @Override // b.g.a.c.g0.u.a, b.g.a.c.g0.i
    public b.g.a.c.n<?> a(x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<Object> nVarH;
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
        i$a i_a = i$a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED;
        i$d i_dL = l(xVar, dVar, String[].class);
        Boolean boolB = i_dL != null ? i_dL.b(i_a) : null;
        if (nVarH == null) {
            nVarH = this._elementSerializer;
        }
        b.g.a.c.n<?> nVarK = k(xVar, dVar, nVarH);
        if (nVarK == null) {
            nVarK = xVar.n(String.class, dVar);
        }
        b.g.a.c.n<?> nVar = b.g.a.c.i0.d.s(nVarK) ? null : nVarK;
        return (nVar == this._elementSerializer && Objects.equals(boolB, this._unwrapSingle)) ? this : new n(this, dVar, nVar, boolB);
    }

    @Override // b.g.a.c.n
    public boolean d(x xVar, Object obj) {
        return ((String[]) obj).length == 0;
    }

    @Override // b.g.a.c.g0.u.a, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        String[] strArr = (String[]) obj;
        int length = strArr.length;
        if (length == 1 && ((this._unwrapSingle == null && xVar.D(w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            u(strArr, dVar, xVar);
            return;
        }
        dVar.b0(strArr, length);
        u(strArr, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h<?> p(b.g.a.c.e0.g gVar) {
        return this;
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((String[]) obj).length == 1;
    }

    @Override // b.g.a.c.g0.u.a
    public b.g.a.c.n<?> s(b.g.a.c.d dVar, Boolean bool) {
        return new n(this, dVar, this._elementSerializer, bool);
    }

    @Override // b.g.a.c.g0.u.a
    public /* bridge */ /* synthetic */ void t(String[] strArr, b.g.a.b.d dVar, x xVar) throws IOException {
        u(strArr, dVar, xVar);
    }

    public void u(String[] strArr, b.g.a.b.d dVar, x xVar) throws IOException {
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        b.g.a.c.n<Object> nVar = this._elementSerializer;
        int i = 0;
        if (nVar == null) {
            while (i < length) {
                if (strArr[i] == null) {
                    dVar.A();
                } else {
                    dVar.j0(strArr[i]);
                }
                i++;
            }
            return;
        }
        int length2 = strArr.length;
        while (i < length2) {
            if (strArr[i] == null) {
                xVar.l(dVar);
            } else {
                nVar.f(strArr[i], dVar, xVar);
            }
            i++;
        }
    }

    public n(n nVar, b.g.a.c.d dVar, b.g.a.c.n<?> nVar2, Boolean bool) {
        super(nVar, dVar, bool);
        this._elementSerializer = nVar2;
    }
}
