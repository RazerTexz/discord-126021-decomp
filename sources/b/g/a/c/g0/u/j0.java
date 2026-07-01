package b.g.a.c.g0.u;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/* JADX INFO: compiled from: StdDelegatingSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0 extends q0<Object> implements b.g.a.c.g0.i, b.g.a.c.g0.o {
    public final b.g.a.c.i0.e<Object, ?> _converter;
    public final b.g.a.c.n<Object> _delegateSerializer;
    public final b.g.a.c.j _delegateType;

    public j0(b.g.a.c.i0.e<Object, ?> eVar, b.g.a.c.j jVar, b.g.a.c.n<?> nVar) {
        super(jVar);
        this._converter = eVar;
        this._delegateType = jVar;
        this._delegateSerializer = nVar;
    }

    @Override // b.g.a.c.g0.i
    public b.g.a.c.n<?> a(b.g.a.c.x xVar, b.g.a.c.d dVar) throws JsonMappingException {
        b.g.a.c.n<?> nVarZ = this._delegateSerializer;
        b.g.a.c.j jVarA = this._delegateType;
        if (nVarZ == null) {
            if (jVarA == null) {
                jVarA = this._converter.a(xVar.d());
            }
            if (!jVarA.y()) {
                nVarZ = xVar.s(jVarA);
            }
        }
        if (nVarZ instanceof b.g.a.c.g0.i) {
            nVarZ = xVar.z(nVarZ, dVar);
        }
        if (nVarZ == this._delegateSerializer && jVarA == this._delegateType) {
            return this;
        }
        b.g.a.c.i0.e<Object, ?> eVar = this._converter;
        b.g.a.c.i0.d.z(j0.class, this, "withDelegate");
        return new j0(eVar, jVarA, nVarZ);
    }

    @Override // b.g.a.c.g0.o
    public void b(b.g.a.c.x xVar) throws JsonMappingException {
        Object obj = this._delegateSerializer;
        if (obj == null || !(obj instanceof b.g.a.c.g0.o)) {
            return;
        }
        ((b.g.a.c.g0.o) obj).b(xVar);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            return true;
        }
        b.g.a.c.n<Object> nVar = this._delegateSerializer;
        if (nVar == null) {
            return obj == null;
        }
        return nVar.d(xVar, objConvert);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        Object objConvert = this._converter.convert(obj);
        if (objConvert == null) {
            xVar.l(dVar);
            return;
        }
        b.g.a.c.n<Object> nVarP = this._delegateSerializer;
        if (nVarP == null) {
            nVarP = p(objConvert, xVar);
        }
        nVarP.f(objConvert, dVar, xVar);
    }

    @Override // b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Object objConvert = this._converter.convert(obj);
        b.g.a.c.n<Object> nVarP = this._delegateSerializer;
        if (nVarP == null) {
            nVarP = p(obj, xVar);
        }
        nVarP.g(objConvert, dVar, xVar, gVar);
    }

    public b.g.a.c.n<Object> p(Object obj, b.g.a.c.x xVar) throws JsonMappingException {
        Class<?> cls = obj.getClass();
        b.g.a.c.n<Object> nVarB = xVar._knownSerializers.b(cls);
        if (nVarB != null) {
            return nVarB;
        }
        b.g.a.c.n<Object> nVarB2 = xVar._serializerCache.b(cls);
        if (nVarB2 != null) {
            return nVarB2;
        }
        b.g.a.c.n<Object> nVarA = xVar._serializerCache.a(xVar._config._base._typeFactory.b(null, cls, b.g.a.c.h0.n.l));
        if (nVarA != null) {
            return nVarA;
        }
        b.g.a.c.n<Object> nVarI = xVar.i(cls);
        return nVarI == null ? xVar.x(cls) : nVarI;
    }
}
