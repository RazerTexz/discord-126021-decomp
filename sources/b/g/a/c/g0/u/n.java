package b.g.a.c.g0.u;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Iterator;

/* JADX INFO: compiled from: EnumSetSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n extends b<EnumSet<? extends Enum<?>>> {
    public n(b.g.a.c.j jVar) {
        super((Class<?>) EnumSet.class, jVar, true, (b.g.a.c.e0.g) null, (b.g.a.c.n<Object>) null);
    }

    @Override // b.g.a.c.n
    public boolean d(b.g.a.c.x xVar, Object obj) {
        return ((EnumSet) obj).isEmpty();
    }

    @Override // b.g.a.c.g0.u.b, b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        EnumSet<? extends Enum<?>> enumSet = (EnumSet) obj;
        int size = enumSet.size();
        if (size == 1 && ((this._unwrapSingle == null && xVar.D(b.g.a.c.w.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this._unwrapSingle == Boolean.TRUE)) {
            u(enumSet, dVar, xVar);
            return;
        }
        dVar.b0(enumSet, size);
        u(enumSet, dVar, xVar);
        dVar.t();
    }

    @Override // b.g.a.c.g0.h
    public b.g.a.c.g0.h p(b.g.a.c.e0.g gVar) {
        return this;
    }

    @Override // b.g.a.c.g0.h
    public boolean q(Object obj) {
        return ((EnumSet) obj).size() == 1;
    }

    @Override // b.g.a.c.g0.u.b
    public /* bridge */ /* synthetic */ void s(EnumSet<? extends Enum<?>> enumSet, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        u(enumSet, dVar, xVar);
    }

    @Override // b.g.a.c.g0.u.b
    public b<EnumSet<? extends Enum<?>>> t(b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n nVar, Boolean bool) {
        return new n(this, dVar, gVar, nVar, bool);
    }

    public void u(EnumSet<? extends Enum<?>> enumSet, b.g.a.b.d dVar, b.g.a.c.x xVar) throws IOException {
        b.g.a.c.n<Object> nVarN = this._elementSerializer;
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            Enum r1 = (Enum) it.next();
            if (nVarN == null) {
                nVarN = xVar.n(r1.getDeclaringClass(), this._property);
            }
            nVarN.f(r1, dVar, xVar);
        }
    }

    public n(n nVar, b.g.a.c.d dVar, b.g.a.c.e0.g gVar, b.g.a.c.n<?> nVar2, Boolean bool) {
        super(nVar, dVar, gVar, nVar2, bool);
    }
}
