package b.g.a.c.g0.u;

import b.g.a.c.g0.t.l$b;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
@b.g.a.c.y.a
public class s extends q0<Object> implements b.g.a.c.g0.i {
    public final b.g.a.c.c0.i _accessor;
    public final boolean _forceTypeInformation;
    public final b.g.a.c.d _property;
    public final b.g.a.c.n<Object> _valueSerializer;
    public final b.g.a.c.j _valueType;
    public final b.g.a.c.e0.g _valueTypeSerializer;
    public transient b.g.a.c.g0.t.l k;

    /* JADX WARN: Illegal instructions before constructor call */
    public s(s sVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, boolean z2) {
        Class cls = sVar._handledType;
        super(cls == null ? Object.class : cls);
        this._accessor = sVar._accessor;
        this._valueType = sVar._valueType;
        this._valueTypeSerializer = gVar;
        this._valueSerializer = nVar;
        this._property = dVar;
        this._forceTypeInformation = z2;
        this.k = l$b.f706b;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.e0.g gVarA = this._valueTypeSerializer;
        if (gVarA != null) {
            gVarA = gVarA.a(dVar);
        }
        b.g.a.c.n<?> nVar = this._valueSerializer;
        if (nVar != null) {
            return q(dVar, gVarA, xVar.y(nVar, dVar), this._forceTypeInformation);
        }
        if (!xVar.C(b.g.a.c.p.USE_STATIC_TYPING) && !this._valueType.x()) {
            return dVar != this._property ? q(dVar, gVarA, nVar, this._forceTypeInformation) : this;
        }
        b.g.a.c.n<Object> nVarQ = xVar.q(this._valueType, dVar);
        Class<?> cls = this._valueType._class;
        boolean zS = false;
        if (!cls.isPrimitive() ? cls == String.class || cls == Integer.class || cls == Boolean.class || cls == Double.class : cls == Integer.TYPE || cls == Boolean.TYPE || cls == Double.TYPE) {
            zS = b.g.a.c.i0.d.s(nVarQ);
        }
        return q(dVar, gVarA, nVarQ, zS);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        Object objJ = this._accessor.j(obj);
        if (objJ == null) {
            return true;
        }
        b.g.a.c.n<Object> nVarP = this._valueSerializer;
        if (nVarP == null) {
            try {
                nVarP = p(xVar, objJ.getClass());
            } catch (JsonMappingException e) {
                throw new RuntimeJsonMappingException(e);
            }
        }
        return nVarP.d(xVar, objJ);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        try {
            Object objJ = this._accessor.j(obj);
            if (objJ == null) {
                xVar.l(dVar);
                return;
            }
            b.g.a.c.n<Object> nVarP = this._valueSerializer;
            if (nVarP == null) {
                nVarP = p(xVar, objJ.getClass());
            }
            b.g.a.c.e0.g gVar = this._valueTypeSerializer;
            if (gVar != null) {
                nVarP.g(objJ, dVar, xVar, gVar);
            } else {
                nVarP.f(objJ, dVar, xVar);
            }
        } catch (Exception e) {
            o(xVar, e, obj, this._accessor.c() + "()");
            throw null;
        }
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        try {
            Object objJ = this._accessor.j(obj);
            if (objJ == null) {
                xVar.l(dVar);
                return;
            }
            b.g.a.c.n<Object> nVarP = this._valueSerializer;
            if (nVarP == null) {
                nVarP = p(xVar, objJ.getClass());
            } else if (this._forceTypeInformation) {
                b.g.a.b.s.b bVarE = gVar.e(dVar, gVar.d(obj, b.g.a.b.h.VALUE_STRING));
                nVarP.f(objJ, dVar, xVar);
                gVar.f(dVar, bVarE);
                return;
            }
            nVarP.g(objJ, dVar, xVar, new s$a(gVar, obj));
        } catch (Exception e) {
            o(xVar, e, obj, this._accessor.c() + "()");
            throw null;
        }
    }

    public b.g.a.c.n<Object> p(b.g.a.c.x xVar, Class<?> cls) throws JsonMappingException {
        b.g.a.c.n<Object> nVarC = this.k.c(cls);
        if (nVarC != null) {
            return nVarC;
        }
        if (!this._valueType.r()) {
            b.g.a.c.n<Object> nVarR = xVar.r(cls, this._property);
            this.k = this.k.b(cls, nVarR);
            return nVarR;
        }
        b.g.a.c.j jVarK = xVar.k(this._valueType, cls);
        b.g.a.c.n<Object> nVarQ = xVar.q(jVarK, this._property);
        b.g.a.c.g0.t.l lVar = this.k;
        Objects.requireNonNull(lVar);
        this.k = lVar.b(jVarK._class, nVarQ);
        return nVarQ;
    }

    public s q(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar, boolean z2) {
        return (this._property == dVar && this._valueTypeSerializer == gVar && this._valueSerializer == nVar && z2 == this._forceTypeInformation) ? this : new s(this, dVar, gVar, nVar, z2);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("(@JsonValue serializer for method ");
        sbU.append(this._accessor.g());
        sbU.append("#");
        sbU.append(this._accessor.c());
        sbU.append(")");
        return sbU.toString();
    }

    public s(b.g.a.c.c0.i iVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar) {
        super(iVar.e());
        this._accessor = iVar;
        this._valueType = iVar.e();
        this._valueTypeSerializer = gVar;
        this._valueSerializer = nVar;
        this._property = null;
        this._forceTypeInformation = true;
        this.k = l$b.f706b;
    }
}
